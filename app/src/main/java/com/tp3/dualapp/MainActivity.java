package com.tp3.dualapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //public static final String EXTRA_MESSAGE ="";
    private EditText msgTxt;
    private TextView headerMsg;
    private TextView reponseMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        msgTxt = (EditText) findViewById(R.id.txt1);

        headerMsg = (TextView) findViewById(R.id.text_header);
        reponseMsg = (TextView) findViewById(R.id.text_message);

    }

    // Version 1
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent i) {
        super.onActivityResult(requestCode, resultCode, i);

        if (requestCode == 25) {
            if (resultCode == RESULT_OK) {
                String reply = i.getStringExtra("messageRep");
                headerMsg.setVisibility(View.VISIBLE);
                reponseMsg.setVisibility(View.VISIBLE);
                reponseMsg.setText(reply);
            } else { //resultCode == RESULT_CANCELED
                Toast.makeText(this, "Chaine vide", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void LaunchActivity(View v) {
        Intent i = new Intent(this, SecondActivity.class);
        String msg = msgTxt.getText().toString();
        i.putExtra("message", msg);
        startActivityForResult(i, 25);

    }

    //Version 2
//    public void LaunchActivity(View v) {
//        Intent i = new Intent(this, SecondActivity.class);
//        String msg = msgTxt.getText().toString();
//        i.putExtra("message", msg);
//        myActivityResultLauncher.launch(i);
//
//    }
//
//    ActivityResultLauncher<Intent> myActivityResultLauncher = registerForActivityResult(
//            new ActivityResultContracts.StartActivityForResult(),
//            new ActivityResultCallback<ActivityResult>() {
//                @Override
//                public void onActivityResult(ActivityResult result) {
//                    if (result.getResultCode() == Activity.RESULT_OK) {
//                        // There are no request codes
//                        Intent data = result.getData();
//                        String reply = data.getStringExtra("messageRep");
//                        headerMsg.setVisibility(View.VISIBLE);
//                        reponseMsg.setVisibility(View.VISIBLE);
//                        reponseMsg.setText(reply);
//
//                    }
//                }
//            });



}
