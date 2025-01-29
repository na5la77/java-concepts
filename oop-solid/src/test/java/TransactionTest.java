
import org.example.classes.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransactionTest {

    private BankAccount savingsAccount;
    private BankAccount currentAccount;

    @BeforeEach
    public void setup() {
        savingsAccount = new SavingsAccount("12345", 5000);
        currentAccount = new CurrentAccount("67890", 3000);
    }

    @Test
    public void testDepositTransaction() throws Exception {
        DepositTransaction deposit = new DepositTransaction(savingsAccount, 1000);
        deposit.execute();

        assertEquals(6000, savingsAccount.getBalance(), "Balance should be 6000 after deposit");

        deposit.undo();

        assertEquals(5000, savingsAccount.getBalance(), "Balance should revert to 5000 after undo");
    }

    @Test
    public void testWithdrawTransaction() throws Exception {
        WithdrawTransaction withdraw = new WithdrawTransaction(savingsAccount, 500);

        withdraw.execute();

        assertEquals(4500, savingsAccount.getBalance(), "Balance should be 4500 after withdrawal");

        withdraw.undo();

        assertEquals(5000, savingsAccount.getBalance(), "Balance should revert to 5000 after undo");
    }

    @Test
    public void testWithdrawTransactionWithLimit() throws Exception {
        WithdrawTransaction withdraw = new WithdrawTransaction(currentAccount, 3500);

        withdraw.execute();

        assertEquals(-500, currentAccount.getBalance(), "Balance should be -500 after overdraft");

        withdraw.undo();

        assertEquals(3000, currentAccount.getBalance(), "Balance should revert to 3000 after undo");
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        WithdrawTransaction withdraw = new WithdrawTransaction(savingsAccount, 6000);

        Exception exception = assertThrows(Exception.class, withdraw::execute);

        assertEquals("You don't have enough balance", exception.getMessage());
    }
}
