package com.amar.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.amar.springboot.entity.Department;
import com.amar.springboot.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setup(){

        Department department = Department.builder().departmentAddress("Bangalore").departmentCode("IT-06").departmentName("IT").departmentId(1L).build();
        Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(department);

    }

    @Test
    void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "IT";
        Department department = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, department.getDepartmentName());
    }
}
