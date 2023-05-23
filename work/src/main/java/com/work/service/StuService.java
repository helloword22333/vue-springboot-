package com.work.service;

import java.time.LocalDateTime;
import java.util.List;

import com.work.pojo.pageBean;
import com.work.pojo.stu;

import java.util.List;

public interface StuService {
    public pageBean page(Integer page , Integer pageSize, String name, Integer deptId, LocalDateTime begin, LocalDateTime end);

    public void delete(List<Integer> ids);

    public void add(stu stu);

    public stu getById(int id);

    public void update(stu stu);
}
