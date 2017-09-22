// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED

import java.util.*;
import java.lang.*;

public class WordListOrder {
    //METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int canArrangeWords(String arr[]) {
        // INSERT YOUR CODE HERE
        HashMap<Character, HashSet<String>> fmap = new HashMap<>();
        HashMap<Character, HashSet<String>> lmap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            char f = arr[i].charAt(0);
            char l = arr[i].charAt(arr[i].length() - 1);
            HashSet<String> set;
            if (fmap.containsKey(f)) {
                set =  fmap.get(l);
                set.add(arr[i]);
                fmap.put(f, set);
            } else {
                set = new HashSet<>();
                set.add(arr[i]);
                fmap.put(f,set);
            }
            if (lmap.containsKey(l)) {
                set =  lmap.get(l);
                set.add(arr[i]);
                lmap.put(l,set);
            } else {
                set = new HashSet<String>();
                set.add(arr[i]);
                lmap.put(l, set);
            }
        }
        for (int i = 0; i < arr.length; i++) {
        }
        return 1;
    }
// METHOD SIGNATURE ENDS

// DO NOT IMPLEMENT THE main( ) METHOD
}