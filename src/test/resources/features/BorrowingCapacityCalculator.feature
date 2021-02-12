@smoke

Feature: Home Loan Borrowing Capacity Calculator

 Scenario Outline: Calculate Borrowing Capacity
    Given User is on how much could I borrow page 
     When User enters borrowing calculation details "<App type>" "<Dependants>" "<Property type>" "<Income>" "<Other Income>" "<Expenses>" "<Home loan repayments>" "<Other loan repayments>" "<Commitments >" "<Credit card limits>"
     And I click on how much I could borrow button
     Then I validate borrowing capacity details

     
	
    Examples: 
		|App type|Dependants  |Property type   | Income |Other Income| Expenses | Home loan repayments | Other loan repayments | Commitments | Credit card limits |
		| Single |0           |Home to live in | 80000  | 10000 	 |       500 |           0 		   |       100             |		0	 |10000 				  |

  	
 Scenario Outline: Validate start over button functionality
    Given User is on how much could I borrow page 
     When User enters borrowing calculation details "<App type>" "<Dependants>" "<Property type>" "<Income>" "<Other Income>" "<Expenses>" "<Home loan repayments>" "<Other loan repayments>" "<Commitments >" "<Credit card limits>"
     And I click on how much I could borrow button
     And I click on start over button
     Then I validate for reset calculation details
     
     Examples: 
		|App type|Dependants  |Property type   | Income |Other Income| Expenses | Home loan repayments | Other loan repayments | Commitments | Credit card limits |
		| Single |0           |Home to live in | 80000  | 10000 	 |       500 |           0 		   |       100             |		0	 |10000 				  |

  	