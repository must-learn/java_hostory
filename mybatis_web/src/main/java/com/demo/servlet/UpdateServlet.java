package com.demo.servlet;

import com.demo.dao.UsersDao;
import com.demo.entity.Users;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    /**
     *创建对应的日志记录对象
     * 通过不同的基本进行日志的记录【DEBUG/WARN/INFO/LOG】
     */
    private Logger log= Logger.getLogger(UpdateServlet.class);
    private UsersDao usersDao=new UsersDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        log.info("获取到查询参数id---"+id);
       Users user= usersDao.findById(Integer.parseInt(id));
        req.setAttribute("user",user);
        log.info("查询完成，查询到的数据--"+user);
        req.getRequestDispatcher("updateUser.jsp").forward(req,resp);
    }
}
