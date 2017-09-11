package service;
import java.text.ParseException;
import java.util.ArrayList;

import domain.Transaction;


public abstract class TransactionParser {
	
	public abstract void parse(ArrayList<Transaction> transactions) ;

}
