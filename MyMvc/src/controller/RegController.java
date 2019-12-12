package controller;

import constant.UserConstant;
import mvc.annotation.RequestMapping;
import org.apache.commons.beanutils.BeanUtils;
import pojo.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

//localhost/mvc/reg/regHandle.do
@RequestMapping("")
public class RegController  {
    @RequestMapping("/regHandle")
    public String reg(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        Map<String,String[]> m=req.getParameterMap();
        User u=new User();
        BeanUtils.populate(u,m);
        UserService reg= new UserService();
        int flag=reg.regUser(u);
        String msg="";
        if(flag == UserConstant.USER_EXISTS){
            msg="用户名已存在";
        }else if(flag==-2){
            msg="邮箱已存在";
        }else if(flag==0){
            System.out.println("注册成功");
            return "redirect:/login.do";
        }else{
            msg="服务器忙...";
        }
        req.setAttribute("msg",msg);
        return "reg";
    }
    @RequestMapping("/loginHandle")
    public String login(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException {
        Map<String,String[]> m=req.getParameterMap();
        User u=new User();
        BeanUtils.populate(u,m);
        UserService service= new UserService();
        User sucUser=service.loginUser(u);
        if(sucUser==null){
            req.setAttribute("msg","用户名或密码错误");
            return "login";
        }

        req.getSession().setAttribute("user",sucUser);


        return "redirect:/success.do";
    }

}
