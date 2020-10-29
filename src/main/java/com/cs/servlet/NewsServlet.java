package com.cs.servlet;

import com.cs.entity.News;
import com.cs.entity.TopTitle;
import com.cs.entity.UserInfo;
import com.cs.service.NewsService;
import com.cs.service.TopTitleService;
import com.cs.service.UserInfoService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "NewsServlet",urlPatterns = "/NewsServlet")
public class NewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        NewsService ns = (NewsService) act.getBean("service");
        UserInfoService us = (UserInfoService) act.getBean("service1");
        TopTitleService ts = (TopTitleService) act.getBean("service2");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String comm = request.getParameter("comm");
        if (comm.equals("news")) {
            try {
                List<News> list = ns.findAllNews();
                if (list != null) {
                    request.setAttribute("list", list);
                    request.getRequestDispatcher("news.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (comm.equals("show")) {
            String userID = request.getParameter("userID");
            int i = Integer.parseInt(userID);
            try {
                UserInfo userInfo = us.findUserInfoByID(i);
                if (userInfo != null) {
                    request.setAttribute("u",userInfo);
                    List<TopTitle> tlist = userInfo.getTopTitleList();
                    request.setAttribute("tlist",tlist);
                    request.getRequestDispatcher("show.jsp").forward(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (comm.equals("del")) {
            String newsID = request.getParameter("newsID");
            int id = Integer.parseInt(newsID);
            try {
                int i = ns.deleteNews(id);
                if (i > 0) {
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (comm.equals("提交")) {
            String newTitle = request.getParameter("newTitle");
            String newsContent = request.getParameter("newsContent");
            String userID = request.getParameter("userID");
            int uID = Integer.parseInt(userID);
            String topID = request.getParameter("topID");
            int tID = Integer.parseInt(topID);
            News news = new News();
            news.setNewTitle(newTitle);
            news.setNewsContent(newsContent);
            news.setUserID(uID);
            news.setTopID(tID);
            Date date = new Date();
            news.setSendDate(date);
            try {
                int i = ns.addNews(news);
                if (i > 0) {
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
