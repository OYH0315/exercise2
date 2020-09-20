package dao;

import pojo.downloadlist;

import java.util.List;

public interface downloadlistdao {
    public List<downloadlist> query();
    public downloadlist queryone(int id);
}
