package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    /*private static final Comparator<Resume> RESUME_COMPARATOR = ((o1, o2) -> o1.getUuid().compareTo(o2.getUuid()));*/

    @Override
    protected void fillDeletedElement(int ind) {
        int numMoved = currentSize - ind - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, ind + 1, storage, ind, numMoved);
        }
    }

    @Override
    protected void insertElement(Resume r, int ind) {
        int insertInd = -ind - 1;
        System.arraycopy(storage, insertInd, storage, insertInd + 1, currentSize - insertInd);
        storage[insertInd] = r;
    }


    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, currentSize, searchKey);
    }
}
