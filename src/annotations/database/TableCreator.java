package annotations.database;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {
	public static void main(String[] args) throws Exception {
		args = new String[1];
		args[0] = "annotations.database.Member";

		if (args.length < 1) {
			System.out.println("arguments: annotated classes");
			System.exit(0);
		}

		for (String className : args) {
			Class<?> cl = Class.forName(className);
			DBTable dbTable = cl.getAnnotation(DBTable.class);
			if (dbTable == null) {
				System.out.println("No DBTable annotations in class "
						+ className);
				continue;
			}
			String tableName = dbTable.name();
			// if the name is empty,use the Class name
			if (tableName.length() < 1) {
				tableName = cl.getName().toUpperCase();
			}
			List<String> columnDefs = new ArrayList<String>();
			// �����������ԣ��鿴�����Ƿ���ע��
			for (Field field : cl.getDeclaredFields()) {
				String columnName = null;
				Annotation[] anns = field.getDeclaredAnnotations();
				// ��ע��
				if (anns.length < 1) {
					continue;// not a db table colum
				}
				// ��SQLIntegerע��
				if (anns[0] instanceof SQLInteger) {
					SQLInteger sInt = (SQLInteger) anns[0];
					// Use field name if name not specified
					if (sInt.name().length() < 1) {
						columnName = field.getName().toUpperCase();
					} else {
						columnName = sInt.name();
					}
					columnDefs.add(columnName + " INT"
							+ getConstraints(sInt.constraints()));
				}

				// ��SQLStringע��
				if (anns[0] instanceof SQLString) {
					SQLString sString = (SQLString) anns[0];
					if (sString.name().length() < 1) {
						columnName = field.getName().toUpperCase();
					} else {
						columnName = sString.name();
					}

					columnDefs.add(columnName + " VARCHAR(" + sString.value()
							+ ")" + getConstraints(sString.constraints()));
				}

				StringBuilder createCommand = new StringBuilder("CREATE TABLE "
						+ tableName + "(");
				for (String columnDef : columnDefs) {
					createCommand.append("\n    " + columnDef + ",");
				}
				String tableCreate = createCommand.substring(0,
						createCommand.length() - 1)
						+ ");";
				System.out.println("Table Creation SQL for " + className
						+ " is :\n" + tableCreate);
			}
		}
	}

	private static String getConstraints(Constraints constraints) {
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
