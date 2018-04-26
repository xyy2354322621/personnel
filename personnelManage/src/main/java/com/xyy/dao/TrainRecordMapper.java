package com.xyy.dao;

import com.xyy.model.Train;
import com.xyy.model.TrainRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/25 0025.
 */
public interface TrainRecordMapper {
    boolean addTrainRecordServices(@Param("train") Train train, @Param("empList") List<String> empList);

    List<TrainRecord> getThisTrainRecords(Train train);

    boolean deleteTrainRecords(@Param("train") Train train, @Param("ridEmpList") String[] ridEmpList);

    TrainRecord getTrainRecord(TrainRecord trainRecord);

    boolean updateTrainRecord(TrainRecord trainRecord);
}
