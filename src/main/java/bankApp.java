
public class bankApp {
public static void main(String[] args) {

    communityAccount account01 = new communityAccount(1000, "1234");
    smallBusinessAccount account02 = new smallBusinessAccount(1000, "1242");
    clientAccount account03 = new clientAccount(4000, "4321");



    bankUser User1 = new bankUser(1234, 1234, "John", "Smith");

   bankDatabase bankDatabase = new bankDatabase();

    bankDatabase.addUser(User1);

    User1.addAccount(account01);
    User1.addAccount(account02);
    User1.addAccount(account03);

    System.out.println(User1.accounts);
    System.out.println(bankDatabase.allBankUserList.get(0));

    System.out.println(bankDatabase.allBankUserList.get(0).accounts.get(1).balance);
    System.out.println(bankDatabase.allBankUserList.get(0).userID);
    System.out.println(bankDatabase.allBankUserList.get(0).userPin);

    account01.depositMoney(1000);
    System.out.println(account01.balance);
    account01.depositMoney(1000);
    System.out.println(account01.balance);

    




    int size = bankDatabase.allBankUserList.size();

     System.out.println(size);


}

}