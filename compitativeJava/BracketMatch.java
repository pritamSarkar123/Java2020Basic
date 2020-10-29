package compitativeJava;

import java.util.Scanner;
import java.util.Stack;
//Problem:-https://practice.geeksforgeeks.org/problems/parenthesis-checker/0#
class BracketMatch {
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		sc.nextLine();
		while(T!=0){
		    String s=sc.nextLine();
		    Stack<Character> stack=new Stack<>();
		    char c;
		    boolean balanced=true;
		    for(int i=0;i<s.length();i++){
		        c=s.charAt(i);
		        if(c=='(' || c=='{' || c=='[') stack.push(c);
		        else if(stack.isEmpty()){
		            balanced=false; break;
		        }else if(c=='}'){
		            if(stack.peek()=='{') stack.pop();
		            else{
		                balanced=false;break;
		            }
		        }else if(c==']'){
		            if(stack.peek()=='[') stack.pop();
		            else{
		                balanced=false;break;
		            }
		        }else if(c==')'){
		            if(stack.peek()=='(') stack.pop();
		            else{
		                balanced=false;break;
		            }
		        }
		    }
		    if(!stack.isEmpty()){
		        System.out.println("not balanced");
		    }else if(!balanced){
		        System.out.println("not balanced");
		    }else{
		        System.out.println("balanced");
		    }
		    T--;
		}
		sc.close();
	}
}