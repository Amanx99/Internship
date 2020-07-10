package com.example.fliply;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import model.Users;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupWithEmail extends AppCompatActivity {

    EditText name, email, password;
    TextView signup,login;
    FirebaseAuth fAuth;
    DatabaseReference mDatabase;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email2);
        password = findViewById(R.id.password2);
        signup = findViewById(R.id.signup2);
        login = findViewById(R.id.login3);

        fAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nameText = name.getText().toString();
                final String emailText = email.getText().toString();
                final String passwordText = password.getText().toString();

                if(TextUtils.isEmpty(nameText)) {
                    name.setError("Name is required");
                    return;
                }

                if(TextUtils.isEmpty(emailText)) {
                    email.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(passwordText)) {
                    password.setError("Password is required");
                    return;
                }

                if(passwordText.length() > 6) {
                    password.setError("Password must be >= 6 characters");
                }

                fAuth.createUserWithEmailAndPassword(emailText,passwordText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(SignupWithEmail.this, "User Created",Toast.LENGTH_SHORT).show();
                            String userId = fAuth.getCurrentUser().getUid();
                            writeNewUser(userId,nameText,emailText);
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }else {
                            Toast.makeText(SignupWithEmail.this,"Error!" + task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }

    private void writeNewUser(String userId, String name, String email) {
        Users users = new Users(name, email);

        mDatabase.child("users").child(userId).setValue(users);
    }
}
