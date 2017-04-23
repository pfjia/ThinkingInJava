package typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;
import java.util.List;

import net.mindview.util.Null;

/**
 * using a dynamic proxy to create a Null Object
 * 
 * @author pfjia
 *
 */

class NullRobotProxyHandler implements InvocationHandler {
	private String nullName;
	private Robot proxied = new NRobot();

	public NullRobotProxyHandler(Class<? extends Robot> type) {
		// TODO Auto-generated constructor stub
		nullName = type.getSimpleName() + " NullRobot";
	}

	// 产生空对象的类
	// 因为需要根据不同的Robot子类生成不同的空对象
	// 所以需要获得被代理对象的simpleName()
	// 也即获得被代理对象的class信息
	// 为了方便就把NRobot作为代理类的内部类
	private class NRobot implements Null, Robot {

		@Override
		public String name() {
			// TODO Auto-generated method stub
			return nullName;
		}

		@Override
		public String model() {
			// TODO Auto-generated method stub
			return nullName;
		}

		@Override
		public List<Operation> operations() {
			// TODO Auto-generated method stub
			return Collections.emptyList();
		}

	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		return method.invoke(proxied, args);
	}

}

public class NullRobot {
	// 根据type返回代理
	public static Robot newNullRobot(Class<? extends Robot> type) {
		return (Robot) Proxy.newProxyInstance(NullRobot.class.getClassLoader(),
				new Class[] { Null.class, Robot.class },
				new NullRobotProxyHandler(type));
	}

	public static void main(String[] args) {
		Robot[] robots = { new SnowRemovalRobot("SnowBee"),
				newNullRobot(SnowRemovalRobot.class) };
		for (Robot r : robots) {
			Robot.Test.test(r);
			System.out.println("我是快乐的分隔符");
		}
	}
}
