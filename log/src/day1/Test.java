package day1;

import org.apache.log4j.Logger;

public class Test {
    public static void main(String[] args) {
        Logger log=Logger.getLogger(Test.class);
        log.debug("debug:错误信息1");
        log.info("info:错误信息2");
        log.warn("warn:错误信息3");
        log.error("error:错误信息4");
        log.fatal("fatal:错误信息5");

        try{
            int a=1/0;
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
