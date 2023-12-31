package com.example.prog4.repository.Employee;

import com.example.prog4.entity.Employee.EmployeeEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity, Integer>,
    JpaSpecificationExecutor<EmployeeEntity> {
  EmployeeEntity findFirstByOrderByEmployeeNumberDesc();

  Optional<EmployeeEntity> findById(int id);

  void save(EmployeeEntity employee);

}
