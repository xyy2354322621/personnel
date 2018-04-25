package com.xyy.dao;

import com.xyy.model.Train;

import java.util.List;

/**
 * Created by xiyueyang on 2018/4/25 0025.
 */
public interface TrainMapper {
    List<Train> getTrains();

    boolean addTrain(Train train);

    Train getTrain(Train train);

    boolean updateTrain(Train train);

    boolean deleteTrain(Train train);
}
