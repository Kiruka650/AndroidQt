package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast toast = Toast.makeText(MainActivity.this,
                "Активити запущена!", Toast.LENGTH_SHORT);
        toast.show();


    }


    public void startNewActivity(View v){
        Intent intent = new Intent(this, SecondActivity.class);
        String Name = ((EditText)findViewById(R.id.editTextTextPersonName)).getText().toString();
        intent.putExtra("name", Name);
        startActivity(intent);
    }
}
