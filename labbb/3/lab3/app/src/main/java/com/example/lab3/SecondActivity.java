package com.example.lab3;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        Bundle arguments = getIntent().getExtras();
        String Name = arguments.get("name").toString();

        EditText editText = (EditText) findViewById(R.id.editText);
        Button addButton = (Button) findViewById(R.id.button3);
        Button delButton = (Button) findViewById(R.id.button4);
        ListView lv = findViewById(R.id.list);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setStroke(6, Color.YELLOW);
        lv.setBackground(drawable);

        ArrayList<String> myStringArray = new ArrayList<String>();
        ArrayAdapter<String> TextAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myStringArray);

        lv.setAdapter(TextAdapter);

        myStringArray.add(Name);
        TextAdapter.notifyDataSetChanged();

        addButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                myStringArray.add(editText.getText().toString());
                TextAdapter.notifyDataSetChanged();
            }
        });

        delButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                int indexOfLastElement = myStringArray.size() - 1;
                if (!myStringArray.isEmpty()){
                    myStringArray.remove(indexOfLastElement);
                    TextAdapter.notifyDataSetChanged();
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Список пуст!", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });


    }


}

