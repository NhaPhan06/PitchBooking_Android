package com.example.pitchbooking.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.database.Cursor;
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
import android.widget.Toast;

import com.example.pitchbooking.R;
import com.example.pitchbooking.activity.DataBase;
import com.example.pitchbooking.activity.Model.Account.Account;
import com.example.pitchbooking.activity.Model.Check.Check;
import com.example.pitchbooking.activity.Model.Schedule.Schedule;

import java.sql.Time;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class BookingPitch extends AppCompatActivity {

    TextView startDateEditText, chonGioTextView, endGioText;

    Button Booking;
    Spinner sanSpinners;
    Button btnback;
    DataBase database;
    ArrayList<Check> checks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_pitch);
        startDateEditText = findViewById(R.id.select_Date);
        chonGioTextView = findViewById(R.id.Chon_gio);
        endGioText = findViewById(R.id.end_gio);
        sanSpinners = findViewById(R.id.sanSpinner);
        btnback = findViewById(R.id.apcardBackHome);

        database = new DataBase(BookingPitch.this, "2.sqlite", null, 1);

        checks = new ArrayList<>();

        Intent intent = getIntent();
        Account acc = (Account) intent.getSerializableExtra("Customer");

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BookingPitch.this, HomePageActivity.class);
                intent.putExtra("Customer", acc);
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

        String[] sanList = {"5", "7"};
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

        Booking = (Button) findViewById(R.id.apcardApprove);

        Booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int check = Check2(Check(startDateEditText.getText().toString(), chonGioTextView.getText().toString(), endGioText.getText().toString()));
                if (check == -1){
                    Toast.makeText(getApplicationContext(), "Khung Gio Da Het San", Toast.LENGTH_SHORT).show();
                }
                else {
                    database.QueryData("INSERT INTO Schedule (CustomerId, PitchId, starTime, endTime, date, status) VALUES " +
                            "('"+ acc.Id + "', '"+check+"', '"+chonGioTextView.getText().toString()+"', '"+endGioText.getText().toString()+"', '"+startDateEditText.getText().toString()+"', 'PROCESS')");
                }
                }
            }
        );

    }

    private int[] Check(String date, String sTime, String eTime) {
        String query = "SELECT * FROM Schedule Where date = '" + date + "'";
        Cursor data = database.GetData(query);
        checks.clear();
        int count = 0;

        int[] pitchs = new int[10];

        Time sCheck = Time.valueOf(sTime);
        Time eCheck = Time.valueOf(eTime);

        while (data.moveToNext()) {
            int id = data.getInt(0);
            String start = data.getString(3);
            Time s = Time.valueOf(start);
            String end = data.getString(4);
            Time e = Time.valueOf(end);
            checks.add(new Check(id, s, e));
        }
        for (Check check : checks) {
            if ((check.start.after(sCheck) && check.start.before(eCheck))
                    || (check.end.after(sCheck) && check.end.before(eCheck))
                    || (check.start.before(sCheck) && check.end.after(eCheck))) {
                pitchs[count] = check.Id;
                count++;
            }
        }
        return pitchs;
    }

    private int Check2(int[] check) {
        String query = "SELECT id FROM Pitch";
        Cursor data = database.GetData(query);
        int count = 0;
        int[] pitchs = new int[100];
        while (data.moveToNext()) {
            int id = data.getInt(0);
            pitchs[count] = id;
            count++;
        }
        int nonDuplicateValue = -1;

        for (int i = 0; i < pitchs.length; i++) {
            int currentValue = pitchs[i];
            boolean isDuplicate = false;
            for (int j = 0; j < check.length; j++) {
                if (currentValue == check[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                nonDuplicateValue = currentValue;
                break;
            }
        }
        return nonDuplicateValue;
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(year, month, dayOfMonth);

                // Kiểm tra nếu ngày đã chọn là trong tương lai hoặc cùng ngày với ngày hiện tại
                if (!selectedDate.before(calendar)) {
                    // Xử lý ngày đã chọn
                    String selectedDateStr = String.format(Locale.getDefault(), "%02d-%02d-%d", dayOfMonth, (month + 1), year);
                    startDateEditText.setText(selectedDateStr);
                } else {
                    // Ngày đã chọn nằm trong quá khứ, bạn có thể thông báo lỗi hoặc xử lý theo cách khác tùy ý.
                    // Toast.makeText(getApplicationContext(), "Không cho phép chọn ngày trong quá khứ.", Toast.LENGTH_SHORT).show();
                }
            }
        }, currentYear, currentMonth, currentDay);

        // Không cho phép hiển thị lịch chọn ngày trong quá khứ
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
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
                if (hourOfDay >= 6 && hourOfDay <= 22) {
                    String selectedTime = String.format(Locale.getDefault(), "%02d:%02d:%02d", hourOfDay, minute, 0);
                    chonGioTextView.setText(selectedTime);
                } else {
                    Toast.makeText(getApplicationContext(), "Hãy chọn giờ từ 6h đến 22h", Toast.LENGTH_SHORT).show();
                }
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
                if (hourOfDay >= 6 && hourOfDay <= 22) {
                    String selectedTime = String.format(Locale.getDefault(), "%02d:%02d:%02d", hourOfDay, minute, 0);
                    endGioText.setText(selectedTime);
                } else {
                    Toast.makeText(getApplicationContext(), "Hãy chọn giờ từ 6h đến 22h", Toast.LENGTH_SHORT).show();
                }
            }
        }, hour, minute, true);

        timePickerDialog.show();
    }
}