package com.xyy.dao;

import com.xyy.model.Attendance;
import com.xyy.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/27 0027.
 */
public interface AttendanceMapper {
    List<Attendance> getTodayAttendance();

    boolean addTodayAttendance(@Param("employees") List<Employee> employees);

    List<Attendance> getTomorrowAttendance();

    boolean addTomorrowAttendance(@Param("employees") List<Employee> employees);
}
