package com.urise.webapp.storage;

import com.urise.webapp.resume.Resume;

import java.util.Objects;

public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        storage = null;
        size = 0;
    }

    public void save(Resume r) {
        storage[size] = r;
        size++;
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
        Resume[] cResume = new Resume[10000];
        for (int i = 0; i < size; i++) {
            if (!Objects.equals(storage[i].getUuid(), uuid))
                cResume[i] = storage[i];
        }
        storage = cResume;
        size--;
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
}
