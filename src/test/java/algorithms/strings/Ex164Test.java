package algorithms.strings;

import org.junit.Test;

import static org.junit.Assert.*;
import static algorithms.strings.Ex164.isHappyTicket;


public class Ex164Test {

    @Test
    public void testIsHappyTicketSuccess(){
        assertTrue(isHappyTicket("0015420"));
        assertTrue(isHappyTicket("00015420"));
        assertTrue(isHappyTicket("162510021"));
        assertTrue(isHappyTicket("911"));
        assertTrue(isHappyTicket("119"));
        assertTrue(isHappyTicket("11111111111"));
        assertTrue(isHappyTicket("100001"));
        assertTrue(isHappyTicket("1001001001"));
        assertTrue(isHappyTicket("10203020301"));
        assertTrue(isHappyTicket("444444444444442"));
        assertTrue(isHappyTicket("12345"));
        assertTrue(isHappyTicket("00"));
        assertTrue(isHappyTicket("001236"));
        assertTrue(isHappyTicket("1111111119"));
        assertTrue(isHappyTicket("191111111111"));
        assertTrue(isHappyTicket("1111111111"));
        assertTrue(isHappyTicket("5555"));
        assertTrue(isHappyTicket("0000"));
        assertTrue(isHappyTicket("999"));
        assertTrue(isHappyTicket("910001"));
        assertTrue(isHappyTicket("99922"));
        assertTrue(isHappyTicket("111002200111"));
        assertTrue(isHappyTicket("999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"));
    }

    @Test
    public void testIsHappyTicketError(){
        assertFalse(isHappyTicket("00100"));
        assertFalse(isHappyTicket("1100003"));
        assertFalse(isHappyTicket("400100"));
        assertFalse(isHappyTicket("10101"));
    }
}
