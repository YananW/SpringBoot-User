package com.mly.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mly.mapper.UserMapper;
import com.mly.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserConrtroller {

    @Autowired
    private UserMapper userMapper;

    //添加页面
    @RequestMapping("add")
    public String addUser(){
        return "add";
    }

    //查询（用于查询）
    @RequestMapping("getUser")
    public String getUser(int id, Model model) throws Exception{
        User user = userMapper.getUser(id);
        model.addAttribute("user",user);
        return "userShow";
    }

    //添加
    @RequestMapping("addUser")
    public String listUser(User user, BindingResult bindingResult) throws Exception{
            userMapper.addUser(user);
            return "redirect:listUser";
    }

    //删除
    @RequestMapping("deleteUser")
    public String deleteUser(User user) throws Exception{
        userMapper.del(user.getId());
        return "redirect:listUser";

    }

    //修改
    @RequestMapping("updateUser")
    public String updateUser(User user) throws Exception{
        boolean flag = userMapper.update(user)>0;
        return "redirect:listUser";

    }

    //查询(用于修改)
    @RequestMapping("findUser")
    public String findUser(int id,Model model) throws Exception{
        User user =userMapper.getUser(id);
        model.addAttribute("user",user);
        return "modify";
    }

    @RequestMapping({"/","listUser"})
    public String listUser(@RequestParam(value = "name",defaultValue = "") String name, Model model,
                           @RequestParam(value = "start",defaultValue = "1") int start,
                           @RequestParam(value = "size",defaultValue = "2") int size) throws Exception {
        PageHelper.startPage(start,size,"ide asc");
       List<User> userList = userMapper.getUserList(name);
        PageInfo<User> pageInfo =new PageInfo<User>(userList);
        model.addAttribute("pages",pageInfo);
        model.addAttribute("name",name);

        return "index";

    }


}
