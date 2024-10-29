package com.howtodoinjava.employees;

import com.howtodoinjava.employees.controllers.EmployeeController;
import com.howtodoinjava.employees.dao.EmployeeRepository;
import com.howtodoinjava.employees.services.EmployeeService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * This '@SpringBootTest' annotation is used to load complete application context for end to end integration testing
 * The @SpringBootTest annotation can be used when we need to bootstrap the entire container.
 * The annotation works by creating the ApplicationContext that will be utilized in our tests.
 */
@SpringBootTest
public class EmployeesApplicationTests {

  @Autowired
  EmployeeController employeeController;

  @Autowired
  EmployeeRepository employeeRepository;

  @Autowired
  EmployeeService employeeService;

  @Test
  public void contextLoads() {
    Assertions.assertThat(employeeController).isNotNull();
    Assertions.assertThat(employeeRepository).isNotNull();
    Assertions.assertThat(employeeService).isNotNull();
  }
}
