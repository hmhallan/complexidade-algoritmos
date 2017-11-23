package dinamica;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class FibonacciBottomUp {
	
	private long operacoes = 0;
	
	private Map<Long,Long> memo = new HashMap<>();
	
	public static void main(String [] args) {

		Instant start = Instant.now();
		
		FibonacciBottomUp f = new FibonacciBottomUp();
		System.out.println( f.fib(100) );
		Instant end = Instant.now();
		
		System.out.println( "Operações: " + f.operacoes );
	    System.out.println(Duration.between(start, end));

	    System.out.println(f.memo);
	}
	
	public long fib( long n ) {
		
		memo.put(0L,1L);
		memo.put(1L,1L);
		
		for ( long i = 2; i <= n; i++ ) {
			this.operacoes++;
			memo.put( i  , memo.get(i-1) + memo.get(i-2) );
		}
		return memo.get(n);
	}

}
