package com.example.cw1;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    //View
    private FloatingActionButton addBtn;
    private RecyclerView hikeRv;

    //Db
    private DBHelper dbHelper;

    //adapter
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init db
        dbHelper = new DBHelper(this);

        ////Initialize
        addBtn = findViewById(R.id.addBtn);
        hikeRv = findViewById(R.id.hikeRv);

        hikeRv.setHasFixedSize(true);


        //Listener
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // move to new activity to create new
                Intent intent = new Intent(MainActivity.this, AddEditHike.class);
                startActivity(intent);
            }
        });
        loadData();
    }

    private void loadData() {
        adapter = new Adapter(this, dbHelper.getAllData());
        hikeRv.setAdapter(adapter);
    }

    @Override
    protected void onResume(){
        super.onResume();
        loadData(); //refresg data
    }

}