package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {
    protected final ArrayList<Resume> storage = new ArrayList<>();

    public int size() {
        return storage.size();
    }

    public void clear() {
        storage.clear();
    }

    public void update(Resume r) {
        if (storage.contains(r)) {
            int ind = getIndex(r.getUuid());
            storage.set(ind, r);
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    public void save(Resume r) {
        if (storage.contains(r)) {
            throw new ExistStorageException(r.getUuid());
        } else {
            storage.add(r);
        }
    }

    public void delete(String uuid) {
        int ind = getIndex(uuid);
        if (ind < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            storage.remove(ind);
        }
    }

    public Resume get(String uuid) {
        int ind = getIndex(uuid);
        if (ind < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage.get(ind);
    }

    protected int getIndex(String uuid) {
        int ind = -1;
        for (int i = 0; i < storage.size(); i++) {
            if (uuid.equals(storage.get(i).getUuid())) {
                ind = i;
            }
        }
        return ind;
    }
}
