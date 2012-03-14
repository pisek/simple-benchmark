package example;

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


		int fact = mm.fact(10);
		System.out.println(fact);
		System.out.println();
		
		
		
		//przekazanie metody przez Method i Object itp (nie polecany sposób!!!)
//		Benchmark b = new StandardBenchmark();
//		BenchmarkResults results = b.testMethod(14, mm, mm.getClass().getMethod("fact", int.class), 5);
//		System.out.println(results);
		
		
		//benchmark poprzez start/stop w kodzie (tylko pojedyncze testy)
//		StandardBenchmark.startBenchmark();
//		for (int i = 0; i < 10; i++) {
//	        mm.fact(8);
//        }
//		Long result = StandardBenchmark.stopBenchmark();
//		System.out.println(result);
		
		
		//benchmark przez przekazanie anonimowej klasy z jedna metoda (NAJEFEKTYWNIEJ!!!)
		Benchmark bb = new StandardBenchmark();
		BenchmarkResults results2 = bb.testEnteredCode(14, new BenchmarkCodeTest() {
			@Override
			public void testCode() {
				mm.fact(5);
			}
		});
		System.out.println(results2);
		
		
	}

}
