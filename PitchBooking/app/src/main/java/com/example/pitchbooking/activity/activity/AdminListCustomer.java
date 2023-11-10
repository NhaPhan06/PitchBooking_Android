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
import com.example.pitchbooking.activity.Model.Account.Account;
import com.example.pitchbooking.activity.Model.Pitch;
import com.example.pitchbooking.activity.adapter.Admin.ListCustomerAdapter;
import com.example.pitchbooking.activity.adapter.Admin.ListPitchAdapter;

import java.util.ArrayList;

public class AdminListCustomer extends AppCompatActivity {

    Button updateBtn;
    ListCustomerAdapter adapter;
    ArrayList<Account> arr;
    ListView listView;
    DataBase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_list_customer);

        database = new DataBase(AdminListCustomer.this, "2.sqlite", null, 1);

        arr = new ArrayList<>();
        listView = findViewById(R.id.list_customer);
        adapter = new ListCustomerAdapter(AdminListCustomer.this, R.layout.lv_customer, arr);
        listView.setAdapter(adapter);

        Get();
    }

    private void Get() {
        String query = "SELECT * FROM Account Where role = 'customer'";
        Cursor data = database.GetData(query);
        arr.clear();
        while (data.moveToNext()) {
            int id = Integer.parseInt(data.getString(0));
            String  email = data.getString(1);
            String fullname  = data.getString(3);
            String phone  = data.getString(4);
            String rol2  = data.getString(5);
            arr.add(new Account(id, email, "", fullname, phone, rol2));
        }
        adapter.notifyDataSetChanged();
    }

    public void onMenuClickAdmin(View view) {
        Intent intent = new Intent(AdminListCustomer.this, adminPage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}