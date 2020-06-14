package com.example.share_prefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    Button button;
    SharedPreferences sharedPreferences;
    View background_view;int sol = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        sharedPreferences = getSharedPreferences( "data_base", Context.MODE_PRIVATE );
        setContentView( R.layout.activity_main2 );
        button = findViewById( R.id.button1 );
        background_view = findViewById( R.id.background_view );
//        Intent intent = getIntent();
//        final String s1 = intent.getStringExtra( "s1" );
        final String x = sharedPreferences.getString( "ab", "" );
        if (x.equals("sf")) {
            background_view.setAlpha( 1f );
        }else if (x.equals( "fs" )){
            background_view.setAlpha( 0f );
        }
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sol==1) {
                    background_view.setAlpha( 1f );
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString( "ab", "sf");
                    editor.apply();
                    sol++;
                }else {
                    background_view.setAlpha( 0f );
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString( "ab", "fs" );
                    editor.apply();
                    sol--;
                }
            }
        } );
        
        button.setOnLongClickListener( new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(Main2Activity.this,Main3Activity.class  );
                startActivity(intent);
                return false;
            }
        } );

    }

    
}
