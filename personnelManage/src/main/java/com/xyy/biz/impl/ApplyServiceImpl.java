package com.xyy.biz.impl;

import com.xyy.biz.ApplyService;
import com.xyy.dao.ApplyMapper;
import com.xyy.model.Apply;
import com.xyy.model.Tourist;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
