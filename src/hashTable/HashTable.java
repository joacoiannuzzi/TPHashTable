package hashTable;

import java.util.LinkedList;

public class  HashTable<T extends Hashable & Comparable<T> & Printeable> {

    private LinkedList<T>[] list;
    private int capacity;

    public HashTable(int capacity) {
        if (!PrimeNumber.isPrime(capacity))
            capacity = PrimeNumber.nextPrime(capacity);
        this.capacity = capacity;
        list = new LinkedList[capacity];
        for(int i = 0; i < capacity ; i++)
            list[i] = new LinkedList<>();
    }

    public boolean exists(T x){
        int k = x.hash(capacity);
        //list[k].goTo(0);
        for (int i = 0 ; i < list[k].size() ; i ++ ) {
            if (x.compareTo(list[k].get(i)) == 0)
                return true;
            //list[k].goNext();
        }
        return false;
    }

    public void insert(T x) {
        int k = x.hash(capacity);
        list[k].add(x);
    }

    public T search(T x) {
        int k = x.hash(capacity);
        //list[k].goTo(0);
        for (int i = 0 ; i < list[k].size() ; i ++ )  {
            if (x.compareTo(list[k].get(i)) == 0)
                return list[k].get(i);
            //list[k].goNext();
        }
        return x;
    }

    public SearchBinaryTree getSearchBinaryTree () {
        SearchBinaryTree a = new SearchBinaryTree<>();
        for (int i = 0; i < capacity; i++ ) {
            if (!list[i].isEmpty())  {
                //list[i].goTo(0);
                for (int j = 0; j < list[i].size(); j++)   {
                    a.insert(list[i].get(i));
                    //list[i].goNext();
                    j++;
                }
            }
        }
        return a;
    }

    public LinkedList<T> getList(T x) {
        int k = x.hash(capacity);
        return list[k];
    }

    public LinkedList<T>[] getLists() {
        return list;
    }

    public int getCapacity() {
        return capacity;
    }

    public void print() {
        for (int i = 0; i < list.length; i++) {
            //list[i].goTo(1);
            System.out.println("In "+ i +": ");
            for (int j = 0; j < list[i].size(); j++) {
                list[i].get(j).print();
                try {
                    //list[i].goNext();
                }
                catch (IndexOutOfBoundsException ignored) {}
            }
        }
    }
}