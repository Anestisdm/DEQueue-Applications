import java.util.Scanner;

public class PostfixToInfix {

	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("\n" + "Enter the mathematical expression in postfix form:");
		String input = scanner.next(); 
		StringDoubleEndedQueueImpl<String> list = new StringDoubleEndedQueueImpl<>();
		boolean val=false;
		char s=input.charAt(0);
		char f=input.charAt(input.length()-1);
		if (('0' <= s && s <= '9') && ((f=='+')||(f=='-')||(f=='*')||(f=='/'))) {
			val=true;
			for (int i=0; i<input.length();i++) {
				char c=input.charAt(i);
				if((c=='+')||(c=='-')||(c=='*')||(c=='/')) {
					list.addLast(list.removeFirst());
					list.addFirst("("+list.removeFirst() + c + list.removeLast()+")");
				}
				else if (('0' <= c && c <= '9')) {
					list.addFirst(Character.toString(c));
				}
				else {
					val=false;
					break;
				}
			}
		}
		if (val==false) {
			System.out.println("Wrong input of the form of mathematical expression");
		}
		else {
			System.out.println(list.getFirst());
		}
		scanner.close();	
	}

}
