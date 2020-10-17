package strings;

public class StringOne {

	public static void main(String[] args) {
		// String:- non primitive , immutable datatype
		
		//more optimized
		String name1="Pritam"; //created in string pool
		String name2="Pritam"; //as already present in string pool, get its reference
		System.out.println(name1==name2);
		
		//less optimized
		String name3=new String("Pritam");//created in heap,then if not present
		//in string pool then create it in string pool also
		System.out.println(name1==name3);//different reference
		
		name1="Vanu";
		//"Pritam" is not removed from string pool, it stays there referenceless ly
		//later garbage collector takes care of it
		
		System.out.println(name1.charAt(0));
		
		System.out.println(name1.length());
		
		System.out.println(name1.substring(2));
		
		System.out.println(name1.substring(1, 3));
		
		System.out.println(name1.contains("n"));
		
		System.out.println(name2.equals(name3));// compares charecter wise not reference wise
		
		System.out.println("".isEmpty());//no charecter:- true
		
		name2+=" vanu";
		name2=name2.concat(" Sarkar");
		//appends new strings , as strings are immutable
		//old strings remains in string pool section without reference
		//garbage collector takes care of it later
		System.out.println(name2);
		
		name2=name2.replace('a', 'x');
		//completely new updated string reffered to the string variable
		//old strings remains in string pool section without reference
		//garbage collector takes care of it later
		System.out.println(name2);
		
		
		//completely new updated string reffered to the string variable
		//old strings remains in string pool section without reference
		//garbage collector takes care of it later
		String[] names=name2.split(" ");
		for(String n:names) {
			System.out.print(n+" , ");
		}
		System.out.println();
		System.out.println(name2.indexOf('x'));//returns 1st occurance index
		
		name2=name2.toLowerCase();
		//completely new updated string reffered to the string variable
		//old strings remains in string pool section without reference
		//garbage collector takes care of it later
		System.out.println(name2);
		
		name2=name2.toUpperCase();
		//completely new updated string reffered to the string variable
		//old strings remains in string pool section without reference
		//garbage collector takes care of it later
		System.out.println(name2);
		
		String name4="   Abasid    ";
		name4=name4.trim();
		//completely new updated string reffered to the string variable
		//old strings remains in string pool section without reference
		//garbage collector takes care of it later
		System.out.println(name4);
	}

}
