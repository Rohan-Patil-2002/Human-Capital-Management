package com.rohan.HCMS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rohan.HCMS.Model.Department;
import com.rohan.HCMS.Model.Employees;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    List<Department> findByDeptId(int deptId);

	List<Department> findByEmployees(Employees employee);

}
