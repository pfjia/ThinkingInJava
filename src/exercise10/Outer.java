package exercise10;

public class Outer {
	private String name;

	public Outer(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	class Inner {

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "�����ڲ��࣬�ҵ��ⲿ��������ǣ�" + name;
		}

	}

	public Inner getInnerInstance() {
		return new Inner();
	}

	public static void main(String[] args) {
		Outer o = new Outer("С��");
		// �ڲ����������new���ɣ�ֻ�����ⲿ��ʵ�����÷�������
		// �����Ǵ�ģ��ڲ�����������new���ɣ��﷨����:(��ʱ�ڲ��಻��static��)
		// Inner i = o.new Inner();
		Inner i = o.getInnerInstance();
		System.out.println(i);
	}

}
