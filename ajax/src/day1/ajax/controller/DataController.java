package day1.ajax.controller;

import day1.ajax.entity.Data;
import day1.ajax.mapper.DataMapper;
import jdbc.tmp.Tmp;
import mvc.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("")
public class DataController  {
    @RequestMapping("/checkKey")
    public void checkKey(HttpServletRequest req, HttpServletResponse resp)throws Exception{
        String sql="select msg,keyword from t_data where keyword=?";
        List<Data> list=Tmp.query(sql,new DataMapper(),req.getParameter("key"));
        String msg="";
        if(list.isEmpty()){
            msg="<font color='green'>可以正常添加</font>";
        }else{
            msg="<font color='red'>key 已存在</font>";
        }
        resp.getWriter().print(msg);
    }
}
