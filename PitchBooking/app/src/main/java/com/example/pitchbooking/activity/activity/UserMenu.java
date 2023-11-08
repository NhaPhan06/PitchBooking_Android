package com.example.pitchbooking.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pitchbooking.R;
import com.example.pitchbooking.activity.Model.Account.Account;

public class UserMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);
    }

    public void onHistoryBookingPageClick(View view){
        Intent intentGet = getIntent();
        Account acc = (Account) intentGet.getSerializableExtra("Customer");

        Intent intent = new Intent(UserMenu.this, CurrentBookingActivity.class);
        intent.putExtra("Customer", acc);
        startActivity(intent);
        finish();
    }
    public void onCurrentBookingPageClick(View view){
        Intent intentGet = getIntent();
        Account acc = (Account) intentGet.getSerializableExtra("Customer");

        Intent intent = new Intent(UserMenu.this, CurrentBookingActivity.class);
        intent.putExtra("Customer", acc);
        startActivity(intent);
        finish();
    }

    public void onHomePageClick(View view) {
        Intent intent = new Intent(UserMenu.this, HomePageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    public void onProfilePage(View view) {
        Intent intent = new Intent(UserMenu.this, UserProfile.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}