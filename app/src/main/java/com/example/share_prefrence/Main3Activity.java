package com.example.share_prefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main3 );
        sharedPreferences = getSharedPreferences( "data_table", Context.MODE_PRIVATE );
        editText = findViewById( R.id.editText );
        button = findViewById( R.id.button2 );
        textView = findViewById( R.id.textView3 );
        
        final String s2 = editText.getText().toString();
        
        final String s1 = sharedPreferences.getString( "a", "" );
        if (s1.equals( "so" )) {
            textView.setText( s2 );
        }
        button.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                textView.setText( s2 );
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString( "a", "so" );
                editor.apply();
            }
        } );
    }
}
