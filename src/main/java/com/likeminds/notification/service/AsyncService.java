package com.likeminds.notification.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncService {

    ExecutorService executorService ;

    public AsyncService(){
        this.executorService =  Executors.newFixedThreadPool(1);
    }
    public void submitTask(Runnable r){
        executorService.execute(r);
    }
}
