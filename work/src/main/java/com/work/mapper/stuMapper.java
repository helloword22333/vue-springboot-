package com.work.mapper;

import com.work.pojo.stu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;
@Mapper
public interface stuMapper {

    public List<stu> list(String name, Integer deptId, LocalDateTime begin, LocalDateTime end);

    public void delete(List<Integer> ids);


    @Insert("insert into stu(username,name,gender,image,job,entrydate,dept_id,create_time,update_time) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void add(stu stu);

    @Select("select * from  stu where id = #{id}")
    public stu getById(int id);

    //public void update(stu stu);
}
