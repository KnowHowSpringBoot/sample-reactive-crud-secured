package org.ujar.basics.reactive.acmedepartments.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.ujar.basics.reactive.acmedepartments.entity.Department;
import reactor.core.publisher.Mono;

public interface DepartmentRepository extends ReactiveCrudRepository<Department, Integer> {
  Mono<Department> findByUserId(Integer userId);
}
