package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import domain.Transaction;
import domain.TransactionType;

public class CapitalOneTransactionParser extends TransactionParser {

	public void parse(ArrayList<Transaction> transactions) {
		//parse csv file
		//Transaction Date,Posted Date,Card No.,Description,Category,Debit,Credit
		//2017-07-06,2017-07-08,8890,PLAYER ONE AMUSEMENT GROU,Entertainment,5.00,
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		 String csvFile = "C:\\Users\\kanwa\\workspace\\MyBudgetWebApp\\resources\\capitalone_apr_july.csv";
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";

	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            line = br.readLine(); //skip first line
	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                String[] token = line.split(cvsSplitBy);
	                Date transactionDate = new Date();
	                try {
	                	transactionDate = df.parse(token[0]);
	                   // String newDateString = df.format(transactionDate);
	                } catch (ParseException e) {
	                    e.printStackTrace();
	                }
	                
	                System.out.println(line);
	                
	                String categoryName=token[3];
	                String categoryType="default";

	                //System.out.println(categoryName);
	                
	                String strAmount ="";
	                
	                if(line.endsWith(",")){
	                	
	                	strAmount = token[token.length-1];
	                	categoryType=token[token.length-2];
	                }
	                else
	                {
	                	strAmount = token[token.length-2];
	                	categoryType=token[token.length-3];

	                }
	                
	                System.out.println(token.length+","+strAmount);
	                if(strAmount.length()>1 )
	                {
	                	Float amount = Float.valueOf(strAmount);
	                	Transaction transaction = new Transaction();
		                transaction.setTransactionDate(transactionDate);
		                
		                BigDecimal bd = new BigDecimal(amount);
		                bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		                
		                
		                transaction.setAmount( bd.floatValue());
		                transaction.setCategoryName(categoryName);
		                transaction.setCategoryType(categoryType);

		                transaction.setTransactionType(TransactionType.CREDIT);
		                transactions.add(transaction);
	                }
	                
	                
	                
	                

	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

		
		
	}
	
}
