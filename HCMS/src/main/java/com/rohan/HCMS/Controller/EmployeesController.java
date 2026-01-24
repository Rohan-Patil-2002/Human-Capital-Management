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

import com.rohan.HCMS.LoginRequest;
import com.rohan.HCMS.Model.ArchivedEmployee;
import com.rohan.HCMS.Model.Department;
import com.rohan.HCMS.Model.Employees;
import com.rohan.HCMS.Model.Skill;
import com.rohan.HCMS.Repository.ArchivedEmployeeRepository;
import com.rohan.HCMS.Repository.EmployeesRepository;
import com.rohan.HCMS.responseType.LoginResponse;
import com.rohan.HCMS.responseType.Status;

@RestController
@RequestMapping
@CrossOrigin
public class EmployeesController {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Autowired
    private ArchivedEmployeeRepository archivedEmployeeRepository;

    // GET all employees
    @GetMapping("/allemployees")
    public ResponseEntity<List<Employees>> getAllEmployees() {
        List<Employees> employees = employeesRepository.findAll();
        return ResponseEntity.ok(employees);
    }

    // GET employee by ID
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employees> getEmployeeById(@PathVariable int id) {
        Optional<Employees> employee = employeesRepository.findById(id);
        return employee.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST create new employee
    @PostMapping("/employees")
    public Employees saveEmployee(@RequestBody Employees employees) {
    	System.out.println(employees.getEmpName());
    	System.out.println(employees.getDepartment().getDeptId());
    	return employeesRepository.save(employees);
    }

    //POST login 
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        Optional<Employees> employeeOptional = employeesRepository.findByEmail(loginRequest.getEmail());

        if (employeeOptional.isPresent()) {
            Employees employee = employeeOptional.get();

            // Check if the email from the request matches the email in the database
            if (!employee.getEmail().equals(loginRequest.getEmail())) {
                return ResponseEntity.status(401).body(new LoginResponse("Invalid email", null));
            }

            // Check if the password from the request matches the password in the database
            if (!employee.getEmpPass().equals(loginRequest.getEmpPass())) {
                return ResponseEntity.status(401).body(new LoginResponse("Invalid password", null));
            }

            // If both email and password are correct
            return ResponseEntity.ok(new LoginResponse("Login successful", employee));
        } else {
            return ResponseEntity.status(404).body(new LoginResponse("Employee not found", null));
        }
    }

    // PUT update employee
    @PutMapping("/update/employee/{id}")
    public ResponseEntity<Employees> updateEmployee(@PathVariable int id, @RequestBody Employees employeeDetails) {
        Optional<Employees> optionalEmployee = employeesRepository.findById(id);
        if (!optionalEmployee.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Employees existingEmployee = optionalEmployee.get();
        existingEmployee.setEmpName(employeeDetails.getEmpName());
        existingEmployee.setEmpPass(employeeDetails.getEmpPass());
        existingEmployee.setSalary(employeeDetails.getSalary());
        existingEmployee.setAge(employeeDetails.getAge());
        existingEmployee.setGender(employeeDetails.getGender());
        existingEmployee.setEmail(employeeDetails.getEmail());
        existingEmployee.setPhoneNo(employeeDetails.getPhoneNo());
        existingEmployee.setDepartment(employeeDetails.getDepartment());

        // Handle skills collection
        existingEmployee.getSkills().clear();
        for (Skill skill : employeeDetails.getSkills()) {
            skill.setEmployee(existingEmployee); // Set the bi-directional relationship
            existingEmployee.getSkills().add(skill);
        }

        Employees updatedEmployee = employeesRepository.save(existingEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }


    // DELETE employee
    @DeleteMapping("/delete/employee/{empId}")
    public Status deleteEmployee(@PathVariable int employeeId)
    {
    	try {
    		Optional<Employees> optional = employeesRepository.findById(employeeId);

    		if(!optional.isPresent()) {
				return new Status(false);
			}

    		Employees employees = optional.get();

//    		ArchivedEmployee archivedEmployee = new ArchivedEmployee(employees.getEmpId(),
//    				employees.getEmpName(), employees.getEmpPass(),  employees.getEmail(),
//    				employees.getPhoneNo(),employees.getSalary(),employees.getGender(),
//    				employees.getAge(), employees.getDepartment());

//    		archivedEmployeeRepository.save(archivedEmployee);
    		employeesRepository.deleteById(employeeId);
    		return new Status(true);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return new Status(false);
    	}
    }

    // Get Department by Id
    @GetMapping("/employees/department/{id}")
    public List<Employees> getEmployeesByDepartment(@PathVariable int id) {
        Department department = new Department();
        department.setDeptId(id);
        return employeesRepository.findByDepartment(department);
    }

    //Get Search
    @GetMapping("/employee/find/{employeeName}")
    public List<Employees> getEmployeeByName(@PathVariable String employeeName){
    	return employeesRepository.findByEmployeeNameLike("%" + employeeName + "%");
    }
}