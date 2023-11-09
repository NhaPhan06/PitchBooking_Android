package com.example.pitchbooking.activity.adapter.Admin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pitchbooking.R;
import com.example.pitchbooking.activity.Model.Check.AllBooking;
import com.example.pitchbooking.activity.Model.Schedule.Schedule;
import com.example.pitchbooking.activity.activity.Admin_AllBooking;
import com.example.pitchbooking.activity.activity.BookingHistory;
import com.example.pitchbooking.activity.adapter.BookingHistory.BookingHistoryAdapter;

import java.util.ArrayList;

public class AllBookingAdapter extends BaseAdapter {

    private Admin_AllBooking context;
    private int layout;
    private ArrayList<AllBooking> arr;

    public AllBookingAdapter(Admin_AllBooking context, int layout, ArrayList<AllBooking> arr) {
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
        TextView txtId, txtName, txtStart, txtEnd, txtDate, txtPitch;
        ImageView imgTrash, imgEdit;
        public ViewHolder() {
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AllBookingAdapter.ViewHolder viewHolder = null;

        if (viewHolder == null) {
            viewHolder = new AllBookingAdapter.ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.lv_adminbooking, null);


            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.txtStart = (TextView) convertView.findViewById(R.id.txtStart);
            viewHolder.txtEnd = (TextView) convertView.findViewById(R.id.txtEnd);
            viewHolder.txtDate = (TextView) convertView.findViewById(R.id.txtDate);
            viewHolder.txtId = (TextView) convertView.findViewById(R.id.txtId);
            viewHolder.txtPitch = (TextView) convertView.findViewById(R.id.txtPitch);

            viewHolder.imgEdit = (ImageView) convertView.findViewById(R.id.iconEdit);
            viewHolder.imgTrash = (ImageView) convertView.findViewById(R.id.iconDelete);

            convertView.setTag(viewHolder);
        }

        AllBooking schedule = arr.get(position);
        viewHolder.txtId.setText("Id:              "+Integer.toString(schedule.getId()));
        viewHolder.txtPitch.setText("Pitch:           "+Integer.toString(schedule.getPitch()));
        viewHolder.txtName.setText("Customer:           "+schedule.getName());
        viewHolder.txtStart.setText("Start Time: "+schedule.getStart());
        viewHolder.txtEnd.setText("End Time:   "+schedule.getEnd());
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