package com.example.smarttodo;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class add extends Fragment {



    TextInputEditText textInputEditText;
    ImageView calenderview;
    TextView datepicker;
    Spinner spinner;
    String selectedDate ="";

    boolean taskAdded = false;
    Button savebtn;

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

        savebtn = view.findViewById(R.id.save);


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
                        selectedDate = date;
                    },
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH));
            dpd.show();

        });


        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = textInputEditText.getText().toString();
                String tasktype = spinner.getSelectedItem().toString();

                if (task.isEmpty() || selectedDate.isEmpty()){
                    Toast.makeText(requireContext(), "Enter Task and select Date ", Toast.LENGTH_SHORT).show();
                }else {
                    insertTaskToFirestore(task,tasktype,selectedDate);
                }
            }
        });

        return view;
    }

    private void insertTaskToFirestore(String task, String taskType, String date) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> taskData = new HashMap<>();
        taskData.put("task", task);
        taskData.put("taskType", taskType);
        taskData.put("date", date);

        db.collection("TaskAdd")
                .add(taskData)
                .addOnSuccessListener(docRef ->{
                        Toast.makeText(requireContext(), "Task saved", Toast.LENGTH_SHORT).show();

                 textInputEditText.setText("");
                 spinner.setSelection(0);
                 datepicker.setText("Select Date");
                 selectedDate="";

                })

                .addOnFailureListener(e ->
                        Toast.makeText(requireContext(), "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show());
    }
}
