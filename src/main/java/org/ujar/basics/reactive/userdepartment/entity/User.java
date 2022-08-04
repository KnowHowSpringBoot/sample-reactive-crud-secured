package org.ujar.basics.reactive.userdepartment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(User.TABLE)
public class User {

  protected static final String TABLE = "users";

  @Id
  private Integer id;

  private String name;

  private int age;

  private double salary;
}
