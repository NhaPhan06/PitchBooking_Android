package com.example.pitchbooking.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import com.example.pitchbooking.R;
import com.example.pitchbooking.activity.DataBase;
import com.example.pitchbooking.activity.Model.Account.Account;
import com.example.pitchbooking.activity.Model.Schedule.Schedule;
import com.example.pitchbooking.activity.adapter.CurrentBooking.CurrentBookingAdapter;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

public class CurrentBookingActivity extends AppCompatActivity {

    CurrentBookingAdapter adapter;
    ArrayList<Schedule> arr;
    ListView listView;
    DataBase database;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_booking);

        database = new DataBase(CurrentBookingActivity.this, "2.sqlite", null, 1);

        arr = new ArrayList<>();
        listView = findViewById(R.id.currentBooking);
        adapter = new CurrentBookingAdapter(CurrentBookingActivity.this, R.layout.lv_current_booking, arr);
        listView.setAdapter(adapter);

        Intent intent = getIntent();
        Account acc = (Account) intent.getSerializableExtra("Customer");

        Get(acc.getId(), "PROCESS");

    }

    private void Get(int customer, String statusCus) {

        String query = "SELECT * FROM Schedule WHERE CustomerId = '" + customer + "' AND Status = '" + statusCus + "'";
        Cursor data = database.GetData(query);
        arr.clear();
        while (data.moveToNext()) {
            int id = data.getInt(0);
            int customerId = data.getInt(1);
            int pitchId  = data.getInt(2);
            String start = data.getString(3);
            String end = data.getString(4);
            String date = data.getString(5);
            String status = data.getString(6);
            arr.add(new Schedule(id,customerId, pitchId, start, end, date, status));
        }
        adapter.notifyDataSetChanged();
    }
}