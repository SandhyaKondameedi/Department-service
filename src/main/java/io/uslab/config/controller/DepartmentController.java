package io.uslab.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.uslab.config.model.DatabaseDetails;
import io.uslab.config.model.ServiceDetails;

@RefreshScope
@RestController
public class DepartmentController 
{
    @Value("${app.service-name}")
    private String serviceName;
    
    @Value("${app.host}")
    private String host;
    
    @Value("${app.env}")
    private String environment;

    @Value("${app.shared.url}")
    private String jdbcUrl;
    
    @Value("${app.shared.user}")
    private String username;
    
    @Value("${app.shared.pass}")
    private String pwd;

    @GetMapping("/service")
    public ServiceDetails getServiceDetails() {
        return new ServiceDetails(host,serviceName,environment);
    }

    @GetMapping("/shared")
    public DatabaseDetails getSharedAttribute() {
        return new DatabaseDetails(jdbcUrl, username, pwd);
    }
}

