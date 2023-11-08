package com.example.pitchbooking.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pitchbooking.R;
import com.example.pitchbooking.activity.DataBase;
import com.example.pitchbooking.activity.Model.Account.Account;

public class LoginPageActivity extends AppCompatActivity {

    DataBase database;
    Button Login;
    Account account;
    TextView txtemail;
    TextView txtpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Login = (Button) findViewById(R.id.login_button);
        txtemail = (TextView) findViewById(R.id.email);
        txtpassword = (TextView) findViewById(R.id.password);

        database = new DataBase(LoginPageActivity.this, "2.sqlite", null, 1);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý sự kiện đăng nhập ở đây
                String email  = txtemail.getText().toString();
                String password = txtpassword.getText().toString();
                // Xác thực người dùng và chuyển hướng tùy theo kết quả
                account = Login(email, password);
                if (account != null){
                    if (account.role.equals("admin")){

                    }
                    else {
                        onLoginActivity(v, account);
                    }
                }
                // Nếu sai

            }
        });

    }

    private Account Login(String email, String password) {
        Cursor data = database.GetData("Select * from Account Where email = '" + email + "' AND password = '" + password + "'" );
        if (data.moveToFirst()){
            int id = data.getInt(0);
            String mail = data.getString(1);
            String fullname = data.getString(3);
            String phone = data.getString(4);
            String role = data.getString(5);
            Account account1 = new Account(id, mail, null, fullname, phone, role);
            return account1;
        }
        data.close();
        return null;
    }

    public void onRegisterActivity(View view) {
        Intent intent = new Intent(LoginPageActivity.this, RegisterPage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    public void onLoginActivity(View view, Account acc) {
        Intent intent = new Intent(LoginPageActivity.this, HomePageActivity.class);
        intent.putExtra("Customer", acc);
        startActivity(intent);
        finish();
    }
}