package hashTable;

import hashTable.GeneralList;

public interface List<L> extends GeneralList {
    void insertNext(L obj);
    void insertPrev(L obj);
}
