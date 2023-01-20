package org.ujar.bs.reactor.acmedepartments.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.ujar.bs.reactor.acmedepartments.entity.Department;
import reactor.core.publisher.Mono;

public interface DepartmentRepository extends ReactiveCrudRepository<Department, Integer> {
  Mono<Department> findByUserId(Integer userId);
}
