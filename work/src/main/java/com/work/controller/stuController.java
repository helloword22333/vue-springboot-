package com.work.controller;

import com.work.pojo.Result;

import com.work.pojo.pageBean;
import com.work.pojo.stu;
import com.work.service.imp.StuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/stu")
public class stuController {
    @Autowired
    private StuServiceImp stuServiceImp;
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Integer deptId,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime end){
        pageBean pageBean =  stuServiceImp.page(page,pageSize,name,deptId,begin,end);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        stuServiceImp.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody stu stu){
        stuServiceImp.add(stu);
        return Result.success();
    }
    @GetMapping("/{id}")
    public  Result getById(@PathVariable int id){
        stu stu_1 = stuServiceImp.getById(id);
        return Result.success(stu_1);
    }
    @PutMapping
    public Result update(@RequestBody stu stu){
        stuServiceImp.update(stu);
        return Result.success();
    }
}
