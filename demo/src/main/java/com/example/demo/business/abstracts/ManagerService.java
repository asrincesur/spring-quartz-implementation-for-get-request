package com.example.demo.business.abstracts;

import com.example.demo.entity.concretes.Manager;

import java.util.Optional;

public interface ManagerService {


    Optional<Manager> findById(Long Id);

    void save(Manager manager);
}
