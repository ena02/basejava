package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage{
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
        int ind = getIndex(r.getUuid());
        if (ind < 0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            storage[ind] = r;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, currentSize);
    }

    public void save(Resume r) {
        int ind = getIndex(r.getUuid());
        if (ind >= 0) {
            throw new ExistStorageException(r.getUuid());
        } else if (currentSize == storage.length) {
            throw new StorageException("ERROR: Storage overflow!", r.getUuid());
        } else {
            insertElement(r, ind);
            currentSize++;
        }
    }

    public void delete(String uuid) {
        int ind = getIndex(uuid);
        if (ind < 0) {
            throw new NotExistStorageException(uuid);
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
            throw new NotExistStorageException(uuid);
        }
        return storage[ind];
    }


    protected abstract void fillDeletedElement(int ind);

    protected abstract void insertElement(Resume r, int ind);

    protected abstract int getIndex(String uuid);
}
