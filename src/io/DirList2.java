package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList2 {
	/**
	 * Ϊʲô�������ڲ���ֻ�ܷ����ⲿ�����е�final�����ı���
	 * 1.��Ϊ������Ϊfinal�Ļ�������ȥ�ľ������õ�ַ�������õ�ַ�����ŷ�����ִ����ϡ��ֲ����������ٶ���ò�������
	 * �����ڲ�����������ڸ��ⲿ�������������һ�µ�
	 * �������˷������������ڣ���ͻᵼ���ڲ���ʹ�ò����ڵ����õ�ַ�����������������ֲ���������Ϊfinal�Ͳ��������������
	 * ������Ϊfinal��ʵ������ֵ����һ��ʵ����ʱ��
	 * ������ȥ�Ĳ��������õ�ַ����ʵ�ʵ�ֵ�������ڲ���Ϳ�������һ���µ�ʵ�����þֲ�������ֵ���п���������Ҫ�õ�ʱ��ֱ���þ����ˡ�
	 * 2.���Կ�����Ϊnumber�ľֲ���������Ϊ���췽���Ĳ������������ڲ���ģ����ϴ��뾭�����ֶ��޸ģ���ʵ�ķ�����������һЩ���ɶ�����������
	 *
	 * ���Java���������ڲ�����ʷ�final�ľֲ������Ļ���
	 * �����ǾͿ�����TryUsingAnonymousClass$1���޸�paramInteger
	 * �������ⲻ���number��ֵ��Ӱ�죬��Ϊ�����ǲ�ͬ��reference��
	 * 
	 * ��ͻ�������ݲ�ͬ�������⡣
	 * 
	 * ���ԣ����Ž⿪�ˣ�JavaΪ�˱������ݲ�ͬ�������⣬�����������ڲ���ֻ���Է���final�ľֲ����������ơ�
	 * 
	 * 
	 * @param regex
	 * @return
	 */

	public static FilenameFilter filter(final String regex) {

		// Creation of anonymous inner class
		return new FilenameFilter() {

			private Pattern pattern = Pattern.compile(regex);

			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return pattern.matcher(name).matches();
			}
		};// End of anonymous inner class

	}

	public static void main(String[] args) {
		File path = new File(".");
		String[] list;
		if (args.length == 0) {
			list = path.list();
		} else {
			list = path.list(filter(args[0]));
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list) {
			System.out.println(dirItem);
		}
	}
}
