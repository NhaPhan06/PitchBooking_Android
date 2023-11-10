package com.example.pitchbooking.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.pitchbooking.R;
import com.example.pitchbooking.activity.DataBase;
import com.example.pitchbooking.activity.Model.Account.Account;
import com.example.pitchbooking.activity.Model.Check.AllBooking;
import com.example.pitchbooking.activity.Model.Schedule.Schedule;
import com.example.pitchbooking.activity.adapter.Admin.AllBookingAdapter;
import com.example.pitchbooking.activity.adapter.CurrentBooking.CurrentBookingAdapter;

import java.util.ArrayList;

public class Admin_AllBooking extends AppCompatActivity {

    AllBookingAdapter adapter;
    ArrayList<AllBooking> arr;
    ListView listView;
    DataBase database;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_all_booking);

        database = new DataBase(Admin_AllBooking.this, "2.sqlite", null, 1);

        arr = new ArrayList<>();
        listView = findViewById(R.id.AdminListView);
        adapter = new AllBookingAdapter(Admin_AllBooking.this, R.layout.lv_adminbooking, arr);
        listView.setAdapter(adapter);

        Intent intent = getIntent();
        Account acc = (Account) intent.getSerializableExtra("Customer");
        Get();
    }

    private void Get() {

        String query = "SELECT Schedule.id, Schedule.PitchId, Account.fullName,Schedule.starTime, Schedule.endTime, Schedule.date FROM Schedule JOIN ACCOUNT ON Schedule.CustomerId = Account.id";
        Cursor data = database.GetData(query);
        arr.clear();
        while (data.moveToNext()) {
            int id = data.getInt(0);
            int pitchId = data.getInt(1);
            String name  = data.getString(2);
            String start = data.getString(3);
            String end = data.getString(4);
            String date = data.getString(5);
            arr.add(new AllBooking(id, pitchId, name , start, end, date));
        }
        adapter.notifyDataSetChanged();
    }


    public void onMenuClickAdmin(View view) {
        Intent intent = new Intent(Admin_AllBooking.this, adminPage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}