package com.xyy.biz.impl;

import com.xyy.biz.TrainRecordService;
import com.xyy.dao.TrainRecordMapper;
import com.xyy.model.Train;
import com.xyy.model.TrainRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/25 0025.
 */
@Service
public class TrainRecordServiceImpl implements TrainRecordService {
    @Resource
    private TrainRecordMapper trainRecordMapper;

    @Override
    public boolean addTrainRecordServices(Train train, List<String> empList) {
        return trainRecordMapper.addTrainRecordServices(train,empList);
    }

    @Override
    public List<TrainRecord> getThisTrainRecords(Train train) {
        return trainRecordMapper.getThisTrainRecords(train);
    }

    @Override
    public boolean deleteTrainRecords(Train train, String[] ridEmpList) {
        return trainRecordMapper.deleteTrainRecords(train,ridEmpList);
    }

    @Override
    public TrainRecord getTrainRecord(TrainRecord trainRecord) {
        return trainRecordMapper.getTrainRecord(trainRecord);
    }

    @Override
    public boolean updateTrainRecord(TrainRecord trainRecord) {
        return trainRecordMapper.updateTrainRecord(trainRecord);
    }
}
