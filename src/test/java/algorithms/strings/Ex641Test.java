package test.java.strings;

import main.java.strings.Ex641;
import org.junit.Assert;
import org.junit.Test;

public class Ex641Test {
    @Test
    public void testGetHappyTicketSuccessful(){
        Assert.assertEquals("9955", Ex641.getHappyTicket("995051"));
        Assert.assertEquals("2", Ex641.getHappyTicket("102"));
        Assert.assertEquals("11234560", Ex641.getHappyTicket("1010234560"));
        Assert.assertEquals("90", Ex641.getHappyTicket("1900"));
        Assert.assertEquals("9900", Ex641.getHappyTicket("396900"));
        Assert.assertEquals("999", Ex641.getHappyTicket("89999"));
    }
}
