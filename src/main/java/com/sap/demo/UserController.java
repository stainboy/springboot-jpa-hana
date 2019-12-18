package com.sap.demo;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController()
@RequestMapping(path = "/v1/users")
public class UserController {

    private static final String DEFAULT_PAGE_SIZE = "10";
    private static final String DEFAULT_PAGE_INDEX = "0";
    private static final String DEFAULT_PAGE_SORT_DIRECTION = "ASC";


    @Autowired
    private UserService userService;


    @PostMapping()
    @ApiOperation(
            value = "Add a new user",
            notes = "Returns the same user added.",
            response = User.class)
    public @ResponseBody
    ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping()
    @ApiOperation(
            value = "Get all users",
            notes = "Returns first N users specified by the size parameter with page offset specified by page parameter.",
            response = Page.class)
    public @ResponseBody
    Page<User> getAllUsers(
            @ApiParam("The size of the page to be returned") @RequestParam(required = false, defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize,
            @ApiParam("Zero-based page index") @RequestParam(required = false, defaultValue = DEFAULT_PAGE_INDEX) Integer pageNo,
            @ApiParam("Field name to sort by") @RequestParam(required = false, defaultValue = "name") String sortBy,
            @ApiParam("Direction to sort by") @RequestParam(required = false, defaultValue = DEFAULT_PAGE_SORT_DIRECTION) Sort.Direction direction
    ) {
        Pageable paging = PageRequest.of(pageNo, pageSize, direction, sortBy);
        return userService.findAll(paging);
    }

    @GetMapping(path = "/{email}")
    @ApiOperation(
            value = "Find user by email address",
            notes = "Returns the user matched by the given email.",
            response = User.class)
    public @ResponseBody
    ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        Optional<User> user = userService.findByEmail(email);
        return ResponseEntity.of(user);
    }

}
