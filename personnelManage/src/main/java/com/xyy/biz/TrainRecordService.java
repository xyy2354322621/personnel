package com.xyy.biz;

import com.xyy.model.Employee;
import com.xyy.model.Train;
import com.xyy.model.TrainRecord;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/25 0025.
 */
public interface TrainRecordService {
    boolean addTrainRecordServices(Train trainRecord, List<String> empList);

    List<TrainRecord> getThisTrainRecords(Train train);

    boolean deleteTrainRecords(Train train, String[] ridEmpList);

    TrainRecord getTrainRecord(TrainRecord trainRecord);

    boolean updateTrainRecord(TrainRecord trainRecord);

    List<TrainRecord> getEmpTrainRecord(Employee employee);

    TrainRecord getThisRecord(TrainRecord trainRecord);
}
