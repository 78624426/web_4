package day1.ajax.controller;

import com.alibaba.fastjson.JSON;
import day1.ajax.entity.Data;
import day1.ajax.entity.Result;
import day1.ajax.mapper.DataMapper;
import jdbc.tmp.Tmp;
import mvc.annotation.RequestMapping;
import mvc.annotation.ResponseBody;

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
    @RequestMapping("/checkKeyJson")
    public void checkKeyForJson(HttpServletRequest req, HttpServletResponse resp)throws Exception{
        String sql="select msg,keyword from t_data where keyword=?";
        List<Data> list=Tmp.query(sql,new DataMapper(),req.getParameter("key"));
        String msg="";
        if(list.isEmpty()){
            msg="<font color='green'>可以正常添加</font>";
        }else{
            msg="<font color='red'>key 已存在</font>";
        }
        Result r=new Result();
        r.setInfo(msg);
        msg= JSON.toJSONString(r);
        //{info:<font color='red'>key 已存在</font>}
        resp.getWriter().print(msg);
    }
    @RequestMapping("/getInfo")
    public void getinfo(HttpServletRequest req, HttpServletResponse resp)throws Exception{
        resp.getWriter().print("这是ajax功能演示案例");
    }

    @RequestMapping("/findOne1")
    public void findOne1(HttpServletRequest req, HttpServletResponse resp)throws Exception{
        String sql="select msg,keyword from t_data where keyword=? or msg=?";
        String key=req.getParameter("key");
        List<Data>list=Tmp.query(sql,new DataMapper(),key,key);
        Data d=new Data();
        if(!list.isEmpty()){//非空则进入
            d=list.get(0);
        }
        resp.getWriter().print(JSON.toJSONString(d));
    }

    @RequestMapping("/findOne2")
    @ResponseBody
    public Data findOne2(HttpServletRequest req, HttpServletResponse resp)throws Exception{
        String sql="select msg,keyword from t_data where keyword=? or msg=?";
        String key=req.getParameter("key");
        List<Data>list=Tmp.query(sql,new DataMapper(),key,key);
        Data d=new Data();
        if(!list.isEmpty()){//非空则进入
            d=list.get(0);
        }
        System.out.println(JSON.toJSONString(list));
        return d;
    }
    @RequestMapping("/findMore")
    @ResponseBody
    public List<Data> findMore(HttpServletRequest req, HttpServletResponse resp)throws Exception{
        String sql="select msg,keyword from t_data where keyword like ? or msg like ?";
        String key=req.getParameter("key");
        List<Data>list=Tmp.query(sql,new DataMapper(),"%"+key+"%","%"+key+"%");
        return list;
    }
}
