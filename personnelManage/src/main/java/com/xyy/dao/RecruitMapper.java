package com.xyy.dao;

import com.xyy.model.Recruit;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
public interface RecruitMapper {
    boolean addRecruit(Recruit recruit);

    List<Recruit> getIssuingRecruits();

    List<Recruit> getRecruits();

    boolean updatePauseIssueRecruit(Recruit recruit);

    boolean updateRecoverIssueRecruit(Recruit recruit);

    boolean updateRecruit(Recruit recruit);

    boolean deleteRecruit(Recruit recruit);
}
