import org.junit.*;
import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.assertEquals;


public class bankAccountTest {

    @Test
    public void testAccountBalance0(){

        bankAccount account01 = new bankAccount(0, "Community");
        assertEquals(0 , account01.balance,0);
    }

      @Test
    public void testAccountBalance1000(){

        bankAccount account01 = new bankAccount(1000, "Community");
        assertEquals(1000 , account01.balance,0);
    }

        @Test
    public void testAccountBalanceMinus1000(){

        bankAccount account01 = new bankAccount(-1000, "Community");
        assertEquals(-1000 , account01.balance,0);
    }

    @Test
    public void testAccountTypeCommunity(){

        bankAccount account01 = new bankAccount(0, "Community");
        assertEquals("Community" , account01.accountType);
    }

      @Test
    public void testDeposit1000(){

        bankAccount account01 = new bankAccount(0, "Community");
        account01.depositMoney(1000);
        assertEquals(1000 , account01.balance, 0);
    }

    @Test
    public void testWithdraw1000(){

        bankAccount account01 = new bankAccount(1000, "Community");
        account01.withdrawMoneyWithMessage(1000);
        assertEquals(0 , account01.balance, 0);
    }

     @Test
    public void testDoubleDeposit1000(){

        bankAccount account01 = new bankAccount(0, "Community");
        account01.depositMoney(1000);
        account01.depositMoney(1000);
        assertEquals(2000 , account01.balance, 0);
    }

    // Testing different account types

     @Test
    public void testWithdrawMoreThanOverdraftLimitSmallBusiness(){

        bankAccount account01 = new bankAccount(0, "Small Business");
        assertEquals("Overdraft Exceeded" , account01.withdrawMoneyWithMessage(1001));
    }

    
      @Test
    public void testWithdrawEqualOverdraftLimitSmallBusiness(){

        bankAccount account01 = new bankAccount(0, "Small Business");
        assertEquals("Overdraft limit met" , account01.withdrawMoneyWithMessage(1000));
    }
    
       @Test
    public void testWithdrawMoreThanOverdraftLimitCommunity(){

        bankAccount account01 = new bankAccount(0, "Community");
        assertEquals("Overdraft Exceeded" , account01.withdrawMoneyWithMessage(2501));
    }

    @Test
    public void testWithdrawEqualOverdraftLimitCommunity(){

        bankAccount account01 = new bankAccount(0, "Community");
        assertEquals("Overdraft limit met" , account01.withdrawMoneyWithMessage(2500));
    }

        @Test
    public void testWithdrawMoreThanOverdraftLimitClient(){

        bankAccount account01 = new bankAccount(0, "Client");
        assertEquals("Overdraft Exceeded" , account01.withdrawMoneyWithMessage(1501));
    }

    @Test
    public void testWithdrawEqualOverdraftLimitClient(){

        bankAccount account01 = new bankAccount(0, "Client");
        assertEquals("Overdraft limit met" , account01.withdrawMoneyWithMessage(1500));
    }


     @Test
    public void testWithdrawEqualOverdraftLimitCommunityAccount(){

        communityAccount account01 = new communityAccount(0);
        assertEquals("Overdraft limit met" , account01.withdrawMoneyWithMessage(2500));
    }

      @Test
    public void testWithdrawOverOverdraftLimitCommunityAccount(){

        communityAccount account01 = new communityAccount(0);
        assertEquals("Overdraft Exceeded" , account01.withdrawMoneyWithMessage(3000));
        assertEquals(0, account01.balance,0);
    }

       @Test
    public void testWithdrawOverOverdraftLimitCommunityAccountBalance(){

        communityAccount account01 = new communityAccount(0);
        assertEquals(0, account01.balance,0);
    }
    


}
