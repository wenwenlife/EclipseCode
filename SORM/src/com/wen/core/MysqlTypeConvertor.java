package com.wen.core;

public class MysqlTypeConvertor implements TypeConvertor {

	@Override
	public String databaseToJava(String columnType) {
		// 数据库表转为java类型(varchar-->String)
		if ("varchar".equals(columnType) || "char".equals(columnType)) {
			return "String";
		}else if("int".equalsIgnoreCase(columnType)
				||"tinyint".equalsIgnoreCase(columnType)
				||"smallint".equalsIgnoreCase(columnType)
				||"integer".equalsIgnoreCase(columnType)
				){
			return "Integer";
		}else if("bigint".equalsIgnoreCase(columnType)){
			return "Long";
		}else if("double".equalsIgnoreCase(columnType)||"float".equalsIgnoreCase(columnType)){
			return "Double";
		}else if("clob".equalsIgnoreCase(columnType)){
			return "java.sql.CLob";
		}else if("blob".equalsIgnoreCase(columnType)){
			return "java.sql.BLob";
		}else if("date".equalsIgnoreCase(columnType)){
			return "java.sql.Date";
		}else if("time".equalsIgnoreCase(columnType)){
			return "java.sql.Time";
		}else if("timestamp".equalsIgnoreCase(columnType)){
			return "java.sql.Timestamp";
		}
		
		return null;
	}

	@Override
	public String javaToDatabase(String columnType) {
		return null;
	}

}
