package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Database {
	
	private SQLiteDatabase db;
	private DbHelper dbhelper;
	
	public Database(Context context){
		
		dbhelper = new DbHelper(context,Codice.NOME_DB,null,Codice.VERSIONE_DB);
		
		db = dbhelper.getWritableDatabase();
	}
	
	public void close(){
		
		db.close();
		
	}
	
	public void inserisci(String nome, String cognome, String telefono, String cellulare, String mail){
		ContentValues dati = new ContentValues();

		dati.put(Codice.DATI_NOME, nome);
		dati.put(Codice.DATI_COGNOME, cognome);
		dati.put(Codice.DATI_TELEFONO, telefono);
		dati.put(Codice.DATI_CELLULARE, cellulare);
		dati.put(Codice.DATI_MAIL, mail);
		
		db.insert(Codice.TABLE_CONTATTI, null, dati);
	}
	
	public void cancella(int id){
		
		String[] args = {"" + id};
		String where = Codice.DATI_ID + "=?";
		
		db.delete(Codice.TABLE_CONTATTI, where, args);
	}
	
	public Cursor orario(){
		
		return db.query(Codice.TABLE_CONTATTI, null /*possiamo specificare quali colonne prendere*/, 
				null /*su quali campi fare il SELECT*/, 
				null /*per quali valori*/, 
				null /*GROUP BY*/, 
				null /*HAVING*/,  
				null /*ORDER BY*/);
	}
}
