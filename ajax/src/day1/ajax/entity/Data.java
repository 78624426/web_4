package day1.ajax.entity;

/*
create table t_data(
 msg char(100),
 keyword char(32)
)


 */

public class Data {
    String msg;
    String keyword;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
