package com.cs.servlet;

import com.cs.entity.TopTitle;
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

@WebServlet(name = "TopTitleServlet",urlPatterns = "/TopTitleServlet")
public class TopTitleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
        NewsService ns = (NewsService) act.getBean("service");
        UserInfoService us = (UserInfoService) act.getBean("service1");
        TopTitleService ts = (TopTitleService) act.getBean("service2");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String comm = request.getParameter("comm");
        System.out.println(comm);
        if (comm.equals("title")) {
            try {
                List<TopTitle> list = ts.findAllTopTitle();
                if (list != null) {
                    request.setAttribute("list",list);
                    request.getRequestDispatcher("title.jsp").forward(request,response);
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
