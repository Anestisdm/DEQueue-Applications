public class HashNode<T,V> {

    protected T key;
    protected V data;
    protected HashNode HashTableNext = null;
    protected HashNode HastTablePrev = null;
    protected HashNode LRUListNext = null;
    protected HashNode LRUListPrev = null;

    HashNode(T key, V data) {
        this.key = key;
        this.data = data;
    }


    public V getData() {
        return data;
    }

    public T getKey() {
        return key;
    }

    public HashNode getHashTableNext() {
        return HashTableNext;
    }

    public HashNode getHastTablePrev() {
        return HastTablePrev;
    }

    public HashNode getLRUListNext() {
        return LRUListNext;
    }

    public HashNode getLRUListPrev() {
        return LRUListPrev;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setHashTableNext(HashNode hashTableNext) {
        HashTableNext = hashTableNext;
    }

    public void setHastTablePrev(HashNode hastTablePrev) {
        HastTablePrev = hastTablePrev;
    }

    public void setLRUListNext(HashNode LRUListNext) {
        this.LRUListNext = LRUListNext;
    }

    public void setLRUListPrev(HashNode LRUListPrev) {
        this.LRUListPrev = LRUListPrev;
    }
}


