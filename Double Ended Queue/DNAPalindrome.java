import java.sql.SQLOutput;
import java.util.Scanner;

public class DNAPalindrome {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("\n" + "Enter the sequence of DNA:");
        String input = scanner.nextLine();
        StringDoubleEndedQueueImpl<String> list = new StringDoubleEndedQueueImpl<>();
        boolean val1 = true;
        for(int i=input.length()-1;i>=0;i--){
            char ch = input.charAt(i);
            if (ch=='A'||ch=='T'||ch=='C'||ch=='G'){
                list.addFirst(Character.toString(ch));
            }
            else{
                val1 = false;
                break;
            }
        }
        if (val1==false){
            System.out.println("Wrong input of the sequence of DNA");
        }
        else{
            boolean val2=true;
            String c;
            if (list.size()%2==0) {
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
            }
            else {
                val2 = false;
            }
            if (val2==true){
                System.out.println("The sequence of DNA is Watson-Crick complemented palindrome ");
            }
            else{
                System.out.println("The sequence of DNA is not Watson-Crick complemented palindrome ");
            }

        }
    }
}
