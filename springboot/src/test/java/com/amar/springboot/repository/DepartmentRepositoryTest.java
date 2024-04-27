package com.amar.springboot.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.amar.springboot.entity.Department;

@SpringBootTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setup() {

        Department department = Department.builder().departmentAddress("Delhi").departmentCode("ME-011").departmentName("Mechanical").build();
        entityManager.persist(department);

    }

    @Test
    void whenFindByName_thenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals("Mechanical",department.getDepartmentName());
    }


}
