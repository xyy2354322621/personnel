package com.xyy.biz;

import com.xyy.model.Attendance;
import com.xyy.model.Employee;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/27 0027.
 */
public interface AttendanceService {
    List<Attendance> getTodayAttendance();

    boolean addTodayAttendance(List<Employee> employees);

    List<Attendance> getTomorrowAttendance();

    boolean addTomorrowAttendance(List<Employee> employees);
}
