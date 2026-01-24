package com.rohan.HCMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.HCMS.Model.ArchivedEmployee;
import com.rohan.HCMS.Repository.ArchivedEmployeeRepository;

@RestController
@CrossOrigin
public class ArchivedEmployeeController {
	@Autowired
    private ArchivedEmployeeRepository archivedEmployeeRepository;

	@GetMapping("/archive/employee")
	public List<ArchivedEmployee>getEmployees(){
		return archivedEmployeeRepository.findAll();
	}
}
