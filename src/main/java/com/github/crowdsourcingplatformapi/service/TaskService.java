package com.github.crowdsourcingplatformapi.service;

import com.github.crowdsourcingplatformapi.models.TaskCreateRequest;
import com.github.crowdsourcingplatformapi.models.entity.Task;
import com.github.crowdsourcingplatformapi.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class TaskService {
    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ModelMapper modelMapper;

    public Task addTask(TaskCreateRequest taskCreateRequest) {
        Task task = modelMapper.map(taskCreateRequest,Task.class);
        task.setStatus(Task.TaskStatus.Idle);
        //logic to fetch current user name via SpringSecurityContex
        task.setUserId(null);
        return taskRepository.saveAndFlush(task);
    }
}
