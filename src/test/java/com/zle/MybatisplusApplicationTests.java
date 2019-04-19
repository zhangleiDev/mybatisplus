package com.zle;

import com.google.common.base.Strings;
import com.zle.dao.UserDao;
import com.zle.entity.User;
import com.zle.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisplusApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;



    /**
     * if test 使用自定义方法判断
     */
    @Test
    public void testSelect4() {
        User user = new User();
        user.setName("");
        List<User> userList = userDao.testSelect4(user);

        userList.forEach(System.out::println);

    }


    /**
     * bind标签demo:
     *
     * */
    @Test
    public void testSelect3() {
        User user = new User();
        user.setName("ha");

        List<User> userList = userDao.testSelect3(user);

        userList.forEach(System.out::println);
    }

    /**
     *foreach 迭代map集合
     */
    @Test
    public void testSelect2() {
        Map<String,Object> param = new HashMap<>();
        param.put("name","haha1");
        param.put("age",10);

        List<User> userList = userDao.testSelect2(param);

        userList.forEach(System.out::println);

    }
    /**
     *foreach 迭代List集合
     */
    @Test
    public void testBatchInsert(){
        Strings.isNullOrEmpty("");
        User user = new User();
        user.setAge(10);
        user.setEmail("fw@r23.cn");
        user.setName("haha");
        User user2 = new User();
        user2.setAge(10);
        user2.setEmail("fw@r23.cn");
        user2.setName("haha");
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user2);

        System.out.println(userDao.batchInsert(users));
        System.out.println(users);

    }
    @Test
    public void testQueryId2(){

        System.out.println(userDao.queryId2(1));

    }
    @Test
    public void testInsert3(){

        User user = new User();
        user.setAge(10);
        user.setEmail("fw@r23.cn");
        user.setName("haha1");
        System.out.println(userDao.insert3(user));

    }
    @Test
    public void testInsert2(){

        User user = new User();
        user.setAge(10);
        user.setEmail("fw@r23.cn");
        user.setName("haha");
        System.out.println(userDao.insert2(user));

    }
    @Test
    public void testQueryAll2(){
        System.out.println(userDao.queryId(1));
       System.out.println(userDao.queryAll2());
    }

    @Test
    public void testQueryId(){

        System.out.println(userDao.queryId(1));
    }

    /**
     * sql session中获取执行对象2
     */
    @Test
    public void testSession2(){
        userService.testSession2();
        System.out.println("Session2 end");
    }
    /**
     * sql session中获取执行对象1
     */
    @Test
    public void testSession(){
        userService.testSession();
        System.out.println("end");
    }

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userDao.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
    @Test
    public void testSelectAll() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userDao.queryAll();
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    /**
     * 获取新增主键方式1
     */
    @Test
    public void insertWithGeneratedKeys(){
        User user = new User();
        user.setAge(10);
        user.setEmail("fw@r23.cn");
        user.setName("haha");
        userDao.insertWithGeneratedKeys(user);
        //userDao.insert(user);
        System.out.println("id is" + user.getId());
    }
    /**
     * 获取新增主键方式2
     */
    @Test
    public void insertWithSelectKey(){
        User user = new User();
        user.setAge(10);
        user.setEmail("fw@r23.cn");
        user.setName("haha");
        userDao.insertWithSelectKey(user);
        //userDao.insert(user);
        System.out.println("id is" + user.getId());
    }

}

