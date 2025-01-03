import java.io.IOException;
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
		int countPlusMinuMultsDiv = 0;
		Scanner input = new Scanner(System.in);
        System.out.print("type: a+b, a-b, a*b or a/b (1 <= a or b <= 10) ");
        String text = input.nextLine(); 
		countPlusMinuMultsDiv += text.chars().filter(num -> num == '+').count();
		countPlusMinuMultsDiv += text.chars().filter(num -> num == '-').count();
		countPlusMinuMultsDiv += text.chars().filter(num -> num == '*').count();
		countPlusMinuMultsDiv += text.chars().filter(num -> num == '/').count();
		if (countPlusMinuMultsDiv == 0)  throw new RuntimeException("No operation +, -, * or / ");
		if (countPlusMinuMultsDiv > 1)  throw new RuntimeException("So many operatioms +, -, * or / ");
		if (countPlusMinuMultsDiv == 1) printResult(text);
    }
	public static void printResult (String exp){
		String a = (exp.indexOf('+') != -1) ? exp.substring(0, exp.indexOf("+")) : "";
		a = a.concat((exp.indexOf('-') != -1) ? exp.substring(0, exp.indexOf("-")) : "");
		a = a.concat((exp.indexOf('*') != -1) ? exp.substring(0, exp.indexOf("*")) : "");
		a = a.concat((exp.indexOf('/') != -1) ? exp.substring(0, exp.indexOf("/")) : "");
		int a_int = Integer.parseInt (a);
		
		String b = exp.substring(exp.lastIndexOf("+") + 1);
		b = b.substring(b.lastIndexOf("-") + 1);
		b = b.substring(b.lastIndexOf("*") + 1);
		b = b.substring(b.lastIndexOf("/") + 1);
		int b_int = Integer.parseInt (b);
		if ((a_int>0)&&(a_int<=10)&&(b_int>0)&&(b_int<=10)){
			if (exp.indexOf('+') != -1) System.out.println("a+b="+(a_int+b_int));
			if (exp.indexOf('-') != -1) System.out.println("a-b="+(a_int-b_int));
			if (exp.indexOf('*') != -1) System.out.println("a*b="+(a_int*b_int));
			if (exp.indexOf('/') != -1) System.out.println("a/b="+(a_int/b_int));
		}else throw new RuntimeException("Missing '(1 <= a or b <= 10)'");
	}
}