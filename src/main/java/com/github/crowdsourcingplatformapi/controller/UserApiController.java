package com.github.crowdsourcingplatformapi.controller;

import com.github.crowdsourcingplatformapi.dto.ErrorObject;
import com.github.crowdsourcingplatformapi.entity.User;
import com.github.crowdsourcingplatformapi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

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

}
