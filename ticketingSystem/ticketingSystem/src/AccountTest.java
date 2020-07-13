import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;

public class AccountTest extends Backend{

    @Test
    public void shouldGetAccountName(){
        String name = "billw           BS 000300.00";
        String nameTrue = "billw";
        accounts.add(name);
        Backend.getAccountNames();
        assertTrue(Backend.users.contains(nameTrue));
    }


}
