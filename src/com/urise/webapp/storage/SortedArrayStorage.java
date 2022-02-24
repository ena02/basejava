package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    /*private static class ResumeComparator implements Comparator<Resume> {
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    }

    private static final ResumeComparator RESUME_COMPARATOR = new ResumeComparator();*/

    private static final Comparator<Resume> RESUME_COMPARATOR = (o1, o2) -> o1.getUuid().compareTo(o2.getUuid());


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
        Resume searchKey = new Resume(uuid, "dummy");
        return Arrays.binarySearch(storage, 0, currentSize, searchKey, RESUME_COMPARATOR);
    }


}
