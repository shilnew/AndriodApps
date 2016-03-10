package com.example.shilpa.db_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    myDBHandler dbHandler;
    EditText myText;
    TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText = (EditText) findViewById(R.id.myInputText);
        displayText = (TextView) findViewById(R.id.myDisplayText);
        dbHandler = new myDBHandler(this, null, null, 2);


    }

    public void printDatabase(){
        String dbString = dbHandler.dbToString();
        displayText.setText(dbString);
        myText.setText("");

    }

    public void addNewRow(View view){
        Products products = new Products(myText.getText().toString());
        dbHandler.addProduct(products);
        printDatabase();

    }

    public void deleteRow(View view){
        dbHandler.deleteProduct(myText.getText().toString());
        printDatabase();
    }
}
