package com.example.pitchbooking.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.pitchbooking.R;
import com.example.pitchbooking.activity.Model.Pitch;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class pitchListAdapter extends RecyclerView.Adapter<pitchListAdapter.ViewHollder> {

    private List<Pitch> pitches;
    Context context;

    public pitchListAdapter(List<Pitch> pitches) {
        this.pitches = pitches;
    }

    @NonNull
    @Override
    public pitchListAdapter.ViewHollder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_pitch_list,parent,false);
//        context = parent.getContext();
//        return new ViewHollder(inflate);
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View pitchView = inflater.inflate(R.layout.viewholder_pitch_list,parent, false);
        ViewHollder viewHollder = new ViewHollder(pitchView);
        return viewHollder;
    }

    @Override
    public void onBindViewHolder(@NonNull pitchListAdapter.ViewHollder holder, int position) {

//        String title, descrip, imageUrl;
//        int price;
//
//        title = pitches.get(holder.getAdapterPosition()).getTitle();
//        descrip = pitches.get(holder.getAdapterPosition()).getDesciption();
//        imageUrl = pitches.get(holder.getAdapterPosition()).getImg();
//        price = pitches.get(holder.getAdapterPosition()).getPrice();
//        Picasso.with(this.context).load(imageUrl).fit().into(holder.img);
//        holder.pTitle.setText(pitches.get(position).getTitle());
//        holder.pPrice.setText(pitches.get(position).getPrice());
////        int drawableResourceID = holder.itemView.getResources().getIdentifier(pitches.get(position).getImg(),"drawable",holder.itemView.getContext().getPackageName());
//
//        Glide.with(holder.itemView.getContext())
//                .load(drawableResourceID)
//                .transform(new GranularRoundedCorners(30,30,0,0))
//                .into(holder.img);
        Pitch pitch = pitches.get(position);
        holder.img.setImageResource(pitch.getImg());
        holder.pTitle.setText(pitch.getTitle());
        holder.pPrice.setText(pitch.getPrice());
    }

    @Override
    public int getItemCount() {
        return pitches.size();
    }

    public class ViewHollder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView pTitle, pPrice;
        CardView  cardView;
        public ViewHollder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.pitchImage);
            pTitle = itemView.findViewById(R.id.pitchTitle);
            pPrice = itemView.findViewById(R.id.pitchPrice);

        }
    }
}
