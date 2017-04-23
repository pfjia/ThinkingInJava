package typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
	// 静态块的加载与语句的先后顺序有关
	private static String[] typeNames = { "typeinfo.pets.Mutt",
			"typeinfo.pets.EgyptianMau", "typeinfo.pets.Pug",
			"typeinfo.pets.Manx", "typeinfo.pets.Cymric", "typeinfo.pets.Rat",
			"typeinfo.pets.Mouse", "typeinfo.pets.Hamster",
			"typeinfo.pets.Gerbil" };
	private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();

	// 静态块可以访问在它之前的变量，对于在它之后的变量，只能赋值，不能访问。（这规则真奇怪）
	static {
		loader();
	}

	// 根据typeNames加载所有的Pet子类的Class引用
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
