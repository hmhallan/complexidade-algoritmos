package dinamica;

import java.time.Duration;
import java.time.Instant;

public class Fibonacci {
	
	private long operacoes = 0;
	
	public static void main(String [] args) {

		Instant start = Instant.now();
		
		Fibonacci f = new Fibonacci();
		System.out.println( f.fib(43) );
		Instant end = Instant.now();
		
		
		System.out.println( "Operações: " + f.operacoes );
	    System.out.println(Duration.between(start, end));
		
	}
	
	public int fib( int n ) {
		this.operacoes++;
		
		if ( n <= 0 ) {
			return 0;
		}
		else if ( n == 1 ) {
			return 1;
		}
		else {
			return fib(n-1) + fib(n-2);
		}
	}

}
