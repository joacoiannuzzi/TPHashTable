public interface HashTableOpenHashing<T> {

    void insert(T x);
    T search(T x);
    SearchBinaryTree<T> getSearchBinaryTree();

}
