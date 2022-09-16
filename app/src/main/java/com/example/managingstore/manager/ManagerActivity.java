package com.example.managingstore.manager;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.managingstore.R;
import com.example.managingstore.databinding.ManagerDomainBinding;


public class ManagerActivity extends AppCompatActivity {

    ManagerDomainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ManagerDomainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new AddUpPictures());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.managerFirstFragment:
                    replaceFragment(new AddUpPictures());
                   break;
                case R.id.managerSecondFragment:
                    replaceFragment(new CheckPictures());
                    break;
                case R.id.managerThirdFragment:
                    replaceFragment(new OtherSettings());

            }
            return true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,fragment);
        fragmentTransaction.commit();
    }
}
