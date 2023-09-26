public class bankAccount {

    // Object variables
    double balance;
    String accountNumber;
    double overdraftLimit;
    String accountType;

    //Constructor
    public bankAccount(double balance, String accountNumber){
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void depositMoney(double deposit){
        if (deposit<= 0){
            System.out.println("Deposit value Declined");
        }

        else{
        this.balance = balance + deposit;
        }
    }

    public void withdrawMoneyWithMessage(double withdrawal){
        if (withdrawal <= 0){
            System.out.println("Withdrawal amount Declined");
        }

        else{

        balance = this.balance - withdrawal;
        
        if (balance < this.overdraftLimit){
                System.out.println("Overdraft Limit Exceeded, Action Declined");
                balance = this.balance + withdrawal;
            }

        else if (balance == overdraftLimit){
                System.out.println("Overdraft limit met");
            }

        else 
        System.out.println("Withdawal Complete");
        }
    }

    public void transferMoney(String accountTransferFrom, String accountTransferTo, int indexAccountTransferFrom, double transferAmount, int userIndex) {
        if (transferAmount <= 0) {
            System.out.println("Transfer amount Declined");
        } else {
            int indexTo = -1;
    
            for (int i = 0; i < bankDatabase.allBankUserList.get(userIndex).accounts.size(); i++) {
                String accountTypeTransferTo = bankDatabase.allBankUserList.get(userIndex).accounts.get(i).accountType;
    
                if (accountTransferTo.equals(accountTypeTransferTo)) {
                    indexTo = i;
                }
            }
    
            if (indexAccountTransferFrom == -1) {
                System.out.println("Transfer Failed, Source Account does not exist");
            } else if (indexTo == -1) {
                System.out.println("Transfer Failed, Target Account does not exist");
            } else if ((bankDatabase.allBankUserList.get(userIndex).accounts.get(indexAccountTransferFrom).balance - bankDatabase.allBankUserList.get(userIndex).accounts.get(indexAccountTransferFrom).overdraftLimit) < transferAmount){
                System.out.println("Transfer Amount Exceeds source Account Overdraft, Transfer Denied");
            } else {
                bankDatabase.allBankUserList.get(userIndex).accounts.get(indexTo).depositMoney(transferAmount);
                bankDatabase.allBankUserList.get(userIndex).accounts.get(indexAccountTransferFrom).withdrawMoneyWithMessage(transferAmount);

                
                System.out.println("Balance in Source Account after Transfer: " + bankDatabase.allBankUserList.get(userIndex).accounts.get(indexAccountTransferFrom).balance);
                System.out.println("Balance in " + accountTransferTo + " after Transfer: " + bankDatabase.allBankUserList.get(userIndex).accounts.get(indexTo).balance);
            }
        }
    }
    

}
