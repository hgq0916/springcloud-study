package com.bojue.restful.controller;

import com.bojue.restful.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @ApiOperation(value = "显示用户列表",notes = "加载系统中的所有用户信息",httpMethod = "GET")
    @RequestMapping(value = "/",method= RequestMethod.GET)
    public Collection<User> list(){
        return users.values();
    }

    @ApiOperation(value = "添加用户",notes = "添加用户到系统",httpMethod = "POST")
    @ApiImplicitParam(name="user",value = "用户实体对象",required = true,dataType = "User")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String add(@ModelAttribute User user){
        users.put(user.getId(),user);
        return "success";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable Long id){
        return users.get(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PATCH)
    public String update(@PathVariable Long id,@ModelAttribute User user){
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        return "success";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id){
        users.remove(id);
        return "success";
    }
}
