package day5.ems;

import day5.ems.entity.Emp;
import day5.ems.mapper.EmpMapper;
import jdbc.tmp.Tmp;

import java.sql.SQLException;
import java.util.List;

public class Empdao {
    static public void insertEmp(Emp e)  {
        String sql="insert into "+
                "t_emp "+
                "(name,salary,gender,edu,hobbies) "+
                "values(?,?,?,?,?)";
        try {
            Tmp.update(sql,e.getName(),e.getSalary(),e.getGender(),e.getEdu(),e.getHobbies_str());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void deleteById(Integer id) {
        String sql="delete from t_emp where id=?";
        try {
            Tmp.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Emp selectById(Integer id) {
        String sql="select * from t_emp where id=?";

        List<Emp>list= null;
        try {
            list = Tmp.query(sql,new EmpMapper(),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list.isEmpty()?null:list.get(0);
    }

    public static void updateEmp(Emp e){
        String sql="update t_emp set name=?,salary=?,gender=?,edu=?,hobbies=? where id=?";
        try {
            Tmp.update(sql,e.getName(),e.getSalary(),e.getGender(),e.getEdu(),e.getHobbies_str(),e.getId());
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static List<Emp> selectAllEmp(){
        String sql="select * from t_emp";
        List<Emp>list=null;
        try {
            list=Tmp.query(sql,new EmpMapper());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
