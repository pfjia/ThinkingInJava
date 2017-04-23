package annotations.database;

import static com.sun.mirror.util.DeclarationVisitors.NO_OP;
import static com.sun.mirror.util.DeclarationVisitors.getDeclarationScanner;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;
import com.sun.mirror.declaration.ClassDeclaration;
import com.sun.mirror.declaration.FieldDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;
import com.sun.mirror.util.SimpleDeclarationVisitor;

public class TableCreationProcessorFactory implements
		AnnotationProcessorFactory {

	@Override
	public Collection<String> supportedOptions() {
		// TODO Auto-generated method stub
		return Collections.emptySet();
	}

	@Override
	public Collection<String> supportedAnnotationTypes() {
		// TODO Auto-generated method stub
		return Arrays.asList("annotations.database.DBTable",
				"annotations.database.Constraints",
				"annotations.database.SQLString",
				"annotations.database.SQLInteger");
	}

	@Override
	public AnnotationProcessor getProcessorFor(
			Set<AnnotationTypeDeclaration> atds,
			AnnotationProcessorEnvironment env) {
		// TODO Auto-generated method stub
		return new TableCreationProcessor(env);
	}

	private static class TableCreationProcessor implements AnnotationProcessor {

		private final AnnotationProcessorEnvironment env;
		private String sql = "";

		public TableCreationProcessor(AnnotationProcessorEnvironment env) {
			// TODO Auto-generated constructor stub
			this.env = env;
		}

		/**
		 * 添加了一个访问者类,初始化sql字符串
		 */
		@Override
		public void process() {
			// TODO Auto-generated method stub
			for (TypeDeclaration typeDecl : env.getSpecifiedTypeDeclarations()) {
				/**
				 * new TableCreationVisitor()、NO_OP是两个Visitor
				 * 第一个在访问每个声明前使用,第二个在访问之后使用
				 */
				typeDecl.accept(getDeclarationScanner(
						new TableCreationVisitor(), NO_OP));
				sql = sql.substring(0, sql.length() - 1) + ");";
				System.out.println("creation SQL is :\n" + sql);
				sql = "";
			}
		}

		private class TableCreationVisitor extends SimpleDeclarationVisitor {
			@Override
			public void visitClassDeclaration(ClassDeclaration d) {
				DBTable dbTable = d.getAnnotation(DBTable.class);
				if (dbTable != null) {
					sql += "CREATE TABLE ";
					sql += (dbTable.name().length() < 1) ? d.getSimpleName()
							.toUpperCase() : dbTable.name();
					sql += " (";
				}
			}

			@Override
			public void visitFieldDeclaration(FieldDeclaration d) {
				String columnName = "";
				if (d.getAnnotation(SQLInteger.class) != null) {
					SQLInteger sInt = d.getAnnotation(SQLInteger.class);
					// 一些情况下，使用条件运算符代码更简洁明了
					columnName = (sInt.name().length() < 1) ? d.getSimpleName()
							.toUpperCase() : sInt.name();
					sql += "\n    " + columnName + " INT"
							+ getConstraints(sInt.constraints()) + ",";
				}
				if (d.getAnnotation(SQLString.class) != null) {
					SQLString sString = d.getAnnotation(SQLString.class);
					columnName = (sString.name().length() < 1) ? d
							.getSimpleName().toLowerCase() : sString.name();
					sql += "\n    " + columnName + " VARCHAR("
							+ sString.value() + ") "
							+ getConstraints(sString.constraints()) + ",";
				}
			}

			// 非静态内部类不能有static变量、方法
			/**
			 * 因为内部类特殊，他被定向为是和成员变量，方法一样的外部类成员
			 * 他必须跟外部类实例相关联才能初始化，这是他的特点之一，为了这个其他东西都要让路 而静态成员是不需要实例就初始化的
			 * 如果一个非静态内部类有了静态成员
			 * ，静态成员不依托于任何内部类实例，那结果也就是此内部类不需要外部类实例就初始化了变量，严重侵害了内部类的定向
			 * 
			 * @param constraints
			 * @return
			 */
			private String getConstraints(Constraints constraints) {
				// TODO Auto-generated method stub
				String result = "";
				if (!constraints.allowNull()) {
					result += " NOT NULL";
				}
				if (constraints.primaryKey()) {
					result += " PRIMARY KEY";
				}
				if (constraints.unique()) {
					result += " UNIQUE";
				}
				return result;
			}
		}
	}

}
