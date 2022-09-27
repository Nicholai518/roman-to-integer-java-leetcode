import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s){
        // Build map for Roman Numerals
        Map<Character, Integer> romanNumeralMap = new HashMap<>();
        romanNumeralMap.put('I', 1);
        romanNumeralMap.put('V', 5);
        romanNumeralMap.put('X', 10);
        romanNumeralMap.put('L', 50);
        romanNumeralMap.put('C', 100);
        romanNumeralMap.put('D', 500);
        romanNumeralMap.put('M', 1000);

        // isolate the last character of the string
        // we are going to work from right to left
        int answer = romanNumeralMap.get(s.charAt(s.length()-1));

        // start from the second to last character
        // compare to the character on the right
        for(int i = s.length()-2; i>=0; i--){
            // if current char is less than character on right, subtract value from answer
            if(romanNumeralMap.get(s.charAt(i)) < romanNumeralMap.get(s.charAt(i+1))){
                answer -= romanNumeralMap.get(s.charAt(i));
            }
            // if current character is greater than character on right, add value to answer
            else{
                answer += romanNumeralMap.get(s.charAt(i));
            }
        }
        return answer;
    }
}
