public class List<T, V>  {

    private HashNode head = null;
    private HashNode tail = null;


    public List() {

    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtFront(HashNode n) {

        if (isEmpty()) {
            head = n;
            tail = n;
        } else {
            n.setHashTableNext(head);
            head = n;
        }
    }



    public V removeFromFront() throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException();

        V data = (V) head.getData();

        if (head == tail)
            head = tail = null;
        else
            head = head.getHashTableNext();

        return (V) data;
    }

    public V removeFromBack() throws EmptyListException {
        if (isEmpty())
            throw new EmptyListException();

        V data = (V) tail.getData();

        if (head == tail)
            head = tail = null;
        else {
            HashNode iterator = head;
            while (iterator.getHashTableNext() != tail)
                iterator = iterator.getHashTableNext();

            iterator.setHashTableNext(null);
            tail = iterator;
        }

        return data;
    }

    public boolean contains(T key) {

        if (this.isEmpty() == true) {
            return false;
        }

        HashNode cursor = this.head;
        boolean found = false;

        while(cursor != null && found == false ) {

            if(cursor.getKey().equals(key)) {
                found = true;
            }
            else {
                cursor = cursor.getHashTableNext();
            }
        }

        return found;
    }

    public HashNode getNode (T key){
        HashNode cursor = this.head;
        HashNode found = null;

        while(cursor != null && found == null ) {

            if(cursor.getKey().equals(key)) {
                found = cursor;
            }
            else {
                cursor = cursor.getHashTableNext();
            }
        }

        return found;
    }

    public boolean remove(T key) throws EmptyListException {

        if(this.isEmpty() == true) {

            return false;
        }

        HashNode cursor = this.head;
        HashNode previous = null;

        while(cursor != null) {

            if(cursor.getKey().equals(key)) {
                break;
            }

            previous = cursor;
            cursor = cursor.getHashTableNext();
        }

        if(cursor == null) {
            return false;
        }

        if(cursor == this.head) {
            this.removeFromFront();
        }
        else if(cursor == this.tail) {
            this.removeFromBack();
        }
        else {
            previous.HashTableNext = cursor.HashTableNext;
        }

        return true;
    }
}