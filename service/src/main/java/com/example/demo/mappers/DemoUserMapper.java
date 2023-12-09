package com.example.demo.mappers;

import com.example.demo.dao.model.DemoUser;
import com.example.sb3.demo.maven.api.model.DemoUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DemoUserMapper {

    DemoUserDto toDto(DemoUser entity);

    DemoUser toEntity(DemoUserDto dto);

    void update(@MappingTarget DemoUser target, DemoUser src);
}
