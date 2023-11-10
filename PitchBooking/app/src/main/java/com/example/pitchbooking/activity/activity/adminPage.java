package com.example.pitchbooking.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pitchbooking.R;

public class adminPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
    }

    public void onLogoutClick(View view) {
//        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(adminPage.this, LoginPageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
    public void add_pitchButton(View view) {
        Intent intent = new Intent(adminPage.this, AddPitchActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
    public void View_pitch_Button(View view) {
        Intent intent = new Intent(adminPage.this, AdminListPitch.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    public void booking_historyButton(View view) {
        Intent intent = new Intent(adminPage.this, Admin_AllBooking.class);
        startActivity(intent);
        finish();
    }

    public void view_customersButton(View view) {
        Intent intent = new Intent(adminPage.this, AdminListCustomer.class);
        startActivity(intent);
        finish();
    }

}