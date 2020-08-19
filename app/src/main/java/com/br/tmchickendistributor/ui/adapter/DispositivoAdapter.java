package com.br.tmchickendistributor.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.br.tmchickendistributor.data.model.DispositivoEscaneado;
import com.br.tmchickendistributor.ui.mvp.impressora.IImpressoraMVP.IPresenter;
import com.br.tmchickendristributor.R;
import java.util.ArrayList;
import java.util.List;

public class DispositivoAdapter extends BaseAdapter {

    private List<DispositivoEscaneado> mDispositivoEscaneados = new ArrayList<>();

    private IPresenter mPresenter;

    public DispositivoAdapter(final IPresenter presenter) {

        this.mPresenter = presenter;
    }

    public void add(String nome, String enderecoBluetooth, int icone) {
        DispositivoEscaneado impressora = new DispositivoEscaneado(enderecoBluetooth, icone, nome);
        mDispositivoEscaneados.add(impressora);
    }

    public void clear() {
        mDispositivoEscaneados.clear();
    }

    public DispositivoEscaneado find(String address) {
        for (DispositivoEscaneado d : mDispositivoEscaneados) {
            if (address.equals(d.getEnderecoBluetooth())) {
                return d;
            }
        }

        return null;
    }

    @Override
    public int getCount() {
        return mDispositivoEscaneados.size();
    }

    @Override
    public Object getItem(int location) {
        return mDispositivoEscaneados.get(location);
    }

    @Override
    public long getItemId(int location) {
        return location;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get layout to populate
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = LayoutInflater.from(mPresenter.getContext());
            v = vi.inflate(R.layout.device_node, null);
        }

        // Populate the layout with new data
        DispositivoEscaneado impressora = (DispositivoEscaneado) getItem(position);
        ((ImageView) v.findViewById(R.id.icon)).setImageResource(impressora.getIcone());
        ((TextView) v.findViewById(R.id.name)).setText(impressora.getNome());
        ((TextView) v.findViewById(R.id.address)).setText(impressora.getEnderecoBluetooth());

        return v;
    }
}

