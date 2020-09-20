package service.impl;

import dao.downloadlistdao;
import dao.impl.downloadlistdaoimpl;
import pojo.downloadlist;
import service.downloadlistServicce;

import java.util.List;

public class downloadlistServiceimpl implements downloadlistServicce {
    private downloadlistdao dao=new downloadlistdaoimpl();
    @Override

    public List<downloadlist> querylist() {
        return dao.query();
    }

    @Override
    public downloadlist querforone( int id) {
        return  dao.queryone(id);
    }
}
