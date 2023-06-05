package com.example.demo.business.concretes;

import com.example.demo.DataAccess.ManagerRepository;
import com.example.demo.business.abstracts.ManagerService;
import com.example.demo.entity.concretes.Manager;
import lombok.Data;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Optional;

@Service
public class ManagerManager implements ManagerService, Job {

    @Autowired
    ManagerRepository managerRepository;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        Long id = jobDataMap.getLong("id");
        System.out.println(id);
        Manager suspendedManager = findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nesne bulunamadı"));
        suspendedManager.setEvrakNo(suspendedManager.getEvrakNo()+"suspended");
        suspendedManager.setState(-1);
        managerRepository.save(suspendedManager);
        System.out.println(new Date());
    }

    @Override
    public Optional<Manager> findById(Long Id) {
        return managerRepository.findById(Id);
    }

    @Override
    public void save(Manager manager) {
        managerRepository.save(manager);
    }


}
