package com.example.mobilproje;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    private static EditText notadi;
    private static Button notekle;
    private static Button notlistesi;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";

    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notadi=findViewById(R.id.et_newNote);
        notekle=findViewById(R.id.button_create);
        notlistesi=findViewById(R.id.button_notelist);

        notekle.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                saveData();
            }
        });

        notlistesi.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent=new Intent(".NotListesi");
                startActivity(intent);
            }
        });

    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //editor.putString(TEXT, notadi.getText().toString());

        list=new ArrayList<>();


        try {

            Set<String> set=sharedPreferences.getStringSet("Notelist",null);
            list.addAll(set);
        }
        catch(Exception e) {
        }

        list.add(notadi.getText().toString());

        Set<String> set2=new HashSet<String>();
        set2.addAll(list);
        editor.putStringSet("Notelist",set2);


        editor.commit();


        Toast.makeText(this, "Yeni Not Eklendi: "+notadi.getText().toString(), Toast.LENGTH_SHORT).show();
    }




}
