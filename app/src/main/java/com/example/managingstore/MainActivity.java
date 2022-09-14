package com.example.managingstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button userButton = (Button) findViewById(R.id.userButton);
        userButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), UserLogin.class);
            startActivity(intent);
        });

        Button managerButton = (Button) findViewById(R.id.managerButton);
        managerButton.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ManagerLogin.class);
            startActivity(intent);
        });
    }
}