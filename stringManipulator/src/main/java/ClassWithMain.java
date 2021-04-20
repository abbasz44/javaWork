import java.util.Scanner;
/*
* this might be a useful resource
* https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html
*/

public class ClassWithMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter String to manipulate:");
        String inputString = input.nextLine();
        StringFun moreFun = new StringFun(inputString);
        StringFun poodle;

        System.out.println(moreFun.getText());
        System.out.println(moreFun.getCharCount());
        System.out.println(moreFun.removeFirst());
        

     }
}
