Feature: AddOwner
#This is how background can be used to eliminate duplicate steps
Scenario:
Given I am on petclinic Add owner page
When I Entered valid data on page
| Fields                 | Values              |
| First Name             | Jow                 |
| Last Name              | Root                   |
| Address          	    | S.P road 		    |
| City			    | GA			    |
| Telephone              | 54                 |
Then New owner registered scuccessfully