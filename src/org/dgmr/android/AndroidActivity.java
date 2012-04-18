package org.dgmr.android;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AndroidActivity extends Activity {
	TextView text = null;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulario_datos_personales);
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

	public void enviar(View view) {
		((TextView )findViewById(R.id.txtView)).setText( ((EditText) findViewById(R.id.editTxt) ).getText() );
	}

	public void borrar(View view) {
		((EditText) findViewById(R.id.editTxt) ).setText(""); 
	}
	
	public void enviarClick(View view) {
		Log.e("Activity",((EditText) findViewById(R.id.editTxtNombre) ).getText() + "" +  ((EditText) findViewById(R.id.editTxtApellidos) ).getText() + ((EditText) findViewById(R.id.editTxtCiudad) ).getText()  );
	}

	public void borrarClick(View view) {
		
		((EditText) findViewById(R.id.editTxtNombre) ).setText(""); 
		((EditText) findViewById(R.id.editTxtApellidos) ).setText(""); 
		((EditText) findViewById(R.id.editTxtCiudad) ).setText("");
		
	}

}