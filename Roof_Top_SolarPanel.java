import java.util.Scanner;
public class Roof_Top_SolarPanel {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Panel ID: ");
        int Panel_ID = input.nextInt();
        System.out.print("Enter Energy genrated in(KWh): ");
        double Energy_Generated = input.nextDouble();
        System.out.print("Enter number of Solar panels: ");
        int num_Solar_panels = input.nextInt();
        Display(Panel_ID, Energy_Generated, num_Solar_panels);
    }
    static void Display(int Panel_ID, double Energy_Generated, int num_Solar_panels){
        System.out.println("Panel ID is: "+ Panel_ID);
        System.out.println("Energy Genrated in KWh: "+Energy_Generated);
        System.out.println("Total nuber od panels: "+ num_Solar_panels);
    }
}
