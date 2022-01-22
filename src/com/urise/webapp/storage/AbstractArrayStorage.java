package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected int currentSize = 0;
    protected static final int MAX_SIZE = 10000;
    protected final Resume[] storage = new Resume[MAX_SIZE];

    public int size() {
        return currentSize;
    }

    public void clear() {
        for (int i = 0; i < currentSize; i++) {
            storage[i] = null;
        }
        currentSize = 0;
    }

    public void update(Resume r) {
        int ind = getSearchKey(r.getUuid());
        if (ind < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            storage[ind] = r;
        }
    }

    @Override
    protected void doUpdate(Resume r, Object index) {
        storage[(Integer) index] = r;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, currentSize);
    }


    @Override
    protected void doSave(Resume r, Object index) {
        if (currentSize == MAX_SIZE) {
            throw new StorageException("ERROR: Storage overflow!", r.getUuid());
        } else {
            insertElement(r, (Integer) index);
            currentSize++;
        }
    }


    @Override
    protected void doDelete(Object index) {
        fillDeletedElement((Integer) index);
        storage[(Integer) index] = storage[currentSize - 1];
        storage[currentSize - 1] = null;
        currentSize--;
    }


    @Override
    protected Resume doGet(Object index) {
        return storage[(Integer) index];
    }


    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
    }

    protected abstract void fillDeletedElement(int ind);

    protected abstract void insertElement(Resume r, int ind);

    protected abstract Integer getSearchKey(String uuid);
}
