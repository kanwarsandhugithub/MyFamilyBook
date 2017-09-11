package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import domain.Transaction;
import domain.TransactionSummary;
import domain.TransactionType;

public class Report {
	
	public  TransactionSummary generateReport(ArrayList<Transaction> transactions)
	
	{
		float totalIncome = 0;
		float totalExpense = 0;
		float totalATM = 0;
		float totalCreditCardExpense =0;

		TransactionSummary transactionSummary = new TransactionSummary();
		HashMap<String,HashMap<String,Float>> totalIncomeByCategory = new HashMap<String,HashMap<String,Float>>();
		HashMap<String,HashMap<String,Float>> totalExpenseByCategory = new HashMap<String,HashMap<String,Float>>();
		HashMap<String,HashMap<String,Float>> totalCreditCardExpenseByCategory = new HashMap<String,HashMap<String,Float>>();
		HashMap<String,HashMap<String,Float>> totalCreditCardExpenseByCategoryType = new HashMap<String,HashMap<String,Float>>();

		HashMap<String, HashMap<String,Float>> categories = new HashMap<String, HashMap<String,Float>>();

		HashMap<String,Float> totalMonthlyIncome = new HashMap<String,Float>();
		HashMap<String,Float> totalMonthlyDebitExpense = new HashMap<String,Float>();
		HashMap<String,Float> totalMonthlyCreditExpense = new HashMap<String,Float>();
		HashMap<String,Float> totalMonthlyCreditExpenseByCategoryType = new HashMap<String,Float>();

		
		for(Transaction transaction : transactions){	
			//incomes
			if(transaction.getTransactionType() == (TransactionType.DEBIT) && transaction.getAmount()>0 
					&& !transaction.getCategoryName().contains("ONLINE TRANSFER FROM")
					&& !transaction.getCategoryName().contains("OVERDRAFT")){

				totalIncome+=transaction.getAmount();
				
				addTotal(totalMonthlyIncome,  transaction.getTransactionDate(),Math.abs(transaction.getAmount()) );
				
				addCategories(totalIncomeByCategory, transaction.getTransactionDate(), transaction.getCategoryName(),Math.abs(transaction.getAmount()));
			}
			
			//debit expenses
			
			if(transaction.getTransactionType() == (TransactionType.DEBIT) && transaction.getAmount()<0 ){
				if(!transaction.getCategoryName().contains("CAPITAL ONE") &&
						!transaction.getCategoryName().contains("TELE-TRANSFER")){
				
					totalExpense+=transaction.getAmount();
					addTotal(totalMonthlyDebitExpense,  transaction.getTransactionDate(),Math.abs(transaction.getAmount()) );

					addCategories(totalExpenseByCategory,  transaction.getTransactionDate(),transaction.getCategoryName(),Math.abs(transaction.getAmount()) );
				}
			}
			
			//credit expenses
			if(transaction.getCategoryName().contains("ATM"))  totalATM+=transaction.getAmount();
			
			if(transaction.getTransactionType() == (TransactionType.CREDIT) ){
				totalCreditCardExpense+=transaction.getAmount();
				addTotal(totalMonthlyCreditExpense,  transaction.getTransactionDate(),Math.abs(transaction.getAmount()) );
				addTotal(totalMonthlyCreditExpenseByCategoryType,  transaction.getTransactionDate(),Math.abs(transaction.getAmount()) );

				addCategories(totalCreditCardExpenseByCategory, transaction.getTransactionDate(), transaction.getCategoryName(),Math.abs(transaction.getAmount()) );
				addCategories(totalCreditCardExpenseByCategoryType, transaction.getTransactionDate(), transaction.getCategoryType(),Math.abs(transaction.getAmount()) );				

			}
			
		}
		
		transactionSummary.setTotalByCategory(categories);
		
		transactionSummary.setTotalCashWithdrawal(totalATM);
		transactionSummary.setTotalIncome(totalIncome);
		transactionSummary.setTotalIncomeByCategory(totalIncomeByCategory);
		transactionSummary.setTotalCreditCardExpense(totalCreditCardExpense);
		transactionSummary.setTotalDebitCardExpense(totalExpense);
		transactionSummary.setTotalCreditCardExpenseByCategory(totalCreditCardExpenseByCategory);
		transactionSummary.setTotalByCategory(totalExpenseByCategory);
		transactionSummary.setMonthlyTotalIncome(totalMonthlyIncome);
		transactionSummary.setMonthlyTotalDebitExpense(totalMonthlyDebitExpense);
		transactionSummary.setMonthlyTotalCreditExpense(totalMonthlyCreditExpense);
		transactionSummary.setTotalCreditCardExpenseByCategoryType(totalCreditCardExpenseByCategoryType);
		
		
		return transactionSummary;
	}

	
private void addTotal(HashMap<String, Float> totalsMap, Date transactionDate, float pAmount) {
		// TODO Auto-generated method stub
		//get month
	  	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
	    simpleDateFormat = new SimpleDateFormat("MMMM");
	    String month = simpleDateFormat.format(transactionDate).toUpperCase();
	    
	    Float amount = totalsMap.get(month);
	    
	    if(amount == null){
	    	totalsMap.put(month, new Float(pAmount));
		}
		else
		{
		float existingAmount = amount.floatValue();
		existingAmount+=pAmount;
		totalsMap.put(month, new Float(existingAmount));
		}
	
	
	}


public void addCategories(HashMap<String, HashMap<String, Float>> categories, Date transactionDate , String category, float pAmount){
		
	//System.out.print("report.addCategories:"+categories);	System.out.print("date:"+transactionDate);System.out.println(category);

		//get the first 3 keywords of category
		String[] parts = category.split(" ");
		String categoryName  = parts[0];
		if(parts.length >= 4){
			categoryName = parts[0]+" "+parts[1]+" "+parts[2];
		}
		else if(parts.length ==2 || parts.length ==3 )
		{
			 categoryName = parts[0]+" "+parts[1];
	
		}

		
		//System.out.println("categoryName:"+categoryName);
		//get month
		

		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");


		    simpleDateFormat = new SimpleDateFormat("MMMM");
		   String month = simpleDateFormat.format(transactionDate).toUpperCase();
		
		  // System.out.println("month:"+month);
		HashMap<String, Float> categoryMonthMap = (HashMap<String, Float>)categories.get(categoryName);
		
		if(categoryMonthMap == null){
			//   System.out.println("categoryMonthMap is null:"+month);
			categoryMonthMap = new HashMap<String, Float>();
			categoryMonthMap.put(month, new Float(pAmount));
			 //  System.out.println("categoryMonthMap added:"+categoryMonthMap);

			   categories.put(categoryName, categoryMonthMap);
			
		}else
		{
			Float amount = categoryMonthMap.get(month);
			
			if(amount == null){
				categoryMonthMap.put(month, new Float(pAmount));
			}
			else
			{
			float existingAmount = amount.floatValue();
			existingAmount+=pAmount;
			categoryMonthMap.put(month, new Float(existingAmount));
			}
			
			
			
			
		}
		
		
		
		
		

		
	}
}
