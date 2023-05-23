package com.work.service;

import com.work.pojo.classBean;

import java.util.List;

public interface ClassService {
    public List<classBean> list();

    public void delete(Integer id);

    public void add(classBean classBean);
}
