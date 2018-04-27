package com.xyy.biz;

import com.xyy.model.BasicParam;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/27 0027.
 */
public interface BasicParamService {
    BasicParam getBasicParam();

    boolean updateBasicParam(BasicParam basicParam);

    void addBasicParam();
}
