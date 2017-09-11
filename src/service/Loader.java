package service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import domain.Transaction;
import domain.TransactionSummary;

public class Loader {
	
	public TransactionSummary  process()
	{
		
		
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		
		
		
		TransactionParser wellsTransactionParser = new WellsfargoTransactionParser();
		wellsTransactionParser.parse(transactions);
		
		TransactionParser capitalOneTransactionParser = new CapitalOneTransactionParser();
		capitalOneTransactionParser.parse(transactions);

		
		Report report  = new Report();
		TransactionSummary transactionSummary = report.generateReport(transactions);
		
		System.out.println("Total Income = "+transactionSummary.getTotalIncome());
		displayMap("total income by category",transactionSummary.getTotalIncomeByCategory());
		System.out.println("Total Credit Card Expense = "+transactionSummary.getTotalCreditCardExpense());
		displayMap("Credit Card",transactionSummary.getTotalCreditCardExpenseByCategory());

		
		System.out.println("Total Checking Expense = "+transactionSummary.getTotalDebitCardExpense());
		displayMap("Debit Card",transactionSummary.getTotalByCategory());
		
		
		
		//get income
		
		return transactionSummary;
		
	}
	
	public static void displayMap(String heading, HashMap<String,HashMap<String,Float>> categories)
	{
		System.out.println("==="+heading+"==="+categories);
		
		for (Map.Entry<String, HashMap<String, Float>> transactionEntry : categories.entrySet()) {
		    String categoryName = transactionEntry.getKey();
		    System.out.print(categoryName);
		    // ...
		    for (Map.Entry<String, Float> nameEntry : transactionEntry.getValue().entrySet()) {
		        String month = nameEntry.getKey();
		        Float amount = nameEntry.getValue();
		        System.out.print(month+"  "+amount);
		        // ...
		    }
		    System.out.println("-");
		}
		
	}
	
	public static void main(String args[]){
		
		Loader loader= new Loader();
		
		loader.process();
	}
	
	

}
