package com.github.crowdsourcingplatformapi.restcontroller;

import com.github.crowdsourcingplatformapi.dto.ErrorObject;
import com.github.crowdsourcingplatformapi.models.TaskCreateRequest;
import com.github.crowdsourcingplatformapi.models.entity.Task;
import com.github.crowdsourcingplatformapi.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(value = "task", description = "the task API")
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Invalid parameter or invalid operation", response = ErrorObject.class),
        @ApiResponse(code = 401, message = "Authorization token not provided or invalid", response = ErrorObject.class),
        @ApiResponse(code = 403, message = "This user is prohibited from performing this operation", response = ErrorObject.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorObject.class)
})
public class TaskApiController {
    @Autowired
    TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskCreateRequest taskCreateRequest){
        Task task = taskService.addTask(taskCreateRequest);
        return ResponseEntity.ok(task);
    }
}
