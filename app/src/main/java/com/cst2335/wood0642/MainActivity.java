package com.cst2335.wood0642;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        loadEmail();
         Button loginbutton = findViewById(R.id.button);

        loginbutton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (isLoginValid()){
                     saveEmail();
                     Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                 }
             }
         });




    }

    private boolean isLoginValid() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        return !email.isEmpty() && password.equals("password");
    }
    @Override
    protected void onPause(){
        super.onPause();
        saveEmail();
    }

    private void saveEmail() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user_email", editTextEmail.getText().toString());
        editor.apply();
    }
    private void loadEmail() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String savedEmail = preferences.getString("user_email", "");
        editTextEmail.setText(savedEmail);
    }
}