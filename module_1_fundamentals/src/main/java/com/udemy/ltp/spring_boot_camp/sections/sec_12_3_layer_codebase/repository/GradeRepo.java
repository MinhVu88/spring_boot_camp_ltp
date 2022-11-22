// GradeRepo is in the data access layer that performs CRUD operations & communicates directly with the db
package com.udemy.ltp.spring_boot_camp.sections.sec_12_3_layer_codebase.repository;

import com.udemy.ltp.spring_boot_camp.sections.sec_12_3_layer_codebase.model.Grade;

import java.util.ArrayList;
import java.util.List;

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
