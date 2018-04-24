package com.xyy.biz.impl;

import com.xyy.biz.ApplyService;
import com.xyy.dao.ApplyMapper;
import com.xyy.model.Apply;
import com.xyy.model.Employee;
import com.xyy.model.Recruit;
import com.xyy.model.Tourist;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/21 0021.
 */
@Service
public class ApplyServiceImpl implements ApplyService {

    @Resource
    private ApplyMapper applyMapper;

    @Override
    public Apply getRepeatApply(Apply apply, Tourist tourist) {
        return applyMapper.getRepeatApply(apply,tourist) ;
    }

    @Override
    public boolean addApply(Apply apply) {
        return applyMapper.addApply( apply) ;
    }

    @Override
    public List<Apply> getApplies(Recruit recruit) {
        return applyMapper.getApplies( recruit);
    }

    @Override
    public boolean updateInvite(Apply apply) {
        return applyMapper.updateInvite(apply);
    }

    @Override
    public boolean updateCancerInvite(Apply apply) {
        return applyMapper.updateCancerInvite( apply);
    }

    @Override
    public boolean updateRefuseApply(Apply apply) {
        return applyMapper.updateRefuseApply(apply) ;
    }

    @Override
    public boolean deleteApply(Apply apply) {
        return applyMapper.deleteApply( apply);
    }

    @Override
    public boolean updateDeleteApply(Apply apply) {
        return applyMapper.updateDeleteApply(apply) ;
    }

    @Override
    public boolean updateSuccessInterview(Apply apply) {
        return applyMapper.updateSuccessInterview( apply) ;
    }

    @Override
    public boolean updateFailInterview(Apply apply) {
        return applyMapper.updateFailInterview( apply) ;
    }

    @Override
    public List<Apply> getMyApplies(Tourist tourist) {
        return applyMapper.getMyApplies( tourist) ;
    }

    @Override
    public void updateSetRead(Apply apply) {
        applyMapper.updateSetRead( apply);
    }

    @Override
    public boolean updateAgreeInvite(Apply apply) {
        return applyMapper.updateAgreeInvite(apply) ;
    }

    @Override
    public boolean updateRefuseInvite(Apply apply) {
        return applyMapper.updateRefuseInvite( apply);
    }

    @Override
    public void updateSetHireApply(Apply apply) {
        applyMapper.updateSetHireApply( apply);
    }

    @Override
    public Apply getApply(Apply apply) {
        return applyMapper.getApply( apply);
    }

    @Override
    public Employee getExistEmployee(Tourist tourist) {
        return applyMapper.getExistEmployee(tourist);
    }
}
