package com.rohan.HCMS.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.HCMS.Model.Department;
import com.rohan.HCMS.Repository.DepartmentRepository;

@RestController
@RequestMapping
@CrossOrigin
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Get all departments
    @GetMapping("/alldepartments")
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @GetMapping("/departments/{deptId}")
    public List<Department> getDepartmentById(@PathVariable int deptId) {
        return departmentRepository.findByDeptId(deptId);
    }

    // Create new department
    @PostMapping("/departments")
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    // Update department
    @PutMapping("update/department/{deptId}")
    public ResponseEntity<Department> updateDepartment(@PathVariable int deptId, @RequestBody Department departmentDetails) {
        Optional<Department> department = departmentRepository.findById(deptId);
        if (department.isPresent()) {
            Department dept = department.get();
            dept.setDeptName(departmentDetails.getDeptName());
            return ResponseEntity.ok(departmentRepository.save(dept));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete department
    @DeleteMapping("/delete/department/{deptId}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable int deptId) {
        Optional<Department> department = departmentRepository.findById(deptId);
        if (department.isPresent()) {
            departmentRepository.delete(department.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
