package temperatureProblemPackage;
import java.util.Scanner;

public class TemperatureProblemClass 
{
	static Scanner input = new Scanner(System.in);
	static final int MONTH = 12;
	static final int TEMP = 2;
	static final int HIGHTEMPINDEX = 0;
	static final int LOWTEMPINDEX = 1;
	static int [][] temperatures = new int[MONTH][TEMP];
	
	public static void main(String[] args) 
	{
		double avghigh = 0;
		double avglow = 0;
		int yearhighmonthindex = 0;
		int yearhigh = 0;
		int yearlowmonthindex = 0;
		int yearlow = 0;
		
		temperatures=inputTempForYear();
		
		avglow=calculateAverageLow(temperatures);
		avghigh=calculateAverageHigh(temperatures);
		
		yearhigh=findHighestTemp(temperatures);
		yearlow=findLowestTemp(temperatures);
		
		System.out.printf("The average high temperature for the year is %.2f", avghigh);
		System.out.println();
		System.out.printf("The average low temperature for the year is %.2f", avglow);
		System.out.println();
		
		yearhighmonthindex = findHighestTemp(temperatures);
		yearlowmonthindex = findLowestTemp(temperatures);
		yearhigh = temperatures[yearhighmonthindex][HIGHTEMPINDEX];
		yearlow = temperatures[yearlowmonthindex][LOWTEMPINDEX];
		
		System.out.println("The highest temperature of the year was "+yearhigh+" in month "+(yearhighmonthindex+1));
		System.out.println("The lowest temperature of the year was "+yearlow+" in month "+(yearlowmonthindex+1));
		

	}//end main
	
	public static void inputTempForMonth(int month, int[][] temperatures)
	{
		System.out.println("Enter the high for the month.");
		temperatures [month][HIGHTEMPINDEX] = input.nextInt();
		
		System.out.println("Enter the low for the month.");
		temperatures [month][LOWTEMPINDEX] = input.nextInt();
			
	}//end inputTempForMonth
	
	public static int[][] inputTempForYear()
	{
		for(int cntr=0; cntr<temperatures.length; cntr++)
		{
			System.out.println("Month = "+(cntr+1));
			inputTempForMonth(cntr, temperatures);
		}
		
		return(temperatures);
	}//end inputTempForYear
	
	public static double calculateAverageHigh(int[][] temperatures)
	{
		int totalhighs = 0;
		double averagehigh = 0;
		
		for (int cntr=0; cntr<MONTH; cntr++)
		{
			totalhighs+=temperatures[cntr][HIGHTEMPINDEX];
		}
		
		averagehigh=(double)totalhighs/(double)MONTH;
		
		return(averagehigh);
	}//end calculateAverageHigh
	
	public static double calculateAverageLow(int[][] temperatures)
	{
		int totallows = 0;
		double averagelow = 0;
		
		for (int cntr=0; cntr<MONTH; cntr++)
		{
			totallows+=temperatures[cntr][LOWTEMPINDEX];
		}
		
		averagelow=(double)totallows/(double)MONTH;
		
		return(averagelow);
	}//end calculateAverageLow
	
	public static int findHighestTemp(int[][] temperatures)
	{
		int highesttemp = 0;
		
		for (int cntr=0; cntr<MONTH; cntr++)
		{
			if(highesttemp<temperatures[cntr][HIGHTEMPINDEX])
			{
				highesttemp=temperatures[cntr][HIGHTEMPINDEX];
			}
		}
		
		for (int index = 0; index<MONTH; index++)
		{
			if(temperatures[index][HIGHTEMPINDEX] == highesttemp)
			{
				return(index);
			}
		}
		return(0); //if high temp is not found return 0
	}//end findHighestTemp
	
	public static int findLowestTemp(int[][] temperatures)
	{
		int lowesttemp = 0;
		
		for (int cntr=0; cntr<MONTH; cntr++)
		{
			if(lowesttemp>temperatures[cntr][LOWTEMPINDEX])
			{
				lowesttemp=temperatures[cntr][LOWTEMPINDEX];
			}
		}
		
		for (int index = 0; index<MONTH; index++)
		{
			if(temperatures[index][LOWTEMPINDEX] == lowesttemp)
			{
				return(index);
			}
		}
		return(0); //if low temp is not found return 0
	}//end findLowestTemp

}//end Class
