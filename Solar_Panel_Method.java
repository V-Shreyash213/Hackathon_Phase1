import java.util.Scanner;

public class Solar_Panel_Method {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Energy genrated in Morning (KWh): ");
        double mornEnergy = input.nextDouble();
        System.out.print("Enter Energy genrated in Evening(KWh): ");
        double evenEnergy = input.nextDouble();
        double t = calculateTotalEnergy(mornEnergy, evenEnergy);
        System.out.println("Total Energy Genrated is: "+ t);
    }
    
    static double calculateTotalEnergy(double mornEnergy, double evenEnergy){
        double Total_Energy_genrated = mornEnergy+evenEnergy;
        return Total_Energy_genrated;
    }
}
