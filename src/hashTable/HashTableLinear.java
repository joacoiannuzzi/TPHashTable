package hashTable;

public class HashTableLinear<T extends Hashable> {

    private T[] table;
    private int size;

    public HashTableLinear(int size) {
        this.size = size;
        table = (T[]) new Object[size];
    }

    public void insert(T t){
        int k = t.hash(size); // hash the key
        // until empty cell or -1,
        while (table[k] != null && table[k].hash(size) != -1) {
            k++;
            k %= size;
        }
        table[k] = t; // insert item
    }

    public T delete(T t) {
        int k = t.hash(size);
        while (table[k] != null) {
            if (table[k].equals(t)) {
                T temp = table[k]; // save item
                table[k] = (T) (Hashable) M -> -1; // delete item
                return temp;
            }
            k++; // go to next cell
            k %= size; // wraparound if necessary
        }
        return null; // can't search item
    }

    public T search(T t) {
        int k = t.hash(size); // hash the key
        while (table[k] != null) {
            if (table[k].equals(t))
                return table[k]; // found, return item
            k++; // go to next cell
            k %= size; // wraparound if necessary
        }
        return null; // can't search item
    }

    public boolean exists(T t) {
        int k = t.hash(size); // hash the key
        while (table[k] != null) {
            if (table[k].equals(t))
                return true; // found, return item
            k++; // go to next cell
            k %= size; // wraparound if necessary
        }
        return false; // can't search item
    }
}