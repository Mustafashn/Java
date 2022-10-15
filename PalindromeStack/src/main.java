import java.util.Scanner;
import java.util.Stack;


public class main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Stack<Character> stck = new Stack<Character>();
        System.out.print("Cümleyi giriniz: "); 
        String cumle = scan.nextLine();
        
        boolean palindrome=isPalindrome(cumle, stck);
        if(palindrome) {
            System.out.println("Palindrome");
        }
        else {
            System.out.println("Palindrome değildir");
        }
    }
   public static boolean isPalindrome(String cumle, Stack<Character> stck) {
        for(int i =0; i<cumle.length()/2;i++) {
            stck.push(cumle.charAt(i));
        }
        for(int i =cumle.length()/2+1;i<cumle.length();i++) {
            if(stck.pop() != cumle.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
