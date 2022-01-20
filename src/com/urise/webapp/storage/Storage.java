package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public interface Storage {

    int size();

    void clear();

    void update(Resume r);

    Resume[] getAll();

    void save(Resume r);

    void delete(String uuid);

    Resume get(String uuid);
}
