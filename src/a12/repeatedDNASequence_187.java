package a12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187.
 * Repeated DNA Sequences
 * Difficulty
 * Medium

 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA,
 * it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings)
 * that occur more than once in a DNA molecule.
 *
 * Example:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class repeatedDNASequence_187 {
    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";
        repeatedDNASequence_187 t = new repeatedDNASequence_187();
        System.out.println(t.findRepeatedDnaSequences(s));

    }
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() < 10){
            return res;
        }

        Map< String, Integer > map = new HashMap<>();

        for(int i = 0; i <= s.length() - 10; i++){
            String temp = s.substring(i, i + 10);
            if(!map.containsKey(temp)){//map.get(s.substring(i, i + 10)) == 1){
                map.put(temp, 1);
            }else if(map.get(temp) == 1){
                res.add(temp);
                // map.remove(s.substring(i, i + 10));
                map.put(temp, 2);//this is dedup, makesure else if will not catch this again
            }
        }

        return res;
    }
}
