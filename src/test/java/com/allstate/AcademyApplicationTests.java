package com.allstate;

import com.allstate.services.CourseServiceTest;
import com.allstate.services.StudentServiceTest;
import com.allstate.services.TeacherService;
import com.allstate.services.TeacherServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@SpringBootTest
@Suite.SuiteClasses({
		StudentServiceTest.class,
		CourseServiceTest.class,
		TeacherServiceTest.class
})

public class AcademyApplicationTests {

	@Test
	public void contextLoads() {
	}

}
