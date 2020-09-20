package dao.impl;

import dao.downloadlistdao;
import pojo.downloadlist;

import java.util.List;

public class downloadlistdaoimpl extends basedao implements downloadlistdao{
    @Override
    public List<downloadlist> query() {
        String sql="select * from t_downloadlist";
        return queryfolist(downloadlist.class,sql);
    }

    @Override
    public downloadlist queryone(int id) {
        String sql="select * from t_downloadlist where id=?";
        return  queryforone(downloadlist.class,sql,id);
    }
}
