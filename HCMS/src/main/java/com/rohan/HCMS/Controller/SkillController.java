package com.rohan.HCMS.Controller;

import com.rohan.HCMS.Model.Employees;
import com.rohan.HCMS.Model.Skill;
import com.rohan.HCMS.Repository.EmployeesRepository;
import com.rohan.HCMS.Repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@CrossOrigin
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;
    
    @Autowired
    private EmployeesRepository employeesRepository;

    // Get all skills
    @GetMapping("/allskill")
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    // Get a single skill by ID
    @GetMapping("/skill/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable(value = "id") Integer skillId) {
        Optional<Skill> skill = skillRepository.findById(skillId);
        return skill.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new skill
    @PostMapping("/add/skill")
    public String createSkill(@RequestBody Skill newSkill) {
        Optional<Skill> existingSkill = skillRepository.findBySkillName(newSkill.getSkillName());

        if (existingSkill.isPresent()) {
            return "Skill already created!";
        }

        skillRepository.save(newSkill);
        return "Skill created successfully!";
    }


    // Update an existing skill
    @PutMapping("/update/skill/{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable(value = "id") Integer skillId, @RequestBody Skill skillDetails) {
        Optional<Skill> optionalSkill = skillRepository.findById(skillId);
        if (!optionalSkill.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Skill skill = optionalSkill.get();
        skill.setSkillName(skillDetails.getSkillName());
        skill.setSkillVersion(skillDetails.getSkillVersion());
        skill.setEmployee(skillDetails.getEmployee());

        Skill updatedSkill = skillRepository.save(skill);
        return ResponseEntity.ok(updatedSkill);
    }

    // Delete a skill
    @DeleteMapping("/delete/skill/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable(value = "id") Integer skillId) {
        Optional<Skill> optionalSkill = skillRepository.findById(skillId);
        if (!optionalSkill.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        skillRepository.delete(optionalSkill.get());
        return ResponseEntity.ok().build();
    }
    
    //New Employee
    @PostMapping("/newEmployee/{empId}")
    public void updateSkillForNewEmployee(@PathVariable int empId, @RequestBody List<Skill> skills) {
        Employees employee = employeesRepository.findById(empId).orElseThrow(() -> 
        new IllegalArgumentException("Invalid employee ID"));
        for (Skill skill : skills) {
            skill.setEmployee(employee);
            skillRepository.save(skill);
        }
    }
}

