import org.example.classes.CurrentAccount;
import org.example.classes.SavingsAccount;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountIT {

    @Test
    public void testDepositAndWithdrawSavingsAccount() throws Exception {
        SavingsAccount savings = new SavingsAccount("12345", 5000);
        savings.deposit(1000);
        assertEquals(6000, savings.getBalance(), 0);
        savings.withdraw(500);
        assertEquals(5500, savings.getBalance(), 0);
    }

    @Test
    public void testWithdrawExceededLimitSavingsAccount() {
        try {
            SavingsAccount savings = new SavingsAccount("12345", 5000);
            savings.withdraw(6000);
            fail("Expected Exception not thrown");
        } catch (Exception e) {
            assertEquals("You don't have enough balance", e.getMessage());
        }
    }

    @Test
    public void testInterestCalculation() {
        SavingsAccount savings = new SavingsAccount("12345", 5000);
        savings.addInterest();
        assertEquals(5150, savings.getBalance(), 0);
    }

    @Test
    public void testOverdraftCurrentAccount() throws Exception {
        CurrentAccount current = new CurrentAccount("67890", 3000);
        current.withdraw(12000);  // Should allow overdraft
        assertEquals(-9000, current.getBalance(), 0);
    }
}
