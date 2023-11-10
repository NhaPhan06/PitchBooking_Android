package com.example.pitchbooking.activity.adapter.Admin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pitchbooking.R;
import com.example.pitchbooking.activity.Model.Check.AllBooking;
import com.example.pitchbooking.activity.Model.Pitch;
import com.example.pitchbooking.activity.activity.AdminListPitch;
import com.example.pitchbooking.activity.activity.Admin_AllBooking;

import java.util.ArrayList;

public class ListPitchAdapter extends BaseAdapter {

    private AdminListPitch context;
    private int layout;
    private ArrayList<Pitch> arr;

    public ListPitchAdapter(AdminListPitch context, int layout, ArrayList<Pitch> arr) {
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
        TextView txtId, txtName;
        ImageView imgTrash, imgEdit;
        public ViewHolder() {
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListPitchAdapter.ViewHolder viewHolder = null;

        if (viewHolder == null) {
            viewHolder = new ListPitchAdapter.ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.lv_pitch, null);


            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.txtId = (TextView) convertView.findViewById(R.id.txtId);

            viewHolder.imgEdit = (ImageView) convertView.findViewById(R.id.iconEdit);
            viewHolder.imgTrash = (ImageView) convertView.findViewById(R.id.iconDelete);

            convertView.setTag(viewHolder);
        }

        Pitch pitch = arr.get(position);
        viewHolder.txtId.setText(Integer.toString(pitch.getId()));
        viewHolder.txtName.setText(pitch.getName());

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