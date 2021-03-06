import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringDoubleEndedQueueImpl <T> implements StringDoubleEndedQueue <T>{
	private Node<T> last; //Ψευδοκόμβος τέλους
	private Node<T> head; //Ψευδοκόμβος αρχής
	private int count=0;
	
	
	public StringDoubleEndedQueueImpl() {
		this.last = new Node<T>(null); 
		this.head = new Node<T>(null);
		head.setNext(last);
		last.setPrev(head);
	}

		@Override
		public boolean isEmpty() {
			return head.getNext()==last;
		}
		
		@Override
		public void addFirst(T item) {
			Node<T> x = new Node<T>(item);
			x.setNext(head.getNext());
			head.getNext().setPrev(x);
			head.setNext(x);
			x.setPrev(head);
			count++;
		}
		
		@Override
		public T removeFirst() throws NoSuchElementException{
			if (isEmpty()==true) {
				throw new NoSuchElementException();
			}
			T result=head.getNext().getItem();
			head.getNext().getNext().setPrev(head);
			head.setNext(head.getNext().getNext());
			count--;
			return result;
		}
		
		@Override
		public void addLast(T item) {
			Node<T> x = new Node<T>(item);
			x.setPrev(last.getPrev());
			last.getPrev().setNext(x);
			last.setPrev(x);
			x.setNext(last);
			count++;
		}
		
		@Override
		public T removeLast() throws NoSuchElementException{
			if (isEmpty()==true) {
				throw new NoSuchElementException();
			}
			T result=last.getPrev().getItem();
			last.getPrev().getPrev().setNext(last);
			last.setPrev(last.getPrev().getPrev());
			count--;
			return result;
		}
		
		@Override
		public T getFirst() throws NoSuchElementException{
			if (isEmpty()==true) {
				throw new NoSuchElementException();
			}
			return head.getNext().getItem();
		}
		
		@Override
		public T getLast() throws NoSuchElementException{
			if (isEmpty()==true) {
				throw new NoSuchElementException();
			}
			return last.getPrev().getItem();
		}
		
		@Override
		public void printQueue(PrintStream stream) {
			Node<T> t=head.getNext();
			while(t.getNext()!=null) {
				stream.println(t.getItem());
				t=t.getNext();
			}
		}
		
		@Override
		public int size() {
			return count;
		}
		
}
