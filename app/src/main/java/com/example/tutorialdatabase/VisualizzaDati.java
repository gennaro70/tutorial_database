package com.example.tutorialdatabase;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.database.Codice;
import com.example.database.Database;

public class VisualizzaDati extends ActionBarActivity{
	
	ListView lista_database;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visualizza_dati);
		
Database d = new Database(getApplicationContext());
        
        final Cursor c = d.orario();
        
        CursorLoader(c);
        
        String from[] = {Codice.DATI_NOME,
        		         Codice.DATI_COGNOME,
        		         Codice.DATI_TELEFONO,
        		         Codice.DATI_CELLULARE,
        		         Codice.DATI_MAIL,
        		         Codice.DATI_ID};
        
        int to[] = {R.id.record_nome,
        		    R.id.record_cognome,
        		    R.id.record_telefono,
        		    R.id.record_cellulare,
        		    R.id.record_mail,
        		    R.id.record_id};
        
        @SuppressWarnings("deprecation")
		SimpleCursorAdapter sca = new SimpleCursorAdapter(this,
        		R.layout.singolo_elemento,
        		c,
        		from,to);
        
        //lo associamo al layout
        lista_database = (ListView) findViewById(R.id.lista_record);
        lista_database.setAdapter(sca);

}

	private void CursorLoader(Cursor c) {
		// TODO Auto-generated method stub
		
	}
	}
