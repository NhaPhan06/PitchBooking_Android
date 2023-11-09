package com.example.pitchbooking.activity.Model.Check;

public class AllBooking {
    public int id;
    public int pitch;
    public String name;
    public String start;
    public String end;
    public String Date;

    public AllBooking(int id, int pitch, String name, String start, String end, String date) {
        this.id = id;
        this.pitch = pitch;
        this.name = name;
        this.start = start;
        this.end = end;
        Date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPitch() {
        return pitch;
    }

    public void setPitch(int pitch) {
        this.pitch = pitch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
