package day5.ems.controller;

import day5.ems.Empdao;
import day5.ems.entity.Emp;
import day5.ems.util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("*.emp")
public class EmpServlet extends HttpServlet{
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path=req.getRequestURI();
        if(path.contains("add")){
            Emp e=Util.getEmp(req);
            System.out.println("前端传来的emp信息："+e);
            Empdao.insertEmp(e);
        }else if(path.contains("delete")){
            String sid=req.getParameter("id");
            Empdao.deleteById(Integer.valueOf(sid));
        }else if(path.contains("showModify")){
            String sid=req.getParameter("id");
            Emp e = Empdao.selectById(Integer.valueOf(sid));
            req.setAttribute("emp",e);
            req.getRequestDispatcher("/day5/ems/showModifyEmp.jsp").forward(req,resp);
            return;
        }else if(path.contains("modify")){
            Emp e=Util.getEmp(req);
            Empdao.updateEmp(e);
        }
        //显示员工列表
        List<Emp>list = Empdao.selectAllEmp();
        req.setAttribute("emps",list);
        req.getRequestDispatcher("/day5/ems/empList.jsp").forward(req,resp);
    }
}
