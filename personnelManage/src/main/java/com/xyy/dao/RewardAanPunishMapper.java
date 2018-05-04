package com.xyy.dao;

import com.xyy.model.Employee;
import com.xyy.model.RewardAanPunish;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/26 0026.
 */
public interface RewardAanPunishMapper {
    List<RewardAanPunish> getCurMonthRewardAndPunish();

    boolean updateCancerRewordPunish(RewardAanPunish rewardAanPunish);

    boolean updateExecuteRewordPunish(RewardAanPunish rewardAanPunish);

    boolean addRewardPunish(RewardAanPunish rewardAanPunish);

    RewardAanPunish getRewardPunish(RewardAanPunish rewardAanPunish);

    boolean updateRewardPunish(RewardAanPunish rewardAanPunish);

    boolean deleteRewardPunish(RewardAanPunish rewardAanPunish);

    List<RewardAanPunish> getThisMonthRewardAndPunish(String month);

    List<RewardAanPunish> getEmpThisMonthExistReward(@Param("employee") Employee employee, @Param("month")String month);

    List<RewardAanPunish> getEmpThisMonthExistPunish(@Param("employee") Employee employee, @Param("month")String month);

    RewardAanPunish getEmpTodayBeLatePunish(Employee employee);

    RewardAanPunish getEmpTodayLeaveEarlyPunish(Employee employee);

    List<RewardAanPunish> getEmpThisMonthOvertime(@Param("employee") Employee employee, @Param("month")String month);

    RewardAanPunish getEmpTodayOvertime(Employee employee);

    RewardAanPunish getThisMonthSalaryReconsider(String reason);

    List<RewardAanPunish> getEmpThisMonthExistRP(@Param("employee") Employee employee, @Param("month") String month);
}
