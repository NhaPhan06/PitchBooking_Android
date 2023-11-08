package com.example.pitchbooking.activity.adapter.BookingHistory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pitchbooking.R;
import com.example.pitchbooking.activity.Model.Schedule.Schedule;
import com.example.pitchbooking.activity.activity.BookingHistory;
import com.example.pitchbooking.activity.activity.CurrentBookingActivity;
import com.example.pitchbooking.activity.adapter.CurrentBooking.CurrentBookingAdapter;

import java.util.ArrayList;

public class BookingHistoryAdapter extends BaseAdapter {

    private BookingHistory context;
    private int layout;
    private ArrayList<Schedule> arr;

    public BookingHistoryAdapter(BookingHistory context, int layout, ArrayList<Schedule> arr) {
        this.context = context;
        this.layout = layout;
        this.arr = arr;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtId, txtName, txtStart, txtEnd, txtDate;
        ImageView imgTrash, imgEdit;
        public ViewHolder() {
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookingHistoryAdapter.ViewHolder viewHolder = null;

        if (viewHolder == null) {
            viewHolder = new BookingHistoryAdapter.ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.lv_current_booking, null);


            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.txtStart = (TextView) convertView.findViewById(R.id.txtStart);
            viewHolder.txtEnd = (TextView) convertView.findViewById(R.id.txtEnd);
            viewHolder.txtDate = (TextView) convertView.findViewById(R.id.txtDate);
            viewHolder.txtId = (TextView) convertView.findViewById(R.id.txtId);

            viewHolder.imgEdit = (ImageView) convertView.findViewById(R.id.iconEdit);
            viewHolder.imgTrash = (ImageView) convertView.findViewById(R.id.iconDelete);

            convertView.setTag(viewHolder);
        }

        Schedule schedule = arr.get(position);
        viewHolder.txtId.setText("Id:              "+Integer.toString(schedule.getId()));
        viewHolder.txtName.setText("Pitch:           "+Integer.toString(schedule.getPitchId()));
        viewHolder.txtStart.setText("Start Time: "+schedule.getStartTime());
        viewHolder.txtEnd.setText("End Time:   "+schedule.getEndTime());
        viewHolder.txtDate.setText("Date:       "+schedule.getDate());

        viewHolder.imgTrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        viewHolder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }


}