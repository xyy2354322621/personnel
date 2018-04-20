package com.xyy.biz.impl;

import com.xyy.biz.TouristService;
import com.xyy.dao.TouristMapper;
import com.xyy.model.Tourist;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
@Service
public class TouristServiceImpl implements TouristService{
    @Resource
    private TouristMapper touristMapper;

    @Override
    public Tourist getTourist(Tourist tourist) {
        return touristMapper.getTourist(tourist);
    }

    @Override
    public boolean addTourist(Tourist tourist) {
        return touristMapper.addTourist(tourist);
    }

    @Override
    public Tourist getLoginTourist(Tourist tourist) {
        return touristMapper.getLoginTourist(tourist);
    }

}
