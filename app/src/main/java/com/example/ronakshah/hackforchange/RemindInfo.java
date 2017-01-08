package com.example.ronakshah.hackforchange;

/**
 * Created by Ronak Shah on 08-01-2017.
 */
public class RemindInfo  {


    public RemindInfo(String name,String description,String time,String interval) {
        this.name = name;
        this.description = description;
        this.interval = interval;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String name,description,time,interval;

}
