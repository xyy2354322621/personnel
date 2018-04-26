package com.xyy.biz.impl;

import com.xyy.biz.RewardAanPunishService;
import com.xyy.dao.RewardAanPunishMapper;
import com.xyy.model.RewardAanPunish;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/26 0026.
 */
@Service
public class RewardAanPunishServiceImpl implements RewardAanPunishService {

    @Resource
    private RewardAanPunishMapper rewardAanPunishMapper;

    @Override
    public List<RewardAanPunish> getCurMonthRewardAndPunish() {
        return rewardAanPunishMapper.getCurMonthRewardAndPunish();
    }

    @Override
    public boolean updateCancerRewordPunish(RewardAanPunish rewardAanPunish) {
        return rewardAanPunishMapper.updateCancerRewordPunish(rewardAanPunish);
    }

    @Override
    public boolean updateExecuteRewordPunish(RewardAanPunish rewardAanPunish) {
        return rewardAanPunishMapper.updateExecuteRewordPunish(rewardAanPunish);
    }

    @Override
    public boolean addRewardPunish(RewardAanPunish rewardAanPunish) {
        return rewardAanPunishMapper.addRewardPunish(rewardAanPunish);
    }

    @Override
    public RewardAanPunish getRewardPunish(RewardAanPunish rewardAanPunish) {
        return rewardAanPunishMapper.getRewardPunish(rewardAanPunish);
    }

    @Override
    public boolean updateRewardPunish(RewardAanPunish rewardAanPunish) {
        return rewardAanPunishMapper.updateRewardPunish(rewardAanPunish);
    }

    @Override
    public boolean deleteRewardPunish(RewardAanPunish rewardAanPunish) {
        return rewardAanPunishMapper.deleteRewardPunish(rewardAanPunish);
    }


}
