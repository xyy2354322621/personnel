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

    boolean updateVacation( Attendance attendance, @Param("vacation") String vacation,@Param("vacationTime") int vacationTime);

    List<Attendance> getThisDateAttendance(String date);

    boolean setPublicVacation(String date);

    boolean cancerPublicVacation(String date);

    Attendance getMyAttendance(Employee employee);

    boolean addClockIn(Employee employee);

    boolean clockInExist(Attendance myAttendance);

    boolean clockOut(Attendance myAttendance);

    boolean updateAttendance(Attendance myAttendance);

    boolean updateClockIn(Attendance myAttendance);

    List<Attendance> getMyThisMonthAttendances(@Param("employee") Employee employee, @Param("month") String month);

    Attendance getAttendance(Attendance attendance);

    boolean addThisDayAttendance(@Param("employees") List<Employee> employees, @Param("date")String date);

    boolean addMyAttendance(Employee employee);

    boolean updateClockOut(Attendance myAttendance);

    Attendance getEmpThisDateAttendance(@Param("employees")Employee employee, @Param("date")String date);
}
