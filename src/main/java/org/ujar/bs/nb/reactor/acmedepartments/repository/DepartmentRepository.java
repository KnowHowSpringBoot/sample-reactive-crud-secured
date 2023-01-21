package org.ujar.bs.nb.reactor.acmedepartments.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.ujar.bs.nb.reactor.acmedepartments.entity.Department;
import reactor.core.publisher.Mono;

public interface DepartmentRepository extends ReactiveCrudRepository<Department, Integer> {
  Mono<Department> findByUserId(Integer userId);
}
