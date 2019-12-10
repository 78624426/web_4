package day5.ems;

import day5.ems.entity.Emp;
import day5.ems.mapper.EmpMapper;
import jdbc.tmp.Tmp;

import java.sql.SQLException;
import java.util.List;

public class Empdao {
    static public void insertEmp(Emp e) throws SQLException {
        String sql="insert into "+
                "t_emp "+
                "(name,salary,gender,edu,hobbies) "+
                "values(?,?,?,?,?)";
        Tmp.update(sql,e.getName(),e.getSalary(),e.getGender(),e.getEdu(),e.getHobbies());
    }

    public static void deleteById(Integer id) throws SQLException {
        String sql="delete from t_emp where id=?";
        Tmp.update(sql,id);
    }

    public static Emp selectById(Integer id) throws SQLException {
        String sql="select * from t_emp where id=?";

        List<Emp>list=Tmp.query(sql,new EmpMapper(),id);
        return list.isEmpty()?null:list.get(0);
    }

    public static void updateEmp(Emp e) throws SQLException {
            String sql="update t_emp set name=?,salary=?,gender=?,edu=?,hobbies=? where id=?";
        Tmp.update(sql,e.getName(),e.getSalary(),e.getGender(),e.getEdu(),e.getHobbies(),e.getId());
    }

    public static List<Emp> selectAllEmp() throws SQLException {
        String sql="select * from t_emp";
        return Tmp.query(sql,new EmpMapper());
    }
}
