package com.knight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppInit {

	public static void main(String[] args) {
		SpringApplication.run(AppInit.class, args);
//		AbstractApplicationContext  context = new AnnotationConfigApplicationContext(AppInit.class);
//        
//        //Byname Autowiring
//		Marks marks = (Marks)context.getBean("marks");
//		marks.setMarks("100");
//		System.out.println(marks.hashCode());
//		marks.setMarks("10");
//		System.out.println(marks.hashCode());
//        Student st = (Student)context.getBean("student");
//        System.out.println("Student Details : "+st);
	}

}
