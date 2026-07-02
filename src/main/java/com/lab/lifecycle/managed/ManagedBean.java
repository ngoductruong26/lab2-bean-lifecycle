package com.lab.lifecycle.managed;

import com.lab.lifecycle.singleton.ServiceB;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManagedBean {

    @Autowired
    private ServiceB serviceB;

    public ManagedBean() {
        System.out.println("  [1] Constructor: object duoc tao");
    }

    @PostConstruct
    public void init() {
        // Chạy sau Constructor và Dependency Injection
        System.out.println("  [2] @PostConstruct: bean san sang");

        // Kiểm tra ServiceB đã được inject chưa
        System.out.println("  ServiceB injected? " + (serviceB != null));
    }

    public void doWork() {
        System.out.println("  [*] doWork() duoc goi");

        // Gọi ServiceB để chứng minh đã được inject
        serviceB.assist();
    }

    @PreDestroy
    public void cleanup() {
        // Chạy trước khi bean bị hủy
        System.out.println("  [3] @PreDestroy: don dep truoc khi huy");
    }
}