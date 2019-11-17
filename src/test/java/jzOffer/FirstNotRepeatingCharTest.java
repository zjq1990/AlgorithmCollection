package jzOffer;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstNotRepeatingCharTest {

    @Test
    public void firstNotRepeatingChar_solution() {
        String str= "googgle";
        FirstNotRepeatingChar solution = new FirstNotRepeatingChar();
        int index = solution.FirstNotRepeatingChar_solution(str);
        System.out.println(index);
    }

    @Test
    public void firstNotRepeatingChar_solution1() {
        String str= "googgle";
        FirstNotRepeatingChar solution = new FirstNotRepeatingChar();
        int index = solution.FirstNotRepeatingChar_solution1(str);
        System.out.println(index);
    }
}