package com.xyy.biz;

import com.xyy.model.RewardAanPunish;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/26 0026.
 */
public interface RewardAanPunishService {
    List<RewardAanPunish> getCurMonthRewardAndPunish();

    boolean updateCancerRewordPunish(RewardAanPunish rewardAanPunish);

    boolean updateExecuteRewordPunish(RewardAanPunish rewardAanPunish);

    boolean addRewardPunish(RewardAanPunish rewardAanPunish);

    RewardAanPunish getRewardPunish(RewardAanPunish rewardAanPunish);

    boolean updateRewardPunish(RewardAanPunish rewardAanPunish);

    boolean deleteRewardPunish(RewardAanPunish rewardAanPunish);

    List<RewardAanPunish> getThisMonthRewardAndPunish(String month);
}
