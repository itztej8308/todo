package com.example.smarttodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Start_activity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start);
       btn = findViewById(R.id.startbtn);
        FirebaseUser currentUser;
        currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentUser!=null){
            startActivity(new Intent(this, Homepage.class));
        }else {
            startActivity(new Intent(this, Signin.class));
        }

       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (currentUser != null){
               Intent i = new Intent(Start_activity.this , Homepage.class);
               startActivity(i);
               finish();
               }else {
                   Intent i = new Intent(Start_activity.this , Signin.class);
                   startActivity(i);
                   finish();
               }
           }
       });
    }
}