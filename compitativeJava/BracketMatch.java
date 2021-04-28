package compitativeJava;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
//Problem:-https://practice.geeksforgeeks.org/problems/parenthesis-checker/0#
class BracketMatch {
	public static void main(String []args) {
		System.out.println("Enter the string");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		sc.close();
		boolean balanced=true;
		int i=0;
		Deque<Character> stack=new LinkedList<>();
		while(i<s.length()) {
			char c=s.charAt(i);
			if(c=='(' || c=='{' || c=='[') stack.addLast(c);
			else if((c==')' || c=='}' || c==']') && stack.isEmpty()) {
				balanced=false;break;
			}else if(c==')') {
				if(stack.peekLast()=='(') stack.pollLast();
				else {
					balanced=false;break;
				}
			}else if(c=='}') {
				if(stack.peekLast()=='{') stack.pollLast();
				else {
					balanced=false;break;
				}
			}else if(c==']') {
				if(stack.peekLast()=='[') stack.pollLast();
				else {
					balanced=false;break;
				}
			}
			i++;
		}
		if(!stack.isEmpty() || !balanced) System.out.println("not balanced");
		System.out.println("balanced");
	}
}
	
	
	
	
	
	
	
	
	
	
	
//	public static void main (String[] args) {
//	    Scanner sc=new Scanner(System.in);
//		int T=sc.nextInt();
//		sc.nextLine();
//		while(T!=0){
//		    String s=sc.nextLine();
//		    Stack<Character> stack=new Stack<>();
//		    char c;
//		    boolean balanced=true;
//		    for(int i=0;i<s.length();i++){
//		        c=s.charAt(i);
//		        // if open bracket then simply push
//		        if(c=='(' || c=='{' || c=='[') stack.push(c);
//		        // if closing bracket comes but stack is empty
//		        else if((c==')' || c=='}' || c==']') && stack.isEmpty()){
//		            balanced=false; break;
//		        }else if(c=='}'){ //if closing bracket and same opening in stack top then ok otherwise not
//		            if(stack.peek()=='{') stack.pop();
//		            else{
//		                balanced=false;break;
//		            }
//		        }else if(c==']'){//if closing bracket and same opening in stack top then ok otherwise not
//		            if(stack.peek()=='[') stack.pop();
//		            else{
//		                balanced=false;break;
//		            }
//		        }else if(c==')'){ //if closing bracket and same opening in stack top then ok otherwise not
//		            if(stack.peek()=='(') stack.pop();
//		            else{
//		                balanced=false;break;
//		            }
//		        }
//		    }
//		    if(!stack.isEmpty()){
//		        System.out.println("not balanced");
//		    }else if(!balanced){
//		        System.out.println("not balanced");
//		    }else{
//		        System.out.println("balanced");
//		    }
//		    T--;
//		}
//		sc.close();
//	}