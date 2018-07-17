//Fill in your name and student number
//Name: Curtis Lin
//Student Number: 260770287
    
public class Calculator
{

	public static void main(String[] args)
	{
		System.out.println("Welcome to the Calculator program!");

		if (args.length < 3)
		{
			System.out.println("You need to enter three arguments to this program. Try typing 'run Calculator 5 5 1' in Dr. Java, or 'java Calculator 5 5 1' on the command line.");
			return;
		}

		int a = getIntegerNumber(args[0]);
		int b = getIntegerNumber(args[1]);
		double c = getDoubleNumber(args[2]);

		System.out.println("The first argument a is: " + a);
		System.out.println("The second argument b is: " + b);
		System.out.println("The third argument c is: " + c);

    //========================
    //Enter your code below
		System.out.println("Sum of a and b is: "+(a+b));
		System.out.println("Product of a and b is: "+(a*b));
		System.out.println("Dividing a by b: "+(a/b));
		System.out.println("Dividing a by c: "+(a/c));
		System.out.println("Is a larger than b: "+(a>b));
		System.out.println("Is a odd: "+((a%2)==1)); // If a is even it will be divisible by 2 which means that there will be no remainder
    //Enter your code above
    //========================
	}

	public static int getIntegerNumber(String arg)
	{
		try
		{
			return Integer.parseInt(arg);
		}catch(NumberFormatException e)
		{
			System.out.println("ERROR: " + e.getMessage() + " This argument must be an integer!");
		}
    	
    	//error, return 1
		return 1;
	}

	public static double getDoubleNumber(String arg)
	{
		try
		{
			return Double.parseDouble(arg);
		}catch(NumberFormatException e)
		{
			System.out.println("ERROR: " + e.getMessage() + " This argument must be a double!");
		}
    	
    	//error, return 1.0
		return 1.0;
	}
}
