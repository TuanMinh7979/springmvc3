package com.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//class thay the cho web.xml
public class ApplicationInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationConf.class, SecurityConf.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SecurityConf.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
