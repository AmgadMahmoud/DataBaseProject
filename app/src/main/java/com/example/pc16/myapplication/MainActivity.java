package com.example.pc16.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void addMethod (View v){
        EditText e1 = findViewById(R.id.edtID);
        String id = e1.getText().toString();
        EditText e2 = findViewById(R.id.edtName);
        String name = e2.getText().toString();
        EditText e3 = findViewById(R.id.edtPhone);
        String phone = e3.getText().toString();
        DBHelper DB = new DBHelper(this);
        DB.addRow(Integer.parseInt(id), name, phone);
    }
    public void readMethod (View v){
        EditText e1 = findViewById(R.id.edtID);
        String id = e1.getText().toString();
        DBHelper DB = new DBHelper(this);
        String name = DB.readContact(Integer.parseInt(id));
        TextView eRead = findViewById(R.id.textView);
        eRead.setText(name);
    }
    public void readAll (View v){
        DBHelper DB = new DBHelper(this);
        String name = DB.getAllNames();
        TextView eRead = findViewById(R.id.textView);
        eRead.setText(name);
    }
}
