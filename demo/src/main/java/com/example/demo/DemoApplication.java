package com.example.demo;

import com.example.demo.DataAccess.ManagerRepository;
import com.example.demo.entity.concretes.Manager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {




    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        ManagerRepository repository = context.getBean(ManagerRepository.class);
        Manager manager = new Manager(1L,1,"2023BS");
        Manager manager2 = new Manager(2L,1,"2023BS");

        repository.save(manager);
        repository.save(manager2);

    }
}
