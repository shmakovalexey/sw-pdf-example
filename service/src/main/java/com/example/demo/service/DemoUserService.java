package com.example.demo.service;

import com.example.demo.dao.DemoUserRepo;
import com.example.demo.dao.model.DemoUser;
import com.example.demo.mappers.DemoUserMapper;
import com.example.sb3.demo.maven.api.DemoServiceApi;
import com.example.sb3.demo.maven.api.model.DemoUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DemoUserService implements DemoServiceApi {
    private final DemoUserRepo demoUserRepo;
    private final DemoUserMapper demoUserMapper;

    @Override
    public DemoUserDto create(DemoUserDto dto) {
        DemoUser user = demoUserRepo.save(demoUserMapper.toEntity(dto));
        return demoUserMapper.toDto(user);
    }

    @Override
    public Optional<DemoUserDto> read(Long id) {
        return demoUserRepo.findById(id)
                .map(demoUserMapper::toDto);
    }

    @Override
    @Transactional
    public DemoUserDto update(DemoUserDto dto) {
        DemoUser exist = demoUserRepo.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException(dto.getId() + " not exist"));
        DemoUser entity = demoUserMapper.toEntity(dto);
        demoUserMapper.update(exist, entity);
        DemoUser updated = demoUserRepo.save(exist);
        return demoUserMapper.toDto(updated);
    }

    @Override
    @Transactional
    public  Optional<DemoUserDto> delete(Long id) {
        var exist = demoUserRepo.findById(id);
        exist.ifPresent(user -> demoUserRepo.deleteById(user.getId()));
        return exist.map(demoUserMapper::toDto);
    }
}

