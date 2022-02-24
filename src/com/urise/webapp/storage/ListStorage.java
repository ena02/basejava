package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;


public class ListStorage extends AbstractStorage<Integer> {
    protected List<Resume> list = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        int ind = -1;
        for (int i = 0; i < list.size(); i++) {
            if (uuid.equals(list.get(i).getUuid())) {
                return i;
            }
        }
        return ind;
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey != -1;
    }


    @Override
    protected void doUpdate(Resume r, Integer searchKey) {
        list.set(searchKey, r);
    }


    @Override
    protected void doSave(Resume r, Integer searchKey) {
        list.add(r);
    }


    @Override
    protected Resume doGet(Integer searchKey) {
        return list.get(searchKey);
    }


    @Override
    protected void doDelete(Integer searchKey) {
        list.remove((searchKey).intValue());
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        return list;
    }

    @Override
    public int size() {
        return list.size();
    }




}
