package testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jpa.entitymodels.Student;
import jpa.service.StudentService;

class StudentServiceTest {

	@Test
		 public void testGetStudentByEmail() {
			StudentService student = new StudentService();
			Student expectedStudent = new Student();
			
			expectedStudent.setsEmail("htaffley6@columbia.edu");
			expectedStudent.setsName("Holmes Taffley");
			expectedStudent.setsPass("xowtOQ");
			
			Student testStudent = student.getStudentByEmail("htaffley6@columbia.edu");
			
			Assertions.assertEquals(expectedStudent, testStudent);
	}

}