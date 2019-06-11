
public class SimpleRecursion {
	
	public static void main(String[] args) {
		countDown(5);
	}
	

public static void countDown(int num) {
	System.out.println(num);
	if(num<0)
		return;
	else
		countDown(num-1);// --num,num-- is different
}
public static int fact(int num) {
	if(num <= 0)
		return 1;
	else
		return num*fact(num-1);
}
public static int gcd(int a, int b) {
	if(b == 0)
		return a;
	else
		return gcd(b, a%b);
}
public static int fibo(int num) {
	if(num == 1 || num == 2)
		return 1;
	else
		return fibo(num-1) + fibo(num -2);
}


}