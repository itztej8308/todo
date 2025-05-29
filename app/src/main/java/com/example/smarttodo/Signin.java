package com.example.smarttodo;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Signin extends AppCompatActivity {


    FirebaseAuth mAuth;
    TextInputEditText emailInp ,passInp;
    Button button;

    TextView registerintent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signin);
        emailInp = findViewById(R.id.email);
        passInp = findViewById(R.id.password);
        button = findViewById(R.id.signin);
        registerintent = findViewById(R.id.registernow);

        registerintent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signin.this , Register.class);
                startActivity(intent);
                finish();
            }
        });

        mAuth = FirebaseAuth.getInstance();

        button.setOnClickListener(v -> {
            String email = emailInp.getText().toString();
            String password = passInp.getText().toString();

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(Signin.this, "Fill the all Field", Toast.LENGTH_SHORT).show();
            };
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);


                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(Signin.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                updateUI(null);
                            }
                        }
                    });
        });




    }
    private void updateUI(FirebaseUser user) {
        if (user != null) {
            Toast.makeText(Signin.this, "Welcome " + user.getEmail(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Signin.this , Homepage.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(Signin.this, "Login failed. Please try again.", Toast.LENGTH_SHORT).show();
        }
    }

}