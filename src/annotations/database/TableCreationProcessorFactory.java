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
		 * �����һ����������,��ʼ��sql�ַ���
		 */
		@Override
		public void process() {
			// TODO Auto-generated method stub
			for (TypeDeclaration typeDecl : env.getSpecifiedTypeDeclarations()) {
				/**
				 * new TableCreationVisitor()��NO_OP������Visitor
				 * ��һ���ڷ���ÿ������ǰʹ��,�ڶ����ڷ���֮��ʹ��
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
					// һЩ����£�ʹ�����������������������
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

			// �Ǿ�̬�ڲ��಻����static����������
			/**
			 * ��Ϊ�ڲ������⣬��������Ϊ�Ǻͳ�Ա����������һ�����ⲿ���Ա
			 * ��������ⲿ��ʵ����������ܳ�ʼ�������������ص�֮һ��Ϊ���������������Ҫ��· ����̬��Ա�ǲ���Ҫʵ���ͳ�ʼ����
			 * ���һ���Ǿ�̬�ڲ������˾�̬��Ա
			 * ����̬��Ա���������κ��ڲ���ʵ�����ǽ��Ҳ���Ǵ��ڲ��಻��Ҫ�ⲿ��ʵ���ͳ�ʼ���˱����������ֺ����ڲ���Ķ���
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
