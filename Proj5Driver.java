/*
Problem:        Project 5 
Written By:     John Waide
*/

import java.io.*;

import java.text.DecimalFormat;

public class Proj5Driver
{
    public static void main(String args[]) throws IOException
    {
        Proj5 app;
        app = new Proj5();
        app.appMain();
	
	 
    }   
}

class Proj5
{
    // Data (Field) Declaration, so declare all your variables HERE
    BufferedReader stdin;   // stdin will represent the keyboard
	int count, MinTN;
	int transcounter;
	int TNArray[] = {11, 22, 33, 44, 55, 66, 77, 88, 0};
	float RAArray[] = {1234.55f, 4321.95f, 6789.95f, 1111.95f, 4567f, 1111,95f, 7788.95f, 1111.95f};
	String DF[] = new String[RAArray.length];
	float TAArray[] = new float[RAArray.length];
	float Taxrate, DA, TotRA, TotDA, TotTA, MinTA, discount;
	DecimalFormat f1 = new DecimalFormat("$#,###.##"); 
	String StrLoc, Date;
	float Avg;
	String numString;
	
	

    // appMain is analogous to your Pseudocode Main
    void appMain() throws IOException
    {				
		stdin = new BufferedReader(new InputStreamReader(System.in));
		GetStrInfo();
		TotDA = TotTA = TotRA = count = transcounter = 0;
		MinTA = 9001;
		discount = 0.05f;
		
		Updates();
		Outray();
		DisplayStoreInfo();
		DisplaySummary();
    }
    void GetStrInfo() throws IOException
    {
	System.out.println("Enter the store location:");
	StrLoc = stdin.readLine();
	
	System.out.println("Enter the date:");
	Date = stdin.readLine();  
	
	System.out.println("Enter the tax rate:");
    	numString = stdin.readLine();
	Taxrate = Float.parseFloat(numString); 
    }
    void Outray()
    {	System.out.println("ARC Daily Transaction Report Summary");
	System.out.print("Trans#");
	System.out.print("\t RA");
	System.out.print("\t \t \t DF");
	System.out.println("\t \t \t \t TA");
	for(count = 0; TNArray[count] != 0; ++count)
	{
		System.out.print(TNArray[count]);
		System.out.print("\t" + f1.format(RAArray[count]));
		System.out.print("\t \t" + DF[count]);
		System.out.println("\t \t \t" + f1.format(TAArray[count]));
	}
    	return;
    }
    void Updates()
    {
	for(count = 0; TNArray[count] != 0; ++count)
	{
		++transcounter;
		if(RAArray[count] > 1500)
		{
		DA = (float)RAArray[count] * (float)discount;
		DF[count] = "No";
		}
		else
		{
			DA = 0;
			DF[count] = "Discounted";
		}
		TAArray[count] = (float)RAArray[count] - (float)DA * (1 + (float)Taxrate);
		TotTA = TotTA + TAArray[count];
		TotRA = TotRA + RAArray[count];
		if(TAArray[count] < MinTA)
		{
			MinTA = TAArray[count];
			MinTN = TNArray[count];
		}
	}
    	Avg = TotTA/transcounter;
	TotDA = TotDA + DA;
    }
    void DisplayStoreInfo()
    {
	System.out.println("\n Store Details");
	System.out.println("*********************");
	System.out.println("Store:" + StrLoc);
	System.out.println("Date:" + Date);
	System.out.println("Tax rate:" + Taxrate);
	System.out.println("*********************");
    }
    void DisplaySummary()
    {
	System.out.println("\n Totals Summary");
	System.out.println("*********************");
	System.out.println("Total retail amount:" + f1.format(TotRA));
	System.out.println("Total discount amount:" + f1.format(TotDA));
	System.out.println("Total transaction amount:" + f1.format(TotTA));
	
	System.out.println("\n Store Stats");
	System.out.println("*********************");
	System.out.println("Average transaction amount:" + f1.format(Avg));
	System.out.println("Low transaction amount:" + f1.format(MinTA));
	System.out.println("Transaction number for low transaction amount:" + MinTN);
    }
    }
	
		