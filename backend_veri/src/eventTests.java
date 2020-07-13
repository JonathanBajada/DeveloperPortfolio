import org.junit.Assert;
import org.junit.Test;

import ../Backend;

public class eventTests {


    @Test
    public void shouldGetEventName(){

        static ArrayList<String> tickets = new ArrayList<String>();
        String event = "billy idol         admin           100 001.00";
        String eventName = "billy idol";
        tickets.add(event);
        Assert.assertTrue(Backend.getEventNames().equals(eventName));

    }
}
