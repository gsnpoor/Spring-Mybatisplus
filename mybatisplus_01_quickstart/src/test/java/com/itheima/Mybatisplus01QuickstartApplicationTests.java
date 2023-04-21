package com.itheima;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisplus01QuickstartApplicationTests {
	@Autowired
	private UserDao userDao;

	@Test
	void testSave(){
		User user = new User();
		user.setName("heima");
		user.setPassword("heimah");
		user.setAge(16);
		user.setTel("111111111");
		userDao.insert(user);
	}

	@Test
	void testDelete(){
		userDao.deleteById(1649299319675265025L);
	}

	@Test
	void testUpdate(){
		User user = new User();
		user.setId(1L);
		user.setName("heima");
		user.setPassword("itheima2");
		userDao.updateById(user);

	}

	@Test
	void testGetById(){
		User user = userDao.selectById(1L);
		System.out.println(user);
	}
	@Test
	void testGetAll(){
		List<User> userlist = userDao.selectList(null);
		System.out.println(userlist);
	}

	@Test
	void testGetByPage(){
		IPage page = new Page(2,2);
		userDao.selectPage(page,null);
		System.out.println("当前页码值"+page.getCurrent());
		System.out.println("每页显示数"+page.getSize());
		System.out.println("一共多少页"+page.getPages());
		System.out.println("一共多少条数据"+page.getTotal());
		System.out.println("数据"+page.getRecords());
	}

}
