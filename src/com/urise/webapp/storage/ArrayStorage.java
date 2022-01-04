package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Objects;

public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        storage = null;
        size = 0;
    }

    public void update(Resume r) {
        if (isPresent(r.getUuid())) {
            for (int i = 0; i < size; i++) {
                if (storage.equals(r.getUuid())) {
                    storage[i] = r;
                }
            }
        } else {
            System.out.println("Storage don't have same resume!");
        }
    }

    public void save(Resume r) {
        if (!isPresent(r.getUuid())) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("This resume already exist in storage!");
        }

    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(storage[i].getUuid(), uuid)) {
                return storage[i];
            }
        }

        return null;
    }

    public void delete(String uuid) {
        if (isPresent(uuid)) {
            for (int i = 0; i < size; i++) {
                if (storage.equals(uuid)) {
                    storage[i] = storage[size - 1];
                    storage[size - 1] = null;
                }
            }

            size--;
        } else {
            System.out.println("Storage don't have same resume!");
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] resume = new Resume[size];
        for (int i = 0; i < size; i++) {
            resume[i] = storage[i];
        }
        return resume;
    }

    public int size() {
        return size;
    }

    public boolean isPresent(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage.equals(uuid)) {
                return true;
            }
        }
        return false;
    }
}
