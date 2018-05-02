package com.xyy.biz.impl;

import com.xyy.biz.AttendanceService;
import com.xyy.dao.AttendanceMapper;
import com.xyy.model.Attendance;
import com.xyy.model.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/27 0027.
 */
@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Resource
    private AttendanceMapper attendanceMapper;

    @Override
    public List<Attendance> getTodayAttendance() {
        return attendanceMapper.getTodayAttendance() ;
    }

    @Override
    public boolean addTodayAttendance(List<Employee> employees) {
        return attendanceMapper.addTodayAttendance(employees);
    }

    @Override
    public List<Attendance> getTomorrowAttendance() {
        return attendanceMapper.getTomorrowAttendance();
    }

    @Override
    public boolean addTomorrowAttendance(List<Employee> employees) {
        return attendanceMapper.addTomorrowAttendance(employees);
    }

    @Override
    public boolean updateVacation(Attendance attendance, String vacation, int vacationTime) {
        return attendanceMapper.updateVacation(attendance,vacation,vacationTime);
    }

    @Override
    public List<Attendance> getThisDateAttendance(String date) {
        return attendanceMapper.getThisDateAttendance(date);
    }

    @Override
    public boolean setPublicVacation(String date) {
        return attendanceMapper.setPublicVacation(date);
    }

    @Override
    public boolean updateCancerPublicVacation(String date) {
        return attendanceMapper.cancerPublicVacation(date);
    }

    @Override
    public Attendance getMyAttendance(Employee employee) {
        return attendanceMapper.getMyAttendance(employee);
    }

    @Override
    public boolean addClockIn(Employee employee) {
        return attendanceMapper.addClockIn(employee);
    }

    @Override
    public boolean clockIn(Attendance myAttendance) {
        return attendanceMapper.clockInExist(myAttendance);
    }

    @Override
    public boolean clockOut(Attendance myAttendance) {
        return attendanceMapper.clockOut(myAttendance);
    }

    @Override
    public boolean updateAttendance(Attendance myAttendance) {
        return attendanceMapper.updateAttendance(myAttendance);
    }

    @Override
    public boolean updateClockIn(Attendance myAttendance) {
        return attendanceMapper.updateClockIn(myAttendance);
    }

    @Override
    public List<Attendance> getMyThisMonthAttendances(Employee employee, String month) {
        return attendanceMapper.getMyThisMonthAttendances(employee,month);
    }

    @Override
    public Attendance getAttendance(Attendance attendance) {
        return attendanceMapper.getAttendance(attendance);
    }

    @Override
    public boolean addThisDayAttendance(List<Employee> employees, String date) {
        return attendanceMapper.addThisDayAttendance(employees,date);
    }

    @Override
    public boolean addMyAttendance(Employee employee) {
        return attendanceMapper.addMyAttendance(employee);
    }

    @Override
    public boolean updateClockOut(Attendance myAttendance) {
        return attendanceMapper.updateClockOut(myAttendance);
    }

    @Override
    public Attendance getEmpThisDateAttendance(Employee employee, String date) {
        return attendanceMapper.getEmpThisDateAttendance(employee,date);
    }

}
