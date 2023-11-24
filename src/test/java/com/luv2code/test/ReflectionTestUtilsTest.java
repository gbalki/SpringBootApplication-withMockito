package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.util.ReflectionTestUtils;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;



@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class ReflectionTestUtilsTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

    @BeforeEach
    public void studentBeforeEach(){
        studentOne.setFirstname("Serhat");
        studentOne.setLastname("Balki");
        studentOne.setEmailAddress("serhatbalki97@gmail.com");
        studentOne.setStudentGrades(studentGrades);

      ReflectionTestUtils.setField(studentOne,"id",1);
      ReflectionTestUtils.setField(studentOne,"studentGrades",new StudentGrades(new ArrayList<>(Arrays.asList(100.0,85.0,76.50,91.75))));
    }

    @Test
    public void getPrivateField(){
        assertEquals(1,ReflectionTestUtils.getField(studentOne,"id"));
    }

    @Test
    public void invokePrivateMethod(){
        assertEquals("Serhat 1",ReflectionTestUtils.invokeMethod(studentOne,"getFirstNameAndId"),"Fail private method not call");
    }

}
