package com.example.demo.dao;

import com.example.demo.dao.model.DemoUser;
import org.springframework.data.repository.CrudRepository;

public interface DemoUserRepo extends CrudRepository<DemoUser, Long> {
}
