package org.ujar.basics.reactive.userdepartment.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.ujar.basics.reactive.userdepartment.entity.Department;
import reactor.core.publisher.Mono;

public interface DepartmentRepository extends ReactiveCrudRepository<Department, Integer> {
  Mono<Department> findByUserId(Integer userId);
}
