package com.xyy.biz;

import com.xyy.model.Train;
import com.xyy.model.TrainRecord;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/25 0025.
 */
public interface TrainService {
    List<Train> getTrains();

    boolean addTrain(Train train);

    Train getTrain(Train train);

    boolean updateTrain(Train train);

    boolean deleteTrain(Train train);
}
