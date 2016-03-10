package com.example.shilpa.ianc;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class AboutPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);

        TextView txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setTextColor(Color.rgb(255, 255, 255));

        EditText txtAbout = (EditText) findViewById(R.id.txtAbout);
        String aboutIANC = "IANC : India Association Of Northern Colorado, is a non- profit organisation. ";
                aboutIANC += "This organisation servers to celebrate the vivid culture and tradition of the Indian";
                aboutIANC += " subcontinent in Fort Collins.";
        txtAbout.setText(aboutIANC);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
