package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
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
    protected void doUpdate(Resume r, Integer index) {
        storage[index] = r;
    }

    public List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, currentSize));
    }


    @Override
    protected void doSave(Resume r, Integer index) {
        if (currentSize == MAX_SIZE) {
            throw new StorageException("ERROR: Storage overflow!", r.getUuid());
        } else {
            insertElement(r, index);
            currentSize++;
        }
    }


    @Override
    protected void doDelete(Integer index) {
        fillDeletedElement(index);
        storage[index] = storage[currentSize - 1];
        storage[currentSize - 1] = null;
        currentSize--;
    }


    @Override
    protected Resume doGet(Integer index) {
        return storage[index];
    }


    @Override
    protected boolean isExist(Integer index) {
        return index >= 0;
    }

    protected abstract void fillDeletedElement(int ind);

    protected abstract void insertElement(Resume r, int ind);

    protected abstract Integer getSearchKey(String uuid);
}
