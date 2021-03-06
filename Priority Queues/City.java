import java.lang.Comparable;

public class City implements CityInterface, Comparable<City> {
    private int Id;
    private String Name;
    private int Population;
    private int CovidCases;
    private static int count;
    private static City array[];

    public City (int Id, String Name,int Population,int CovidCases) {
        this.Id=Id;
        this.Name=Name;
        this.Population=Population;
        this.CovidCases=CovidCases;
        array[++count]=this;
    }

    public City (int Id, String Name,int Population,int CovidCases,String DataStructure) {
        this.Id = Id;
        this.Name = Name;
        this.Population = Population;
        this.CovidCases = CovidCases;
    }

    public static void setArrayLength(int n) {
        array= new City [n];
    }

    @Override
    public int getID() {
        return Id;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public int getPopulation() {
        return Population;
    }

    @Override
    public int getCovidCases() {
        return CovidCases;
    }

    @Override
    public void setID(int ID) {
        this.Id=ID;
    }

    @Override
    public void setName(String name) {
        this.Name=name;
    }

    @Override
    public void setPopulation(int population) {
        this.Population=population;
    }

    @Override
    public void setCovidCases(int CovidCases) {
        this.CovidCases=CovidCases;
    }

    public static City[] getArray() { return array;}

    public static int getCount() { return count; }

    public double calculateDensity(int population, int CovidCases){
        return Math.round((CovidCases*50000/population)*100.0/100.0);
    }

    @Override
    public int compareTo(City c) {
        double n1 = calculateDensity(this.Population, this.CovidCases);
        double n2 = calculateDensity(c.Population, c.CovidCases);
        if (n1>n2){
            return 1;
        }
        else if(n1<n2){
            return -1;
        }
        else{
            String s1=this.Name;
            String s2=c.Name;
            int l1=s1.length();
            int l2=s2.length();
            int n = Math.min(l1,l2);
            for (int i=0;i<=n;i++){
                if (s1.charAt(i)<s2.charAt(i)){
                    return 1;
                }
                else if (s1.charAt(i)>s2.charAt(i)){
                    return -1;
                }
            }
        }
        return (this.Id<=c.Id)? 1 : -1;
    }
}
