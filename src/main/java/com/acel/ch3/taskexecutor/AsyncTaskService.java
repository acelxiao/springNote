package com.acel.ch3.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
@Service
public class AsyncTaskService {
	
	@Async //注解在类上则该类所有方法都是异步的
    public void executeAsyncTask(Integer i){
        System.out.println("任务1: "+i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i){
        System.out.println("任务2: "+ i);
    }

}
