package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission;

import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Course;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Student;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.repository.CourseRepository;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class GradeSubmissionApp implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public void run(String... args) throws Exception {
		Student[] students = new Student[] {
			new Student("Maynard Keenan", LocalDate.parse("1964-04-17")),
			new Student("Adam Jones", LocalDate.parse("1965-01-15")),
			new Student("Dan Carey", LocalDate.parse("1961-05-10")),
			new Student("Paul D'Amour", LocalDate.parse("1967-05-17")),
			new Student("Justin Chancellor", LocalDate.parse("1971-11-19"))
		};

		studentRepository.saveAll(Arrays.asList(students));

		Course[] courses = new Course[] {
			new Course("Opiate", "EP", "Censorship & organized religion."),
			new Course("Undertow", "ALBUM_1", "Imposing waves of misery & dread."),
			new Course("Aenima", "ALBUM_2", "Another Dead Hero."),
			new Course("Lateralus", "ALBUM_3", "Spiral Out."),
			new Course("10000 Days", "ALBUM_4", "The orbital period of the planet Saturn."),
			new Course("Fear Inoculum", "ALBUM_5", "Se7en.")
		};

		courseRepository.saveAll(Arrays.asList(courses));
	}

	public static void main(String[] args) {
		SpringApplication.run(GradeSubmissionApp.class, args);
	}
}
