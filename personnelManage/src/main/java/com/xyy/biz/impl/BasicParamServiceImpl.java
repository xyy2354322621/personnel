package com.xyy.biz.impl;

import com.xyy.biz.BasicParamService;
import com.xyy.dao.BasicParamMapper;
import com.xyy.model.BasicParam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/27 0027.
 */
@Service
public class BasicParamServiceImpl implements BasicParamService {
    @Resource
    private BasicParamMapper basicParamMapper;


    @Override
    public BasicParam getBasicParam() {
        return basicParamMapper.getBasicParam();
    }

    @Override
    public boolean updateBasicParam(BasicParam basicParam) {
        return basicParamMapper.updateBasicParam(basicParam);
    }

    @Override
    public void addBasicParam() {
        basicParamMapper.addBasicParam();
    }
}
