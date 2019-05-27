package com.example.mobilproje;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OncelikSayfasi extends AppCompatActivity {

    private static EditText onceliktext;
    private static Button oncelikbutton;
    public static final String SHARED_PREFS = "sharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oncelik_sayfasi);

        onceliktext=findViewById(R.id.et_oncelik);
        oncelikbutton=findViewById(R.id.button_oncelik);

        Bundle bundle = getIntent().getExtras();
        final String bakilannot=bundle.getString("bakilannot");

        oncelikbutton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(bakilannot+"oncelik", onceliktext.getText().toString());
                editor.commit();
                Toast.makeText(getApplicationContext(),"Oncelik Eklendi "+onceliktext.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
