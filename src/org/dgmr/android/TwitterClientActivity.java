package org.dgmr.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;

public class TwitterClientActivity extends ListActivity implements OnItemClickListener{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		String[] cabecera = new String[]{
				"nombre", "usuario", "twit", "fecha"};
		
		int[] nombresTxtViews = new int[]{
				R.id.txtNombre, R.id.txtUsuario, R.id.txtTwit, R.id.txtFecha
		};
		
		HashMap twitt1 = new HashMap<String, String>();
		twitt1.put("nombre", "David Gutiérrez Marqueta");
		twitt1.put("usuario", "@Dagumar");
		twitt1.put("twit", "Mocking Twitter client");
		twitt1.put("fecha", "hace 5 min");
		
		HashMap<String, String> twitt2 = new HashMap<String, String>();
		twitt2.put("nombre", "David Gutiérrez Marqueta");
		twitt2.put("usuario", "@Dagumar");
		twitt2.put("twit", "Curso de Android!");
		twitt2.put("fecha", "hace 10 min");
		
		HashMap twitt3 = new HashMap<String, String>();
		twitt3.put("nombre", "David Gutiérrez Marqueta");
		twitt3.put("usuario", "@Dagumar");
		twitt3.put("twit", "curso de Android!");
		twitt3.put("fecha", "hace 15 min");
		
		HashMap twitt4 = new HashMap<String, String>();
		twitt4.put("nombre", "David Gutiérrez Marqueta");
		twitt4.put("usuario", "@Dagumar");
		twitt4.put("twit", "Curso de Android!");
		twitt4.put("fecha", "hace 20 min");
		
		List arrayMaps = new ArrayList<HashMap>();
		arrayMaps.add(twitt1);
		arrayMaps.add(twitt2);
		arrayMaps.add(twitt3);
		arrayMaps.add(twitt4);
		
		SimpleAdapter adaptadorParaLaLista = new SimpleAdapter(this, arrayMaps, R.layout.twitterclient, cabecera, nombresTxtViews);
		this.setListAdapter(adaptadorParaLaLista);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
		Toast.makeText(this, "Seleccionado " + this.getSelectedItemId(), Toast.LENGTH_LONG).show();
		
		
	}
	

}
