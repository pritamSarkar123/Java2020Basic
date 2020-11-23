package basicMath;

import java.math.BigInteger;

public class BigIntegerProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger a=new BigInteger("123456");
		BigInteger b=BigInteger.TEN;
		BigInteger c=a.add(b);
		System.out.println(c);
		BigInteger d=a.multiply(c);
		System.out.println(d);
		System.out.println(d.mod(BigInteger.valueOf(Character.MAX_VALUE)));
		System.out.println(d.isProbablePrime(5));
		/*
		 * error is proportional to e^(- certainty)
		 * */
	}

}
