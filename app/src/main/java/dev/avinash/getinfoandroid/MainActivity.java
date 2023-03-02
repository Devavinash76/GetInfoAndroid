package dev.avinash.getinfoandroid;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.btn_get);
        final TextView textView = (TextView)findViewById(R.id.device_name);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(
                        "SERIAL: " + Build.SERIAL + "\n" +
                                "MODEL: " + Build.MODEL + "\n" +
                                "ID: " + Build.ID + "\n" +
                                "Manufacture: " + Build.MANUFACTURER + "\n" +
                                "Brand: " + Build.BRAND + "\n" +
                                "Type: " + Build.TYPE + "\n" +
                                "User: " + Build.USER + "\n" +
                                "BASE: " + Build.VERSION_CODES.BASE + "\n" +
                                "INCREMENTAL: " + Build.VERSION.INCREMENTAL + "\n" +
                                "SDK:  " + Build.VERSION.SDK + "\n" +
                                "BOARD: " + Build.BOARD + "\n" +
                                "BRAND: " + Build.BRAND + "\n" +
                                "HOST: " + Build.HOST + "\n" +
                                "FINGERPRINT: "+Build.FINGERPRINT + "\n" +
                                "Version Code: " + Build.VERSION.RELEASE
                );
            }
        });
    }
}