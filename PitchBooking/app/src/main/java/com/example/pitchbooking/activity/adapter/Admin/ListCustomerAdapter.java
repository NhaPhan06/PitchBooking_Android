package com.example.pitchbooking.activity.adapter.Admin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pitchbooking.R;
import com.example.pitchbooking.activity.Model.Account.Account;
import com.example.pitchbooking.activity.Model.Pitch;
import com.example.pitchbooking.activity.activity.AdminListCustomer;
import com.example.pitchbooking.activity.activity.AdminListPitch;

import java.util.ArrayList;

public class ListCustomerAdapter extends BaseAdapter {

    private AdminListCustomer context;
    private int layout;
    private ArrayList<Account> arr;

    public ListCustomerAdapter(AdminListCustomer context, int layout, ArrayList<Account> arr) {
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
        TextView txtEmail, txtName, txtPhone;
        ImageView imgTrash, imgEdit;
        public ViewHolder() {
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListCustomerAdapter.ViewHolder viewHolder = null;

        if (viewHolder == null) {
            viewHolder = new ListCustomerAdapter.ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.lv_customer, null);


            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.txtEmail = (TextView) convertView.findViewById(R.id.txtEmail);
            viewHolder.txtPhone = (TextView) convertView.findViewById(R.id.txtPhone);

            viewHolder.imgEdit = (ImageView) convertView.findViewById(R.id.iconEdit);
            viewHolder.imgTrash = (ImageView) convertView.findViewById(R.id.iconDelete);

            convertView.setTag(viewHolder);
        }

        Account acc = arr.get(position);
        viewHolder.txtEmail.setText(acc.getUserName());
        viewHolder.txtName.setText(acc.getFullName());
        viewHolder.txtPhone.setText(acc.getPhone());

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
