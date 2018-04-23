package com.xyy.biz;

import com.xyy.model.Recruit;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
public interface RecruitService {
    boolean addRecruit(Recruit recruit);

    List<Recruit> getIssuingRecruits();
}
