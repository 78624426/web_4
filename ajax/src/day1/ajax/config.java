package day1.ajax;

import mvc.annotation.Configuration;
import mvc.config.ResourceHandlerRegistry;
import mvc.config.WebConfigurer;

@Configuration
public class config extends WebConfigurer{
    @Override
    public void addViewControllers(ResourceHandlerRegistry r) {
        r.addViewController("add","/add");
    }
}
