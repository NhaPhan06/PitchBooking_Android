package com.example.pitchbooking.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pitchbooking.R;
import com.example.pitchbooking.activity.DataBase;

public class MainActivity extends AppCompatActivity {

    DataBase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new DataBase(MainActivity.this, "2.sqlite", null, 1);

        database.QueryData("CREATE TABLE IF NOT EXISTS Account (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "email NVARCHAR(100) UNIQUE, " +
                "password NVARCHAR(100), " +
                "fullName NVARCHAR(100), " +
                "phone NVARCHAR(100), " +
                "role NVARCHAR(100))"
        );

        database.QueryData("CREATE TABLE IF NOT EXISTS Pitch (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name NVARCHAR(100) UNIQUE, " +
                "size INTEGER)"
        );

        database.QueryData("CREATE TABLE IF NOT EXISTS Schedule (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "CustomerId NVARCHAR(100), " +
                "PitchId NVARCHAR(100)," +
                "starTime NVARCHAR(100), " +
                "endTime NVARCHAR(100), " +
                "date NVARCHAR(100), " +
                "status NVARCHAR(100)) "
        );


/*        database.QueryData("INSERT INTO Account (email, password, fullName, phone, role) " +
                "VALUES ('admin', '1', 'Phuc Nguyen', '0986747213', 'admin')");
        database.QueryData("INSERT INTO Account (email, password, fullName, phone, role) " +
                "VALUES ('QuynhPham', '1', 'Pham Xuan Quynh', '0942374825', 'customer')");
        database.QueryData("INSERT INTO Pitch (name, size) VALUES " +
                "('Sân 1', 5), " +
                "('Sân 2', 5), " +
                "('Sân 3', 7)");
        database.QueryData("INSERT INTO Schedule (CustomerId, PitchId, starTime, endTime, date, status) VALUES " +
                "(1, 1, 10, 12, '2023-11-01', 'completed'), " +
                "(2, 2, 15, 17, '2023-11-02', 'completed')");

        database.QueryData("INSERT INTO Schedule (CustomerId, PitchId, starTime, endTime, date, status) VALUES " +
                "('1', '1', '08:00:00', '10:00:00', '2023-11-01', 'DONE'), " +
                "('2', '2', '08:00:00', '10:00:00', '2023-11-01', 'DONE'), " +
                "('2', '2', '14:00:00', '16:00:00', '2023-11-12', 'PROCESS') ");

        database.QueryData("INSERT INTO Schedule (CustomerId, PitchId, starTime, endTime, date, status) VALUES " +
                "('2', '2', '14:30:00', '16:00:00', '2023-11-12', 'PROCESS') ");*/


    }

    public void onLoginActivity(View view){
        Intent intent = new Intent(MainActivity.this, LoginPageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    public void onRegisterActivity(View view) {
        Intent intent = new Intent(MainActivity.this, RegisterPage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    public void onAdminActivity(View view) {
        Intent intent = new Intent(MainActivity.this, adminPage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

}