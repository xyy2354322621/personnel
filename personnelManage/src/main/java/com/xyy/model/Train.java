package com.xyy.model;

/**
 * Created by xiyueyang on 2018/4/25 0025.
 */
public class Train {
    private long train_no;
    private String train_name;
    private String train_address;
    private String start_time;
    private String end_time;
    private String message;

    public long getTrain_no() {
        return train_no;
    }

    public void setTrain_no(long train_no) {
        this.train_no = train_no;
    }

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public String getTrain_address() {
        return train_address;
    }

    public void setTrain_address(String train_address) {
        this.train_address = train_address;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
