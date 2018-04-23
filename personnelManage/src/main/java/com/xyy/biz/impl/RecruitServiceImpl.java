package com.xyy.biz.impl;

import com.xyy.biz.RecruitService;
import com.xyy.dao.RecruitMapper;
import com.xyy.model.Recruit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
@Service
public class RecruitServiceImpl implements RecruitService {

    @Resource
    private RecruitMapper recruitMapper;

    @Override
    public boolean addRecruit(Recruit recruit) {
        return recruitMapper.addRecruit(recruit);
    }

    @Override
    public List<Recruit> getIssuingRecruits() {
        return recruitMapper.getIssuingRecruits();
    }

    @Override
    public List<Recruit> getRecruits() {
        return recruitMapper.getRecruits();
    }

    @Override
    public boolean updatePauseIssueRecruit(Recruit recruit) {
        return recruitMapper. updatePauseIssueRecruit( recruit);
    }

    @Override
    public boolean updateRecoverIssueRecruit(Recruit recruit) {
        return recruitMapper.updateRecoverIssueRecruit( recruit);
    }

    @Override
    public boolean updateRecruit(Recruit recruit) {
        return recruitMapper.updateRecruit(recruit);
    }

    @Override
    public boolean deleteRecruit(Recruit recruit) {
        return recruitMapper.deleteRecruit( recruit);
    }


}
