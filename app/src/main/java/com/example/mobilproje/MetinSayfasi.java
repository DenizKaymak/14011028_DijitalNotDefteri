package com.example.mobilproje;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MetinSayfasi extends AppCompatActivity {

    private static TextView metinicerik;
    private static Button metinduzenle;

    public static final String SHARED_PREFS = "sharedPrefs";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metin_sayfasi);

        metinicerik=findViewById(R.id.tw_metinicerik);
        metinduzenle=findViewById(R.id.button_metinduzenle);

        Bundle bundle = getIntent().getExtras();
        final String bakilannot=bundle.getString("bakilannot");

        try {
            //  Block of code to try
            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

            metinicerik.setText(sharedPreferences.getString(bakilannot+"metinicerigi",null));

            String renk=sharedPreferences.getString(bakilannot+"metinrengi",null);


            if(renk.equals("G")){
                metinicerik.setTextColor(Color.GREEN);
            }else if(renk.equals("B")){
                metinicerik.setTextColor(Color.BLACK);
            }else if(renk.equals("R")){
                metinicerik.setTextColor(Color.RED);
            }
        }
        catch(Exception e) {
            //  Block of code to handle errors
        }






        metinduzenle.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(".MetinDuzenle");
                intent.putExtra("bakilannot",bakilannot);
                startActivity(intent);
            }
        });


    }



}

