package test;

import com.veitch.dao.UserDao;
import com.veitch.dao.impl.UserDaoImpl;
import com.veitch.pojo.User;
import com.veitch.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
    @org.junit.Test
    public void  testSelectAll(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDaoImpl userDao = (UserDaoImpl) applicationContext.getBean("userDaoImpl");

        System.out.println(userDao.selectAll());

    }

    @org.junit.Test
    public void  testLogin(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDaoImpl userDao = (UserDaoImpl) applicationContext.getBean("userDaoImpl");

        User user = new User();

        user.setName("aaa");
        user.setPassword("111");

        user = userDao.login(user);
        System.out.println(user.getId()+"-"+user.getName()+"-"+user.getPassword());

    }

    @org.junit.Test
    public void  testInsert(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDaoImpl userDao = (UserDaoImpl) applicationContext.getBean("userDaoImpl");

        UserServiceImpl userService = (UserServiceImpl)applicationContext.getBean("userServiceImpl");

        User user = new User();

        user.setName("fuck");
        user.setPassword("1111");

        int i = userService.insertUser(user);
        System.out.println(i);

    }

    @org.junit.Test
    public void  testDelete(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        UserDaoImpl userDao = (UserDaoImpl) applicationContext.getBean("userDaoImpl");


        int i = userDao.deleteById("10");
        System.out.println(i);

    }
}
