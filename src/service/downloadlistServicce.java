package service;

import pojo.downloadlist;

import java.util.List;

public interface downloadlistServicce {
    public List<downloadlist> querylist();
    public downloadlist querforone(int id);
}
