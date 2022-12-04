package com.example.whatsappextender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    EditText msgEditText, phoneNoEditText;
    String countryCode="+91";
    Button sendButton;
    String whatsappUri = "https://api.whatsapp.com/send?phone=";
    String number = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgEditText = (EditText) findViewById(R.id.msgEditText);
        phoneNoEditText = (EditText) findViewById(R.id.phoneNoEditText);
        sendButton = (Button) findViewById(R.id.sendButton);
        if (phoneNoEditText.getText() != null) {
            number = phoneNoEditText.getText().toString();
        } else {
            Toast.makeText(this, "Please enter number", Toast.LENGTH_SHORT).show();
        }
// Taking reference of Edit Text
        final EditText messageEditText = findViewById(R.id.phoneNoEditText);

        // Taking reference to button
        Button submit = findViewById(R.id.sendButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = countryCode+phoneNoEditText.getText().toString();
                String message= msgEditText.getText().toString();
                try {
                    sendData(number,message);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void sendData(String number,String message) throws UnsupportedEncodingException {
        String url = whatsappUri+ number;
        String messageUrl = "https://api.whatsapp.com/send?phone="+ number +"&text=" + URLEncoder.encode(message, "UTF-8");
        Log.d("MainActivity", "url"+url+"message"+messageUrl);
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        i.setData(Uri.parse(messageUrl));
        startActivity(i);

    }


}
