package com.example.smarttodo;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class bottomSheet extends AppCompatActivity  {

    TextInputEditText textInputEditText;
    ImageView calenderview;
    Button saveButton;
    Spinner spinner;


    TextView datepicker;


    private String [] task = {
            "Today's Task",
            "Weekly Task"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_sheet_layout);

        textInputEditText = findViewById(R.id.addtext);
        calenderview = findViewById(R.id.calendersheet);
        saveButton = findViewById(R.id.save);
        datepicker = findViewById(R.id.datepicker);
        spinner = findViewById(R.id.spinner);




        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                task
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);








        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the DatePickerDialog when calendar icon is clicked
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(bottomSheet.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                                String date = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                                datepicker.setText(date);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });


    }
}
