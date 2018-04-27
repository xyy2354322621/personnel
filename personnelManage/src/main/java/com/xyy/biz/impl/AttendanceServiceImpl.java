package com.xyy.biz.impl;

import com.xyy.biz.AttendanceService;
import com.xyy.dao.AttendanceMapper;
import com.xyy.model.Attendance;
import com.xyy.model.Employee;
import org.springframework.stereotype.Controller;
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
}
