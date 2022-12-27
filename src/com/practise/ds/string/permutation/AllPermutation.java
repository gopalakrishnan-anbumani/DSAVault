//https://www.interviewcake.com/question/java/recursive-string-permutations
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class AllPermutation {

    public static Set<String> getPermutations(String inputString) {

        // generate all permutations of the input string
        Set<String> hs = new HashSet<String>();        
        
        perm("",inputString, hs);
        
        return hs;
    }
    public static void perm(String neww, String old, Set<String> hs) {
        
        if(old.length() < 1){
            hs.add(neww);
            return;
        }
        for(int i=0;i<old.length();i++){
            perm(neww+old.charAt(i) , old.substring(0,i) + old.substring(i+1), hs);
        }
        
    }


    // tests

    @Test
    public void emptyStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList(""));
        final Set<String> actual = getPermutations("");
        assertEquals(expected, actual);
    }

    @Test
    public void oneCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("a"));
        final Set<String> actual = getPermutations("a");
        assertEquals(expected, actual);
    }

    @Test
    public void twoCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("ab", "ba"));
        final Set<String> actual = getPermutations("ab");
        assertEquals(expected, actual);
    }

    @Test
    public void threeCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("abc", "acb", "bac", "bca",
                                                                 "cab", "cba"));
        final Set<String> actual = getPermutations("abc");
        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
