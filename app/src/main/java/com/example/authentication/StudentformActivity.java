package com.example.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TimePicker;

import java.util.Calendar;

public class StudentformActivity extends AppCompatActivity  implements
        View.OnClickListener {

    private static final int PICK_FILE_REQUEST_CODE = 1;
    Button btnTimePicker;
    EditText txtTime;
    private int mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentform);
        Button btnUpload = findViewById(R.id.btnUpload);
        btnTimePicker = (Button) findViewById(R.id.btn_time);
        txtTime = (EditText) findViewById(R.id.time);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        final EditText vehicleTypeField = findViewById(R.id.vehicleTypeField);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioYes) {
                    vehicleTypeField.setVisibility(View.VISIBLE);
                } else if (checkedId == R.id.radioNo) {
                    vehicleTypeField.setVisibility(View.GONE);
                    // You may want to clear the text when hiding the field
                    vehicleTypeField.setText("");
                }
            }
        });

        btnTimePicker.setOnClickListener((View.OnClickListener) this);

        // Set an onClickListener for the upload button
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilePicker();
            }
        });
    }

    // Method to open the file picker
    public void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*"); // Allow all file types
        startActivityForResult(intent, PICK_FILE_REQUEST_CODE);
    }
    protected void onActivityResult( int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_FILE_REQUEST_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                Uri selectedFileUri = data.getData();
                // Handle the selected file URI as needed
            }
        }
    }

    public void onClick(View v) {
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            int mHour = c.get(Calendar.HOUR_OF_DAY);
            int mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }


    }
}