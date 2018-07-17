/*
Name: Curtis Lin
Student Number: 26070287
*/
public class LemonadeStand 
{
	public static void main(String[] args)
	{
		standStates(2, 37, 2.25);// where i call the method
	}
	
	public static void printTotalSales(int numSales, double price)//method printTotalSales
	{
		System.out.println("We sold " + numSales + " units at $" + price +" each, which totals $"+ (numSales*price) +("."));
	}
	
	public static int divide(int first, int second) //
	{
		if (second==0) {
			System.out.println("The second parameter cannot be 0"); //what the program will print if the second parameter is 0
			return 0; //what the program will return if the second parameter is 0
		}
		return first / second;
	}
	
	public static int getMaximum(int a, int b) 
	{
		if (a>b) {
			return a; //if a>b the program will return a
		}
		else {
			return b; //if it's something else like b>a, the program will return b
		}
	}
	
	public static void standStates(int numDays, int numSales, double price) 
	{
		printTotalSales(numSales, price);
		int salesPerDay= divide(numSales, numDays);
		System.out.println("With "+ numSales +" sales over "+ numDays +" days, the sales per day were "+ salesPerDay +".");
		int targetSales= getMaximum (salesPerDay, 10);
		System.out.println("The target sales are now: "+ targetSales +".");
	}

}
