package com.example.smarttodo;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;


public class add extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    TextInputEditText textInputEditText;
    ImageView calenderview;
    TextView datepicker;
    Spinner spinner;

    public add() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // ✅ FIX: Assign layout to a variable
        View view = inflater.inflate(R.layout.fragment_add, container, false);

        textInputEditText = view.findViewById(R.id.addtext);
        calenderview = view.findViewById(R.id.calendersheet);
        datepicker = view.findViewById(R.id.datepicker);
        spinner = view.findViewById(R.id.spinner);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                requireContext(),
                R.array.task,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        // Calendar click
        calenderview.setOnClickListener(v -> {
            Calendar cal = Calendar.getInstance();
            DatePickerDialog dpd = new DatePickerDialog(requireContext(),
                    (DatePicker view1, int year, int month, int day) -> {
                        String date = year + "-" + (month + 1) + "-" + day;
                        datepicker.setText(date);
                    },
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH));
            dpd.show();

        });

        return view; // ✅ Return only after initializing everything
    }
}
