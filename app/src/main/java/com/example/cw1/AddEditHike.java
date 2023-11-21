package com.example.cw1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class AddEditHike extends AppCompatActivity {

    private ImageView pfp;
    private EditText hikenametxt, locationtxt, lengthtxt, desctxt;
    private RadioGroup BtngroupParking;
    private Spinner  level;
    private DatePicker datepickertxt;
    private FloatingActionButton addBtn;

//    String hikename, location, length, desc, datepicker, btnparking, Diff;
//    Integer radiobtn;

    //action bar
    private ActionBar actionBar;

    //permission
    private static final int CAMERA_REQUEST = 100;
    private static final int STORAGE_REQUEST = 200;
    private static final int IMAGE_FROM_GALLERY = 300;
    private static final int IMAGE_FROM_CAMERA = 400;

    //String array of permission
    private String[] cameraReq;
    private String[] storageReq;

    //database
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_hike);

        //init db
        dbHelper = new DBHelper(this);

        //init permission
//        cameraReq = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

        //init actino bar
        actionBar = getSupportActionBar();
        //title for action bar
        actionBar.setTitle("Add Hike");

        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        //init view
        pfp = findViewById(R.id.pfp);
        hikenametxt = findViewById(R.id.hikenametxt);
        locationtxt = findViewById(R.id.locationtxt);
        lengthtxt = findViewById(R.id.lengthtxt);
        desctxt = findViewById(R.id.desctxt);
        BtngroupParking = findViewById(R.id.BtngroupParking);
        datepickertxt = findViewById(R.id.datepickertxt);
        level = findViewById(R.id.level);
        addBtn = findViewById(R.id.addBtn);

        //event handler
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();
            }

            private void saveData() {

                //set data into var
//                hikename = hikenametxt.getText().toString();
//                location = locationtxt.getText().toString();
//                length = lengthtxt.getText().toString();
//                desc = desctxt.getText().toString();
//                datepicker = String.format("%02d-%02d-%d",
//                        datepickertxt.getDayOfMonth(), datepickertxt.getMonth() + 1, datepickertxt);
//                radiobtn = BtngroupParking.getCheckedRadioButtonId();
//                int btnSelected = BtngroupParking.getCheckedRadioButtonId();
//                boolean is_parking = btnSelected == R.id.radioBtnYes;
//
//                //check empty
//                if(hikename.isEmpty() || location.isEmpty() || length.isEmpty() ||
//                desc.isEmpty() || datepicker.isEmpty()){
//                    //save data, isnuser have 1 data
//                    Toast.makeText(getApplicationContext(), "Please fill in the form", Toast.LENGTH_SHORT).show();
                String hikename = hikenametxt.getText().toString().trim();
                String location = locationtxt.getText().toString().trim();
                String date = String.format("%02d-%02d-%d",
                        datepickertxt.getDayOfMonth(), datepickertxt.getMonth() + 1, datepickertxt.getYear());
                String length = lengthtxt.getText().toString().trim();
                String Diff = level.getSelectedItem().toString().trim();
                String description = desctxt.getText().toString().trim();
                int selectedRadioButtonId = BtngroupParking.getCheckedRadioButtonId();
                boolean is_parking = selectedRadioButtonId == R.id.radioBtnYes;

                //Time stamp
                String timeStamp = "" +System.currentTimeMillis();
                Log.d(hikename,"name");
                // Popup alert
                if (!hikename.isEmpty() || !location.isEmpty() || !date.isEmpty() ||
                        !length.isEmpty() || !Diff.isEmpty()) {

                   long id =  dbHelper.insertHike(
                         hikename,
                           location,
                           date,
                           String.valueOf(is_parking),
                            Diff,
                            length,
                            description,
                            timeStamp,
                           timeStamp
                    );
                    Toast.makeText(getApplicationContext(), "Inserted" +id, Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(AddEditHike.this, "Please fill out the form", Toast.LENGTH_SHORT).show();
                    return;
                }
            }



    });
    }

    @Override
    public boolean onSupportNavigateUp() {

        onBackPressed();
        return super.onSupportNavigateUp();
    }
//insert data in database from addEditHike class

}


