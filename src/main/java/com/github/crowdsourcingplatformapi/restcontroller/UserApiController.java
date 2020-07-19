package com.github.crowdsourcingplatformapi.restcontroller;

import com.github.crowdsourcingplatformapi.dto.ErrorObject;
import com.github.crowdsourcingplatformapi.models.entity.User;
import com.github.crowdsourcingplatformapi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "users", description = "the users API")
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "Invalid parameter or invalid operation", response = ErrorObject.class),
        @ApiResponse(code = 401, message = "Authorization token not provided or invalid", response = ErrorObject.class),
        @ApiResponse(code = 403, message = "This user is prohibited from performing this operation", response = ErrorObject.class),
        @ApiResponse(code = 500, message = "Internal server error", response = ErrorObject.class)
})
public class UserApiController {
    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> registerNewUser(@Valid @RequestBody User user) throws Exception {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping("/users-with-skills")
    public ResponseEntity<List<User>> getUsersWithMandatorySkills(@RequestParam(value = "skillList", required = true) @NotEmpty List<String> skillList) {
        List<User> usersList = userService.findUsersHavingMandatorySkills(skillList);
        return ResponseEntity.ok(usersList);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable UUID userId){
        User user = userService.findUserById(userId);
        if(user!=null)
            return ResponseEntity.ok(user);
        else
            return new ResponseEntity("No such user with id: "+user,HttpStatus.NOT_FOUND);
    }

    //accessible only to the user
    @PatchMapping("/users/{userId}")
    public ResponseEntity<User> updateSkillsForTheUser(@PathVariable UUID userId, @RequestBody List<String> skills){
        User user = userService.updateSkillsForTheUserWithId(userId,skills);
        if(user!=null)
            return ResponseEntity.ok(user);
        else
            return new ResponseEntity("No such user with id: "+user,HttpStatus.NOT_FOUND);
    }

    //accessible only to the user
    @GetMapping("/users/{userId}/tasks")
    public ResponseEntity<User> getTasksForWhichUserRegistered(@PathVariable UUID userId){
        return null;
    }


}
