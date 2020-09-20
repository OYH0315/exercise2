package test;

import org.junit.Test;
import pojo.downloadlist;
import service.downloadlistServicce;
import service.impl.downloadlistServiceimpl;

import java.util.List;

import static org.junit.Assert.*;

public class downloadlistServiceimplTest {
private downloadlistServicce service =new downloadlistServiceimpl();
    @Test
    public void querylist() {
        List<downloadlist> list=service.querylist();
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).toString());
        }
    }
    @Test
    public void test2()
    {
        System.out.println(service.querforone(1).toString());
    }
}