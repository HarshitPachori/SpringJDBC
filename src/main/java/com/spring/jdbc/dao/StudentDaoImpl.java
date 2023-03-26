/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.jdbc.dao;

import com.spring.jdbc.entities.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 *
 * @author dell
 */
@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Student student) {
        // insert query
        String query = "insert into student (id,name,city) values(?,?,?)";
        int res = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return res;
    }

    @Override
    public int change(Student student) {
        // updating data
        String query = "update student set name=?, city=? where id=?";
        int res = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return res;
    }

    @Override
    public int delete(int studentID) {
        // delete query
        String query = "delete from student where id=?";
        int res = this.jdbcTemplate.update(query, studentID);
        return res;
    }

    @Override
    public Student getStudent(int studentId) {
        // selecting or reading singlw user data
        String query = "select * from student where id=?";
        RowMapper<Student> rowMapper = new RowMapperImpl(); // rowmapperimpl use kiya hai qki rowmapper ek interface hai
        Student student = this.jdbcTemplate.queryForObject(query, rowMapper, studentId); // for single row selection
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        // selecting more than one row
        String query = "select * from student";
        List<Student> student = this.jdbcTemplate.query(query, new RowMapperImpl()); // for multiple row selection
        return student;

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate JdbcTemplate) {
        this.jdbcTemplate = JdbcTemplate;
    }

}
