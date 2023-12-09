package com.cst2335.wood0642;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_relative);

         Button ClickButton = findViewById(R.id.Button1);
         Switch SwitchButton = findViewById(R.id.Switch1);
         ClickButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Toast.makeText(getApplicationContext(),getResources().getString(R.string.toastmessage),Toast.LENGTH_LONG).show();
             }
         });
         SwitchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(CompoundButton cb, boolean b) {
             String switchCheck;
            if (b){
                switchCheck="on";
            }else {
                switchCheck="off";
            }
            String SwitchMessage = "the switch is now " + switchCheck;

            Snackbar snackbar = Snackbar.make(cb,SwitchMessage,Snackbar.LENGTH_LONG)
             .setAction("Undo",click -> cb.setChecked(!b) );
            snackbar.show();
             }
         });


    }
}