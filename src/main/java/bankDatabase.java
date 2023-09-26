import java.util.ArrayList;

public class bankDatabase {

    public static ArrayList<bankUser> allBankUserList = new ArrayList<bankUser>();

    //public static int bankDatabaseSize = bankDatabase.allBankUserList.size();

   public static void initialize() {
    
    bankUser Admin = new bankUser(1000, 1000, "John", "Smith");
    bankUser Admin2 = new bankUser(4564, 1245, "John", "Apple");

    communityAccount account01 = new communityAccount(1000, "1111");
    smallBusinessAccount account02 = new smallBusinessAccount(1000, "2222");
    //clientAccount account03 = new clientAccount(1000, "3333");

    communityAccount account04 = new communityAccount(1000, "4444");
    smallBusinessAccount account05 = new smallBusinessAccount(1000, "5555");
    clientAccount account06 = new clientAccount(1000, "6666");

    Admin.accounts.add(account01);
    Admin.accounts.add(account02);
    //Admin.accounts.add(account03);
    Admin2.addAccount(account04, "Community");
    Admin2.addAccount(account05, "Small Business");
    Admin2.addAccount(account06, "Client");

    allBankUserList.add(Admin);
    allBankUserList.add(Admin2);
    }   

    // add user account
    public void addUser(bankUser user){
        allBankUserList.add(user);
    }

    // User login validation
    public static int findTargetUserID(int targetUserId) {
        for (int i = 0; i < allBankUserList.size(); i++) {
            if (allBankUserList.get(i).userID == targetUserId) {
                return i; // Found the user, return the index
            }
        }
        return -1000; // User not found, return -1000
    }
        
        
    }
    


