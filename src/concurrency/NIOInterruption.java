package concurrency;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class NIOBlocked implements Runnable {
	private final SocketChannel sc;
	private final String id;

	public NIOBlocked(SocketChannel sc, String id) {
		// TODO Auto-generated constructor stub
		this.sc = sc;
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		System.out.println("Waiting for read() in " + this);
		try {
			sc.read(ByteBuffer.allocate(1));
		} catch (ClosedByInterruptException e) {
			System.out.println("ClosedByInterruptException  " + id);
		} catch (AsynchronousCloseException e) {
			System.out.println("AsynchronousCloseException  " + id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Exiting NIOBlocked.run() " + this);
	}
}

public class NIOInterruption {
	public static void main(String[] args) throws IOException,
			InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		ServerSocket server = new ServerSocket(8080);
		InetSocketAddress isa = new InetSocketAddress("localhost", 8080);
		SocketChannel sc1 = SocketChannel.open(isa);
		SocketChannel sc2 = SocketChannel.open(isa);
		Future<?> f = exec.submit(new NIOBlocked(sc1, "sc1"));
		exec.execute(new NIOBlocked(sc2, "sc2"));
		exec.shutdown();

		TimeUnit.SECONDS.sleep(1);

		// Produce an interrupt via cancel
		f.cancel(true);// NIO响应interrupt，这个调用会关闭sc1

		TimeUnit.SECONDS.sleep(1);
		// Release the block by closing the channel
		sc2.close();// 使用关闭底层资源的方式关闭sc2
	}
}
