package web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public  abstract  class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        request.setCharacterEncoding("UTF-8");
        try {
            Method method=this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            try {
                method.invoke(this,request,response);
            } catch (IllegalAccessException e) {
                //e.printStackTrace();
            } catch (InvocationTargetException e) {
                //e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            //e.printStackTrace();
        }
        System.out.println("base被调用");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
