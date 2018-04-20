package com.xyy.biz;

import com.xyy.model.Tourist;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
public interface TouristService {
    Tourist getTourist(Tourist tourist);

    boolean addTourist(Tourist tourist);

    Tourist getLoginTourist(Tourist tourist);
    /*Tourist getTourist(Tourist tourist);

    boolean addTourist(Tourist tourist);

    Tourist getLoginTourist(Tourist tourist);*/
}
