package com.xyy.dao;

import com.xyy.model.BasicParam;

/**
 * Created by xiyueyang on 2018/4/27 0027.
 */
public interface BasicParamMapper {
    BasicParam getBasicParam();

    boolean updateBasicParam(BasicParam basicParam);

    void addBasicParam();
}
