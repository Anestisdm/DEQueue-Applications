import javax.swing.*;
import java.awt.*;

public class DNAPalindrome {
    public static void main(String[] args) {
        ImageIcon icon1 = new ImageIcon("src/images/dna.png");
        Image image1 = icon1.getImage().getScaledInstance(40, 40, 0);
        ImageIcon icon2 = new ImageIcon("src/images/true.png");
        Image image2 = icon2.getImage().getScaledInstance(40, 40, 0);
        ImageIcon icon3 = new ImageIcon("src/images/false.png");
        Image image3 = icon3.getImage().getScaledInstance(40, 40, 0);
        ImageIcon icon4 = new ImageIcon("src/images/warning.png");
        Image image4 = icon4.getImage().getScaledInstance(40, 40, 0);
        String input = (String) JOptionPane.showInputDialog(null, "Enter the sequence of DNA:", "DNA palindrome", JOptionPane.QUESTION_MESSAGE, new ImageIcon(image1), null, null);
        StringDoubleEndedQueueImpl<String> list = new StringDoubleEndedQueueImpl<>();
        boolean val1 = true;
        if (input != null) {
            for (int i = input.length() - 1; i >= 0; i--) {
                char ch = input.charAt(i);
                if (ch == 'A' || ch == 'T' || ch == 'C' || ch == 'G') {
                    list.addFirst(Character.toString(ch));
                } else {
                    val1 = false;
                    break;
                }
            }
            if (val1 == false) {
                JOptionPane.showMessageDialog(null, "Wrong input of the sequence of DNA", "Error", JOptionPane.WARNING_MESSAGE, new ImageIcon(image4));
            } else {
                boolean val2 = true;
                String c;
                if (list.size() % 2 == 0) {
                    while (list.size() > 0) {
                        String n = list.removeFirst();
                        if (n.equals("A")) {
                            c = "T";
                        } else if (n.equals("T")) {
                            c = "A";
                        } else if (n.equals("C")) {
                            c = "G";
                        } else {
                            c = "C";
                        }
                        if (!(c.equals(list.removeLast()))) {
                            val2 = false;
                            break;
                        }

                    }
                } else {
                    val2 = false;
                }
                if (val2 == true) {
                    JOptionPane.showMessageDialog(null, "The sequence of DNA is Watson-Crick complemented palindrome ", "Message", JOptionPane.WARNING_MESSAGE, new ImageIcon(image2));
                } else {
                    JOptionPane.showMessageDialog(null, "The sequence of DNA is not Watson-Crick complemented palindrome ", "Message", JOptionPane.WARNING_MESSAGE, new ImageIcon(image3));
                }

            }
        }
    }
}
