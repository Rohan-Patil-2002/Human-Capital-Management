package com.rohan.HCMS.Repository;

import com.rohan.HCMS.Model.Skill;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

	Optional<Skill> findBySkillName(String skillName);
}
