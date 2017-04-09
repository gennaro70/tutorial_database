package com.example.database;

public class Codice {
	
	//modificare questo codice per cambiare database
	
		public static final String NOME_DB = "contatti";
		public static final int VERSIONE_DB = 1;

		//definire i nomi e creazione della tabella
		public static final String TABLE_CONTATTI = "rubrica";
		public static final String DATI_ID = "_id";
		public static final String DATI_NOME = "nome";
		public static final String DATI_COGNOME = "cognome";
		public static final String DATI_TELEFONO = "telefono";
		public static final String DATI_CELLULARE = "cellulare";
		public static final String DATI_MAIL = "mail";
		public static final String CREATE_TABLE_CONTATTI = "CREATE TABLE IF NOT EXISTS " 
		        + TABLE_CONTATTI + " (" 
				+ DATI_ID + " integer primary key autoincrement, "
				+ DATI_NOME + " text not null, "
				+ DATI_COGNOME + " text not null, "
				+ DATI_TELEFONO + " text not null, "
				+ DATI_CELLULARE + " text not null, "
				+ DATI_MAIL + " text not null); ";

}
