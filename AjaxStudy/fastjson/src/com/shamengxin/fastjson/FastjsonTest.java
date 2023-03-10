package com.shamengxin.fastjson;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试阿里巴巴的fastjson的使用
 */
public class FastjsonTest {
    public static void main(String[] args) {
        //创建一个USer类型的对象
        User user = new User("111","zhangsan",20);

        //将以上的User对象转换json格式的字符串
        //使用阿里巴巴的fastjson组件中的JSON类即可
        //fastjson中有一个类，叫做：JSON。全部大写
        //JSON类中的方法都是静态方法，直接调用即可。
        String jsonStr = JSON.toJSONString(user);

        System.out.println(jsonStr);

        //尝试List集合是否可以转换成数组
        List<User> userList=new ArrayList<>();
        User user1=new User("120","lisi",30);
        User user2=new User("130","jackson",33);

        userList.add(user1);
        userList.add(user2);

        String jsonStr2 = JSON.toJSONString(userList);

        System.out.println(jsonStr2);
    }
}
