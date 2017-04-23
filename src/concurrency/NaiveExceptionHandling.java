package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NaiveExceptionHandling {
	public static void main(String[] args) {
		try {
			ExecutorService exec = Executors.newCachedThreadPool();
			exec.execute(new ExceptionThread());
			// new ExceptionThread();
		} catch (RuntimeException e) {
			// This statement will not execute!!!
			System.out.println("Execption has been handled!");
		}
	}

}
