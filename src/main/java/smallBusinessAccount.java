public class smallBusinessAccount extends bankAccount {

     //Constructor
     public smallBusinessAccount(double balance, String accountNumber){
        super(balance, accountNumber);
        this.overdraftLimit = -1000;
        this.accountType = "Small Business";

    }
    
}
    
