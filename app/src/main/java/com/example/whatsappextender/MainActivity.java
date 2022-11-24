package com.example.whatsappextender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText msgEditText, phoneNoEditText;
    Button sendButton;
    String uri = "com.whatsapp";
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

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWhatsapp();
            }
        });

    }

    private void openWhatsapp() {

        String uriConversation = "com.whatsapp.Conversation";
        Intent sendIntent;
      //  boolean isWhatsappInstalled = whatsappInstalledOrNot(uri);


       // if (isWhatsappInstalled==true) {
            sendIntent = new Intent("android.intent.action.VIEW",Uri.parse(uri));
            //sendIntent.setComponent(new ComponentName(uri, uriConversation));
            //sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(number) + "@s.whatsapp.net");
            startActivity(sendIntent);
//        } else {
//            Uri playStoreuri = Uri.parse("market://details?id=com.whatsapp");
//            Intent goToMarket = new Intent(Intent.ACTION_VIEW, playStoreuri);
//            Toast.makeText(this, "Forwarding to playstore",
//                    Toast.LENGTH_SHORT).show();
//            startActivity(goToMarket);
//        }
    }

//    private boolean whatsappInstalledOrNot(String uri) {
//        PackageInfo applicationInfo=null;
//        PackageManager packageManager = getPackageManager();
//        boolean appInstalled;
//        try {
//
//            applicationInfo=getPackageManager().getPackageInfo(uri,0);//pkgname,int flags
//            //Toast.makeText(this, ""+applicationInfo, Toast.LENGTH_LONG).show();
//            Log.i("whatsappInstalledOrNot", "whatsappInstalledOrNot: "+applicationInfo);
//            appInstalled = true;
//
//        } catch (PackageManager.NameNotFoundException e) {
//            appInstalled = false;
//            Log.i("whatsappInstalledOrNot", "whatsappInstalledOrNot: "+applicationInfo);
//           // Toast.makeText(this, "Whatsapp not installed. Please install it.", Toast.LENGTH_SHORT).show();
//        }
//        //Log.d("whatsapp", "whatsappInstalledOrNot: "+appInstalled);
//        Toast.makeText(this, ""+appInstalled, Toast.LENGTH_SHORT).show();
//        return appInstalled;
//    }
}