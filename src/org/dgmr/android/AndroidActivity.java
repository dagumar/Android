package org.dgmr.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class AndroidActivity extends Activity implements OnItemSelectedListener{
	TextView text = null;
	EditText editTxtNombre = null;
	EditText editTxtApellidos = null;
	Spinner spinCiudad = null;
	String ciudad = "";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulario_datos_personales);
		editTxtNombre = ((EditText) findViewById(R.id.editTxtNombre));
		editTxtApellidos = ((EditText) findViewById(R.id.editTxtApellidos));
		spinCiudad = ((Spinner) findViewById(R.id.spinCiudad));
		spinCiudad.setOnItemSelectedListener(this);
		obtenerValoresSpinner();



	}
	public void obtenerValoresSpinner(){

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ciudades, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		spinCiudad.setAdapter(adapter);
	}


	public void click(View view) {
		Button boton = (Button) view;
		boton.setText("3, 2, 1");
		text = (TextView) findViewById(R.id.textView1);
		text.setText("Redrum");
		Log.e("ACTIVITY", "La app se va a autodestruir");
		LinearLayout linLay = (LinearLayout) findViewById(R.id.textView1)
				.getParent();
		linLay.setBackgroundColor(getResources().getColor(R.color.rojo));
	}

	public void enviarClick(View view) {
		String nombre = editTxtNombre.getText().toString();
		String apellidos = editTxtApellidos.getText().toString();
	    ciudad = spinCiudad.getSelectedItem().toString();
		//String ciudad = editTxtCiudad.getText().toString();
		Log.e("Activity", nombre + " " + apellidos + " " + ciudad);

		Toast.makeText(this, "Enviando los datos. ", Toast.LENGTH_LONG).show();
		Intent request = new Intent(AndroidActivity.this, RecuperarValores.class);
		request.putExtra("nombre", nombre);
		request.putExtra("apellidos", apellidos);
		request.putExtra("ciudad", ciudad);
		startActivity(request);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuItem item = null;
		item = menu.add(this.getString(R.string.desarrollador));
		item.setIcon(R.drawable.ic_launcher);
		item = menu.add(this.getString(R.string.ayuda));
		item.setIcon(android.R.drawable.ic_menu_help);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		if(item.getTitle().equals(this.getString(R.string.desarrollador))){
			mostrarAlerta("Dev by:", "Dagumar");
			mostrarAlertaEnBarraDeNotificaciones();
		}
		if(item.getTitle().equals(this.getString(R.string.ayuda))){
			Toast.makeText(AndroidActivity.this, "En construcción", Toast.LENGTH_LONG).show();
			
		}
		return super.onMenuItemSelected(featureId, item);
	}
	
	public void mostrarAlerta(String titulo, String texto){

		Builder alert = new AlertDialog.Builder(this);
		alert.setTitle(titulo);
		alert.setMessage(texto);
		alert.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(AndroidActivity.this, "Donaciones a través de Paypal!! ", Toast.LENGTH_LONG).show();
			}
		});
		alert.show();


	}
	
	public void mostrarAlertaEnBarraDeNotificaciones(){
		String ns = Context.NOTIFICATION_SERVICE;
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
		Notification notification = new Notification(R.drawable.ic_launcher, "Esto es una alerta en la barra", System.currentTimeMillis());
		Intent notificationIntent = new Intent(this, AndroidActivity.class);
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
		notification.setLatestEventInfo(this.getApplicationContext(), ((CharSequence)"Alerta"), ((CharSequence)"En el status"), contentIntent);
		mNotificationManager.notify(1, notification);
	}
	
	

	public void borrarClick(View view) {

		editTxtNombre.setText("");
		editTxtApellidos.setText("");
		spinCiudad.setSelection(0);

	}

	// Primer formulario simple: coger valor de un edit y rellenar un text view
	public void enviar(View view) {
		((TextView) findViewById(R.id.txtView))
		.setText(editTxtNombre.getText());
	}

	public void borrar(View view) {
		((EditText) findViewById(R.id.editTxt)).setText("");
	}
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		ciudad = spinCiudad.getSelectedItem().toString();
		Log.e("ACTIVITY", " La ciudad elegida es " + ciudad);
		
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		ciudad = "Sin ciudad";
		
	}

}