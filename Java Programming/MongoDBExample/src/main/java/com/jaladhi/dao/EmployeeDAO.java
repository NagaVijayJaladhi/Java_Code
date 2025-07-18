package com.jaladhi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.jaladhi.model.EmployeeModel;

@EnableMongoRepositories
@Repository
public interface EmployeeDAO extends MongoRepository<EmployeeModel, Long> {

}
