package com.example.pitchbooking.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pitchbooking.R;
import com.example.pitchbooking.activity.Model.Account.Account;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
//        initRecyclerview();
//        RecyclerView rvPitchList = findViewById(R.id.ListView);
//        pitches = new ArrayList<>();
//        pitches.add(new Pitch("san", R.drawable.pitchbooking, 3));
//        rvPitchList.setAdapter(new pitchListAdapter(pitches));
//        rvPitchList.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initRecyclerview() {


    }


    public void onMenuClick(View view) {
        Intent intentGet = getIntent();
        Account acc = (Account) intentGet.getSerializableExtra("Customer");

        Intent intent = new Intent(HomePageActivity.this, UserMenu.class);
        intent.putExtra("Customer", acc);
        startActivity(intent);
        finish();
    }
    public void onProfilePage(View view) {
        Intent intent = new Intent(HomePageActivity.this, UserProfile.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    public void onBookingClick(View view) {
        Intent intentGet = getIntent();
        Account acc = (Account) intentGet.getSerializableExtra("Customer");

        Intent intent = new Intent(HomePageActivity.this, BookingPitch.class);
        intent.putExtra("Customer", acc);
        startActivity(intent);
        finish();
    }
}