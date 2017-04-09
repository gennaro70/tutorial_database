package com.example.tutorialdatabase;

import com.example.database.Codice;
import com.example.database.Database;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class CancellaDati extends ActionBarActivity{
	
	ListView lista_database;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cancella_dati);
		
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
	        
	        
	        lista_database = (ListView) findViewById(R.id.lista_cancella_record);
	        lista_database.setAdapter(sca);
	        lista_database.setClickable(true);
	        
	        lista_database.setOnItemClickListener(new AdapterView.OnItemClickListener() {

				@SuppressWarnings("deprecation")
				public void onItemClick(AdapterView<?> parent, View v, int position,
						long id) {
						
					
					TextView txtId = (TextView) v.findViewById(R.id.record_id); //otteniamo il riferimento all'ID
					String elemIdString = (String) txtId.getText(); //otteniamo l'id che ci interessa
					int elemIdInt = Integer.parseInt(elemIdString);
					
					Database d = new Database(getApplicationContext());
					d.cancella(elemIdInt); //cancelliamo l'elemento
					d.close();
				
					c.requery(); //aggiorniamo la listview
					
				}
			});

	}

		private void CursorLoader(Cursor c) {
			// TODO Auto-generated method stub
			
		}

	}
