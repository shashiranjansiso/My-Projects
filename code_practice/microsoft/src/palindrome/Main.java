package palindrome;

public class Main {
    public static void main( String[] args ){
        getPalindrome("Deesawaseed");
    }
    
    public static String getPalindrome(String sentence){
        //remove punctuation
        sentence = sentence.replaceAll("(\\.)|(\\?)|(\\,)|(!)", "");
        String[] words = sentence.split("\\s");
        int wordLength = 0;
        int largestPalindromeLength = 0;
        String palindrome = null;
        for (String word : words) {
            word = word.toLowerCase();
            wordLength = word.length();
            char[] charArray = word.toCharArray();
            char[] yarrArach = new char[wordLength];
            //reverse it!
            for (int i = charArray.length; i > 0 ; i--) {
                yarrArach[wordLength - i] = charArray[i - 1];
            }
            boolean isPalindrome = false;
            for (int i = 0; i < wordLength; i++) {
                if(charArray[i] == yarrArach[i]){
                    isPalindrome = true;
                }else{
                    isPalindrome = false;
                    break;
                }
            }
            if(isPalindrome && wordLength > largestPalindromeLength){
                largestPalindromeLength = wordLength;
                palindrome = word;
            }
        }
        if (palindrome != null) {
            System.out.println("Largest Palindrome size: " + largestPalindromeLength + " Palindrome: " + palindrome);
            return palindrome;
        } else {
            System.out.println("No palindromes found in " + sentence);
        }
        return null;
    }
}