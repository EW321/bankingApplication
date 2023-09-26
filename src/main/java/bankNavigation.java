import java.util.Scanner;
import java.util.Random;

public class bankNavigation {

    private static Scanner scanner = new Scanner(System.in);
    static int indexLoginCheck;

    public static void main(String[] args) {
        bankDatabase.initialize();
        showLoginScreen();
    }

    private static void showLoginScreen() {
        System.out.println("Welcome to Mobile Banking");
        System.out.print("Enter your user ID: ");
        int userIDInput = scanner.nextInt();
        System.out.print("Enter your pin: ");
        int userPinInput = scanner.nextInt();

        indexLoginCheck = bankDatabase.findTargetUserID(userIDInput);

        if (indexLoginCheck == -1000) {
            System.out.println("User not found.");
        } else {
            System.out.println("User ID Accepted");
        }

        if (userPinInput == (bankDatabase.allBankUserList.get(indexLoginCheck).userPin)) {
            showMainMenu();
        } else {
            System.out.println("Invalid credentials. Please try again.");
            showLoginScreen();
        }
    }

    private static void showMainMenu() {
        System.out.println("Main Menu");
        System.out.println("1. Manage Accounts");
        System.out.println("2. Create New Bank Account");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                manageAccountsMenu();
                break;
            case 2:
                createNewAccountMenu();
                break;
            case 3:
                System.out.println("Thank you for using Mobile Banking. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                showMainMenu();
        }
    }

    private static void manageAccountsMenu(){
        System.out.println("Manage Accounts");
        for (int i = 0; i < bankDatabase.allBankUserList.get(indexLoginCheck).accounts.size(); i++) {
            System.out.println((i+1)+". "+ bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(i).accountType);
       }
       System.out.println("4. Return to Main Menu");
       System.out.println("5. Exit");
       System.out.print("Enter your choice: ");
        int choicemanageAccountsMenu = scanner.nextInt();

        switch (choicemanageAccountsMenu) {
            case 1:
                manageCommunityAccountMenu();
                break;
            case 2:
              manageSmallBusinessAccountMenu();
                break;
            case 3:
                manageClientAccountMenu();
                break;
            case 4:
                showMainMenu();
                break;
            case 5:
                System.out.println("Thank you for using Mobile Banking. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                manageAccountsMenu();
        }
    }

    private static void manageCommunityAccountMenu() {

        System.out.println("Manage Community Account");
        System.out.println("1. Make a Deposit");
        System.out.println("2. Make a Withdrawal");
        System.out.println("3. Make a Transfer");
        System.out.println("4. Check Balance");
        System.out.println("5. Return to Manage Accounts Menu");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        int choiceCommunityAccountMenu = scanner.nextInt();

        // Find index of client account in User accounts list
        int indexFrom = -1;
        String accountTransferFrom = "Community";
        for (int i = 0; i < bankDatabase.allBankUserList.get(indexLoginCheck).accounts.size(); i++) {
            String accountTypeTransferFrom = bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(i).accountType;

            if (accountTransferFrom.equals(accountTypeTransferFrom)) {
                indexFrom = i;
            }
        }

         switch (choiceCommunityAccountMenu) {
            case 1:
            System.out.println("Enter Deposit Amount:");
            double deposit = scanner.nextDouble();
            bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(indexFrom).depositMoney(deposit);
            System.out.println("Balance after Deposit: " +  bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(indexFrom).balance);
            manageCommunityAccountMenu();
                break;
            case 2:
            System.out.println("Do you have required second signatory to complete this action?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int optionCommunityAccountMenuWithdraw = scanner.nextInt();
            switch (optionCommunityAccountMenuWithdraw){
                case 1:
                 System.out.println("Enter Withdrawal Amount:");
            double withdrawal = scanner.nextDouble();
            bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(indexFrom).withdrawMoneyWithMessage(withdrawal); // index 2
            System.out.println("Balance after Deposit: " +  bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(indexFrom).balance); // index 2
            manageCommunityAccountMenu();
                break;

                case 2:
            System.out.println("Please visit our website to see requirements to perform actions to your Community Account");
            manageCommunityAccountMenu();
                break;

                default:
            System.out.println("Invalid choice. Please try again.");
            manageCommunityAccountMenu();
            }
            break;

            case 3:
            System.out.println("Do you have required second signatory to complete this action?");
            System.out.println("1. Yes");
            System.out.println("2. No");
            int optionCommunityAccountMenuTransfer = scanner.nextInt();
            switch (optionCommunityAccountMenuTransfer){
                case 1:
                System.out.println("Enter Transfer Amount:");
                double transferAmount = scanner.nextDouble();
                System.out.println("Enter Account to Transfer to:");
                System.out.println("1. Small Business");
                System.out.println("2. Client");
                int accountOptionInput = scanner.nextInt();
                String accountTransferTo = "Initialise";
                if (accountOptionInput == 1){
                 accountTransferTo = "Small Business";
                 }
                else if (accountOptionInput == 2){
                 accountTransferTo = "Client";
                }
                else{
                manageCommunityAccountMenu();
                }
                bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(indexFrom).transferMoney(accountTransferFrom, accountTransferTo, indexFrom , transferAmount, indexLoginCheck);
                manageCommunityAccountMenu();
                break;

                case 2:
            System.out.println("Please visit our website to see requirements to perform actions to your Community Account");
            manageCommunityAccountMenu();
            break;

                default:
            System.out.println("Invalid choice. Please try again.");
            manageCommunityAccountMenu();
            }
                break;
            case 4:
            System.out.println("Balance in Account: " + bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(indexFrom).balance);
            manageCommunityAccountMenu();
                break;
            case 5:
            manageAccountsMenu();
                break;
            case 6:
                System.out.println("Thank you for using Mobile Banking. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                manageAccountsMenu();
        }
    }

    private static void manageSmallBusinessAccountMenu() {
        System.out.println("Manage Small Business Account");
        System.out.println("1. Make a Deposit");
        System.out.println("2. Make a Withdrawal");
        System.out.println("3. Make a Transfer");
        System.out.println("4. Check Balance");
        System.out.println("5. Return to Manage Accounts Menu");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        // Find index of client account in User accounts list
        int indexFrom = -1;
        String accountTransferFrom = "Small Business";
        for (int i = 0; i < bankDatabase.allBankUserList.get(indexLoginCheck).accounts.size(); i++) {
            String accountTypeTransferFrom = bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(i).accountType;

            if (accountTransferFrom.equals(accountTypeTransferFrom)) {
                indexFrom = i;
            }
        }

         switch (choice) {
            case 1:
            System.out.println("Enter Deposit Amount:");
            double deposit = scanner.nextDouble();
            bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(indexFrom).depositMoney(deposit);
            System.out.println("Balance after Deposit: " +  bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(indexFrom).balance);
            manageSmallBusinessAccountMenu();
                break;
            case 2:
              System.out.println("Enter Withdrawal Amount:");
            double withdrawal = scanner.nextDouble();
            bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(indexFrom).withdrawMoneyWithMessage(withdrawal); // index 2
            System.out.println("Balance after Withdrawal: " +  bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(indexFrom).balance); // index 2
            manageSmallBusinessAccountMenu();
                break;
            case 3:
            System.out.println("Enter Transfer Amount:");
            double transferAmount = scanner.nextDouble();
            System.out.println("Enter Account to Transfer to: 1. Client   2.Community");
            int accountOptionInput = scanner.nextInt();
            String accountTransferTo = "Initialise";
            if (accountOptionInput == 1){
                accountTransferTo = "Client";
            }
            else if (accountOptionInput == 2){
                accountTransferTo = "Community";
            }
            else{
            manageSmallBusinessAccountMenu();
            }
            bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(indexFrom).transferMoney(accountTransferFrom, accountTransferTo, indexFrom , transferAmount, indexLoginCheck);
            manageSmallBusinessAccountMenu();
                break;
            case 4:
            System.out.println("Balance in Account: " + bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(indexFrom).balance);
            manageSmallBusinessAccountMenu();
                break;
            case 5:
            manageAccountsMenu();
                break;
            case 6:
                System.out.println("Thank you for using Mobile Banking. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                manageAccountsMenu();
        }

    }

     private static void manageClientAccountMenu() {
        System.out.println("Manage Client Account");
        System.out.println("1. Make a Deposit");
        System.out.println("2. Make a Withdrawal");
        System.out.println("3. Make a Transfer");
        System.out.println("4. Check Balance");
        System.out.println("5. Return to Manage Accounts Menu");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        // Find index of client account in User accounts list
        int indexFrom = -1;
        String accountTransferFrom = "Client";
        for (int i = 0; i < bankDatabase.allBankUserList.get(indexLoginCheck).accounts.size(); i++) {
            String accountTypeTransferFrom = bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(i).accountType;

            if (accountTransferFrom.equals(accountTypeTransferFrom)) {
                indexFrom = i;
            }
        }

         switch (choice) {
            case 1:
            System.out.println("Enter Deposit Amount:");
            double deposit = scanner.nextDouble();
            bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(indexFrom).depositMoney(deposit); // index 2
            System.out.println("Balance after Deposit: " +  bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(indexFrom).balance);
            manageClientAccountMenu();
                break;
            case 2:
              System.out.println("Enter Withdrawal Amount:");
            double withdrawal = scanner.nextDouble();
            bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(indexFrom).withdrawMoneyWithMessage(withdrawal); // index 2
            System.out.println("Balance after Withdrawal: " +  bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(indexFrom).balance); // index 2
            manageClientAccountMenu();
                break;
            case 3:
            System.out.println("Enter Transfer Amount:");
            double transferAmount = scanner.nextDouble();
            System.out.println("Enter Account to Transfer to: 1. Community   2.Small Business");
            int accountOptionInput = scanner.nextInt();
            String accountTransferTo = "Initialise";
            if (accountOptionInput == 1){
                accountTransferTo = "Community";
            }
            else if (accountOptionInput == 2){
                accountTransferTo = "Small Business";
            }
            else{
            manageClientAccountMenu();
            }
            bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(indexFrom).transferMoney(accountTransferFrom, accountTransferTo, indexFrom , transferAmount, indexLoginCheck);
            manageClientAccountMenu();
                break;
            case 4:
            System.out.println("Balance in Account: " + bankDatabase.allBankUserList.get(indexLoginCheck).accounts.get(indexFrom).balance);
            manageClientAccountMenu();
                break;
            case 5:
            manageAccountsMenu();
                break;
            case 6:
                System.out.println("Thank you for using Mobile Banking. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                manageAccountsMenu();
        }

    }

     private static void createNewAccountMenu() {
        System.out.println("Select Account to create");
        System.out.println("1. Community");
        System.out.println("2. Small Business");
        System.out.println("3. Client");
        System.out.println("4. Return to Account Management");
        System.out.println("5. Exit Banking");
        int choice = scanner.nextInt();

        switch(choice) {

            case 1:
            createCommunityAccount();
            break;

            case 2:
            createSmallBusinessAccount();
            break;

            case 3:
            createClientAccount();
            break;

            case 4:
            manageAccountsMenu();

            case 5:
            System.out.println("Thank you for using Mobile Banking. Goodbye!");
                System.exit(0);
            break;

            default:
                System.out.println("Invalid choice. Please try again.");
                createNewAccountMenu();
        }

    }

    private static void createClientAccount() {
        double balance = 0;
        String accountType = "Client";
        Random random = new Random();
        int randFourDigitNumber = random.nextInt(9000) + 1000; // Generates a 4-digit number
        String accountNumber = String.valueOf(randFourDigitNumber);

        bankDatabase.allBankUserList.get(indexLoginCheck).addAccount(new clientAccount(balance, accountNumber), accountType);
        createNewAccountMenu();
    }

    private static void createSmallBusinessAccount() {
        double balance = 0;
        String accountType = "Small Business";
        Random random = new Random();
        int randFourDigitNumber = random.nextInt(9000) + 1000; // Generates a 4-digit number
        String accountNumber = String.valueOf(randFourDigitNumber);

        bankDatabase.allBankUserList.get(indexLoginCheck).addAccount(new smallBusinessAccount(balance, accountNumber), accountType);
        createNewAccountMenu();
    }

    private static void createCommunityAccount() {
        double balance = 0;
         String accountType = "Community";
        Random random = new Random();
        int randFourDigitNumber = random.nextInt(9000) + 1000; // Generates a 4-digit number
        String accountNumber = String.valueOf(randFourDigitNumber);
        System.out.println("Do you have the required second signatory?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int input = scanner.nextInt();
        if (input == 2){
            System.out.println("See our website for requirements to open a Community Account");
        }
        else if (input == 1){
            bankDatabase.allBankUserList.get(indexLoginCheck).addAccount(new communityAccount(balance, accountNumber), accountType);
            System.out.println(" Community Account created");
        }
        else {
            System.out.println("Invalid input, please try again");
            createCommunityAccount();

        }
        createNewAccountMenu();
    }

    }

    

