package net.mindview.util;

import java.io.File;
import java.io.IOException;

public class ProcessFiles {
	// �ڲ��ӿ�
	public interface Strategy {
		void process(File file);
	}

	private Strategy strategy;
	private String ext;

	public ProcessFiles(Strategy strategy, String ext) {
		this.strategy = strategy;
		// �ļ���׺��
		this.ext = ext;
	}

	// ʹ��strategy��process������������ƥ�䵽���ļ�
	public void start(String[] args) {
		try {
			if (args.length == 0) {
				// ���·�����������Ŀ��
				File file = new File(".");
				// System.out.println("file Ŀ¼�� " + file.getAbsolutePath());
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
		// ��׺��������ʽΪ��.*\.java
		// ���ͣ� .* ƥ������������ַ���.ƥ�������ַ���
		// \. ת�� . ��������ͨ�� .
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
