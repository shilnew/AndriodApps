package com.example.shilpa.movingintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.view.MotionEvent;
import android.transition.TransitionManager;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    ViewGroup view_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view_group = (ViewGroup) findViewById(R.id.view_group);

        view_group.setOnTouchListener(
                new RelativeLayout.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view,MotionEvent event) {
                        moveButton();
                        return true;
                    }

                }
        );

       // Intent i = new Intent(this, exampleServiceIntent.class);
        Intent i = new Intent(this, MyService.class);
        startService(i);
    }

    public void moveButton(){

        View btnToSecond = (View) findViewById(R.id.btnToSecond);

        TransitionManager.beginDelayedTransition(view_group);
        //move the button
        RelativeLayout.LayoutParams setParamRules = new RelativeLayout.LayoutParams(
               RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        //setParamRules.addRule(ALIGN_PARENT_BOTTOM, TRUE);
        //setParamRules.addRule(ALIGN_PARENT_RIGHT, TRUE);
        btnToSecond.setLayoutParams(setParamRules);

        //resize the button
        ViewGroup.LayoutParams setRules = btnToSecond.getLayoutParams();
        setRules.width = 300;
        setRules.height = 300;
        btnToSecond.setLayoutParams(setRules);
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

    public void onClick(View view){
        Intent i = new Intent(this, secondAct.class);

        final EditText messageText = (EditText) findViewById(R.id.messageText);
        String messageFirst = messageText.getText().toString();
        i.putExtra("messageFirst", messageFirst);

        startActivity(i);
    }
}
