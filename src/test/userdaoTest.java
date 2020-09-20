package test;

import dao.impl.userdaoimpl;
import dao.userdao;
import org.junit.Test;

import static org.junit.Assert.*;

public class userdaoTest {
private userdao dao =new userdaoimpl();
    @Test
    public void queryuserbyusername() {
        System.out.println(dao.queryuserbyusername("admin").toString()
        );
    }

    @Test
    public void saveuser() {
    }

    @Test
    public void querybyusernameandpassword() {
    }
}