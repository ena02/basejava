package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.List;

public interface Storage {

    int size();

    void clear();

    void update(Resume r);

    List<Resume> getAllSorted();

    void save(Resume r);

    void delete(String uuid);

    Resume get(String uuid);
}
