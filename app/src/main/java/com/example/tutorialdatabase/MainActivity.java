package com.example.tutorialdatabase;


import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button btn1 = (Button) findViewById(R.id.btn_inserisci);
        btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent apri = new Intent(MainActivity.this,InserireDati.class);
				startActivity(apri);
				// TODO Auto-generated method stub
				
			}
		} );
        
        Button btn2 = (Button) findViewById(R.id.btn_visualizza);
        btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent apri = new Intent(MainActivity.this,VisualizzaDati.class);
				startActivity(apri);
				// TODO Auto-generated method stub
				
			}
		} );
        
        Button btn3 = (Button) findViewById(R.id.btn_cancella);
        btn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent apri = new Intent(MainActivity.this,CancellaDati.class);
				startActivity(apri);
				// TODO Auto-generated method stub
				
			}
		} );
    }
}
