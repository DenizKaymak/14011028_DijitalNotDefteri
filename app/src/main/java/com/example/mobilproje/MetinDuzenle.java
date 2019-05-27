package com.example.mobilproje;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MetinDuzenle extends AppCompatActivity {

    private static EditText metingir;
    private static EditText metinrengi;
    private static Button metinekle;

    public static final String SHARED_PREFS = "sharedPrefs";
    String bakilannot2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metin_duzenle);

        metingir=findViewById(R.id.et_metingir);
        metinrengi=findViewById(R.id.et_metinrengi);
        metinekle=findViewById(R.id.button_metinekle);

        Bundle bundle = getIntent().getExtras();
        final String bakilannot=bundle.getString("bakilannot");
        bakilannot2=bakilannot;

        metinekle.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                metinkaydet();
                Intent intent=new Intent(".MetinSayfasi");
                intent.putExtra("bakilannot",bakilannot);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Metin Eklendi", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void metinkaydet(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(bakilannot2+"metinicerigi", metingir.getText().toString());
        editor.putString(bakilannot2+"metinrengi",metinrengi.getText().toString());
        editor.commit();

    }
}
