package com.example.shilpa.ianc;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String sNews = "";

        String[] itemsIANC = {"About", "Past Event", "Current Committee", "Join us"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemsIANC);
        ListView list = (ListView) findViewById(android.R.id.list);
        list.setAdapter(arrayAdapter);

        TextView txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setTextColor(Color.rgb(255, 255, 255));

        TextView txtCurrentNews = (TextView) findViewById(R.id.txtCurrentNews);
        sNews = "IANC Holi celebrations on 24th April 2016 from 3-6pm.";
        sNews += "Venue: University Village Clubhouse, 1600 W Plum Street, Fort Collins, CO 80521";

        txtCurrentNews.setText(sNews);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0){
                    Intent intent = new Intent(getBaseContext(),AboutPage.class);
                    startActivity(intent);
                }
                else if (position == 1){
                    Intent intent = new Intent(getBaseContext(),PastEvent.class);
                    startActivity(intent);
                }
                else if (position == 2){
                    Intent intent = new Intent(getBaseContext(),JoinUs.class);
                    startActivity(intent);

                }else if (position == 3){

                    String url = "https://groups.yahoo.com/neo";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);


                }

                //Toast.makeText(getApplicationContext(),
                //        "Click ListItem Number " + position, Toast.LENGTH_LONG)
                //        .show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
