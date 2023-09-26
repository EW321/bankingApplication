import java.util.ArrayList;
import java.util.List;

public class bankUser {

    public int userID;
    public int userPin;
    private String userNameFirst;
    private String userNameLast;
    public List<bankAccount> accounts;

    public bankUser(int userID, int userPin, String userNameFirst, String userNameLast){

        this.userID = userID;
        this.userPin = userPin;
        this.userNameFirst = userNameFirst;
        this.userNameLast = userNameLast;
        accounts = new ArrayList<>();
    }

    public void addAccount(bankAccount account, String accountType) {
        // Limited to one of each account
        int outcome= 0;
        for (int i = 0; i < accounts.size(); i++){
            if (accounts.get(i).accountType.equals(accountType)){
                outcome = 1;
                break;
            }
            else{ 
                outcome = 2;
            }
        }
        if (outcome == 1){
            System.out.println(accountType + " Account already exists for this user. Try a different account Type.");
        }
        else if(outcome == 2){
            System.out.println(accountType + " Account created");
            accounts.add(account);
        }
        else{
            
        }
        
        
        
    }


    
}
