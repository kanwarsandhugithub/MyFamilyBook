package domain;

import java.util.HashMap;

public class TransactionSummary {
	
	float totalIncome;
	float totalExpense;
	float totalCreditCardExpense;
	float totalDebitCardExpense;
	float netSaving;
	
	
	public float getNetSaving() {
		
		float totalExpense = totalCreditCardExpense+totalDebitCardExpense;
		return totalIncome-totalExpense;
		
		
	}
	public void setNetSaving(float netSaving) {
		this.netSaving = netSaving;
	}
	String [] months = {
			  "APRIL", 
			  "MAY", 
			  "JUNE", 
			  "JULY"  
			};
	
	
	public HashMap<String, Float> getMonthlyTotalDebitExpense() {
		return monthlyTotalDebitExpense;
	}
	public void setMonthlyTotalDebitExpense(HashMap<String, Float> monthlyTotalDebitExpense) {
		this.monthlyTotalDebitExpense = monthlyTotalDebitExpense;
	}
	public HashMap<String, Float> getMonthlyTotalCreditExpense() {
		return monthlyTotalCreditExpense;
	}
	public void setMonthlyTotalCreditExpense(HashMap<String, Float> monthlyTotalCreditExpense) {
		this.monthlyTotalCreditExpense = monthlyTotalCreditExpense;
	}
	HashMap<String,Float> monthlyTotalIncome;
	HashMap<String,Float> monthlyTotalDebitExpense;
	HashMap<String,Float> monthlyTotalCreditExpense;

	public HashMap<String, Float> getMonthlyTotalIncome() {
		return monthlyTotalIncome;
	}
	public void setMonthlyTotalIncome(HashMap<String, Float> monthlyTotalIncome) {
		this.monthlyTotalIncome = monthlyTotalIncome;
	}
	public String[] getMonths() {
		return months;
	}
	public void setMonths(String[] months) {
		this.months = months;
	}
	public float getTotalDebitCardExpense() {
		return Math.abs(totalDebitCardExpense);
	}
	public void setTotalDebitCardExpense(float totalDebitCardExpense) {
		this.totalDebitCardExpense = totalDebitCardExpense;
	}
	public float getTotalExpense() {
		return totalExpense;
	}
	public void setTotalExpense(float totalExpense) {
		this.totalExpense = totalExpense;
	}
	HashMap<String,HashMap<String,Float>> totalIncomeByCategory;
	HashMap<String,HashMap<String,Float>> totalCheckingExpenseByCategory;
	HashMap<String,HashMap<String,Float>> totalCreditCardExpenseByCategory;
	HashMap<String,HashMap<String,Float>> totalCreditCardExpenseByCategoryType;

	

	public HashMap<String, HashMap<String, Float>> getTotalCreditCardExpenseByCategoryType() {
		return totalCreditCardExpenseByCategoryType;
	}
	public void setTotalCreditCardExpenseByCategoryType(
			HashMap<String, HashMap<String, Float>> totalCreditCardExpenseByCategoryType) {
		this.totalCreditCardExpenseByCategoryType = totalCreditCardExpenseByCategoryType;
	}
	public HashMap<String, HashMap<String,Float>> getTotalCreditCardExpenseByCategory() {
		return totalCreditCardExpenseByCategory;
	}
	public void setTotalCreditCardExpenseByCategory(HashMap<String, HashMap<String,Float>> totalCreditCardExpenseByCategory) {
		this.totalCreditCardExpenseByCategory = totalCreditCardExpenseByCategory;
	}
	public HashMap<String, HashMap<String,Float>> getTotalExpenseByCategory() {
		return totalCheckingExpenseByCategory;
	}
	public void setTotalExpenseByCategory(HashMap<String, HashMap<String,Float>> totalExpenseByCategory) {
		this.totalCheckingExpenseByCategory = totalExpenseByCategory;
	}
	HashMap<String,HashMap<String,Float>> totalByCategory;
	float totalCashWithdrawal;
	public float getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(float totalIncome) {
		this.totalIncome = totalIncome;
	}
	public HashMap<String, HashMap<String,Float>> getTotalIncomeByCategory() {
		return totalIncomeByCategory;
	}
	public void setTotalIncomeByCategory(HashMap<String, HashMap<String,Float>> totalIncomeByCategory) {
		this.totalIncomeByCategory = totalIncomeByCategory;
	}
	public float getTotalCreditCardExpense() {
		return totalCreditCardExpense;
	}
	public void setTotalCreditCardExpense(float totalCreditCardExpense) {
		this.totalCreditCardExpense = totalCreditCardExpense;
	}
	public HashMap<String, HashMap<String,Float>> getTotalByCategory() {
		return totalByCategory;
	}
	public void setTotalByCategory(HashMap<String, HashMap<String,Float>> totalByCategory) {
		this.totalByCategory = totalByCategory;
	}
	public float getTotalCashWithdrawal() {
		return totalCashWithdrawal;
	}
	public void setTotalCashWithdrawal(float totalCashWithdrawal) {
		this.totalCashWithdrawal = totalCashWithdrawal;
	}
	

}
