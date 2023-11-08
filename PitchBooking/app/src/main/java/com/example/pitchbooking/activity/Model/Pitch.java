package com.example.pitchbooking.activity.Model;

import java.io.Serializable;

public class Pitch  implements Serializable {
    private String title;
    private int img;
   private int price;
//    private int time;

    public Pitch(String title, int img, int price) {
        this.title = title;
        this.img = img;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
