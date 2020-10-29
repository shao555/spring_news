package com.cs.test;

import com.cs.entity.News;
import com.cs.entity.TopTitle;
import com.cs.entity.UserInfo;
import com.cs.service.NewsService;
import com.cs.service.TopTitleService;
import com.cs.service.UserInfoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SMtest {

    ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
    NewsService ns = (NewsService) act.getBean("service");
    UserInfoService us = (UserInfoService) act.getBean("service1");
    TopTitleService ts = (TopTitleService) act.getBean("service2");

    //查询新闻表所有记录
    @Test
    public void findAllNews() throws Exception {
        List<News> list = ns.findAllNews();
        for (News n : list) {
            System.out.println(
                    n.getNewsID() + " " + n.getNewTitle() + " " + n.getNewsContent()
                            + " " + n.getSendDate() + " " + n.getUserID() + " " + n.getTopID()
            );
        }
    }

    //查询标题表所有记录
    @Test
    public void findAllTopTitle() throws Exception {
        List<TopTitle> list = ts.findAllTopTitle();
        for (TopTitle t : list) {
            System.out.println(
                    t.getTopID() + " " + t.getTopTitle() + " " + t.getSendDate()
                            + " " + t.getUserID()
            );
        }
    }

    //查询用户表所有记录
    @Test
    public void findAllUserInfo() throws Exception {
        List<UserInfo> list = us.findAllUserInfo();
        for (UserInfo u : list) {
            System.out.println(
                    u.getUserID() + " " + u.getUserName() + " " + u.getUserPass()
                            + " " + u.getSex() + " " + u.getAge() + " " + u.getEmail()
            );
        }
    }

    //查询新闻表所有信息的总记录数
    @Test
    public void findByNewsCount() throws Exception {
        int i = ns.findByNewsCount();
        System.out.println("总记录数: " + i);
    }

    //添加新闻
    @Test
    public void addNews() throws Exception {
        News news = new News();
        news.setNewTitle("新闻标题5");
        news.setNewsContent("新闻内容5");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date time = format.parse("2020-10-28");
        news.setSendDate(time);
        news.setUserID(5);
        news.setTopID(5);
        int i = ns.addNews(news);
        if (i > 0) {
            System.out.println("添加成功!");
        } else {
            System.out.println("添加失败!");
        }
    }

    //修改新闻
    @Test
    public void updateNews() throws Exception {
        News news = new News();
        news.setNewTitle("新的新闻标题1");
        news.setNewsContent("新的新闻内容1");
        news.setNewsID(1);
        int i = ns.updateNews(news);
        if (i > 0) {
            System.out.println("修改成功!");
        } else {
            System.out.println("修改失败!");
        }
    }

    //删除新闻
    @Test
    public void deleteNews() throws Exception {
        int i = ns.deleteNews(4);
        if (i > 0) {
            System.out.println("删除成功!");
        } else {
            System.out.println("删除失败!");
        }
    }



    //根据ID查询用户发布了那些标题
    @Test
    public void findUserInfoByID() throws Exception {
        UserInfo userInfo = us.findUserInfoByID(1);
        System.out.println(userInfo.getUserName());
        for (TopTitle t : userInfo.getTopTitleList()) {
            System.out.println(t.getTopTitle());
        }

    }


    //添加用户
    @Test
    public void addUser() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("淑慧阿姨");
        userInfo.setUserPass("121212");
        userInfo.setSex("女");
        userInfo.setAge(40);
        userInfo.setEmail("373636@email.com");
        int i = us.addUser(userInfo);
        if (i > 0) {
            System.out.println("添加成功!");
        } else {
            System.out.println("添加失败!");
        }
    }



}
