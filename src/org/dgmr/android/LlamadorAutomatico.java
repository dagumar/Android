package org.dgmr.android;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class LlamadorAutomatico extends Activity{
	
	private EditText edtTelefono;
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.llamador_automatico);
		edtTelefono = ((EditText) findViewById(R.id.edtTelefono));
		btn = ((Button) findViewById(R.id.btn));
		
		OnClickListener callClickListener = new OnClickListener() {
				@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:+" + edtTelefono.getText()));
				startActivity(intent);
				
			}
		};

		btn.setOnClickListener( callClickListener);
		
	}


}
