package com.superprofan.dict1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = findViewById(R.id.griview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                Intent i = new Intent(getApplicationContext(),LearningActivity.class);
                i.putExtra("id", position);
                startActivity(i);

               //Toast.makeText(MainActivity.this, "" + id, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
