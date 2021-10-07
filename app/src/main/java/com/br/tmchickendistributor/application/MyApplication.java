package com.br.tmchickendistributor.application;

import android.app.Application;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {
		
		@Override
		public void onCreate() {
				super.onCreate();
				// The default Realm file is "default.realm" in Context.getFilesDir();
				// we'll change it to "myrealm.realm"
				Realm.init(this);
               RealmConfiguration config = new RealmConfiguration.Builder().name("chicken_distributor_trinity.realm").deleteRealmIfMigrationNeeded().build();
				Realm.setDefaultConfiguration(config);
		}
}
