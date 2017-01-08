package com.example.ronakshah.hackforchange;

/**
 * Created by Ronak Shah on 08-01-2017.
 */
public class Data {
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDdate() {
        return ddate;
    }

    public void setDdate(String ddate) {
        this.ddate = ddate;
    }

    private String pname,dname,ddate;
    public Data(String pname,String dname,String ddate) {
        this.pname = pname;
        this.dname = dname;
        this.ddate = ddate;
    }
}
