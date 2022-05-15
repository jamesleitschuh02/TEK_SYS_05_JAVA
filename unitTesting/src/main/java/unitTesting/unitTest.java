package unitTesting;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.StudentService;

public class unitTest {
	
	@ParameterizedTest
	@CsvSource({"aiannitti7@is.gd, TWP4hf5j",
				"cjaulme9@bing.com, FnVklVgC6r6",
				"cstartin3@flickr.com, XYHzJ1S",
				"hguerre5@deviantart.com, OzcxzD1PGs",
				"hluckham0@google.ru, X1uZcoIh0dj",
				"htaffley6@columbia.edu, xowtOQ",
				"ljiroudek8@sitemeter.com, bXRoLUP",
				"qllorens2@howstuffworks.com, W6rJuxd",
				"sbowden1@yellowbook.com, SJc4aWSU",
				"tattwool4@biglobe.ne.jp, Hjt0SoVmuBz"
	})
	public void testValidateStudent(String email, String password) {
		StudentService student = new StudentService();
		
		boolean expectedStudent = student.validateStudent(email, password);
		
		Assertions.assertTrue(expectedStudent);
	}

}
