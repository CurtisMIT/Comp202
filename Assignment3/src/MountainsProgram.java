/*
 * Name: Curtis Lin
 * Sutdent Number: 26070287
 */
import java.util.Arrays;

public class MountainsProgram 
{
	// method that gets the next point
	public static double getNextPoint (double prevHeight, double steepness, double maxHeight)
	{

		double random = -steepness + (Math.random() * ((steepness- (-steepness)) ));
		
		//this is raymond's edit
		//raymonds here again
		
		
		double nextPoint = prevHeight + random;
		if(nextPoint > maxHeight)
		{
			nextPoint = maxHeight;
			return nextPoint;
		}
		else if (nextPoint < 0 )
			
		{
			nextPoint=0;
			return nextPoint;
		}
		else 
		{
			return nextPoint;
		}
	}
	
	// method that generates mountains
	public static double[] generateMountains (int numPoints, double steepness, double maxHeight)
	{
		double[] variable = new double[numPoints];
	
		variable[0] = maxHeight/2;
		
		
		for ( int i = 1; i<numPoints; i++)
		{
			variable[i] = getNextPoint( variable[i-1], steepness, maxHeight);
		}

		
		return variable;
	}
	
	// method that can find the maximum height
	public static double findMaxHeight(double[] variable)
	{

		
		if (variable.length == 0) 
		{
			return 0.0;
		}
		
		double tempMax = variable[0];
	
		
		for (int i = 1; i<variable.length; i++)
		{
			
			if (variable[i] > tempMax)
			{
				tempMax = variable[i];
				
			}

		}
		return tempMax;
	}
	
	// method that draws the mountains
	public static void drawMountains(double[] variable, String symbol)
	{
	
		double var = findMaxHeight(variable);
		System.out.println(var);
		int maxHeight = (int)(var + 1);
		System.out.println(maxHeight);
		

		for ( int i = maxHeight; i >= 0; i--)
		{
			for( int j=0; j<variable.length; j++)
			{
				if(variable[j] < i) 
				{
					System.out.print(" ");
				}
				else if( i-variable[j]  < 1 && i-variable[j]  > -1 && i!=0)
				{
					System.out.print("^");
				}
				else if( variable[j] > i && i!=0)
				{
					System.out.print(symbol);
				}
				else if(i == 0)
				{
					System.out.print("-");
				}
			}
			System.out.println("");
		}
	}
	
	
}
