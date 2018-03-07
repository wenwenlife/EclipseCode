package com.wen.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.wen.bean.ColumnInfo;
import com.wen.bean.JavaFieldGetSet;
import com.wen.bean.TableInfo;
import com.wen.core.DBManage;
import com.wen.core.MysqlTypeConvertor;
import com.wen.core.TableContext;
import com.wen.core.TypeConvertor;

/**
 * 封装了生成Java文件(源代码)常用的操作
 * 
 * @author 李文
 *2018年1月11日下午7:00:54
 *
 */
public class JavaFileUtils {

	/**
	 * 根据字段信息生成java属性信息。如：varchar username-->private String
	 * username;以及相应的set和get方法源码
	 * 
	 * @param column 字段信息
	 * @param convertor  类型转化器
	 * @return java属性和set/get方法源码
	 */
	public static JavaFieldGetSet createFieldGetSetSRC(ColumnInfo column, TypeConvertor convertor) {
		JavaFieldGetSet jfgs = new JavaFieldGetSet();

		String javaFieldType = convertor.databaseToJava(column.getDataType());

		jfgs.setFieldInfo("\tprivate " + javaFieldType + " " + column.getName() + ";\n");

		// public String getUsername(){return username;}
		// 生成get方法的源代码
		StringBuilder getSrc = new StringBuilder();
		getSrc.append(
				"\tpublic " + javaFieldType + " get" + StringUtils.firstCharToUpperCase(column.getName()) + "(){\n");
		getSrc.append("\t\treturn " + column.getName() + ";\n");
		getSrc.append("\t}\n");
		jfgs.setGetInfo(getSrc.toString());

		// public void setUsername(String username){this.username=username;}
		// 生成set方法的源代码
		StringBuilder setSrc = new StringBuilder();
		setSrc.append("\tpublic void set" + StringUtils.firstCharToUpperCase(column.getName()) + "(");
		setSrc.append(javaFieldType + " " + column.getName() + "){\n");
		setSrc.append("\t\tthis." + column.getName() + "=" + column.getName() + ";\n");
		setSrc.append("\t}\n");
		jfgs.setSetInfo(setSrc.toString());
		return jfgs;
	}

	/**
	 * 根据表信息生成java类的源代码
	 * 
	 * @param tableInfo
	 *            表信息
	 * @param convertor
	 *            数据类型转化器
	 * @return java类的源代码
	 */
	public static String createJavaSrc(TableInfo tableInfo, TypeConvertor convertor) {

		Map<String, ColumnInfo> columns = tableInfo.getColumns();
		List<JavaFieldGetSet> javaFields = new ArrayList<JavaFieldGetSet>();

		for (ColumnInfo c : columns.values()) {
			javaFields.add(createFieldGetSetSRC(c, convertor));
		}

		StringBuilder src = new StringBuilder();

		// 生成package语句
		src.append("package " + DBManage.getConf().getPoPackage() + ";\n\n");
		// 生成import语句
		src.append("import java.sql.*;\n");
		src.append("import java.util.*;\n\n");
		// 生成类声明语句
		src.append("public class " + StringUtils.firstCharToUpperCase(tableInfo.getTname()) + " {\n\n");

		// 生成属性列表
		for (JavaFieldGetSet f : javaFields) {
			src.append(f.getFieldInfo());
		}
		src.append("\n\n");
		// 生成get方法列表
		for (JavaFieldGetSet f : javaFields) {
			src.append(f.getGetInfo());
		}
		// 生成set方法列表
		for (JavaFieldGetSet f : javaFields) {
			src.append(f.getSetInfo());
		}

		// 生成类结束
		src.append("}\n");
		System.out.println(src);
		return src.toString();
	}

	public static void createJavaPOFile(TableInfo tableInfo, TypeConvertor convertor) {
		String src = createJavaSrc(tableInfo, convertor);

		String srcPath = DBManage.getConf().getSrcPath() + "\\";
		String packagePath = DBManage.getConf().getPoPackage().replaceAll("\\.", "/");

		File f = new File(srcPath + packagePath);

		if (!f.exists()) { // 如果指定目录不存在，则帮助用户建立
			f.mkdirs();
		}

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(
					f.getAbsoluteFile() + "/" + StringUtils.firstCharToUpperCase(tableInfo.getTname()) + ".java"));
			bw.write(src);
			System.out.println("建立表" + tableInfo.getTname() + "对应的java类："
					+ StringUtils.firstCharToUpperCase(tableInfo.getTname()) + ".java");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		// ColumnInfo ci = new ColumnInfo("id", "int", 0);
		// JavaFieldGetSet f = createFieldGetSetSRC(ci,new
		// MysqlTypeConvertor());
		// System.out.println(f);

		Map<String, TableInfo> map = TableContext.tables;
		TableInfo t = map.get("emp");
		createJavaPOFile(t, new MysqlTypeConvertor());
		// for (TableInfo t : map.values()) {
		// createJavaPOFile(t, new MysqlTypeConvertor());
		// }
	}

}
