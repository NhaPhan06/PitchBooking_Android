package com.example.pitchbooking.activity.Model.Check;

import java.sql.Time;

public class Check {
    public int Id;
    public Time start;
    public Time end;

    public Check(int id, Time start, Time end) {
        Id = id;
        this.start = start;
        this.end = end;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time getStart) {
        this.end = getStart;
    }
}
