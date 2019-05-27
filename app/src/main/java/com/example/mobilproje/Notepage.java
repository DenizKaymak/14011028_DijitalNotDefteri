package com.example.mobilproje;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Notepage extends AppCompatActivity {

    private static TextView notename;
    private static Button metinsayfasi;
    private static Button onceliksayfasi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepage);

        notename=findViewById(R.id.tw_notename);
        metinsayfasi=findViewById(R.id.button_metin);
        onceliksayfasi=findViewById(R.id.button_oncelik);


        Bundle bundle = getIntent().getExtras();
        final String bakilannot=bundle.getString("bakilannot");

        notename.setText(bakilannot);

        metinsayfasi.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(".MetinSayfasi");
                intent.putExtra("bakilannot",bakilannot);
                startActivity(intent);
            }
        });

        onceliksayfasi.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(".OncelikSayfasi");
                intent.putExtra("bakilannot",bakilannot);
                startActivity(intent);
            }
        });

    }
}
