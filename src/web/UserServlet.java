package web;

import pojo.user;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

import service.codeservice;
import service.impl.userserviceimpl;
import service.userservice;
import utils.webutils;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        user user=webutils.copyparamtobean(request.getParameterMap(), new user());
        userservice userservice=new userserviceimpl();
        System.out.println(user.toString());
        String code1= request.getParameter("code");
        String code= (String) request.getSession().getAttribute("vcode");
        String msg=null;
        if(code.equalsIgnoreCase(code1))
        {
            if(userservice.checkuser(user.getUsername()))
            {

               request.getSession().setAttribute("user",user);
                System.out.println("登陆成功");
                request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
            }
            else {
                msg="账号或者密码错误";
                request.setAttribute("msg",msg);
                request.setAttribute("username",user.getUsername());//存放在request域中数据回显
           request.getRequestDispatcher("/pages/user/login_fail.jsp").forward(request,response);
            }
        }
    else{
        msg="验证码错误";
            request.setAttribute("msg",msg);
            request.setAttribute("username",user.getUsername());
            request.getRequestDispatcher("/pages/user/login_fail.jsp").forward(request,response);
        }
    }
    protected void createcode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        codeservice codeservice=new codeservice();
        String code=codeservice.createCode();
        request.getSession().setAttribute("vcode",code);
        response.setContentType("img/jpeg");
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);
        BufferedImage image=codeservice.createimg(code);
        ServletOutputStream out=response.getOutputStream();
        ImageIO.write(image,"JPEG",out);
        System.out.println("458453416574896451564");
        out.flush();
        out.close();

    }
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException//安全退出
    {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath());
    }
    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userservice userservice=new userserviceimpl();
//        String username= request.getParameter("username");
//        String password= request.getParameter("password");
//        String email= request.getParameter("email");
        String code1= request.getParameter("code");
        String code= (String) request.getSession().getAttribute("vcode");
        user us1=  webutils.copyparamtobean(request.getParameterMap(),new user());
        if(code!=null&&code1.equalsIgnoreCase(code))
        {
            if(userservice.checkuser(us1.getUsername()))
            {
                System.out.println("用户名存在");
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            }
            else {
                userservice.registuser(us1);
            }
            request.getSession().setAttribute("user",us1);
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }
        else {
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            System.out.println("验证码错误");
        }
    }
}
