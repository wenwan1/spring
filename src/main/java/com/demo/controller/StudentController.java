package com.demo.controller;

import com.demo.entity.Student;
import com.demo.repository.StudentRepository;
import com.demo.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    private static final Logger logger= LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentRepository studentRepository;
    @RequestMapping("/student/getStudentInfoById")
    public Result getStudents(Integer id){
        try{
            Student one = studentRepository.getOne(id);
            return new Result(one,true,"查询学生信息成功");
        }catch (Exception e){
            logger.error("StudentController[getStudents] error",e);
            return new Result(false,"查询学生信息失败");
        }
    }

    @RequestMapping("/student/findAll")
    public Result findAll(){
        try{
            List<Student> all = studentRepository.findAll();
            return new Result(all,true,"查询成功");
        }catch (Exception e){
            logger.error("StudentController[findAll] error",e);
            return new Result(false,"查询失败");
        }

    }

}
