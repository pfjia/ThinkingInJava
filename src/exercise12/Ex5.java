package exercise12;

public class Ex5 {
	public static void main(String[] args) {
		int i = 0;
		int j;
		boolean flag = true;
		while (true) {
			try {
				// �׳��쳣����
				{
					j = 10 / i;
				}
				System.out.println(j);
				break;
			} catch (Exception e) {
				e.printStackTrace();
				i++;
			}
		}
	}
}
