/*
Problem:        Project 4
Written By:     John Waide
*/

import java.io.*;

public class Proj4Driver
{
    public static void main(String args[]) throws IOException
    {
        Proj4 app;
        app = new Proj4();
        app.appMain();
    }   
}

class Proj4
{
    // Data (Field) Declaration, so declare all your variables HERE
    BufferedReader stdin;   // stdin will represent the keyboard
	String Date;
	String EmpName;
	String HighEmp;
	String numString; 
	String inString;
	int SalesNumber;
	char SalesType;
	double TotalSales, YTDSales, SalesAmount, AccumSales, UpdatedYTD, Bonus, TotalSalesF, TotalSalesA, TotalSalesS, TotalYTD, HighAmt;
	
	

    // appMain is analogous to your Pseudocode Main
    void appMain() throws IOException
    {
		stdin = new BufferedReader(new InputStreamReader(System.in));
		outHeader();
		InitRpt();
		GetDate();
		while(!EmpName.equalsIgnoreCase("Done"))
		{
			ProcessEmployee();
		}
		CalcTotalDailySales();
		DisplaySummary();
    }
    void outHeader()
    {
	System.out.println("\n *********************");
	System.out.println("Project 4");
	System.out.println("by John Waide");
	System.out.println("*********************");
    }
    void InitRpt()
    {
	HighAmt = TotalSalesF = TotalSalesA = TotalSalesS = 0;
	SalesNumber = -1;
	EmpName = "null";
	
    }
    void GetDate() throws IOException
    {
	System.out.println("Enter the date:");
	Date = stdin.readLine();
    }
    void ProcessEmployee() throws IOException
    {
	GetEmpName();
	
	if(!EmpName.equalsIgnoreCase("Done"))
	{
		AccumSales = 0;
		
				
		GetBalFwd();

		
		DisplayEmpInfo();

		while(SalesNumber != 0)
		{
			ProcTrans();
		}
		
		UpdatedYTD = YTDSales + AccumSales;
		TotalYTD = TotalYTD + UpdatedYTD;
		Bonus = AccumSales * .05; 
		
		DisplayEmpDailySalesInfo();
		
		
	}
    }
    void GetEmpName() throws IOException
    {
	System.out.println("Enter employee name:");
	EmpName= stdin.readLine(); 	
    }
    void GetBalFwd() throws IOException
    {
		System.out.println("Enter employee year to date sales:");
		numString = stdin.readLine();
		YTDSales = Double.parseDouble(numString);
    }
    void DisplayEmpInfo() 
    {
		System.out.print("Employee name:" + EmpName);
		System.out.println("\t YTD Sales:" + YTDSales);
		
		
    }
    void DisplayEmpDailySalesInfo()
    {
		System.out.print("EndingYTD:" + UpdatedYTD);
		System.out.println("\t Bonus:" + Bonus);
		
    }
    void ProcTrans() throws IOException
    {
	System.out.println("Enter sales number:");
	numString = stdin.readLine();
	SalesNumber = Integer.parseInt(numString);
	if(SalesNumber != 0)
	{
		System.out.println("Enter sales type:");
		inString = stdin.readLine();
		SalesType = inString.charAt(0);
		
		
		System.out.println("Enter sales amount:");
		numString = stdin.readLine();
		SalesAmount = Float.parseFloat(numString);
		
		AccumSales = AccumSales + SalesAmount;
		
		if(SalesAmount > HighAmt)
		{
			HighAmt = SalesAmount;
			HighEmp = EmpName;
		}
		
		if(SalesType == 'F')
			TotalSalesF = TotalSalesF + SalesAmount;
		else
			if(SalesType == 'A')
				TotalSalesA = TotalSalesA + SalesAmount;
			else
			
				if(SalesType == 'S')
					TotalSalesS = TotalSalesS + SalesAmount;
	DisplayTransaction();				

		
	}
}
void DisplayTransaction()
{
		System.out.println("Sales number:" + SalesNumber);
		System.out.println("Sales type:" + SalesType);
		System.out.println("Sales amount:" + SalesAmount);
		System.out.println("Running bal:" + AccumSales);
			
}	
void CalcTotalDailySales()
{
TotalSales = TotalSalesF + TotalSalesA + TotalSalesS;
}
void DisplaySummary()
{
	System.out.println("Date:" + Date);
	System.out.println("Total food and drink sales:" + TotalSalesF);
	System.out.println("Total alcohol sales:" + TotalSalesA);
	System.out.println("Total sundries sales:" + TotalSalesS);
	System.out.println("Total sales:" + TotalSales);
	System.out.println("Total year to date sales:" + TotalYTD);
	System.out.println("Highest sales amount:" + HighAmt);
	System.out.println("Employee with highest sales amount:" + HighEmp);
}
} // end of class Proj4 	
		 
		
		
				
  		


  

