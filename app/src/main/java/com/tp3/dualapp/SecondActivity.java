package com.tp3.dualapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView txt1;
    private EditText reponse;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        reponse = (EditText) findViewById(R.id.editText_second);
        txt1 = (TextView) findViewById(R.id.text_message);


        i = getIntent();
        String message = i.getStringExtra("message");
        txt1.setVisibility(View.VISIBLE);
        txt1.setText(message);

    }

    public void LaunchReply(View v) {
        String msgRep = reponse.getText().toString();

        Intent j = new Intent();
        j.putExtra("messageRep", msgRep);

        if(msgRep.isEmpty())
        {
            setResult(RESULT_CANCELED, j);
        }
        else
        {
            setResult(RESULT_OK, j);
        }

        finish();
    }
}
