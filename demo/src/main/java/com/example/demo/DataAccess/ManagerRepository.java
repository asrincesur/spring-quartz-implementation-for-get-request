package com.example.demo.DataAccess;

import com.example.demo.entity.concretes.Manager;
import org.quartz.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}