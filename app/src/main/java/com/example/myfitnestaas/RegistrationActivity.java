package com.example.myfitnestaas;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationActivity extends AppCompatActivity
{
    Intent intent;
    private EditText redLogin, redPassword;
    private FirebaseAuth sAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        init();
    }

    private void init(){
        redLogin = findViewById(R.id.RTxt1);
        redPassword = findViewById(R.id.RTxt2);
        sAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser cUser = sAuth.getCurrentUser();
        if(cUser != null){
            Toast.makeText(this, "User not null", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "User null", Toast.LENGTH_SHORT).show();
        }
    }

    public void RButton1(View view) {
        if(!TextUtils.isEmpty(redLogin.getText().toString()) && !TextUtils.isEmpty(redPassword.getText().toString())) {
            sAuth.createUserWithEmailAndPassword(redLogin.getText().toString(), redPassword.getText().toString()).
                    addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "User SignUp Successeful", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "User SignUp Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void rbut2(View view) {
        Intent intent = new Intent(this,AuthorizationActivity.class);
        startActivity(intent);
    }
}
