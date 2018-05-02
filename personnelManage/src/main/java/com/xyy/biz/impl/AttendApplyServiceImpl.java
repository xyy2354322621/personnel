package com.xyy.biz.impl;

import com.xyy.biz.AttendApplyService;
import com.xyy.dao.AttendApplyMapper;
import com.xyy.model.AttendApply;
import com.xyy.model.Attendance;
import com.xyy.model.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/28 0028.
 */
@Service
public class AttendApplyServiceImpl implements AttendApplyService {
    @Resource
    private AttendApplyMapper attendApplyMapper;

    @Override
    public AttendApply getMyAttendApply(Attendance attendance) {
        return attendApplyMapper.getMyAttendApply(attendance);
    }

    @Override
    public boolean addAttendApply(AttendApply myAttendApply) {
        return attendApplyMapper.addAttendApply(myAttendApply);
    }

    @Override
    public boolean updateAttendApply(AttendApply myAttendApply) {
        return attendApplyMapper.updateAttendApply(myAttendApply);
    }

    @Override
    public boolean updateApplyLeave(AttendApply attendApply, String vacation, int timeLong) {
        return attendApplyMapper.updateApplyLeave(attendApply,vacation,timeLong);
    }

    @Override
    public List<AttendApply> getMyThisMonthAttendApplies(List<Attendance> myAttendances) {
        return attendApplyMapper.getMyThisMonthAttendApplies(myAttendances);
    }

    @Override
    public List<AttendApply> getThisMonthAttendApplies(String month) {
        return attendApplyMapper.getThisMonthAttendApplies(month);
    }

}
