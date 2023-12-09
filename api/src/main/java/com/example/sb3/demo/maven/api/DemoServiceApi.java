package com.example.sb3.demo.maven.api;

import com.example.sb3.demo.maven.api.model.DemoUserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Demo Crud Controller")
public interface DemoServiceApi {

    @Operation(summary = "Create user", description = "create new user")
    @PostMapping("/user")
    DemoUserDto create(@RequestBody DemoUserDto userDto);

    @Operation(summary = "get user", description = "get info about user by id")
    @GetMapping("/user/{id}")
    Optional<DemoUserDto> read(@Parameter(description = "User id") @PathVariable("id") Long id);

    @Operation(summary = "Update user", description = "update existed user")
    @PutMapping("/user")
    DemoUserDto update(@RequestBody DemoUserDto userDto);

    @Operation(summary = "delete user", description = "delete user by id")
    @DeleteMapping("/user/{id}")
    Optional<DemoUserDto> delete(@Parameter(description = "User id") @PathVariable("id") Long id);
}
