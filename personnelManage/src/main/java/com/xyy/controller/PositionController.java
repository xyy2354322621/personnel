package com.xyy.controller;

import com.xyy.biz.DepartmentService;
import com.xyy.biz.PositionService;
import com.xyy.model.Department;
import com.xyy.model.Position;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by xiyueyang on 2018/4/20 0020.
 */
@Controller
public class PositionController {

    @Resource
    private PositionService positionService;

    @Resource
    private DepartmentService departmentService;

    @RequestMapping("/gotoManagePosition")
    public String gotoManagePosition()throws Exception{
        return "managePosition";
    }

    @RequestMapping("/managePosition")
    public String managePosition(HttpSession session)throws Exception{
        List<Position> positions = positionService.getPositions();
        session.setAttribute("positions",positions);
        return "managePosition";
    }

    @RequestMapping("/createPosition")
    public String createPosition(HttpSession session)throws Exception{
        List<Department> departments = departmentService.getDepartments();
        session.setAttribute("departments",departments);
        return "createPosition";
    }

    @RequestMapping("/savePosition")
    public void savePosition(Position position, String salary, HttpServletResponse response)throws Exception{
        Position existPotion = positionService.getPosition(position);
        response.setContentType("text/html;charset=utf-8");
        if(existPotion==null){
            long basic_salary = Long.parseLong(salary);
            position.setBasic_salary(basic_salary);
            position.setExist(1);
            if(positionService.addPosition(position)){
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('职位新增成功'));" +
                        "window.location.href='createPosition';</script>");
            }else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('职位新增失败'));" +
                        "window.location.href='createPosition';</script>");
            }
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('此部门中的该职位已存在'));" +
                    "window.location.href='createPosition';</script>");
        }
    }

    @RequestMapping("/alterPosition")
    public String alterPosition(Position position,HttpSession session)throws Exception{
        position = getChosenPosition(position,session);
        session.setAttribute("alterPosition",position);
        return "alterPosition";
    }

    @RequestMapping("/updatePosition")
    public void updatePosition(Position position,String salary, HttpSession session,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Position alterPosition = (Position) session.getAttribute("alterPosition");
        position.setDepart_no(alterPosition.getDepart_no());
        Position existPotion = positionService.getPosition(position);
        long basic_salary = Long.parseLong(salary);
        alterPosition.setBasic_salary(basic_salary);
        alterPosition.setPos_name(position.getPos_name());
        if(existPotion==null){
            if(positionService.updatePosition(alterPosition)){
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('职位修改成功'));" +
                        "window.location.href='managePosition';</script>");
            }else {
                session.setAttribute("alterPosition",alterPosition);
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('职位修改失败'));" +
                        "window.location.href='gotoAlterPosition';</script>");
            }
        }else {
            session.setAttribute("alterPosition",alterPosition);
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('此职位所属的部门中已存在将修改的同名职位\n请更改为其他职位名称'));" +
                    "window.location.href='gotoAlterPosition';</script>");
        }
    }

    @RequestMapping("/gotoAlterPosition")
    public String gotoAlterPosition()throws Exception{
        return "alterPosition";
    }

    private Position getChosenPosition(Position position,HttpSession session)throws Exception{
        List<Position> positions = (List<Position>) session.getAttribute("positions");
        for (Position pos :positions) {
            if (pos.getPos_no()==position.getPos_no()){
                position = pos;
                break;
            }
        }
        return position;
    }

    @RequestMapping("/discardPosition")
    public void discardPosition(Position position,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Position usingPosition = positionService.getUsingPosition(position);
        if (usingPosition==null){
            if(positionService.updateDiscardPosition(position)){
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('职位废弃成功'));" +
                        "window.location.href='managePosition';</script>");
            }else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('职位废弃失败，请重试'));" +
                        "window.location.href='managePosition';</script>");
            }
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('该职位下尚有员工，不可废弃'));" +
                    "window.location.href='managePosition';</script>");
        }

    }

    @RequestMapping("/recoverPosition")
    public void recoverPosition(Position position,HttpServletResponse response)throws Exception {
        response.setContentType("text/html;charset=utf-8");
        Position recoverPosition = positionService.getRecoverPosition(position);
        if (recoverPosition!=null) {
            if (positionService.updateRecoverPosition(position)) {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('职位恢复成功'));" +
                        "window.location.href='managePosition';</script>");
            } else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('职位恢复失败，请重试'));" +
                        "window.location.href='managePosition';</script>");
            }
        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('此职位的部门已解散，不可恢复'));" +
                    "window.location.href='managePosition';</script>");
        }
    }

    @RequestMapping("/deletePosition")
    public void deletePosition(Position position,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        Position usingPosition = positionService.getUsingPosition(position);
        if (usingPosition==null){
            response.getWriter().write("<script language='javascript'>if( confirm(decodeURIComponent('确定要删除吗？'))){" +
                    "window.location.href ='confirmDeletePosition?pos_no="+position.getPos_no()+"';}else {window.location.href ='managePosition';} </script>");

        }else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('该职位下尚有员工，不可删除'));" +
                    "window.location.href='managePosition';</script>");
        }



    }

    @RequestMapping("/confirmDeletePosition")
    public void confirmDeletePosition(Position position,HttpServletResponse response)throws Exception {
        response.setContentType("text/html;charset=utf-8");
        if (positionService.deletePosition(position)) {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('职位删除成功'));" +
                    "window.location.href='managePosition';</script>");
        } else {
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('职位删除失败，请重试'));" +
                    "window.location.href='managePosition';</script>");
        }

    }

    @RequestMapping("/departPosition")
    public String departPosition(Department department,HttpSession session)throws Exception{
        List<Position> departPositions = positionService.getDepartPositions(department);
        session.setAttribute("departPositions",departPositions);
        return "departPositions";
    }
}
