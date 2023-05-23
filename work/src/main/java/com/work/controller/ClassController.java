package com.work.controller;

import com.work.pojo.Result;
import com.work.pojo.classBean;
import com.work.service.ClassService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping
    public Result list(){
        List<classBean> classBeanList = classService.list();
        return Result.success(classBeanList);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable  Integer id){
        classService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody classBean classBean){
        classService.add(classBean);
        return Result.success();
    }
}
