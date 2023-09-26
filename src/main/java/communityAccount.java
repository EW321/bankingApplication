public class communityAccount extends bankAccount {
 
     //Constructor
     public communityAccount(double balance, String accountNumber){
         super(balance, accountNumber);
         this.overdraftLimit = -2500;
         this.accountType = "Community";

     }
 
    }