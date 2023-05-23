package com.work.service.imp;

import com.work.mapper.ClassMapper;
import com.work.pojo.classBean;
import com.work.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClassServiceImp implements ClassService {
    @Autowired
    private ClassMapper classMapper;
    @Override
    public List<classBean> list(){
        List<classBean> classBeanList = classMapper.list();
        return classBeanList;
    }

    @Override
    public void delete(Integer id) {
        classMapper.delete(id);
    }

    @Override
    public void add(classBean classBean) {
        classBean.setCreateTime(LocalDateTime.now());
        classBean.setUpdateTime(LocalDateTime.now());
        classMapper.add(classBean);
    }
}
