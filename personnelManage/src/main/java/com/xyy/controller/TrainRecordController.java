package com.xyy.controller;

import com.xyy.biz.TrainRecordService;
import com.xyy.model.Train;
import com.xyy.model.TrainRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/25 0025.
 */
@Controller
public class TrainRecordController {
    @Resource
    private TrainRecordService trainRecordService;

    @RequestMapping("/addEmpToTrain")
    public void addEmpToTrain(Train train, @RequestParam("chosenEmp") String[] empList, HttpServletResponse response) throws Exception {
        List<TrainRecord> thisTrainRecords = trainRecordService.getThisTrainRecords(train);
        List<String> notJoin = new ArrayList<>();
        for (String s : empList) {
            notJoin.add(s);
        }
        List<String> join = new ArrayList<>();
        for (TrainRecord tr : thisTrainRecords) {
            for (String st : notJoin) {
                if (tr.getE_id().equals(st)) {
                    join.add(st);
                }
            }
        }
        notJoin.removeAll(join);
        if (notJoin.size() > 0) {
            if (trainRecordService.addTrainRecordServices(train, notJoin)) {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('添加学员成功'));" +
                        "window.location.href='manageTrain';</script>");
            } else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('添加学员失败，请重试'));" +
                        "window.location.href='manageTrain';</script>");
            }
        } else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('这些员工都已被选则参加培训，不需重复选择'));" +
                    "window.location.href='manageTrain';</script>");
        }
    }

    @RequestMapping("/ridEmpFromTrain")
    public void ridEmpFromTrain(Train train, @RequestParam("ridEmp") String[] empList, HttpSession session, HttpServletResponse response) throws Exception {
        session.setAttribute("ridEmpList",empList);
        response.getWriter().write("<script language='javascript'>if( confirm(decodeURIComponent('剔除则被剔除学员的培训记录将被删除，\\n确定要删除吗？'))){" +
                "window.location.href ='confirmDeleteTrainRecord?train_no="+train.getTrain_no()+"';}else {window.location.href ='browseEmpJoinTrain?train_no="+train.getTrain_no()+"';} </script>");

    }

    @RequestMapping("/confirmDeleteTrainRecord")
    public void confirmDeleteTrainRecord(Train train,HttpSession session, HttpServletResponse response) throws Exception {
        String[] ridEmpList = (String[]) session.getAttribute("ridEmpList");
        if(trainRecordService.deleteTrainRecords(train,ridEmpList)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('剔除学员成功'));" +
                    "window.location.href='browseEmpJoinTrain?train_no="+train.getTrain_no()+"';</script>");
        } else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('剔除学员失败，请重试'));" +
                    "window.location.href='browseEmpJoinTrain?train_no="+train.getTrain_no()+"';</script>");
        }
    }

    @RequestMapping("trainRecord")
    public String trainRecord(TrainRecord trainRecord,Model model)throws Exception{
        TrainRecord record = trainRecordService.getTrainRecord(trainRecord);
        model.addAttribute(record);
        return "trainRecord";
    }

    @RequestMapping("updateTrainRecord")
    public void updateTrainRecord(TrainRecord trainRecord,HttpSession session,HttpServletResponse response)throws Exception{
        session.setAttribute("updateTrainRecord",trainRecord);
        response.getWriter().write("<script language='javascript'>if( confirm(decodeURIComponent('点击确定则原纪录被覆盖，\\n点击取消则新编辑的记录被清除'))){" +
                "window.location.href ='confirmUpdateTrainRecord';}" +
                "else {window.location.href ='trainRecord?train_no="+trainRecord.getTrain_no()+"&e_id="+trainRecord.getE_id()+"';} </script>");

    }

    @RequestMapping("confirmUpdateTrainRecord")
    public void confirmUpdateTrainRecord(HttpSession session,HttpServletResponse response)throws Exception{
        TrainRecord trainRecord = (TrainRecord) session.getAttribute("updateTrainRecord");
        if (trainRecordService.updateTrainRecord(trainRecord)){
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('培训记录修改成功'));" +
                    "window.location.href='browseEmpJoinTrain?train_no="+trainRecord.getTrain_no()+"';</script>");
        } else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('培训记录修改失败，请重试'));" +
                    "window.location.href='browseEmpJoinTrain?train_no="+trainRecord.getTrain_no()+"';</script>");
        }
    }


}