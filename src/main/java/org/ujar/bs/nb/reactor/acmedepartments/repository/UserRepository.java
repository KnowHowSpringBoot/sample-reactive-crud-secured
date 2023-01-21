package org.ujar.bs.nb.reactor.acmedepartments.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.ujar.bs.nb.reactor.acmedepartments.entity.User;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveCrudRepository<User, Integer> {
  @Query("SELECT * FROM users WHERE age >= $1")
  Flux<User> findByAge(int age);
}
