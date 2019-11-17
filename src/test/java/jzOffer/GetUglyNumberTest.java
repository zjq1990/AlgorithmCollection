package jzOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class GetUglyNumberTest {

    @Test
    public void getUglyNumber_solution() {
        GetUglyNumber solution = new GetUglyNumber();
        int number = solution.getUglyNumber_solution(10);
        System.out.println(number);
    }

    @Test
    public void getUglyNumber_solution1() {
        GetUglyNumber solution = new GetUglyNumber();
        int number = solution.getUglyNumber_solution1(10);
        System.out.println(number);
    }
}