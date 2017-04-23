package net.mindview.util;

import java.io.File;
import java.io.IOException;

public class ProcessFiles {
	// 内部接口
	public interface Strategy {
		void process(File file);
	}

	private Strategy strategy;
	private String ext;

	public ProcessFiles(Strategy strategy, String ext) {
		this.strategy = strategy;
		// 文件后缀名
		this.ext = ext;
	}

	// 使用strategy的process（）处理所有匹配到的文件
	public void start(String[] args) {
		try {
			if (args.length == 0) {
				// 相对路径是相对于项目名
				File file = new File(".");
				// System.out.println("file 目录： " + file.getAbsolutePath());
				processDirectoryTree(file);
			} else {
				for (String arg : args) {
					File fileArg = new File(arg);
					if (fileArg.isDirectory()) {
						processDirectoryTree(fileArg);
					} else {
						// Allow user to leave off extension:
						if (!arg.endsWith("." + ext)) {
							arg += "." + ext;
							strategy.process(new File(arg).getCanonicalFile());
						}
					}
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void processDirectoryTree(File root) throws IOException {
		// 后缀的正则表达式为：.*\.java
		// 解释： .* 匹配任意个任意字符（.匹配任意字符）
		// \. 转义 . ，就是普通的 .
		for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + ext)) {
			strategy.process(file.getCanonicalFile());
		}
	}

	// Demonstration of how to use it:
	public static void main(String[] args) {
		new ProcessFiles(new ProcessFiles.Strategy() {

			@Override
			public void process(File file) {
				// TODO Auto-generated method stub
				System.out.println(file);
			}
		}, "java").start(args);
	}
}
