package typeinfo;

import java.util.Arrays;
import java.util.List;

public class SnowRemovalRobot implements Robot {
	private String name;

	public SnowRemovalRobot(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String model() {
		// TODO Auto-generated method stub
		return "SnowBot Series 11";
	}

	@Override
	public List<Operation> operations() {
		// TODO Auto-generated method stub
		return Arrays.asList(new Operation() {

			@Override
			public String description() {
				// TODO Auto-generated method stub
				return name + " can shovel snow";
			}

			@Override
			public void command() {
				// TODO Auto-generated method stub
				System.out.println(name + " shoveling snow");
			}
		}, new Operation() {

			@Override
			public String description() {
				// TODO Auto-generated method stub
				return name + " can chip ice";
			}

			@Override
			public void command() {
				// TODO Auto-generated method stub
				System.out.println(name + " chipping ice");
			}
		}, new Operation() {

			@Override
			public String description() {
				// TODO Auto-generated method stub
				return name + " can clear the roof";
			}

			@Override
			public void command() {
				// TODO Auto-generated method stub
				System.out.println(name + " clearing roof");
			}
		});
	}

	public static void main(String[] args) {
		Robot.Test.test(new SnowRemovalRobot("Slusher"));
	}

}
