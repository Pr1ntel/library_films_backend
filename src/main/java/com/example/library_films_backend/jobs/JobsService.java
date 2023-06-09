package com.example.library_films_backend.jobs;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import org.quartz.*;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
@AllArgsConstructor
public class JobsService {
    private Scheduler scheduler;

    public void run() throws SchedulerException {

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("my-name", "РЕКЛАМА");

        JobDetail jobDetail = JobBuilder
                .newJob(SimpleJob.class)
                .setJobData(jobDataMap)
                .build();

        SimpleScheduleBuilder simpleSchedule = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInMilliseconds(10000)

        .withRepeatCount(5);

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withSchedule(simpleSchedule)
                .startAt(new Date(System.currentTimeMillis()))
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
    }

    @PostConstruct
    public void postConstruct() throws SchedulerException {
        scheduler.start();
    }

    @PreDestroy
    public void preDestroy() throws SchedulerException {
        scheduler.shutdown();
    }
}
