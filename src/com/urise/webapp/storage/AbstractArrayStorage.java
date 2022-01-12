package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage {
    protected int currentSize = 0;
    protected static final int MAX_SIZE = 10000;
    protected final Resume[] storage = new Resume[MAX_SIZE];

    public void clear() {
        for (int i = 0; i < currentSize; i++) {
            storage[i] = null;
        }
        currentSize = 0;
    }

    public void update(Resume r) {
        int ind = getIndex(r.getUuid());
        if (ind != -1) {
            System.out.println("ERROR: Resume " + r.getUuid() + " not exist in the storage!");
        } else {
            storage[ind] = r;
        }
    }


    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, currentSize);
    }

    public void save(Resume r) {
        int ind = getIndex(r.getUuid());
        if (ind > 0) {
            System.out.println("ERROR: Resume " + r.getUuid() + " already exist in the storage!");
        } else if (currentSize == storage.length) {
            System.out.println("ERROR: Storage overflow!");
        } else {
            insertElement(r, ind);
            currentSize++;
        }
    }

    public void delete(String uuid) {
        int ind = getIndex(uuid);
        if (ind < 0) {
            System.out.println("ERROR: Storage don't have resume " + uuid + " !");
        } else {
            fillDeletedElement(ind);
            storage[ind] = storage[currentSize - 1];
            storage[currentSize - 1] = null;
            currentSize--;
        }
    }

    public Resume get(String uuid) {
        int ind = getIndex(uuid);
        if (ind < 0) {
            System.out.println("ERROR: Resume " + uuid + " don't exist in the storage!");
            return null;
        }
        return storage[ind];
    }

    protected abstract void fillDeletedElement(int ind);

    protected abstract void insertElement(Resume r, int ind);

    public int size() {
        return currentSize;
    }

    protected abstract int getIndex(String uuid);
}
