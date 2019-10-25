package com.mly.mapper;
import com.mly.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where CONCAT(mobname,nickname,username,phone) like CONCAT('%',{name},'%')")
    public List<User> getUserList(String name);

    @Insert("insert into user (id,mobname,username,nickname,phone,register,password) "+
    "valus (#{id},#{mobname},#{username},#{nickname},#{phone},#{register},#{password})")
    public Integer addUser(User user);

    @Delete("delete from user where id=#{id} ")
    public void del(int id);

    @Select("select * from user where id=#{id}")
    public User getUser(int id);

    @Update("update user set "+
    "mobname = #{mobname},username = #{username},nickname = #{nickname},phone = #{phone},register = #{register},password = #{password}"+
    "where id = #{id}")
    public int update(User user);
}
