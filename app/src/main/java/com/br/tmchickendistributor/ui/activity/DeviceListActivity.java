package com.br.tmchickendistributor.ui.activity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.br.tmchickendistributor.data.model.DispositivoEscaneado;
import com.br.tmchickendistributor.data.model.Impressora;
import com.br.tmchickendistributor.ui.abstracts.AbstractActivity;
import com.br.tmchickendistributor.ui.adapter.DispositivoAdapter;
import com.br.tmchickendistributor.ui.mvp.impressora.IImpressoraMVP;
import com.br.tmchickendistributor.ui.mvp.impressora.Presenter;
import com.br.tmchickendristributor.R;
import java.util.Set;

/**
 * This Activity appears as a dialog. It lists any paired devices and devices detected in the area
 * after discovery. When a device is chosen by the user, the MAC address of the device is sent back
 * to the parent Activity in the result Intent.
 */
public class DeviceListActivity extends AppCompatActivity implements IImpressoraMVP.IView {

  // Return Intent extra
  public static String EXTRA_DEVICE_ADDRESS = "device_address";

  // Address preference name
  public static String PREF_DEVICE_ADDRESS = "device_address";

  private static final int PRIVATE_MODE = 0;

  @BindView(R.id.btnConectar)
  Button btnConectar;

  @BindView(R.id.btnEscanear)
  Button btnEscanear;

  @BindView(R.id.edtEnderecoBluetooth)
  EditText edtEnderecoBluetooth;

  @BindView(R.id.toolbar)
  Toolbar mToolbar;

  @BindView(R.id.lvDispositivos)
  ListView lvDispositivos;

  IImpressoraMVP.IPresenter mPresenter;



  // Represents the local device Bluetooth adapter.
  private BluetoothAdapter mBtAdapter;

  // Device adapter which handle list of devices.
  private DispositivoAdapter mDevicesAdapter;

  // The BroadcastReceiver that listens for discovered devices and
  // changes the title when discovery is finished
  private final BroadcastReceiver mReceiver =
      new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
          String action = intent.getAction();

          // When discovery finds a device
          if (BluetoothDevice.ACTION_FOUND.equals(action)) {
            // Get the BluetoothDevice object from the Intent
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            boolean bonded = device.getBondState() == BluetoothDevice.BOND_BONDED;
            int iconId =
                bonded
                    ? R.mipmap.ic_bluetooth_connected_black_48dp
                    : R.mipmap.ic_bluetooth_black_48dp;
            // Find is device is already exists
            DispositivoEscaneado dispositivoEscaneado = mDevicesAdapter.find(device.getAddress());
            // Skip if device is already in list
            if (dispositivoEscaneado == null) {
              mDevicesAdapter.add(device.getName(), device.getAddress(), iconId);
            } else {
              dispositivoEscaneado.setNome(device.getName());
              dispositivoEscaneado.setIcone(iconId);
            }

            // When discovery is finished, change the Activity title
          } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
            setProgressBarIndeterminateVisibility(false);
            setTitle(R.string.title_select_device);
            findViewById(R.id.lnlEscanear).setVisibility(View.VISIBLE);
          }
        }
      };

  @SuppressLint("NewApi")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.device_list);
    ButterKnife.bind(this);

    initViews();



    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
      setFinishOnTouchOutside(false);
    }

    mPresenter = new Presenter(this);

    mBtAdapter = BluetoothAdapter.getDefaultAdapter();

    // Initialize array adapters. One for already paired devices and
    // one for newly discovered devices
    mDevicesAdapter = new DispositivoAdapter(mPresenter);

    // Initialize the button to perform connect
    final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    edtEnderecoBluetooth = findViewById(R.id.edtEnderecoBluetooth);
    edtEnderecoBluetooth.setText(prefs.getString(PREF_DEVICE_ADDRESS, ""));

    btnConectar.setOnClickListener(
        v -> {
          String address = edtEnderecoBluetooth.getText().toString();
          if (!address.isEmpty()) {
            this.selecionarImpressora(address, address);
            AbstractActivity.showToast(DeviceListActivity.this, "Impressora Selecionada:".concat(address));
            NavUtils.navigateUpFromSameTask(this);
          }else{
            edtEnderecoBluetooth.setError("Endereço obrigatório!");
          }
        });

    lvDispositivos.setAdapter(mDevicesAdapter);
    lvDispositivos.setOnItemClickListener(
        (parent, view, position, id) -> {
          mBtAdapter.cancelDiscovery();

          DispositivoEscaneado dispositivoEscaneado =
              (DispositivoEscaneado) mDevicesAdapter.getItem(position);
          String address = dispositivoEscaneado.getEnderecoBluetooth();



          if (BluetoothAdapter.checkBluetoothAddress(address)) {
              this.selecionarImpressora(address,dispositivoEscaneado.getNome());
            AbstractActivity.showToast(DeviceListActivity.this, "Impressora Selecionada:".concat(dispositivoEscaneado.getNome()));
            NavUtils.navigateUpFromSameTask(this);
          }
        });

    btnEscanear.setOnClickListener(v -> startDiscovery());

    // Register for broadcasts when a device is discovered
    IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
    registerReceiver(mReceiver, filter);

    // Register for broadcasts when discovery has finished
    filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
    registerReceiver(mReceiver, filter);

    if (mBtAdapter != null && mBtAdapter.isEnabled()) {
      // Get a set of currently paired devices
      Set<BluetoothDevice> pairedDevices = mBtAdapter.getBondedDevices();

      // If there are paired devices, add each one to the ArrayAdapter
      if (pairedDevices.size() > 0) {
        for (BluetoothDevice device : pairedDevices) {
          mDevicesAdapter.add(
              device.getName(), device.getAddress(), R.mipmap.ic_bluetooth_connected_black_48dp);
        }
      }
      findViewById(R.id.txtTituloDesabilitado).setVisibility(View.GONE);
    } else {
      findViewById(R.id.lnlEscanear).setVisibility(View.GONE);
    }
  }

  private void inserirImpressora( final Impressora impressora) {

    mPresenter.inserirImpresora(impressora);
  }

  private void initViews() {
    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    final SharedPreferences.Editor edit = prefs.edit();
    edit.putString(PREF_DEVICE_ADDRESS, edtEnderecoBluetooth.getText().toString());
    edit.commit();

    // Make sure we're not doing discovery anymore
    cancelDiscovery();

    // Unregister broadcast listeners
    unregisterReceiver(mReceiver);
  }

  @Override
  public boolean onKeyUp(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK) {
      setResult(RESULT_FIRST_USER);
      finish();
      return true;
    }
    return super.onKeyUp(keyCode, event);
  }

  private void cancelDiscovery() {
    if (mBtAdapter != null) {
      mBtAdapter.cancelDiscovery();
    }
  }



  private void startDiscovery() {
    // Indicate scanning in the title
    setProgressBarIndeterminateVisibility(true);
    setTitle(R.string.title_scanning);
    findViewById(R.id.lnlEscanear).setVisibility(View.GONE);

    // If we're already discovering, stop it
    if (mBtAdapter.isDiscovering()) {
      mBtAdapter.cancelDiscovery();
    }

    // Request discover from BluetoothAdapter
    mBtAdapter.startDiscovery();
  }

  private void selecionarImpressora(final String address,String nome) {

    /*Verifica se existe impressora ativa*/
    if (mPresenter.existeImpressoraAtiva()) {

      Impressora impressoraAtiva = mPresenter.pequisarImpressoraAtiva();
      if (!impressoraAtiva.getEndereco().equals(address)) {
        /*Verifcar se a impressora eh nova*/
        Impressora impressoraPesquisada = mPresenter.pesquisarImpressora(address);
        if (impressoraPesquisada.getEndereco() != null) {
          // edita
          impressoraAtiva.setAtivo(false);
          impressoraPesquisada.setAtivo(true);
          mPresenter.atualizarImpressora(impressoraAtiva);
          mPresenter.atualizarImpressora(impressoraPesquisada);
        } else { // cria}
          impressoraPesquisada.setAtivo(true);
          impressoraPesquisada.setNome(nome);
          impressoraPesquisada.setEndereco(address);
          inserirImpressora( impressoraPesquisada);
        }
      }
    }
    /** Cria nova impressora */
    else {
      Impressora impressora = new Impressora();
      impressora.setNome(nome);
      impressora.setEndereco(address);
      impressora.setAtivo(true);
      inserirImpressora(impressora);
    }
  }

  @Override
  public void onBackPressed() {}
}
