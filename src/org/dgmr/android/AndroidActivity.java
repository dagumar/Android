package org.dgmr.android;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class AndroidActivity extends Activity implements OnItemSelectedListener{
	TextView text = null;

	EditText editTxtNombre = null;
	EditText editTxtApellidos = null;
	Spinner spinCiudad = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulario_datos_personales);
		editTxtNombre = ((EditText) findViewById(R.id.editTxtNombre));
		editTxtApellidos = ((EditText) findViewById(R.id.editTxtApellidos));
		spinCiudad = ((Spinner) findViewById(R.id.spinCiudad));
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
		String  ciudad = spinCiudad.getSelectedItem().toString();
		;
		//String ciudad = editTxtCiudad.getText().toString();
		Log.e("Activity", nombre + " " + apellidos + " " + ciudad);
	}

	public void borrarClick(View view) {

		editTxtNombre.setText("");
		editTxtApellidos.setText("");
		spinCiudad.setSelection(0);
		//editTxtCiudad.setText("");

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
		
	}
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}