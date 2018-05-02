package com.xyy.dao;

import com.xyy.model.AttendApply;
import com.xyy.model.Attendance;
import com.xyy.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/28 0028.
 */
public interface AttendApplyMapper {
    AttendApply getMyAttendApply(Attendance attendance);

    boolean addAttendApply(AttendApply myAttendApply);

    boolean updateAttendApply(AttendApply myAttendApply);

    boolean updateApplyLeave(@Param("attendApply") AttendApply attendApply, @Param("vacation")String vacation, @Param("timeLong")int timeLong);

    List<AttendApply> getMyThisMonthAttendApplies(@Param("myAttendances")List<Attendance> myAttendances);

    List<AttendApply> getThisMonthAttendApplies(String month);
}
