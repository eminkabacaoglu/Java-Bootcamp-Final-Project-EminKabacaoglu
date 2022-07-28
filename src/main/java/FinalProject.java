import util.Responder;

import java.util.Scanner;

public class FinalProject {

    public static void main(String[] args) {

        final Scanner keyboardInput = new Scanner(System.in);

        while (true){
            System.out.println("Choose a Report? \n 1: Total Amount Of Policies By Policy Type (Bar Chart)\n 2: Payments By Year (Line Chart)\n 3: Total Quantity Of Policies By Agencies Cities (Pie Chart)\n 4: Agencies Performance Table\n E: Exit");
            String response = keyboardInput.nextLine();
            new Responder().find(response);
        }


  }
}
