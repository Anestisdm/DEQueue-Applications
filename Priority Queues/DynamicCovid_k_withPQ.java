import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DynamicCovid_k_withPQ {
    public static void main (String[] args) {
        BufferedReader reader = null;
        File f = new File(args[0]);
        try {
            reader = new BufferedReader(new FileReader(f));
            String line;
            line = reader.readLine();
            int c = 0;
            while (line != null) {
                c++;
                line = reader.readLine();
            }
            if (c >= 1) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter the number of the cities:");
                int k = scanner.nextInt();
                PQ item = new PQ(k);
                if (k <= c) {
                    reader = new BufferedReader(new FileReader(f));
                    line = reader.readLine();
                    while (line != null) {
                        StringTokenizer st = new StringTokenizer(line, " ");
                        while (st.hasMoreTokens()) {
                            int Id = Integer.parseInt(st.nextToken());
                            if (Id < 1 || Id > 999) {
                                throw new IncorrectInputException("The Id " + Id + " is out of bounds");
                            }
                            String Name = st.nextToken();
                            if (Name.length() > 50) {
                                throw new IncorrectInputException("The Name of the City " + Name + " is out of bounds");
                            }
                            int Population = Integer.parseInt(st.nextToken());
                            if (Population < 0 || Population >= 10000000) {
                                throw new IncorrectInputException("The Population of " + Name + " is out of bounds");
                            }
                            int CovidCases = Integer.parseInt(st.nextToken());
                            if (CovidCases > Population) {
                                throw new IncorrectInputException("Covid cases of " + Name + " is greater than the population");
                            }
                            City town = new City(Id, Name, Population, CovidCases, "PQ");
                            if (item.size() < k) {
                                item.insert(town);
                            }
                            else {
                                if (town.compareTo(item.min()) > 0) {
                                    item.remove(item.min().getID());
                                    item.insert(town);
                                }
                            }
                        }
                        line = reader.readLine();
                    }
                    System.out.println("The top " + k + " cities are:");
                    for(int i=1;i<=k;i++){
                        System.out.println(item.getMax().getName());
                    }
                }
                else {
                    throw new IncorrectInputException("Wrong input of number of the cities!");
                }
            }
            else {
                throw new NullPointerException();
            }

        } catch (FileNotFoundException e) {
            System.out.println("The file was not found");
        } catch (IOException e) {
            System.out.println("Error reading file " + f.getName());
        } catch (NullPointerException e) {
            System.out.println("The file " + f.getName() + " is empty!");
        } catch (IncorrectInputException e) {
            System.out.println(e);
        } catch (InputMismatchException e) {
            System.out.println("Wrong type of input!");
        }
    }
}
