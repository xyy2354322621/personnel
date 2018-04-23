package com.xyy.biz;

import com.xyy.model.Apply;
import com.xyy.model.Tourist;

/**
 * Created by xiyueyang on 2018/4/21 0021.
 */
public interface ApplyService {
    Apply getRepeatApply(Apply apply, Tourist tourist);

    boolean addApply(Apply apply);
}
