public class clientAccount extends bankAccount {

     //Constructor
     public clientAccount(double balance, String accountNumber){
        super(balance, accountNumber);
        this.overdraftLimit = -1500;
        this.accountType = "Client";

    }
    
}
