package com.example.pitchbooking.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.pitchbooking.R;
import com.example.pitchbooking.activity.DataBase;
import com.example.pitchbooking.activity.Model.Check.AllBooking;
import com.example.pitchbooking.activity.Model.Pitch;
import com.example.pitchbooking.activity.adapter.Admin.AllBookingAdapter;
import com.example.pitchbooking.activity.adapter.Admin.ListPitchAdapter;

import java.util.ArrayList;

public class AdminListPitch extends AppCompatActivity {

    Button updateBtn;
    ListPitchAdapter adapter;
    ArrayList<Pitch> arr;
    ListView listView;
    DataBase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_list_pitch);
        updateBtn = findViewById(R.id.UpdatePitch);

        database = new DataBase(AdminListPitch.this, "2.sqlite", null, 1);

        arr = new ArrayList<>();
        listView = findViewById(R.id.list_pitch);
        adapter = new ListPitchAdapter(AdminListPitch.this, R.layout.lv_pitch, arr);
        listView.setAdapter(adapter);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminListPitch.this, UpdatePitch.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        Get();
    }

    private void Get() {
        String query = "SELECT * FROM Pitch";
        Cursor data = database.GetData(query);
        arr.clear();
        while (data.moveToNext()) {
            int id = data.getInt(0);
            String name  = data.getString(1);
            arr.add(new Pitch(id, name));
        }
        adapter.notifyDataSetChanged();
    }

    public void onMenuClickAdmin(View view) {
        Intent intent = new Intent(AdminListPitch.this, adminPage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}