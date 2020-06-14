package com.example.share_prefrence;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button, button1;
    SharedPreferences sharedPreferences;
    View background_view;
    int sop = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        editText = findViewById( R.id.edit );
        textView = findViewById( R.id.text );
        button = findViewById( R.id.button );
        button1 = findViewById( R.id.button1 );
        background_view = findViewById( R.id.background_view );

        sharedPreferences = getSharedPreferences( "data_base", Context.MODE_PRIVATE );

        if (sharedPreferences.contains( "asd" )) {
            textView.setText( sharedPreferences.getString( "asd", "" ) );
        }
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edit = editText.getText().toString();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString( "asd", edit );
                editor.commit();
                Toast.makeText( getApplicationContext(),
                                "Text has been sent to file", Toast.LENGTH_SHORT ).show();
            }
        } );
        button1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, Main2Activity.class );
                startActivity( intent );
            }
        } );
    }
}

               