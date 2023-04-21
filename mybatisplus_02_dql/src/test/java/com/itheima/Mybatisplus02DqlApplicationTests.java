package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.domain.query.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Mybatisplus02DqlApplicationTests {

    @Autowired
    private UserDao userDao;
    @Test
    void testGetAll() {
        //方式一：按条件查询
        /*QueryWrapper qw = new QueryWrapper();
        qw.lt("age",18);
        List<User> userList = userDao.selectList(qw);
        System.out.println(userList);*/

        //方式二：lambda格式按条件查询
        /*QueryWrapper<User> qw = new QueryWrapper<User>();
        qw.lambda().lt(User::getAge,13);
        List<User> userList = userDao.selectList(qw);
        System.out.println(userList);*/

        //方式三：lambda格式按条件查询
        /*LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.lt(User::getAge,13);
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);*/

        //LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        //小于30大于12
        /*lqw.lt(User::getAge,30);
        lqw.gt(User::getAge,12);
        lqw.lt(User::getAge,30).gt(User::getAge,12);*/

        //小于14或者大于30
        /*lqw.lt(User::getAge,14).or().gt(User::getAge,30);
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);*/

        /*UserQuery uq = new UserQuery();
        uq.setAge(13);
        uq.setAge2(30);
        //lqw.lt(User::getAge,uq.getAge2()).gt(User::getAge,uq.getAge());
        lqw.lt(null!=uq.getAge2(),User::getAge,uq.getAge2());
        lqw.gt(null!=uq.getAge(),User::getAge,uq.getAge());
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);*/

        //查询投影
        //lqw.select(User::getId,User::getName,User::getAge);
        /*QueryWrapper<User> qw = new QueryWrapper<User>();
        qw.select("count(*) as count, tel");
        qw.groupBy("tel");
        List<Map<String, Object>> userlist2 = userDao.selectMaps(qw);
        *//*qw.select("id", "name", "age");
        List<User> userlist = userDao.selectList(qw);*//*
        System.out.println(userlist2);*/

        //条件查询
        /*LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.eq(User::getName,"heima").eq(User::getAge, 12);
        User loginUser = userDao.selectOne(lqw);
        System.out.println(loginUser);*/

        //范围查询 lt:<, le:<=, gt:>, ge:>=, eq, between
        /*LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.between(User::getAge, 10, 14);
        List<User> userlist3 = userDao.selectList(lqw);
        System.out.println(userlist3);*/

        //模糊匹配
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        //lqw.like(User::getName,"ei");
        lqw.likeRight(User::getName,"hei");
        List<User> userlist4 = userDao.selectList(lqw);
        System.out.println(userlist4);
    }

}
