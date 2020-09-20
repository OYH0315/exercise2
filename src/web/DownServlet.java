package web;

import org.apache.commons.io.IOUtils;
import pojo.downloadlist;
import service.downloadlistServicce;
import service.impl.downloadlistServiceimpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class DownServlet extends BaseServlet {
    private downloadlistServicce service=new downloadlistServiceimpl();
    protected void showpage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("654566454646545664654");
         downloadlistServicce service=new downloadlistServiceimpl();
        List<downloadlist> list=service.querylist();
        request.setAttribute("list",list);//将数据存放在request域中，请求转发到显示页面显示数据
        request.getRequestDispatcher("/pages/client/down.jsp").forward(request,response);

    }
    protected void downpicture(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//实现下载
         downloadlistServicce service=new downloadlistServiceimpl();
    String strid=request.getParameter("id");
        System.out.println(strid);
    int id=Integer.parseInt(strid);
    downloadlist d=service.querforone(id);
    String filename="/"+d.getPath();
    ServletContext servletContext=request.getServletContext();
    String minetype=servletContext.getMimeType(filename);
        System.out.println(minetype);
response.setContentType(minetype);
response.setHeader("Content-Disposition","attachment;filename="+d.getName()+".jpg");
        InputStream inputStream=servletContext.getResourceAsStream(filename);
        OutputStream outputStream=response.getOutputStream();
        IOUtils.copy(inputStream,outputStream);
    }
}
