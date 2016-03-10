package com.example.shilpa.ianc;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
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

        String[] itemsIANC = {"About", "Past Event", "Current Committee", "Join us"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemsIANC);
        ListView list = (ListView) findViewById(android.R.id.list);
        list.setAdapter(arrayAdapter);

        TextView txtTitle = (TextView) findViewById(R.id.txtTitle);
        txtTitle.setTextColor(Color.rgb(255, 255, 255));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0){
                    Intent intent = new Intent(getBaseContext(),AboutPage.class);
                    startActivity(intent);
                }
                else if (position == 1){
                    Toast.makeText(getApplicationContext(),
                            "Show the past events", Toast.LENGTH_LONG)
                            .show();
                }
                else if (position == 2){
                    Toast.makeText(getApplicationContext(),
                            "Show the current committee", Toast.LENGTH_LONG)
                            .show();
                }else if (position == 3){
                    Intent intent = new Intent(getBaseContext(),JoinUs.class);
                    startActivity(intent);
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
