package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList2 {
	/**
	 * 为什么方法中内部类只能访问外部方法中的final参数的变量
	 * 1.因为不声明为final的话，传过去的就是引用地址，而引用地址会随着方法的执行完毕、局部变量的销毁而变得不复存在
	 * ，而内部类的生命周期跟外部类的生命周期是一致的
	 * ，超出了方法的生命周期，这就会导致内部类使用不存在的引用地址、进而崩溃。而将局部变量声明为final就不存在这个问题了
	 * ，声明为final的实例被赋值给另一个实例的时候
	 * ，传过去的不再是引用地址而是实际的值，所以内部类就可以利用一个新的实例将该局部变量的值进行拷贝，到需要用的时候直接用就行了。
	 * 2.可以看到名为number的局部变量是作为构造方法的参数传入匿名内部类的（以上代码经过了手动修改，真实的反编译结果中有一些不可读的命名）。
	 *
	 * 如果Java允许匿名内部类访问非final的局部变量的话，
	 * 那我们就可以在TryUsingAnonymousClass$1中修改paramInteger
	 * ，但是这不会对number的值有影响，因为它们是不同的reference。
	 * 
	 * 这就会造成数据不同步的问题。
	 * 
	 * 所以，谜团解开了：Java为了避免数据不同步的问题，做出了匿名内部类只可以访问final的局部变量的限制。
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
