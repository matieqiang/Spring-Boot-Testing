package com.howtodoinjava.employees.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.howtodoinjava.employees.model.Employee;
import com.howtodoinjava.employees.services.EmployeeService;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * '@WebMvcTest'
 * <p>
 * 1. '@WebMvcTest' Provides an easy way to configure and execute unit tests for Spring MVC.
 * It focuses on testing the behavior of components such as @ControllerController, @RestController, and @ControllerAdvice without launching the full application context.
 * <p>
 * 2. Using the @WebMvcTest annotation allows you to specify the controller class to be tested,
 * while automatically configuring the required beans.
 * This increases the efficiency of testing and reduces test dependencies.
 * <p>
 * 3. This allows you to simulate and validate requests using MockMvc objects during testing.
 *
 * 'MockMvc class,'
 */
@WebMvcTest(EmployeeController.class)
public class StandaloneControllerTests {

    @MockBean
    EmployeeService employeeService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testfindAll() throws Exception {
        Employee employee = new Employee("Lokesh", "Gupta");
        List<Employee> employees = Arrays.asList(employee);

        Mockito.when(employeeService.findAll()).thenReturn(employees);

        mockMvc.perform(get("/employee"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", Matchers.is("Lokesh")));
    }

}
