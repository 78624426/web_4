package day5.ems.util;

import day5.ems.entity.Emp;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class Util {
    public static Emp getEmp(HttpServletRequest req){
        Map<String,String[]> m=req.getParameterMap();
        Emp e=new Emp();
        try {
            BeanUtils.populate(e,m);
        } catch (Exception e1) {}
        return e;
    }
}
