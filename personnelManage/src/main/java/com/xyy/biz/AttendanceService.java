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

    boolean updateVacation(Attendance attendance, String vacation, int vacationTime);

    List<Attendance> getThisDateAttendance(String date);

    boolean setPublicVacation(String date);

    boolean updateCancerPublicVacation(String date);

    Attendance getMyAttendance(Employee employee);

    boolean addClockIn(Employee employee);

    boolean clockIn(Attendance myAttendance);

    boolean clockOut(Attendance myAttendance);

    boolean updateAttendance(Attendance myAttendance);

    boolean updateClockIn(Attendance myAttendance);

    List<Attendance> getMyThisMonthAttendances(Employee employee, String month);

    Attendance getAttendance(Attendance attendance);

    boolean addThisDayAttendance(List<Employee> employees, String date);

    boolean addMyAttendance(Employee employee);

    boolean updateClockOut(Attendance myAttendance);

    Attendance getEmpThisDateAttendance(Employee employee, String date);
}
