package com.example.managingstore;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ManagerLogin extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager_login);

        Button loginButton = (Button)findViewById(R.id.loginButton);
        loginButton.setOnClickListener(view -> {

            String ID = ((EditText)findViewById(R.id.idInput)).getText().toString();
            String password = ((EditText)findViewById(R.id.passwordInput)).getText().toString();

            if(isValid(ID,password)){
               Intent intent = new Intent(getApplicationContext(),ManagerActivity.class);
               startActivity(intent);
            }else{
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("로그인 실패");
                alert.setPositiveButton("확인", (dialog, which) -> dialog.dismiss());
                alert.setMessage("아이디 혹은 비밀번호가 틀렸거나, 존재하지 않는 관리자입니다.");
                alert.show();
            }
        });
    }
    boolean isValid(String ID, String password){

        /*TODO : DB 와 소켓통신으로 개발해야 되는 부분.
         * 로그인 기능 구현해서, 관리자인지, 사용자인지 여부 체크하거나 아니면 DB를 따로 파서 관리할 것.
         * 당장은 Admin 으로 해서 하나의 id/pw 만 있음. (For making Prototype)
         */

        return ID.equals("admin") && password.equals("1234");
    }
}
