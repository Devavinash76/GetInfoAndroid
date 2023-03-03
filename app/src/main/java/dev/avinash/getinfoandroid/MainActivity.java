package dev.avinash.getinfoandroid;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView,listView2;

    TextView text,text2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialise layout

        listView = findViewById(R.id.listview);

        text = findViewById(R.id.totalapp);

        listView2 = findViewById(R.id.listview2);

        text2 = findViewById(R.id.totalapp2);

        Button button = (Button)findViewById(R.id.btn_get);
        final TextView textView = (TextView)findViewById(R.id.device_name);

        String web = String.valueOf(getPackageManager().hasSystemFeature("android.software.webview"));
        Toast.makeText(getApplicationContext(),web,Toast.LENGTH_LONG).show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(
                                "Version Code: " + Build.VERSION.RELEASE
                );
            }
        });
    }
    public void getallapps(View view) {

        // get list of all the apps installed

        List<PackageInfo> packList = getPackageManager().getInstalledPackages(0);

        String[] apps = new String[packList.size()];

        for (int i = 0; i < packList.size(); i++) {

            PackageInfo packInfo = packList.get(i);

            apps[i] = packInfo.applicationInfo.loadLabel(getPackageManager()).toString();

        }

        // set all the apps name in list view

        listView.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, apps));

        // write total count of apps available.

        text.setText(packList.size() + " Apps are installed");

    }

    public void getallapps2(View view) {

        // get list of all the apps installed

        List<PackageInfo> packList = getPackageManager().getInstalledPackages(0);

        String[] apps = new String[packList.size()];

        for (int i = 0; i < packList.size(); i++) {

            PackageInfo packInfo = packList.get(i);

            apps[i] = packInfo.applicationInfo.loadLabel(getPackageManager()).toString();

        }

        // set all the apps name in list view

        listView2.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, apps));

        // write total count of apps available.

        text2.setText(packList.size() + " Apps are installed");

    }
}