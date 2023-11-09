package com.example.pitchbooking.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pitchbooking.R;
import com.example.pitchbooking.activity.DataBase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterPage extends AppCompatActivity {

    DataBase database;

    TextView txtEmail, txtName, txtPhone, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        txtEmail = findViewById(R.id.text_email);
        txtName = findViewById(R.id.text_name);
        txtPhone = findViewById(R.id.text_phone);
        txtPass = findViewById(R.id.password);

        database = new DataBase(RegisterPage.this, "2.sqlite", null, 1);

    }

    public void Register(){
        String phone = "\\d{10}";
        String EMAIL_PATTERN = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
        if (txtName.getText().toString() != null && txtEmail.getText().toString() != null && txtPass.getText().toString() != null && txtPhone.getText().toString() != null ){
            if (Pattern.matches(phone, txtPhone.getText().toString()) ){
                if (Pattern.matches(EMAIL_PATTERN, txtEmail.getText().toString())){
                    database.QueryData("INSERT INTO Account (email, password, fullName, phone, role) " +
                            "VALUES ('"+txtEmail.getText().toString()+"', '"+txtPass.getText().toString()+"', '"+txtName.getText().toString()+"', '"+txtPhone.getText().toString()+"', 'customer')");
                    Intent intent = new Intent(RegisterPage.this, LoginPageActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "A@B.C", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(getApplicationContext(), "Phone Gồm 10 số.", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(), "Không để trống.", Toast.LENGTH_SHORT).show();
        }
    }

    public void onLoginActivity(View v){
        Intent intent = new Intent(RegisterPage.this, LoginPageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    public void onRegisterActivity(View view){
        Register();
    }


}