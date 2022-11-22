// GradeService is in the service layer that manages business logic & lies between presentation & data access
package com.udemy.ltp.spring_boot_camp.sections.sec_12_3_layer_codebase.service;

import com.udemy.ltp.spring_boot_camp.sections.sec_12_3_layer_codebase.Constants;
import com.udemy.ltp.spring_boot_camp.sections.sec_12_3_layer_codebase.model.Grade;
import com.udemy.ltp.spring_boot_camp.sections.sec_12_3_layer_codebase.repository.GradeRepo;

import java.util.List;

public class GradeService {
	GradeRepo gradeRepo = new GradeRepo();

	public Grade getGrade(int index) {
		return gradeRepo.getGrade(index);
	}

	public List<Grade> getGrades() {
		return gradeRepo.getGrades();
	}

	public void addGrade(Grade newGrade) {
		gradeRepo.addGrade(newGrade);
	}

	public void updateGrade(int index, Grade currentGrade) {
		gradeRepo.updateGrade(index, currentGrade);
	}

	public int getGradeIndexById(String id) {
		for(int i = 0; i < getGrades().size(); i++) {
			if(getGrades().get(i).getId().equalsIgnoreCase(id)) {
				return i;
			}
		}

		// index not found
		return Constants.NOT_FOUND;
	}

	public Grade getGradeById(String id) {
		int index = getGradeIndexById(id);

		return index != Constants.NOT_FOUND ? getGrade(index) : new Grade();
	}

	public void submitGrade(Grade grade) {
		int index = getGradeIndexById(grade.getId());

		if(index == Constants.NOT_FOUND) {
			addGrade(grade);
		}else {
			updateGrade(index, grade);
		}
	}
}
