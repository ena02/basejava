package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Objects;

public class ArrayStorage {
    private int currentSize = 0;
    private int maxSize = 10000;
    private Resume[] storage = new Resume[maxSize];


    public void clear() {
        storage = null;
        currentSize = 0;
    }

    public void update(Resume r) {
        if (isPresent(r.getUuid())) {
            for (int i = 0; i < currentSize; i++) {
                if (storage.equals(r.getUuid())) {
                    storage[i] = r;
                }
            }
        } else {
            System.out.println("ERROR: Storage don't have same resume!");
        }
    }

    public void save(Resume r) {
        if (!isPresent(r.getUuid())) {
            if (currentSize < maxSize) {
                storage[currentSize] = r;
                currentSize++;
            } else {
                System.out.println("ERROR: Storage overflow!");
            }

        } else {
            System.out.println("ERROR: This resume already exist in storage!");
        }

    }

    public Resume get(String uuid) {
        for (int i = 0; i < currentSize; i++) {
            if (Objects.equals(storage[i].getUuid(), uuid)) {
                return storage[i];
            }
        }

        return null;
    }

    public void delete(String uuid) {
        if (isPresent(uuid)) {
            for (int i = 0; i < currentSize; i++) {
                if (storage.equals(uuid)) {
                    storage[i] = storage[currentSize - 1];
                    storage[currentSize - 1] = null;
                }
            }

            currentSize--;
        } else {
            System.out.println("ERROR: Storage don't have same resume!");
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] resume = new Resume[currentSize];
        for (int i = 0; i < currentSize; i++) {
            resume[i] = storage[i];
        }
        return resume;
    }

    public int size() {
        return currentSize;
    }

    public boolean isPresent(String uuid) {
        for (int i = 0; i < currentSize; i++) {
            if (storage[i].getUuid() == uuid) {
                return true;
            }
        }
        return false;
    }
}
