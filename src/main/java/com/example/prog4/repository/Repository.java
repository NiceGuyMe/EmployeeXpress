package com.example.prog4.repository;

import com.example.prog4.entity.Employee.EmployeeEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.domain.Specification;

@org.springframework.stereotype.Repository
@Primary
public interface Repository {
  void save(EmployeeEntity employee);

  Optional<EmployeeEntity> findById(int id);

  List<EmployeeEntity> findAll(Specification<EmployeeEntity> spec);

  List<EmployeeEntity> findAllWithoutCnaps(Specification<EmployeeEntity> spec);
}
