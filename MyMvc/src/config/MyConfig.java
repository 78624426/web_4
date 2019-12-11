package config;

import mvc.annotation.Configuration;
import mvc.config.ResourceHandlerRegistry;
import mvc.config.WebConfigurer;
@Configuration
public class MyConfig extends WebConfigurer {
    @Override
    public void addViewControllers(ResourceHandlerRegistry reg) {
        //localhost/mvc/reg.do
        reg.addViewController("reg","/reg")
        .addViewController("login","/login")
        .addViewController("success","/success");
    }
}
