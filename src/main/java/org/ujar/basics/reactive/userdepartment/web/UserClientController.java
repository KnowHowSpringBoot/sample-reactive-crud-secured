package org.ujar.basics.reactive.userdepartment.web;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.ujar.basics.reactive.userdepartment.client.UserClient;
import org.ujar.basics.reactive.userdepartment.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client/users")
@RequiredArgsConstructor
class UserClientController {

  private final UserClient userClient;

  @GetMapping("/{userId}")
  @ApiResponses(@ApiResponse(code = 200, message = "Ok", response = User.class))
  Mono<ResponseEntity<User>> getUserById(@PathVariable String userId) {
    Mono<User> user = userClient.getUser(userId);
    return user.map(ResponseEntity::ok)
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @GetMapping
  @ApiResponses(@ApiResponse(code = 200, message = "Ok", response = User.class, responseContainer = "List"))
  Flux<User> getAllUsers() {
    return userClient.getAllUsers();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @ApiResponses(@ApiResponse(code = 201, message = "Created", response = User.class))
  Mono<User> create(@RequestBody User user) {
    return userClient.createUser(user);
  }


}
