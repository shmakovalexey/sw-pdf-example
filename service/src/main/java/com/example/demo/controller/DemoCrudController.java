package com.example.demo.controller;

import com.example.demo.service.DemoUserService;
import com.example.sb3.demo.maven.api.DemoServiceApi;
import com.example.sb3.demo.maven.api.model.DemoUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class DemoCrudController implements DemoServiceApi {

    private final DemoUserService demoUserService;

    @Override
    public DemoUserDto create(DemoUserDto userDto) {
        return demoUserService.create(userDto);
    }

    @Override
    public Optional<DemoUserDto> read(Long id) {
        return demoUserService.read(id);
    }

    @Override
    public DemoUserDto update(DemoUserDto userDto) {
        return demoUserService.update(userDto);
    }

    @Override
    public Optional<DemoUserDto> delete(Long id) {
        return demoUserService.delete(id);
    }
}
