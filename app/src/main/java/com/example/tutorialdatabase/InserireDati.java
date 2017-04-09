package com.example.tutorialdatabase;

import com.example.database.Database;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InserireDati extends ActionBarActivity implements OnClickListener{
	
	private Button btn_invia;
	private EditText txt_nome, txt_cognome, txt_telefono, txt_cellulare, txt_mail;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inserire_dati);
		
		btn_invia = (Button) findViewById(R.id.salva_dati);
        btn_invia.setOnClickListener(this);
        txt_nome = (EditText) findViewById(R.id.ins_nome);
        txt_cognome = (EditText) findViewById(R.id.ins_cognome);
        txt_telefono = (EditText) findViewById(R.id.ins_telefono);
        txt_cellulare = (EditText) findViewById(R.id.ins_cellulare);
        txt_mail = (EditText) findViewById(R.id.ins_mail);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		case R.id.salva_dati:
			String nome = txt_nome.getText().toString();
			String cognome = txt_cognome.getText().toString();
			String telefono = txt_telefono.getText().toString();
			String cellulare = txt_cellulare.getText().toString();
			String mail = txt_mail.getText().toString();
			
			if ((nome.length() > 0)&& 
			    (cognome.length() > 0)&& 
			    (telefono.length() > 0)&& 
			    (cellulare.length() > 0)&& 
			    (mail.length() > 0)){
				
				Database d = new Database(getApplicationContext());
				d.inserisci(nome, cognome, telefono, cellulare, mail);
				d.close();
				
				CharSequence testo = "Dati Salvati nel database!";
				int durata = Toast.LENGTH_SHORT;
				Toast toast = Toast.makeText(getApplicationContext(), testo, durata);
				toast.show();
				
				txt_nome.setText("");
				txt_cognome.setText("");
				txt_telefono.setText("");
				txt_cellulare.setText("");
				txt_mail.setText("");}
			else {
				
				CharSequence testo = "Non sono stati completati tutti i campi";
				int durata = Toast.LENGTH_SHORT;
				Toast toast = Toast.makeText(getApplicationContext(), testo, durata);
				toast.show();
			}
				
			break;
		}
	}	
	}
