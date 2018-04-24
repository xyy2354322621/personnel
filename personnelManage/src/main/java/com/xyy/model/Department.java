package com.xyy.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
public class Department {
    private long depart_no;
    private String depart_name;
    private String depart_location;
    private int exist;
    private String create_time;
    private Set<Position> positionSet = new HashSet<>();

    public long getDepart_no() {
        return depart_no;
    }

    public void setDepart_no(long depart_no) {
        this.depart_no = depart_no;
    }

    public String getDepart_name() {
        return depart_name;
    }

    public void setDepart_name(String depart_name) {
        this.depart_name = depart_name;
    }

    public String getDepart_location() {
        return depart_location;
    }

    public void setDepart_location(String depart_location) {
        this.depart_location = depart_location;
    }

    public int getExist() {
        return exist;
    }

    public void setExist(int exist) {
        this.exist = exist;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public Set<Position> getPositionSet() {
        return positionSet;
    }

    public void setPositionSet(Set<Position> positionSet) {
        this.positionSet = positionSet;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depart_no=" + depart_no +
                ", depart_name='" + depart_name + '\'' +
                ", depart_location='" + depart_location + '\'' +
                ", exist=" + exist +
                ", create_time='" + create_time + '\'' +
                ", positionSet=" + positionSet +
                '}';
    }
}
