package com.xyy.controller;

import com.xyy.biz.TrainService;
import com.xyy.model.Train;
import com.xyy.model.TrainRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/25 0025.
 */
@Controller
public class TrainController {
    @Resource
    private TrainService trainService;

    @RequestMapping("manageTrain")
    public String manageTrain(Model model) throws Exception {
        List<Train> trains = trainService.getTrains();
        model.addAttribute(trains);
        return "manageTrain";
    }

    @RequestMapping("createTrain")
    public String createTrain() throws Exception {
        return "createTrain";
    }

    @RequestMapping("/saveTrain")
    public void saveTrain(Train train, HttpServletResponse response) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date start = format.parse(train.getStart_time().substring(0,10)+" "+train.getStart_time().substring(11,16));
        Date end = format.parse(train.getEnd_time().substring(0,10)+" "+train.getEnd_time().substring(11,16));
        if (start.getTime()<end.getTime()) {
            if (trainService.addTrain(train)) {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('培训新开成功'));" +
                        "window.location.href='manageTrain';</script>");
            } else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('培训新开失败'));" +
                        "window.location.href='createTrain';</script>");

            }
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('结束时间不能早于开始时间'));" +
                    "window.location.href='createTrain';</script>");
        }
    }

    @RequestMapping("/alterTrain")
    public String alterTrain(Train train, Model model) throws Exception {
        Train alterTrain = trainService.getTrain(train);
        model.addAttribute(alterTrain);
        return "alterTrain";
    }

    @RequestMapping("/updateTrain")
    public void updateTrain(Train train, HttpServletResponse response) throws Exception {
        if (trainService.updateTrain(train)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('培训修改成功'));" +
                    "window.location.href='manageTrain';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('培训修改失败'));" +
                    "window.location.href='manageTrain';</script>");
        }
    }

    @RequestMapping("/deleteTrain")
    public void deleteTrain(Train train,HttpServletResponse response) throws Exception {
        response.getWriter().write("<script language='javascript'>if( confirm(decodeURIComponent('确定要删除吗？'))){" +
                "window.location.href ='confirmDeleteTrain?pos_no="+train.getTrain_no()+"';}else {window.location.href ='managePosition';} </script>");

    }

    @RequestMapping("/confirmDeleteTrain")
    public void confirmDeleteTrain(Train train,HttpServletResponse response) throws Exception {
        if(trainService.deleteTrain(train)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('培训删除成功'));" +
                    "window.location.href='manageTrain';</script>");
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('培训删除失败'));" +
                    "window.location.href='manageTrain';</script>");
        }
    }


}
