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

public class AuthorizationActivity extends AppCompatActivity {

    Intent intent;
    private EditText edLogin, edPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        init();
    }


    private void init(){
        edLogin = findViewById(R.id.ATxt1);
        edPassword = findViewById(R.id.ATxt2);
        mAuth = FirebaseAuth.getInstance();
    }

    public void AButton1(View view) {
        if(!TextUtils.isEmpty(edLogin.getText().toString()) && !TextUtils.isEmpty(edPassword.getText().toString())) {
            mAuth.signInWithEmailAndPassword( edLogin.getText().toString(), edPassword.getText().toString()).
                    addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "User SignIn Successeful", Toast.LENGTH_SHORT).show();
                        intent = new Intent(AuthorizationActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "User SignIn Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        else {
            Toast.makeText(getApplicationContext(), "Please enter Email and Password", Toast.LENGTH_SHORT).show();
        }
    }

    public void AButton2(View view) {
        intent = new Intent(AuthorizationActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }
}
