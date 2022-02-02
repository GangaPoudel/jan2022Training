package com.virtusa;

import java.util.Scanner;

public class FactoryDesignPatternApplication {

    public static void main(String[] args) {

        GetPlanFactory planFactory = new GetPlanFactory();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter plan type (singleplan or familyplan): ");
        String name = scan.nextLine();

        System.out.println("Enter # of units: ");
        int units = scan.nextInt();

        Plan plan = planFactory.getPlan(name);

        System.out.println("The total due for " + name + " using " + units + " units is: ");
        plan.getRate();
        plan.calculateBill(units);
    }
}
