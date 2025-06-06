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
    FirebaseUser currentUser;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Check if user is already logged in
            FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

            if (currentUser != null) {
                // User is logged in, go directly to Homepage
                startActivity(new Intent(this, Homepage.class));
                finish(); // finish this activity so it can't be returned to
            } else {
                // User not logged in, show start screen
                setContentView(R.layout.activity_start);
                EdgeToEdge.enable(this);

                btn = findViewById(R.id.startbtn);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Go to sign-in screen
                        Intent intent = new Intent(Start_activity.this, Signin.class);
                        startActivity(intent);
                        finish(); // prevent back press from returning to this screen
                    }
                });
            }
        }
    }

