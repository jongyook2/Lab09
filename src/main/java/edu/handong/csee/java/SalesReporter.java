package edu.handong.csee.java;
import java.util.Scanner;

public class SalesReporter {
	private double highestSales;
	private double averageSales;
	private Salesman[] team;
	private int numberOfSalesman;
	public SalesReporter() {
		System.out.println("Enter number of sales associates: ");
		Scanner keyboard = new Scanner(System.in);

		numberOfSalesman = keyboard.nextInt();

	}
	public static void main(String[] agrs) {
		SalesReporter myReporter = new SalesReporter();
		myReporter.getData();
		myReporter.calculateAverage();
		myReporter.calculateHighest();
		myReporter.printOutResults();
	}
	public void getData() {
		team = new Salesman[numberOfSalesman];
		for(int i=0; i<numberOfSalesman; i++) {
			Scanner keyboard= new Scanner(System.in);

			System.out.println("Enter data for associate number "+i+1);
			System.out.print("Enter name of sales associate: ");
			String name = keyboard.nextLine();
			System.out.print("Enter assoiate's sales: $");
			double sales = keyboard.nextDouble();

			Salesman mySalesman = new Salesman();
			mySalesman.setmName(name);
			mySalesman.setSales(sales);

			team[i]=mySalesman;
		}
	}
	public void calculateAverage() {
		double sum =0;
		for(int i=0; i<team.length; i++) {
			double sales = team[i].getSales();
			sum = sum + sales;
		}
		averageSales= sum/team.length;
	}
	public void calculateHighest() {
		double sum =0;
		for(int i=0; i<team.length-1; i++) {
			if(team[i].getSales() < team[i+1].getSales()) {
				highestSales = team[i+1].getSales();
			}
		}
	}	

	public void printOutResults() {
		System.out.println("Average sales per associate is $" + averageSales);
		System.out.println("The highest sales figure is $" + highestSales);
		double difference;
		int i;
		for(i=0; i < team.length; i++) {
			if(team[i].getSales() == highestSales) {
				System.out.println("The following had the highest sales:");
				System.out.println("Name: " + team[i].getmName());
				System.out.println("Sales: $" + team[i].getSales());
				difference = team[i].getSales() - averageSales;
				System.out.println("$"+difference+" is above the average.");
			}
		}
		 for(i=0; i < team.length; i++) {
				if(team[i].getSales() != highestSales) {
					System.out.println("Name: " + team[i].getmName());
					System.out.println("Sales: $" + team[i].getSales());
					difference = team[i].getSales() - averageSales;
					if(difference > 0) System.out.println("$"+difference+"is above the average.");
					else System.out.println("$"+Math.abs(difference)+"is below the average.");
				}
			}
		}
	}
