package com.xyy.biz;

import com.xyy.model.AttendApply;
import com.xyy.model.Attendance;
import com.xyy.model.Employee;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/28 0028.
 */
public interface AttendApplyService {
    AttendApply getMyAttendApply(Attendance attendance);

    boolean addAttendApply(AttendApply myAttendApply);

    boolean updateAttendApply(AttendApply myAttendApply);

    boolean updateApplyLeave(AttendApply attendApply, String vacation, int timeLong);

    List<AttendApply> getMyThisMonthAttendApplies(List<Attendance> myAttendances);

    List<AttendApply> getThisMonthAttendApplies(String month);
}
