
public class HashMap<K> {

    private List[] array;

    public HashMap(int arraySize) {
        int arrayLength= (arraySize>=5? arraySize/5 : 5 );
        this.array = new List[arrayLength];
    }


    public boolean add(HashNode node) {

        int hash = node.getKey().hashCode();
        int address = hash % this.array.length;
        List chain = this.array[address];

        if (chain == null) {
            chain = new List();
            this.array[address] = chain;
        }

        if (chain.contains(node.getKey()) == false) {
            chain.insertAtFront(node);
            return true;
        }
        return false;
    }

    public boolean remove(K key) throws EmptyListException {

        int hash = (key).hashCode();
        int address = hash % this.array.length;
        List chain = this.array[address];

        if (chain == null) {
            return false;
        }

        boolean removed = chain.remove(key);

        return removed;
    }

    public boolean contains(K key) {

        int hash = (key).hashCode();
        int address = hash % this.array.length;
        List chain = this.array[address];

        if (chain == null) {
            return false;
        }

        return chain.contains(key);
    }

    public HashNode get (K key){

        int hash = (key).hashCode();
        int address = hash % this.array.length;
        List chain = this.array[address];

        if (chain == null) {
            return null;
        }

        return chain.getNode(key);
    }

}


