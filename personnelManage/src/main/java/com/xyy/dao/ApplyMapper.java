package com.xyy.dao;

import com.xyy.model.Apply;
import com.xyy.model.Employee;
import com.xyy.model.Recruit;
import com.xyy.model.Tourist;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/21 0021.
 */
public interface ApplyMapper {
    Apply getRepeatApply(Apply apply, Tourist tourist);

    boolean addApply(Apply apply);

    List<Apply> getApplies(Recruit recruit);

    boolean updateInvite(Apply apply);

    boolean updateCancerInvite(Apply apply);

    boolean updateRefuseApply(Apply apply);

    boolean deleteApply(Apply apply);

    boolean updateDeleteApply(Apply apply);

    boolean updateSuccessInterview(Apply apply);

    boolean updateFailInterview(Apply apply);

    List<Apply> getMyApplies(Tourist tourist);

    void updateSetRead(Apply apply);

    boolean updateAgreeInvite(Apply apply);

    boolean updateRefuseInvite(Apply apply);

    void updateSetHireApply(Apply apply);

    Apply getApply(Apply apply);

    Employee getExistEmployee(Tourist tourist);
}
