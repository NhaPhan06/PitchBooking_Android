package com.example.pitchbooking.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.pitchbooking.R;

import java.util.Calendar;
import java.util.Locale;

public class BookingPitch extends AppCompatActivity {

    TextView startDateEditText, chonGioTextView, endGioText;
    Spinner sanSpinners;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_pitch);
        startDateEditText = findViewById(R.id.select_Date);
        chonGioTextView = findViewById(R.id.Chon_gio);
        endGioText = findViewById(R.id.end_gio);
        sanSpinners = findViewById(R.id.sanSpinner);
        btnback = findViewById(R.id.apcardBackHome);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookingPitch.this, HomePageActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        startDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        chonGioTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });
        endGioText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEndTimePickerDialog();
            }
        });


        String[] sanList = {"Sân A", "Sân B", "Sân C", "Sân D", "Sân E"};
        ArrayAdapter<String> sanAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, sanList);
        sanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sanSpinners.setAdapter(sanAdapter);

        sanSpinners.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedSan = sanList[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // Xử lý ngày đã chọn
                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                startDateEditText.setText(selectedDate);
            }
        }, currentYear, currentMonth, currentDay); // Thay đổi ngày mặc định ở đây

        datePickerDialog.show();
    }
    private void showTimePickerDialog() {
        Calendar currentTime = Calendar.getInstance();
        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        int minute = currentTime.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                // Xử lý giờ đã chọn
                String selectedTime = String.format(Locale.getDefault(), "%02d:%02d", hourOfDay, minute);
                chonGioTextView.setText(selectedTime);
            }
        }, hour, minute, true);

        timePickerDialog.show();
    }

    private void showEndTimePickerDialog() {
        Calendar currentTime = Calendar.getInstance();
        int hour = currentTime.get(Calendar.HOUR_OF_DAY);
        int minute = currentTime.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                // Xử lý giờ đã chọn
                String selectedTime = String.format(Locale.getDefault(), "%02d:%02d", hourOfDay, minute);
                endGioText.setText(selectedTime);
            }
        }, hour, minute, true);

        timePickerDialog.show();
    }
}