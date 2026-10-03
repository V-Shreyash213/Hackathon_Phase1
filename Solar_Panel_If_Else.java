import java.util.Scanner;
public class Solar_Panel_If_Else {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Energy genrated in(KWh): ");
        double Energy_Generated = input.nextDouble();
        if (Energy_Generated>=10 ){
            System.out.println("Good Energy Generation");
        }
        else System.out.println("Low Energy Generation");
    }
}
