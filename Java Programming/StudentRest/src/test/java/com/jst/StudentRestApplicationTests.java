package com.jst;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.jst.entity.StudentEntity;
import com.jst.repository.StudentRepository;
import com.jst.service.StudentService;

@SpringBootTest
public class StudentRestApplicationTests {

	@Mock
	private StudentRepository studentRepo;
	
	@InjectMocks
	private StudentService studentService;
	
	@Test
	void createStudent() {
		StudentEntity student = new StudentEntity();
		student.setName("shan");
		student.setMobile("9840142282");
		student.setEmail("eakshan@gmail.com");
		student.setLocation("Bangalore");
		studentService.addStudent(student);
	}
	
	@Test
	void getAllStudent() {
		assertThat(studentService.getAllStudent());
	}

}
