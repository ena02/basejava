package com.urise.webapp.storage;

import com.sun.org.apache.regexp.internal.RE;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;


public class ListStorage extends AbstractStorage {
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
    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey != -1;
    }


    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        list.set((int) searchKey, r);
    }


    @Override
    protected void doSave(Resume r, Object searchKey) {
        list.add(r);
    }


    @Override
    protected Resume doGet(Object searchKey) {
        return list.get((Integer) searchKey);
    }


    @Override
    protected void doDelete(Object searchKey) {
        list.remove(((Integer) searchKey).intValue());
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[list.size()]);
    }

    @Override
    public int size() {
        return list.size();
    }


}
