package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import domain.Transaction;
import domain.TransactionType;

public class WellsfargoTransactionParser extends TransactionParser {
	
	
	public void parse(ArrayList<Transaction> transactions) {
		//parse csv file
		//6/1/2017	-100	*		ATM WITHDRAWAL AUTHORIZED ON 06/01 7181 REGIONAL ST DUBLIN CA 0005189 ATM ID 9960X CARD 1712
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		
		 String csvFile = "C:\\Users\\kanwa\\workspace\\MyBudgetWebApp\\resources\\Checking_apr_june.csv";
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";

	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {
	            	if(line.length()>0){
	            	//System.out.println(line);
	                // use comma as separator
	                String[] token = line.split(cvsSplitBy);
	                Date transactionDate = new Date();
	                try {
	                //	System.out.println(token[0]);
	                	transactionDate = df.parse(token[0].replaceAll("^\"|\"$", ""));
	                   // String newDateString = df.format(transactionDate);
	                } catch (ParseException e) {
	                    e.printStackTrace();
	                }
	                
	                
	                Float amount = Float.valueOf(token[1].replaceAll("^\"|\"$", ""));
	                
	                
	                Transaction transaction = new Transaction();
	                transaction.setTransactionDate(transactionDate);
	                transaction.setAmount(amount);
	                transaction.setCategoryName(token[4].replaceAll("^\"|\"$", ""));
	                transaction.setTransactionType(TransactionType.DEBIT);
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
