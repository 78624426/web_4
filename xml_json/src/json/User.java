package json;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Arrays;
import java.util.Date;

public class User {
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    Date birth;
    String address;
    int[]arr;
    Boolean isOk;

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public Boolean getOk() {
        return isOk;
    }

    public void setOk(Boolean ok) {
        isOk = ok;
    }

    public User(Date birth, String address, int[] arr, Boolean isOk) {
        this.birth = birth;
        this.address = address;
        this.arr = arr;
        this.isOk = isOk;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "birth=" + birth +
                ", address='" + address + '\'' +
                ", arr=" + Arrays.toString(arr) +
                ", isOk=" + isOk +
                '}';
    }
}
