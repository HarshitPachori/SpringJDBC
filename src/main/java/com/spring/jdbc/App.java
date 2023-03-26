package com.spring.jdbc;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println("My program started.....");
        // Spring jdbc => jdbcTemplate
        // for xml cofiguration
        //  ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        // for annotation configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);

        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        // for inserting
//        Student student = new Student();
//        student.setId(666);
//        student.setName("Madhur rawat");
//        student.setCity("Agra");
//
//        int res = studentDao.insert(student);
//        System.out.println("student added : " + res);
// for updating
//        Student student = new Student();
//        student.setId(666);
//        student.setName("Raj kumar");
//        student.setCity("Lucknow");
//        int res = studentDao.change(student);
//        System.out.println("updated records : " + res);
// for delete 
//        int res = studentDao.delete(666);
////        System.out.println("deleted records ... " + res);
//// for selecting single line data
//        Student stud = studentDao.getStudent(25);
//        System.out.println(stud);
//for multiple row selection
        List<Student> students = studentDao.getAllStudent();
        for (Student s : students) {
            System.out.println(s);
        }
    }
}
