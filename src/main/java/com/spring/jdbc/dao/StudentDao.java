/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Student;
import java.util.List;

/**
 *
 * @author dell
 */
public interface StudentDao {
    public int insert(Student student);
    public int change(Student student);
    public int delete(int studentID);
    public Student getStudent(int studentId);
    public List<Student> getAllStudent();
}
