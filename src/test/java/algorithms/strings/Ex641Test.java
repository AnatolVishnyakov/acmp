package test.java.strings;

import main.java.strings.Ex641;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Ex641Test {
    @Test
    public void testGetHappyTicketSuccessful(){
        assertEquals("9955", Ex641.getHappyTicket("995051"));
        assertEquals("2", Ex641.getHappyTicket("102"));
        assertEquals("11234560", Ex641.getHappyTicket("1010234560"));
        assertEquals("90", Ex641.getHappyTicket("1900"));
        assertEquals("9900", Ex641.getHappyTicket("396900"));
        assertEquals("999", Ex641.getHappyTicket("89999"));
    }
}
