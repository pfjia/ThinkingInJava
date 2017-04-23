package strings;

public class WitherStringBulider {
	public String implicit(String[] fields) {
		String result = "";
		for (int i = 0; i < fields.length; i++) {
			// 每次循环都会生成StringBuilder
			result += fields[i];
		}
		return result;
	}

	public String explicit(String[] fields) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < fields.length; i++) {
			result.append(fields[i]);
		}
		return result.toString();
	}

}
