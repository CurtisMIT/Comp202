/*
 * Name: Curtis Lin
 * Student Number : 260770287
 */
public class SlotMachine 
{
	public static void main(String[] args)
	{

//		doubl2e totalAmt = Double.parseDouble(args[0]);
//		double roundBet = Double.parseDouble(args[1]);
//		double goal = Double.parseDouble(args[2]);
//
//		playMachine(totalAmt, roundBet, goal);
	}
	
	// diceRoll method that takes no parameters
	
	public static int diceRoll()
	{
		return (int) (Math.random()*6 + 1);
	}
	
	// getSymbol method that spits out the appropriate symbol according to the integer received
	
	public static String getSymbol(int a)
	{
		if (a==1) 
		{
			return "Cherries";
		}

		else if (a==2)
		{
			return "Oranges";
		}
		else if (a==3) 
		{
			return "Plums";
		}
		else if (a==4)
		{
			return "Bells";
		}
		else if (a==5) 
		{
			return "Melons";
		}
		else if (a==6) 
		{
			return "Bars";
		}
		else 
		{
			return "ERROR";
		}
	}
	
	// getMultiplyer method that returns a multiplyer according to the appropriate combination of symbols

	public static int getMultiplyer(String b, String c, String d)
	{
		if ( b.equals("Bell") && c.equals("Bell") && d.equals("Bell") ) // if all three symbols are "Bell"
		{
			return 5; 
		}
		else if ( b.equals(c) && c.equals(d) ) // since the above condition is passed, the remaining identical trios would not include three "Bell"
		{
			return 3;
		}
		else if ( b.equals(c) || b.equals(d) || c.equals(d) ) // this way of writing the condition should be able to capture all the identical duos
		{
			return 2;
		}
		else // the remaining non-identical combos
		{
			return 0;
		}
	}
	
	// canPlay method which determines whether the player can play or not

	public static boolean canPlay( double totalAmt , double roundBet ) 
	{
		if ( totalAmt>roundBet && roundBet >0) // in order to play the player must have more money in their pocket than the round bet, and that they are actually betting. Hence the round bet must be larger than 0
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	// goalReached method to check whether the player has reached his/her goal

	public static boolean goalReached( double totalAmt , double goal ) 
	{
		if( totalAmt>=goal ) // the totalAmt maybe equal or larger than the goal after a round. Hence, larger or equal
		{
			return true;
		}
		else 
		{
			return false;
		}

	}
	
	// displaySymbols method prints the symbols aquired

	public static void displaySymbols( String firstSymb, String secSymb, String thirdSymb ) 
	{
		System.out.println( firstSymb + " " + secSymb + " " + thirdSymb );
	}
	
	// formatMoney method that transforms the money displayed to the user into the required format

	public static String formatMoney(double m) 
	{
		return String.format("$%.2f" , m);
	}
	
	// the method that combines everything

	public static void playMachine( double totalAmt , double roundBet , double goal )
	{

		if(canPlay(totalAmt, roundBet)) {
			if(goalReached(goal, totalAmt)) {

				int roundNum = 1;
				while(totalAmt>roundBet && totalAmt <goal) {

					System.out.println("You are playing round " + roundNum + ".");
					//update totalAmt
					totalAmt = totalAmt - roundBet;

					String firstSymb = "";
					String secSymb = "";
					String thirdSymb = "";

					// writing the diceRoll method three times so that it generates a random number every time 
					
					int randomNum = diceRoll();
					firstSymb = getSymbol( randomNum );

					randomNum = diceRoll();
					secSymb = getSymbol( randomNum );

					randomNum = diceRoll();
					thirdSymb = getSymbol( randomNum );

					displaySymbols(firstSymb, secSymb, thirdSymb);
					int multiplyer = getMultiplyer(firstSymb, secSymb, thirdSymb);

					totalAmt = totalAmt + (roundBet * multiplyer);
					System.out.println("You currently have " + formatMoney(totalAmt) + ".");

					roundNum++; // this way the round number goes up every time the loop succeeds

				}

			}else {
				System.out.println("You have reached your goal and no further gambling is allowed");
			}
		} else {
			System.out.print("You do not have enough money ");
			throw new IllegalArgumentException("Insufficient funds");
		}

		//whether lost or won
		if(totalAmt>=goal) {
			System.out.println("You reached your goal! You have " + formatMoney(totalAmt) + ".");


		} else {
			System.out.println("You lost. You have " + formatMoney(totalAmt) + ".");
		}


	}
}
