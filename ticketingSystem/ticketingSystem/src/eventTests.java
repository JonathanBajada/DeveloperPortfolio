import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Rule.*ss;


import ../Backend;

public class eventTests {

    @Rule

    @Test
    public void shouldGetEventName(){

        static ArrayList<String> tickets = new ArrayList<String>();
        String event = "billy idol         admin           100 001.00";
        String eventName = "billy idol";
        tickets.add(event);
        Assert.assertTrue(Backend.getEventNames().equals(eventName));

    }
}
