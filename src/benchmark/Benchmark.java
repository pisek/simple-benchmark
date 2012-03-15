package benchmark;

import java.lang.reflect.Method;

public abstract class Benchmark {
	
	protected static StandardBenchmark staticBenchmark = null;
	
	private boolean started = false;
	private Long startTime = 0L;
	
	
	
	
	
	/**
	 * Metoda testuje kod z danej metody ({@link Method}) danego obiektu ({@link Object}) {@code times} razy. <br/>
	 * Do metody, jesli potrzeba, nalezy podac parametry w {@code args}
	 * 
	 * @author mpisarsk
	 * 
	 * @param times
	 * @param classObject
	 * @param method
	 * @param args
	 * @return
	 */
	public abstract BenchmarkResults testMethod(int times, Object classObject, Method method, Object... args);
	
	/**
	 * Metoda testuje kod, przekazany przez anonimowa klase implementujaca {@link BenchmarkCodeTest}.<br/>
	 * Inaczej mowiac, benchmark testuje {@code times} razy wykonywanie metody {@code testCode} z przekazanego obiektu implementujacego {@link BenchmarkCodeTest}  
	 * 
	 * @author mpisarsk
	 * 
	 * @param times
	 * @param code
	 * @return
	 */
	public abstract BenchmarkResults testEnteredCode(int times, BenchmarkCodeTest code);
	
	
	
	
	/**
	 * Metoda zatrzymuje pojedynczy benchmark
	 * 
	 * @author mpisarsk
	 * 
	 * @return nanosekundy
	 */
	public Long stop() {
		started = false;
		Long out = System.nanoTime() - startTime;
		startTime = 0L;
		return out;
    }

	/**
	 * Metoda uruchamia pojedynczy benchmark
	 * 
	 * @author mpisarsk
	 *
	 */
	public void start() {
		started = true;
		startTime = System.nanoTime();
    }

	/**
	 * Zwraca flage czy pojedynczy benchmark jest uruchomiony
	 * 
	 * @author mpisarsk
	 * 
	 * @return
	 */
	public boolean isStarted() {
	    return started;
    }
	
	
	/**
	 * Metoda statyczna odpala pojedynczy benchmark.
	 * 
	 * @author mpisarsk
	 *
	 */
	public static void startBenchmark() {
		if (staticBenchmark == null) {
			staticBenchmark = new StandardBenchmark();
		} else if (staticBenchmark.isStarted()) {
			staticBenchmark.stop();
		}
		
		staticBenchmark.start();
	}
	
	/**
	 * Metoda statyczna, zatrzymuje testowanie. Najlepiej uzywac jej w sekcji {@code finally} jako ze metoda ta musi być wykonana na koniec testowania.<br/>
	 * Zwraca liczbe nanosekund ktore zajelo wykonywanie danego kodu.
	 * 
	 * @author mpisarsk
	 * 
	 * @return nanosekundy
	 */
	public static Long stopBenchmark() {
		if (staticBenchmark == null) {
			System.err.println("No benchmark initialised");
			return 0L;
		} else if (!staticBenchmark.isStarted()) {
			System.err.println("No benchmark started");
			return 0L;
		}
		
		return staticBenchmark.stop();
	}
	
	
}
