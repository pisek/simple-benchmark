package benchmark;

import java.lang.reflect.Method;

public class StandardBenchmark extends Benchmark {
	

	/**
	 * @see benchmark.Benchmark#testEnteredCode(int, benchmark.BenchmarkCodeTest)
	 */
	@Override
	public BenchmarkResults testEnteredCode(int times, BenchmarkCodeTest code) {

		BenchmarkResults br = new BenchmarkResults();
		
		for (int i = 0; i < times; i++) {
			
			long startTime = System.nanoTime();
			try {
				
				code.testCode();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
				br.addTimeResult(System.nanoTime() - startTime);
				
			}
			
		}
		
		return br;
	}
	
	/**
	 * @see benchmark.Benchmark#testMethod(int, java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public BenchmarkResults testMethod(int times, Object classObject, Method method, Object... args) {

		BenchmarkResults br = new BenchmarkResults();
				
		for (int i = 0; i < times; i++) {
			
			long startTime = System.nanoTime();
			try {
				
				method.invoke(classObject, args);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
				br.addTimeResult(System.nanoTime() - startTime);
				
			}
			
		}
		
		
		return br;
	}

}
