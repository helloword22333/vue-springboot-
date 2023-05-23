package com.work.service.imp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.work.mapper.stuMapper;
import com.work.pojo.pageBean;
import com.work.pojo.stu;
import com.work.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class StuServiceImp implements StuService {
    @Autowired
    private stuMapper stuMapper;

    @Override
    public pageBean page(Integer page , Integer pageSize, String name, Integer deptId, LocalDateTime begin, LocalDateTime end) {
        PageHelper.startPage(page,pageSize);
        List<stu> empList = stuMapper.list(name, deptId,begin, end);
        Page<stu> p = (Page<stu>) empList;
        pageBean pagebean = new pageBean(p.getTotal(),p.getResult());
        return pagebean;
    }

    @Override
    public void delete(List<Integer> ids) {
        stuMapper.delete(ids);
    }

    @Override
    public void add(stu stu) {
        stu.setCreateTime(LocalDateTime.now());
        stu.setUpdateTime(LocalDateTime.now());
        stuMapper.add(stu);
    }

    @Override
    public stu getById(int id) {
        stu stu_ = stuMapper.getById(id);
        return stu_;
    }

    @Override
    public void update(stu stu) {
        stu.setUpdateTime(LocalDateTime.now());
        //stuMapper.update(stu);
    }
}
