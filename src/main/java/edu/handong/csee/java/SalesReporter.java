package edu.handong.csee.java; //package name
import java.util.ArrayList; //import ArrayList class
import java.util.Scanner; //import standard input from keyboard

/**
 * This public class defines SalesReporter object.<br>
 * It has main method, getData, calculateAverage, calculateHighest, and printOutResults method <br>
 * Summary: instantiate SalesReporter class to Reporting and receive salesman name, and sales as input <br>
 * ask whether add other person's info<br>
 * calculate average and highest, print salesman's information<br>
 * 
 *  @author YJW <br>
 */
public class SalesReporter {
	private double highestSales; //declare instance variable(highest sales record)
	private double averageSales; //declare instance variable(average sales record)
	ArrayList<Salesman> team = new ArrayList(); //instantiate team(ArrayList<Saleman>

	/**
	 * This public static void method is main <br>
	 * instantiates SalesReporter Class to Reporting <br>
	 * calls all method(getData, calculateAverage, calculateHighest, and printOutResults
	 * 
	 */
	public static void main(String[] agrs) {
		SalesReporter Reporting = new SalesReporter(); //instantiate Class SalesReporter to Reporting
		Reporting.getData(); //calls getData method
		Reporting.calculateAverage(); //calls calculateAverage method
		Reporting.calculateHighest(); //calls calculateHighest method
		Reporting.printOutResults(); //calls printOutResults method
	}
	/**
	 * This public void method is getData that receives name and sales by user(keyboard)<br>
	 * initializes Salesman to mySalesman and stores name and sales in mySalesman then, mySalesmna add to team(arrayList)
	 */
	public void getData() {

		int i=0; //local variable(use index)
		while(true){ //loop until choose equal to "No"
			Scanner keyboard= new Scanner(System.in); // instantiate Class Scanner to keyboard(input)
			System.out.println("Enter data for associate number "+(i+1)); //output(Enter data for associate number 1~numberofSalesman ) is shown in your monitor
			i++; // increase(it is index of Salesman)
			System.out.print("Enter name of sales associate: "); //output(Enter number of sales associates: ) is shown in your monitor
			String name = keyboard.nextLine(); //name is input(string type) from keyboard
			System.out.print("Enter assoiate's sales: $"); //output(Enter assoiate's sales: $ ) is shown in your monitor
			double sales = keyboard.nextDouble(); //sales is input(double type) from keyboard
			keyboard.nextLine(); //enter 
			Salesman mySalesman = new Salesman(); //instantiate Class Salesman to mySalesman
			mySalesman.setmName(name); //store name 
			mySalesman.setSales(sales); //store sales

			team.add(mySalesman); //team array index i is initialized to mySalesman(has name and sales)
			System.out.println(); //next line
			System.out.print("Do you want to input others?(yes or no) "); //output(Do you want to input others?(yes or no) ) is shown in your monitor
			String choose = keyboard.nextLine(); //choose is input(string type) from keyboard

			if(choose.equalsIgnoreCase("no")){ //if choose equal to "no" 
				break; //escape from while loop
			}

		}
	}
	/**
	 * This public void method is calculateAverage that calculates average(salesman's sales) <br>
	 * 
	 */
	public void calculateAverage() {
		double sum =0; // declare sum and initialize to 0
		for(int i=0; i<team.size(); i++) { //loop 0 to arrayList size-1
			double sales = team.get(i).getSales(); //declare sales and initialize to team.get(i).getSales()
			sum = sum + sales; //sum(now) is sum(before) + sales(array index i)
		}
		averageSales= sum/team.size(); // sum is divided by array length
	}
	/**
	 * This public void method is calculateHighest that calculates highest(salesman's sales) <br>
	 * 
	 */
	public void calculateHighest() {
		//double highestSales=0;  // declare highestSales and initialize to 0
		for(int i=0; i<team.size(); i++) { //loop 0 to arraylist size-1
			if(team.get(i).getSales() > highestSales) { //if team.get(i)'s sales is more than highestSales
				highestSales = team.get(i).getSales(); //highestSales is team.get(i)'s sales
			}
		}
	}	
	/**
	 * This public void method is printOutResults that prints average, highest <br>
	 * also, it shows 1st sales member's name and sales, and other members(+ print how sales differ from average) 
	 */
	public void printOutResults() {
		System.out.println("Average sales per associate is $" + averageSales); //output(Enter assoiate's sales: $averageSales) is shown in your monitor
		System.out.println("The highest sales figure is $" + highestSales); //output(Enter assoiate's sales: $highestSales) is shown in your monitor
		double difference; //declare variable(difference) double type
		int i; //declare variable i(for loop)
		for(i=0; i < team.size(); i++) { //loop 0 to arraylist size-1
			if(team.get(i).getSales() == highestSales) { //if team.get(i)'s Sales is equal to highestSales
				System.out.println("\nThe following had the highest sales:"); //output(The following had the highest sales:) is shown in your monitor
				System.out.println("Name: " + team.get(i).getmName()); //output(Name: team.get(i)'s name) is shown in your monitor
				System.out.println("Sales: $" + team.get(i).getSales()); //output(Sales: team.get(i)'s Sales) is shown in your monitor
				difference = team.get(i).getSales() - averageSales; //initialize to (team.get(i)'s sales-average) 
				System.out.println("$"+difference+" is above the average."); //output($difference is above the average) is shown in your monitor
			}
		}
		if(team.size()>1) {//if there are number of Salesman
			System.out.println("\nThe rest performed as follows:"); //output(The rest performed as follows:) is shown in your monitor
			for(i=0; i < team.size(); i++) { //loop 0 to arraylist size-1
				if(team.get(i).getSales() != highestSales) { //if team.get(i)'s Sales is not equal to highestSales
					System.out.println("Name: " + team.get(i).getmName()); //output(Name: team.get(i)'s name) is shown in your monitor
					System.out.println("Sales: $" +team.get(i).getSales()); //output(Sales: team.get(i)'s Sales) is shown in your monitor
					difference = team.get(i).getSales() - averageSales; //initialize to (team.get(i)'s sales-average) 
					if(difference > 0) //if difference is larger than 0
						System.out.println("$"+difference+" is above the average."); //output($difference is above the average) is shown in your monitor
					else if(difference < 0) //if difference is less than 0
						System.out.println("$"+Math.abs(difference)+" is below the average."); //output($difference is below the average) is shown in your monitor
					else //if difference is equal to 0
						System.out.println("sales is the average(same)."); //output(sales is the average(same).) is shown in your monitor
				}
			}
		}
	}
}