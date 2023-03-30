package org.ujar.webfluxcrudsecured.service;

import java.util.List;
import java.util.function.BiFunction;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ujar.webfluxcrudsecured.dto.UserDepartmentDTO;
import org.ujar.webfluxcrudsecured.entity.Department;
import org.ujar.webfluxcrudsecured.entity.User;
import org.ujar.webfluxcrudsecured.repository.DepartmentRepository;
import org.ujar.webfluxcrudsecured.repository.UserRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  private final DepartmentRepository departmentRepository;
  private final BiFunction<User, Department, UserDepartmentDTO> userDepartmentDTOBiFunction =
      (x1, x2) -> UserDepartmentDTO.builder()
          .age(x1.getAge())
          .departmentId(x2.getId())
          .departmentName(x2.getName())
          .userName(x1.getName())
          .userId(x1.getId())
          .location(x2.getLocation())
          .salary(x1.getSalary()).build();

  public Mono<User> createUser(User user) {
    return userRepository.save(user);
  }

  public Flux<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Mono<User> findById(Integer userId) {
    return userRepository.findById(userId);
  }

  public Mono<User> updateUser(Integer userId, User user) {
    return userRepository.findById(userId)
        .flatMap(dbUser -> {
          dbUser.setAge(user.getAge());
          dbUser.setSalary(user.getSalary());
          return userRepository.save(dbUser);
        });
  }

  public Mono<User> deleteUser(Integer userId) {
    return userRepository.findById(userId)
        .flatMap(existingUser -> userRepository.delete(existingUser)
            .then(Mono.just(existingUser)));
  }

  public Flux<User> findUsersByAge(int age) {
    return userRepository.findByAge(age);
  }

  public Flux<User> fetchUsers(List<Integer> userIds) {
    return Flux.fromIterable(userIds)
        .parallel()
        .runOn(Schedulers.boundedElastic())
        .flatMap(this::findById)
        .ordered((u1, u2) -> u2.getId() - u1.getId());
  }

  private Mono<Department> getDepartmentByUserId(Integer userId) {
    return departmentRepository.findByUserId(userId);
  }

  public Mono<UserDepartmentDTO> fetchUserAndDepartment(Integer userId) {
    Mono<User> user = findById(userId).subscribeOn(Schedulers.boundedElastic());
    Mono<Department> department = getDepartmentByUserId(userId).subscribeOn(Schedulers.boundedElastic());
    return Mono.zip(user, department, userDepartmentDTOBiFunction);
  }

}
