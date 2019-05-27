package com.example.mobilproje;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class NotListesi extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> list;
    MyAdapter adapter;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_listesi);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);

        Set<String> set=sharedPreferences.getStringSet("Notelist",null);
        list.addAll(set);
        String[] oncelik=new String[list.size()];

        for(int i=0; i<list.size(); i++){
            try{
                oncelik[i]=sharedPreferences.getString(list.get(i)+"oncelik",null);

            }
            catch (Exception e){

            }

        }


        adapter=new MyAdapter(this,list,oncelik);
        recyclerView.setAdapter(adapter);
    }
}
