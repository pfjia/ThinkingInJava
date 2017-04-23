package typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
	// ��̬��ļ����������Ⱥ�˳���й�
	private static String[] typeNames = { "typeinfo.pets.Mutt",
			"typeinfo.pets.EgyptianMau", "typeinfo.pets.Pug",
			"typeinfo.pets.Manx", "typeinfo.pets.Cymric", "typeinfo.pets.Rat",
			"typeinfo.pets.Mouse", "typeinfo.pets.Hamster",
			"typeinfo.pets.Gerbil" };
	private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();

	// ��̬����Է�������֮ǰ�ı�������������֮��ı�����ֻ�ܸ�ֵ�����ܷ��ʡ������������֣�
	static {
		loader();
	}

	// ����typeNames�������е�Pet�����Class����
	@SuppressWarnings("unchecked")
	private static void loader() {
		try {
			for (String name : typeNames) {
				types.add((Class<? extends Pet>) Class.forName(name));
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Class<? extends Pet>> getTypes() {
		// TODO Auto-generated method stub
		return types;
	}

}
