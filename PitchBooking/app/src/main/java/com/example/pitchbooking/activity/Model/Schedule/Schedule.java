package com.example.pitchbooking.activity.Model.Schedule;

import java.sql.Date;
import java.sql.Time;

public class Schedule {

    public Schedule(int id, int customerId, int pitchId, String startTime, String endTime, String date, String status) {
        Id = id;
        CustomerId = customerId;
        PitchId = pitchId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.status = status;
    }

    public int Id;
    public int CustomerId;
    public int PitchId;
    public String startTime;
    public String endTime;
    public String date;
    public String status;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public int getPitchId() {
        return PitchId;
    }

    public void setPitchId(int pitchId) {
        PitchId = pitchId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
