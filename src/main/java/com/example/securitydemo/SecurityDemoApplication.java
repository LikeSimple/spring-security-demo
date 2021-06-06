package com.example.securitydemo;

import com.example.securitydemo.config.CustomUserDetails;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.example.securitydemo.persistence.mapper")
public class SecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
    }

    @GetMapping("/")
    public String getHome() {
        return "hello world!";
    }

    @GetMapping("/secure/home")
    @PreAuthorize("hasRole('ADMIN')")
    public String getSecureHome() {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Secure Home: " + userDetails.getUsername();
    }

    @GetMapping("/secure/hello/{name}")
    @PreAuthorize("hasPermission(#name,'ADMIN')&&isMember('1')")
    public String sayHello(@PathVariable("name") String name) {
        return "Hello, " + name;
    }

}
