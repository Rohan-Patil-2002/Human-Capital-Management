package com.rohan.HCMS.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.rohan.HCMS.Model.Department;
import com.rohan.HCMS.Model.Employees;


@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
    Optional<Employees> findByEmail(String email);

    List<Employees> findByDepartment(Department department);

    @Query(value="SELECT * FROM employees WHERE emp_name LIKE %?1%", nativeQuery = true)
    List<Employees> findByEmployeeNameLike(String emp_name);

}
