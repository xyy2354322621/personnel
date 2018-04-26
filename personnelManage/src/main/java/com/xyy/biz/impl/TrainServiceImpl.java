package com.xyy.biz.impl;

import com.xyy.biz.TrainService;
import com.xyy.dao.TrainMapper;
import com.xyy.model.Train;
import com.xyy.model.TrainRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/25 0025.
 */
@Service
public class TrainServiceImpl implements TrainService {
    @Resource
    private TrainMapper trainMapper;

    @Override
    public List<Train> getTrains() {
        return trainMapper.getTrains();
    }

    @Override
    public boolean addTrain(Train train) {
        return trainMapper.addTrain(train);
    }

    @Override
    public Train getTrain(Train train) {
        return trainMapper.getTrain(train);
    }

    @Override
    public boolean updateTrain(Train train) {
        return trainMapper.updateTrain(train);
    }

    @Override
    public boolean deleteTrain(Train train) {
        return trainMapper.deleteTrain(train);
    }


}
