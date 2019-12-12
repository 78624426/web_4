package day1.ajax.mapper;

import day1.ajax.entity.Data;
import jdbc.tmp.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataMapper implements RowMapper<Data>{
    @Override
    public Data mapRow(ResultSet rs) throws SQLException {
        Data d=new Data();
        d.setKeyword(rs.getString("keyword"));
        d.setMsg(rs.getString("msg"));
        return d;
    }
}
