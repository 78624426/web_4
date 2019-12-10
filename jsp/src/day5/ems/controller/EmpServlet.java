package day5.ems.controller;

import day5.ems.Empdao;
import day5.ems.entity.Emp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("*.emp")
public class EmpServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path=req.getRequestURI();

        if(path.contains("add")){
            Emp e=new Emp();

            try {
                BeanUtils.populate(e,req.getParameterMap());
            } catch (Exception e0) {
                System.out.println("参数封装出错");
            }

            //下面为解决前端传入的是字符串数组，而BeanUtils封装的只是数组中第一个元素的bug
            String[]arr=req.getParameterValues("hobbies");
            StringBuilder hobbies=new StringBuilder();
            for(String s:arr){
                hobbies.append(s).append(",");
            }
            //删除最后一个字符,并放入emp对象中
            e.setHobbies(hobbies.deleteCharAt(hobbies.length()-1).toString());

            System.out.println("前端传来的emp信息："+e);
            try {
                Empdao.insertEmp(e);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }else if(path.contains("delete")){
            String sid=req.getParameter("id");
            try {
                Empdao.deleteById(Integer.valueOf(sid));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(path.contains("showModify")){
            String sid=req.getParameter("id");
            Emp e= null;
            try {
                e = Empdao.selectById(Integer.valueOf(sid));
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            req.setAttribute("emp",e);
            req.getRequestDispatcher("/day5/ems/showModifyEmp.jsp").forward(req,resp);
            return;
        }else if(path.contains("modify")){
            Emp e=new Emp();
            try {
                BeanUtils.populate(e,req.getParameterMap());
            } catch (Exception e0) {
                System.out.println("参数封装出错");
            }
            try {
                Empdao.updateEmp(e);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        //显示员工列表
        List<Emp>list= null;
        try {
            list = Empdao.selectAllEmp();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("emps",list);
        req.getRequestDispatcher("/day5/ems/empList.jsp").forward(req,resp);
    }
}
