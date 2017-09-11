<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Light Bootstrap Dashboard by Creative Tim</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="assets/css/light-bootstrap-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
</head>
<body>


        <div class="content">
            <div class="container-fluid">
                <div class="row">
                  <div class="col-md-6">
                   <div class="card">
                  <div class="header">
                                <h4 class="title">Financial</h4>
                                <p class="category">Total Income ${transactionSummary.totalIncome}</p>
                                <p class="category">Total Checking Expense ${transactionSummary.totalDebitCardExpense}</p>
								<p class="category">Total Credit Card Expense ${transactionSummary.totalCreditCardExpense}</p>
								<p class="category">Net saving ${transactionSummary.totalIncome-(transactionSummary.totalCreditCardExpense+transactionSummary.totalDebitCardExpense)}</p>
						
                                
                            </div>
                            </div>
                  </div>
                </div>
                   <div class="row">
                
                <div class="col-md-6">
                        <div class="card">
                            
  							  <div>
                            <div class="header">
                                <h4 class="title">Total Income</h4>
                                <p class="category">${transactionSummary.totalIncome}</p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped">
                                    <thead>
                                        <th>Category</th>
											<c:forEach var="columnHeader" items="${transactionSummary.months}">
											    <th>
											        <c:out value="${columnHeader}" />
											    </th>
											</c:forEach>
										</thead>
                                    <tbody>
                                    
                                    <tr>
                                 
                                        
                                        <td>Total Income</td>                                        	
                                        	<c:forEach var="columnHeader" items="${transactionSummary.months}">
											 
											    											    <td>
											   	 <c:set var="myParam" value="${columnHeader}"/>
											         <c:out value="${transactionSummary.monthlyTotalIncome[myParam]}"/>
											    </td>
											</c:forEach>
										 </tr>
										 <tr>

                                        <td>Total Debit Expense</td>                                        	
                                        	<c:forEach var="columnHeader" items="${transactionSummary.months}">
											 
											    											    <td>
											   	 <c:set var="myParam" value="${columnHeader}"/>
											   		<fmt:formatNumber var="formattedAmount" type="number" minFractionDigits="2" maxFractionDigits="2" value="${transactionSummary.monthlyTotalDebitExpense[myParam]}"/>
													<c:out value="${formattedAmount}"/>	
											   
											    </td>
											</c:forEach>
                                         </tr>                                 
                                              <tr>
                                 
                                        
                                        <td>Total Credit Expense</td>                                        	
                                        	<c:forEach var="columnHeader" items="${transactionSummary.months}">
											 
											    											    <td>
											   	 <c:set var="myParam" value="${columnHeader}"/>
											   	 <fmt:formatNumber var="formattedAmount" type="number" minFractionDigits="2" maxFractionDigits="2" value="${transactionSummary.monthlyTotalCreditExpense[myParam]}" />
													<c:out value="${formattedAmount}"/>			
											   	 
											    </td>
											</c:forEach>

                                        </tr>
 										<tr>
 
                                        <td>Total Expense</td>                                        	
                                        	<c:forEach var="columnHeader" items="${transactionSummary.months}">
										    <td>
											   	 <c:set var="myParam" value="${columnHeader}"/>
											   	 <fmt:formatNumber var="formattedAmount" type="number" minFractionDigits="2" maxFractionDigits="2" value="${transactionSummary.monthlyTotalCreditExpense[myParam]+transactionSummary.monthlyTotalDebitExpense[myParam]}" />
													<c:out value="${formattedAmount}"/>											   	 
											    </td>
											</c:forEach>
                                        </tr>
                                        
                                     	<tr>
 
                                        <td>Saving</td>                                        	
                                        	<c:forEach var="columnHeader" items="${transactionSummary.months}">
										    <td>
											   	 <c:set var="myParam" value="${columnHeader}"/>
											   	 <fmt:formatNumber var="formattedAmount" type="number" minFractionDigits="2" maxFractionDigits="2" value="${transactionSummary.monthlyTotalIncome[myParam]-(transactionSummary.monthlyTotalCreditExpense[myParam]+transactionSummary.monthlyTotalDebitExpense[myParam])}" />

											         <c:out value="${formattedAmount}"/>
											    </td>
											</c:forEach>
                                        </tr>   
                                        
                                        
                                        
                                     <c:forEach items="${transactionSummary.totalIncomeByCategory}" var="transaction">
                                    
                                        <tr>
                                        	<td>${transaction.key}</td>
                                        	
                                        	<c:forEach var="columnHeader" items="${transactionSummary.months}">
											    <td>
											   	 <c:set var="myParam" value="${columnHeader}"/>
											   	 	<fmt:formatNumber var="formattedAmount" type="number" minFractionDigits="2" maxFractionDigits="2" value="${transaction.value[myParam]}" />

											         <c:out value="${formattedAmount}"/>
									
											    </td>
											</c:forEach>
                                        
                                        
                                        
                                        </tr>
                                  
                                  	</c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                        </div>
                    </div>
                  
                   <div class="col-md-6">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Debit Expenses</h4>
                                <p class="category">Total  ${transactionSummary.totalDebitCardExpense}</p>
                       
                                
                            </div>
  							  <div>

                        <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped">
                                    <thead>
                                        <th>Category</th>
											<c:forEach var="columnHeader" items="${transactionSummary.months}">
											    <th>
											        <c:out value="${columnHeader}" />
											    </th>
											</c:forEach>
										</thead>
                                    <tbody>
                                    
                                      <tr>
                                 
                                        
                                        <td>Totals</td>                                        	
                                        	<c:forEach var="columnHeader" items="${transactionSummary.months}">
											 
											    											    <td>
											   	 <c:set var="myParam" value="${columnHeader}"/>

											   <fmt:formatNumber var="formattedAmount" type="number" minFractionDigits="2" maxFractionDigits="2" value="${transactionSummary.monthlyTotalDebitExpense[myParam]}" />

											         <c:out value="${formattedAmount}"/>
											   
											    </td>
											</c:forEach>
    									</tr>
                                    
                                    
                                     <c:forEach items="${transactionSummary.totalByCategory}" var="transaction">
                                    
                                        <tr>
                                        	<td>${transaction.key}</td>
                                        	
                                        	<c:forEach var="columnHeader" items="${transactionSummary.months}">
											    <td>
											   	 <c:set var="myParam" value="${columnHeader}"/>
											   	 
											   	 <fmt:formatNumber var="formattedAmount" type="number" minFractionDigits="2" maxFractionDigits="2" value="${transaction.value[myParam]}" />

											         <c:out value="${formattedAmount}"/>
											    </td>
											</c:forEach>
                                        
                                        
                                        
                                        </tr>
                                  
                                  	</c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                        </div>
                    </div>
                
                   
                



 			


                </div>
                
                
                  <div class="row">
                  
                     <div class="col-md-6">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Total Credit Expense</h4>
                                   
                            </div>
  							  <div>

                             <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped">
                                    <thead>
                                        <th>Category</th>
											<c:forEach var="columnHeader" items="${transactionSummary.months}">
											    <th>
											        <c:out value="${columnHeader}" />
											    </th>
											</c:forEach>
										</thead>
                                    <tbody>
                                    
                                   <tr>

                                        <td>Totals</td>                                        	
                                        	<c:forEach var="columnHeader" items="${transactionSummary.months}">
											 
											    											    <td>
											   	 <c:set var="myParam" value="${columnHeader}"/>
											   
											    <fmt:formatNumber var="formattedAmount" type="number" minFractionDigits="2" maxFractionDigits="2" value="${transactionSummary.monthlyTotalCreditExpense[myParam]}" />

											         <c:out value="${formattedAmount}"/>
											   
											   
											    </td>
											</c:forEach>
    									</tr>
                                    
   
                                     <c:forEach items="${transactionSummary.totalCreditCardExpenseByCategory}" var="transaction">
                                    
                                        <tr>
                                        	<td>${transaction.key}</td>
                                        	
                                        	<c:forEach var="columnHeader" items="${transactionSummary.months}">
											    <td>
											   	 <c:set var="myParam" value="${columnHeader}"/>
											     <fmt:formatNumber var="formattedAmount" type="number" minFractionDigits="2" maxFractionDigits="2" value="${transaction.value[myParam]}" />

											         <c:out value="${formattedAmount}"/>
											         
											         
											         
											    </td>
											</c:forEach>
                                        
                                        
                                        
                                        </tr>
                                  
                                  	</c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                        </div>
                    </div>
                
                
                  <div class="col-md-6">
                        <div class="card">
                     
  							  <div>

                             <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped">
                                    <thead>
                                        <th>Category</th>
											<c:forEach var="columnHeader" items="${transactionSummary.months}">
											    <th>
											        <c:out value="${columnHeader}" />
											    </th>
											</c:forEach>
										</thead>
                                    <tbody>
                                    
                                   <tr>

                                        <td>Totals</td>                                        	
                                        	<c:forEach var="columnHeader" items="${transactionSummary.months}">
											 
											    											    <td>
											   	 <c:set var="myParam" value="${columnHeader}"/>
											   
											    <fmt:formatNumber var="formattedAmount" type="number" minFractionDigits="2" maxFractionDigits="2" value="${transactionSummary.monthlyTotalCreditExpense[myParam]}" />

											         <c:out value="${formattedAmount}"/>
											   
											   
											    </td>
											</c:forEach>
    									</tr>
                                    
   
                                     <c:forEach items="${transactionSummary.totalCreditCardExpenseByCategoryType}" var="transaction">
                                    
                                        <tr>
                                        	<td>${transaction.key}</td>
                                        	
                                        	<c:forEach var="columnHeader" items="${transactionSummary.months}">
											    <td>
											   	 <c:set var="myParam" value="${columnHeader}"/>
											     <fmt:formatNumber var="formattedAmount" type="number" minFractionDigits="2" maxFractionDigits="2" value="${transaction.value[myParam]}" />

											         <c:out value="${formattedAmount}"/>
											         
											         
											         
											    </td>
											</c:forEach>
                                        
                                        
                                        
                                        </tr>
                                  
                                  	</c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                        </div>
                    </div>
                
                
                  
                  </div>
                
                
                
            </div>
        </div>



</body>
</html>