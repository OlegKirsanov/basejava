import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int position = 0;

    void clear() {
        for(int index = 0; index < position; index++){
            storage[index] = null;
        }
        position = 0;
    }

    void save(Resume r) {
        storage[position++] = r;
    }

    Resume get(String uuid) {
        for(int index = 0; index < position; index++){
            if(storage[index].uuid.equals(uuid)){
                return storage[index];
            }
        }
//        Resume notFound = new Resume();
//        notFound.uuid = "Resume not found!";
        return null;
    }

    private int indexOf(String uuid) {
        int indexFound = -1;
        for(int index = 0; index < position; index++) {
            if (storage[index].uuid.equals(uuid)) {
                indexFound = index;
                break;
            }
        }
        return indexFound;
    }

    void delete(String uuid) {
        int index = indexOf(uuid);
        int size = position - index - 1;
        System.arraycopy(storage, index + 1, storage, index, size);
        storage[position--] = null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        return position;
    }
}
