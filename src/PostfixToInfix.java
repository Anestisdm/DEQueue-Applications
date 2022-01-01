import javax.swing.*;
import java.awt.*;

public class PostfixToInfix {

	public static void main(String[] args) {
		ImageIcon icon1 = new ImageIcon("src/images/mathematics.png");
		Image image1 = icon1.getImage().getScaledInstance(40, 40, 0);
		ImageIcon icon2 = new ImageIcon("src/images/warning.png");
		Image image2 = icon2.getImage().getScaledInstance(40, 40, 0);
		String input = (String) JOptionPane.showInputDialog(null, "Enter the mathematical expression in postfix form:", "Postfix to Infix", JOptionPane.QUESTION_MESSAGE, new ImageIcon(image1), null, null);
		StringDoubleEndedQueueImpl<String> list = new StringDoubleEndedQueueImpl<>();
		boolean val = false;
		if (input != null) {
			char s = input.charAt(0);
			char f = input.charAt(input.length() - 1);
			if (('0' <= s && s <= '9') && ((f == '+') || (f == '-') || (f == '*') || (f == '/'))) {
				val = true;
				for (int i = 0; i < input.length(); i++) {
					char c = input.charAt(i);
					if ((c == '+') || (c == '-') || (c == '*') || (c == '/')) {
						list.addLast(list.removeFirst());
						list.addFirst("(" + list.removeFirst() + c + list.removeLast() + ")");
					} else if (('0' <= c && c <= '9')) {
						list.addFirst(Character.toString(c));
					} else {
						val = false;
						break;
					}
				}
			}
			if (val == false) {
				System.out.println("Wrong input of the form of mathematical expression");
				JOptionPane.showMessageDialog(null, "Wrong input of the form of mathematical expression", "Error", JOptionPane.WARNING_MESSAGE, new ImageIcon(image2));

			} else {
				JOptionPane.showMessageDialog(null, "The mathematical expression in Infix form is:\n"+list.getFirst(), "Message", JOptionPane.WARNING_MESSAGE, new ImageIcon(image1));
			}
		}
	}

}
