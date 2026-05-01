package com.divya.soapservice.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.config.annotation.EnableWs;
//import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.endpoint.adapter.DefaultMethodEndpointAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "users")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema userSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("UserPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://example.com/user");
        wsdl.setSchema(userSchema);
        return wsdl;
    }
//
//    @Bean
//    public Jaxb2Marshaller marshaller() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setContextPath("com.divya.soapservice.generated");
//        return marshaller;
//    }

//    @Bean
//    public org.springframework.ws.server.endpoint.adapter.MarshallingMethodEndpointAdapter marshallingMethodEndpointAdapter(Jaxb2Marshaller marshaller) {
//        org.springframework.ws.server.endpoint.adapter.MarshallingMethodEndpointAdapter adapter =
//                new org.springframework.ws.server.endpoint.adapter.MarshallingMethodEndpointAdapter();
//
//        adapter.setMarshaller(marshaller);
//        adapter.setUnmarshaller(marshaller);
//
//        return adapter;
//    }

//    @Bean
//    public DefaultMethodEndpointAdapter defaultMethodEndpointAdapter() {
//        return new DefaultMethodEndpointAdapter();
//    }

    @Bean
    public XsdSchema userSchema() {
        return new SimpleXsdSchema(new ClassPathResource("user.xsd"));
    }
}


//package com.divya.soapservice.config;

//
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.ws.config.annotation.EnableWs;
////import org.springframework.ws.config.annotation.WsConfigurerAdapter;
//import org.springframework.ws.transport.http.MessageDispatcherServlet;
//import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
//import org.springframework.xml.xsd.SimpleXsdSchema;
//import org.springframework.xml.xsd.XsdSchema;
//
//@EnableWs
//@Configuration
//public class WebServiceConfig {
//
//    @Bean
//    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
//        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
//        servlet.setApplicationContext(context);
//        servlet.setTransformWsdlLocations(true);
//        return new ServletRegistrationBean<>(servlet, "/ws/*");
//    }
//
//    @Bean(name = "users")
//    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema userSchema) {
//        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
//        wsdl.setPortTypeName("UserPort");
//        wsdl.setLocationUri("/ws");
//        wsdl.setTargetNamespace("http://example.com/user");
//        wsdl.setSchema(userSchema);
//        return wsdl;
//    }
//
//    @Bean
//    public XsdSchema userSchema() {
//        return new SimpleXsdSchema(new ClassPathResource("user.xsd"));
//    }
//}
