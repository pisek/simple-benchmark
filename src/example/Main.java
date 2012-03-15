package example;

import example.utils.MathematicalMethods;
import benchmark.Benchmark;
import benchmark.BenchmarkCodeTest;
import benchmark.BenchmarkResults;
import benchmark.StandardBenchmark;




public class Main {

	/**
	 * @param args
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 */
	public static void main(String[] args) throws SecurityException, NoSuchMethodException {

		final MathematicalMethods mm = new MathematicalMethods();


		System.out.println("10! = " + mm.fact(10));
		System.out.println();
		
		
		
		//przekazanie metody przez Method i Object itp (nie polecany sposób!!!)
//		Benchmark b = new StandardBenchmark();
//		BenchmarkResults results = b.testMethod(14, mm, mm.getClass().getMethod("fact", int.class), 5);
//		System.out.println(results);
		
		
		//benchmark poprzez start/stop w kodzie (tylko pojedyncze testy)
//		for (int j = 0; j < 10; j++) {
//			Benchmark.startBenchmark();
//			for (int i = 0; i < 10; i++) {
//				mm.fact(8);
//			}
//			Long result = Benchmark.stopBenchmark();
//			System.out.println(result);
//		}
		
		
		//benchmark przez przekazanie anonimowej klasy z jedna metoda (NAJEFEKTYWNIEJ!!!)
//		Benchmark bb = new StandardBenchmark();
//		BenchmarkResults results2 = bb.testEnteredCode(14, new BenchmarkCodeTest() {
//			public void testCode() {
//				mm.fact(5);
//			}
//		});
//		System.out.println(results2);
		
		
	}

}
