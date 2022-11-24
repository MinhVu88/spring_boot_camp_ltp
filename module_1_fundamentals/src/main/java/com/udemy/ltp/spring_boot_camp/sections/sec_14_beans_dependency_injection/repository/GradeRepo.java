// GradeRepo is in the data access layer that performs CRUD operations & communicates directly with the db
package com.udemy.ltp.spring_boot_camp.sections.sec_14_beans_dependency_injection.repository;

import com.udemy.ltp.spring_boot_camp.sections.sec_14_beans_dependency_injection.model.Grade;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// @Component
@Repository
public class GradeRepo {
	private List<Grade> grades = new ArrayList<>();

	// in CRUD, this is the R part (Retrieve)
	public Grade getGrade(int index) {
		return grades.get(index);
	}

	// in CRUD, this is the R part (Retrieve all data)
	public List<Grade> getGrades() {
		return grades;
	}

	// in CRUD, this is the C part (Create)
	public void addGrade(Grade newGrade) {
		grades.add(newGrade);
	}

	// in CRUD, this is the U part (Update)
	public void updateGrade(int index, Grade currentGrade) {
		grades.set(index, currentGrade);
	}
}
