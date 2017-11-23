package dinamica;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class FibonacciTopDown {
	
	private long operacoes = 0;
	
	private Map<Long,Long> memo = new HashMap<>();
	
	public static void main(String [] args) {

		Instant start = Instant.now();
		
		FibonacciTopDown f = new FibonacciTopDown();
		System.out.println( f.fib(100) );
		Instant end = Instant.now();
		
		
		System.out.println( "Operações: " + f.operacoes );
	    System.out.println(Duration.between(start, end));
		
	    System.out.println(f.memo);
	}
	
	public long fib( long n ) {
		this.operacoes++;
		
		if ( n <= 0 ) {
			return 0;
		}
		else if ( n == 1 ) {
			return 1;
		}
		else if ( !memo.containsKey(n) ) {
			memo.put(n, (fib(n-1) + fib(n-2)) );
		}
		return memo.get(n);
	}

}
