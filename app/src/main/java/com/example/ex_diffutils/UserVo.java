package com.example.ex_diffutils;

import java.util.ArrayList;

public class UserVo {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<UserVo> getTestList(int size) {
        ArrayList<UserVo> itemList = new ArrayList<>();
        UserVo item;
        for(int i = 0; i < size; i++) {
            item = new UserVo();
            item.setId(i);
            item.setName("name " + i);
            itemList.add(item);
        }
        return itemList;
    }
}
