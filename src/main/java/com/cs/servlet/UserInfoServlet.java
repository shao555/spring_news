package com.cs.servlet;

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
import java.util.List;

@WebServlet(name = "UserInfoServlet",urlPatterns = "/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        NewsService ns = (NewsService) act.getBean("service");
        UserInfoService us = (UserInfoService) act.getBean("service1");
        TopTitleService ts = (TopTitleService) act.getBean("service2");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String comm = request.getParameter("comm");
        if (comm.equals("user")) {
            try {
                List<UserInfo> list = us.findAllUserInfo();
                if (list != null) {
                    request.setAttribute("list",list);
                    request.getRequestDispatcher("user.jsp").forward(request,response);
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
