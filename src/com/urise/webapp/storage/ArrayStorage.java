package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {


    @Override
    protected void fillDeletedElement(int ind) {
        storage[ind] = storage[currentSize - 1];
    }

    @Override
    protected void insertElement(Resume r, int ind) {
        storage[currentSize] = r;
    }


    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < currentSize; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
