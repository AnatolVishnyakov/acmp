package main.java.strings;

import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Ticket {
    private static final int BOUND_END = 2;
    private static final int SKIP_VALUE = 0;
    private final String ticketNumber;

    public Ticket(String number) {
        ticketNumber = number;
    }

    private Deque<Integer> prepareTicketFormat() {
        Deque<Integer> ticket = new LinkedList<>();
        for (int i = 0; i < ticketNumber.length(); i++) {
            int value = Character.getNumericValue(ticketNumber.charAt(i));
            if(value != SKIP_VALUE){
                ticket.addFirst(value);
            }
        }
        return ticket;
    }

    // 11111 1111 9 - YES
    // 9 1111 11111 - YES
    private boolean runAnalyzeTicket(Deque<Integer> deque) {
        if(deque.size() < 2){
            return false;
        }

        int left = 0;
        int right = 0;
        while(deque.size() != 2){
            int l = ((LinkedList<Integer>) deque).get(deque.size() - 1) + ((LinkedList<Integer>) deque).get(deque.size() - 2);
            if(left <= right && l != 10){
                left = deque.pollFirst() + deque.pollFirst();
                if(left == 10){
                    deque.addFirst(1);
                } else if(left > 10){
                    deque.addFirst(left % 10);
                    deque.addFirst(left / 10);
                } else {
                    deque.addFirst(left);
                }
            } else {
                right = deque.pollLast() + deque.pollLast();
                if(right == 10){
                    deque.addLast(1);
                } else if(right > 10){
                    deque.addLast(right / 10);
                    deque.addLast(right % 10);
                } else {
                    deque.addLast(right);
                }
            }
        }
        left = deque.pollFirst();
        right = deque.pollLast();

        return left == right;
    }

    private boolean handleTicket() {
        Deque<Integer> deque = prepareTicketFormat();
        return runAnalyzeTicket(deque);
    }

    public boolean isHappy(){
        return handleTicket();
    }
}

public class Ex164 {
    private static final Scanner in = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static boolean isHappyTicket(String number){
        Ticket ticket = new Ticket(number);
        return ticket.isHappy();
    }

    public static void main(String[] args) {
        String input = in.nextLine();
        if(isHappyTicket(input)){
            out.print(YES);
        } else {
            out.print(NO);
        }

        out.flush();
    }
}
