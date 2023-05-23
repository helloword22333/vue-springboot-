package com.work.mapper;

import com.work.pojo.classBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface ClassMapper {
    @Select("select * from banji")
    public List<classBean> list();

    @Delete("delete from banji where id = #{id}")
    public void delete(Integer id);

    @Insert("insert into banji (name,create_time,update_time) values (#{name},#{createTime},#{updateTime})")
    public void add(classBean classBean);
}
