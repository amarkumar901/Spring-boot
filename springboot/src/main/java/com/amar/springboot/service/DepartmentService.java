package com.amar.springboot.service;

import java.util.List;

import com.amar.springboot.entity.Department;
import com.amar.springboot.error.DepartmentNotFoundException;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentsList();

    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

    public String deleteDepartmentById(Long id);

    public Department updateDepartment(Long id, Department department);

    public Department fetchDepartmentByName(String name);
    
}
