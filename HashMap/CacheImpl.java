
public class CacheImpl<K, V> implements Cache<K, V>{

        private final int capacity;
        private int count;
        private HashNode head, tail;
        long lookUps;
        long hits;
        long misses;
        HashMap hashtable;


        public CacheImpl(int capacity)
        {

            this.capacity = capacity;
            hashtable = new HashMap<K>(capacity);
            head = new HashNode(null,null);
            tail = new HashNode(null,null);
            head.setLRUListNext(tail);
            tail.setLRUListPrev(head);
            head.setLRUListPrev(null);
            tail.setLRUListNext(null);
            count = 0;
            lookUps=0;
            hits = 0;
            misses=0;
        }

        public void deleteNode(HashNode node)
        {
            node.LRUListPrev.LRUListNext = node.LRUListNext;
            node.LRUListNext.LRUListPrev = node.LRUListPrev;
        }

        public void addToHead(HashNode node)
        {
            node.LRUListNext = head.LRUListNext;
            node.LRUListNext.LRUListPrev = node;
            node.LRUListPrev = head;
            head.LRUListNext = node;
        }

        @Override
        public V lookUp(K key)
        {
            lookUps++;
            if (hashtable.contains(key)) {
                HashNode node = hashtable.get(key);
                V result = (V) node.getData();
                deleteNode(node);
                addToHead(node);
                hits++;
                return result;
            }
            misses++;
            return null;
        }

        @Override
        public void store(K key, V value) throws EmptyListException {
            if (hashtable.contains(key) == false) {
                HashNode node = new HashNode(key, value);
                hashtable.add(node);
                if (count < capacity) {
                    count++;
                    addToHead(node);
                }
                else {
                    hashtable.remove(tail.LRUListPrev.getKey());
                    deleteNode(tail.LRUListPrev);
                    addToHead(node);
                }
            }
        }

        public double getHitRatio(){
            return (double)hits/lookUps;
        }

        public long getHits(){
            return hits;
        }

        public long getMisses(){
            return misses;
        }

        public long getNumberOfLookUps(){
            return lookUps;
        }


}

