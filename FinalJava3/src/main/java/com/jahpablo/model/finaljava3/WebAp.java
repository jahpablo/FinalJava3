package com.jahpablo.model.finaljava3;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAp extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println(">>>>>>>>>>>>>>> Cargando Configuracion clases de configuracion");
        return new Class<?>[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Cargando configuracion de servlets");
        return new Class<?>[]{WebApConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> Cargando Configuracion de Servicios"); 
       return new String[]{"/servicios/*"};
    }
    
}
