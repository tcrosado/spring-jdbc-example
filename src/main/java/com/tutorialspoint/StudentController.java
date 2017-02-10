package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by trosado on 2/10/17.
 */
@RestController
public class StudentController {

    ApplicationContext context =
            new ClassPathXmlApplicationContext("Beans.xml");

    StudentJDBCTemplate studentJDBCTemplate =
            (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");

    @RequestMapping("/list")
    public List<Student> listStudents(){
        return studentJDBCTemplate.listStudents();
    }
    @RequestMapping("/create")
    public void createStudent(@RequestParam(value="name") String name,@RequestParam(value="age") Integer age){
        studentJDBCTemplate.create(name,age);
    }
}
