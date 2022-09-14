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

        setActivity(R.id.userButton,UserLogin.class);
        setActivity(R.id.managerButton,ManagerLogin.class);
    }
    void setActivity(int ID, java.lang.Class<?> cls){
        Button button = (Button)findViewById(ID);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), cls);
            startActivity(intent);
        });
    }
}