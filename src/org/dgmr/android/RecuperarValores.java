package org.dgmr.android;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class RecuperarValores extends Activity {
	
	TextView txtNombre ;
	TextView txtApellidos ;
	TextView txtCiudad ;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form_recuperar_valores);
		txtNombre = ((TextView) findViewById(R.id.txtNombre));
		txtApellidos = ((TextView) findViewById(R.id.txtApellidos));
		txtCiudad = ((TextView) findViewById(R.id.txtCiudad));
		
		Bundle extras = getIntent().getExtras();
		String nombre = extras.getString("nombre");
		String apellidos = extras.getString("apellidos");
		String ciudad = extras.getString("ciudad");
		
		txtNombre.setText(nombre);
		txtApellidos.setText(apellidos);
		txtCiudad.setText(ciudad);
		
	}
}
