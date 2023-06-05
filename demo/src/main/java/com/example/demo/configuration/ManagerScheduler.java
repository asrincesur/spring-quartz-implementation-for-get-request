package com.example.demo.configuration;

import com.example.demo.DataAccess.ManagerRepository;
import com.example.demo.business.concretes.ManagerManager;
import org.hibernate.type.descriptor.DateTimeUtils;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class ManagerScheduler {

    @Autowired
    private Scheduler scheduler;

    public void scheduleJob(Long id) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(ManagerManager.class)
                .withIdentity("ManagerManager", "group1")
                .usingJobData("id", id)
                .build();

      /*  Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .build();*/
        LocalDateTime currentTime = LocalDateTime.now();
        //property şeklinde ver
        LocalDateTime scheduledTime = currentTime.plusSeconds(15);

        ZonedDateTime zonedDateTime = scheduledTime.atZone(ZoneId.systemDefault());
        Date startDate = Date.from(zonedDateTime.toInstant());

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .startAt(startDate) // 30 saniye sonra başlat
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
    }



}
