package com.iitb;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import org.springframework.test.annotation.Rollback;

import com.iitb.beans.Course;
import com.iitb.repository.CourseRepository;





@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CourseRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired	
	private CourseRepository courseRepository;
	
	@Test
	public void testCreateSupplier() {
		Course course = new Course("Java Full Web Development","Java Develper","Completed","dfasdf","adsfdfs");	
		Course savedcourse = courseRepository.save(course);
		System.out.println("Task Created Successfully "+course);
		assertThat(savedcourse.getCourse_id()).isGreaterThan(0);

	}
	

	@Test
	public void testListAllSupplier() {
		Iterable<Course> listcourse = courseRepository.findAll();
		System.out.println("List has found successfully");
		listcourse.forEach(course -> System.out.println(course));
	}
	/*
	@Test
	public void testGetSupplierById() {
		Course course = courseRepository.findById((long) 5).get();
		System.out.println(course);
		assertThat(course).isNotNull();
	}
	
	@Test
	public void testUpdateSupplierDetails() {
		Course course = courseRepository.findById((long) 5).get();
		course.setCourse_title("Compuer Science and Engineering");
		course.setCourse_code("CSE20204");
		course.setDescription("Computer Science");	
		course.setYear("2024");
		course.setSemester("1st");
		System.out.println("Updated Successfully");
		System.out.println(courseRepository.save(course));

	}
	*/
	
	@Test
	public void testDeleteSupplier() {
		Long courseId = (long) 6;
		courseRepository.deleteById(courseId);
		System.out.println("Deleted Successfully");

		
	}
	


}
