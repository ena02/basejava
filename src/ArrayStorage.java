import java.util.Objects;

/**
 * Array based storage for Resumes
 */
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
        for (Resume resume : storage) {
            if (resume == null) {
                break;
            }

            if (Objects.equals(resume.getUuid(), uuid))
                return resume;
        }
        return null;
    }

    public void delete(String uuid) {
        Resume[] cResume = new Resume[10000];
        int ind = 0;
        for (Resume resume : storage) {
            if (resume == null) {
                break;
            }
            if (!Objects.equals(resume.getUuid(), uuid)) {
                cResume[ind] = resume;
                ind++;
            }
        }
        storage = cResume;
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] resume = new Resume[size];
        int ind = 0;
        for (Resume r : storage) {
            if (r != null) {
                resume[ind] = r;
                ind++;
            }
        }
        return resume;
    }

    public int size() {
        return size;
    }
}
