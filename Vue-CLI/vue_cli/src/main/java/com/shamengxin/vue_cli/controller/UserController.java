package com.shamengxin.vue_cli.controller;

import com.shamengxin.vue_cli.entity.User;
import com.shamengxin.vue_cli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlElementRef;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 更新用户
     */

    @PostMapping("update")
    public Map<String,Object> update(@RequestBody User user){
        HashMap<String ,Object> map = new HashMap<>();
        try {
            userService.update(user);
            map.put("success",true);
            map.put("msg","更新用户信息成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","更新用户失败："+e.getMessage());
        }
        return map;
    }

    /**
     * 查一个
     */
    @GetMapping("findOne")
    public User findOne(String id){
        return userService.findById(id);
    }


    /**
     * 删除用户信息
     */
    @GetMapping("delete")
    public Map<String,Object> delete(String id){
        HashMap<String ,Object> map = new HashMap<>();
        try {
            userService.delete(id);
            map.put("success",true);
            map.put("msg","删除用户信息成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","删除用户失败："+e.getMessage());
        }
        return map;
    }

    /**
     * 添加用户
     */
    @PostMapping("add")
    public Map<String,Object> add(@RequestBody User user){
        HashMap<String, Object> map = new HashMap<>();
        try {
            userService.save(user);
            map.put("success",true);
            map.put("msg","添加用户信息成功");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",false);
            map.put("msg","添加用户失败："+e.getMessage());
        }
        return map;
    }

    /**
     * 查询所有
     */
    @GetMapping("findAll")
    public Map<String,Object> findAll(Integer page,Integer rows){
        Map<String,Object> map = new HashMap<>();
        List<User> results = userService.findAll();
        map.put("total",10);
        map.put("totalPage",1);
        map.put("page",page);
        map.put("results",results);
        return map;
    }

}
