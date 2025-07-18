package com.jaladhi.db;

public class DataBaseSqlQueries {

	public static final String DATA_BASE_PASSWORD = "root";
	public static final String DATA_BASE_USER_NAME = "root";
	public static final String DATA_BASE_URL = "jdbc:derby://localhost:1527/tmchatdb";
	public static final String DATA_BASE_DRIVER_NAME = "org.apache.derby.jdbc.ClientDriver";
	
	public static final String INSERT_CLOSED_ACCOUNT = "INSERT INTO CLOSED_ACCOUNT VALUES ( ? ) ";
	public static final String INSERT_MESSAGE = "INSERT INTO MESSAGE VALUES (?, ?, ?, ?, ?, 'N')";
	public static final String INSERT_NOTIFICATION = "INSERT INTO NOTIFICATION VALUES (?, ?, ?, ?, ?)";
	public static final String INSERT_FRIEND = "INSERT INTO FRIEND (FRIEND_CODE,MEMBER_CODE) VALUES (?, ?)";
	public static final String INSERT_FRIEND_REQUEST = "INSERT INTO FRIEND_REQUEST(SENT_BY,SENT_TO) VALUES (?, ?)";
	
	public static final String GET_MEMBER_TABLE_BY_CODE = "SELECT * FROM MEMBER WHERE CODE = ?";
	public static final String GET_MEMBER_TABLE_BY_USERNAME = "SELECT * FROM MEMBER WHERE USERNAME = ?";
	public static final String GET_CODE_FROM_MEMBER_TABLE_BY_USERNAME = "SELECT CODE FROM MEMBER WHERE USERNAME = ?";
	
	public static final String DELETE_FROM_FRIEND = "DELETE FROM FRIEND WHERE MEMBER_CODE = ? OR FRIEND_CODE = ?";
	public static final String DELETE_FROM_FRIEND_REQUEST = "DELETE FROM FRIEND_REQUEST WHERE SENT_BY = ? OR SENT_TO = ?";
	public static final String DELETE_FROM_FRIEND_REQUEST_BY_AND_TO = "DELETE FROM FRIEND_REQUEST WHERE SENT_BY = ? AND SENT_TO = ?";
	public static final String DELETE_FROM_FRIEND_OR_AND = "DELETE FROM FRIEND WHERE ((FRIEND_CODE = ? AND MEMBER_CODE = ?) OR (FRIEND_CODE = ? AND MEMBER_CODE = ?))";
	
	public static final String SELECT_FROM_FRIEND_REQUEST = "SELECT * FROM FRIEND_REQUEST WHERE SENT_BY = ? AND SENT_TO = ?";
	public static final String SELECT_FROM_FRIEND_REQUEST_OR = "SELECT * FROM FRIEND_REQUEST WHERE (SENT_TO = ? AND SENT_BY = ?) OR (SENT_TO = ? AND SENT_BY = ?)";
	public static final String SELECT_FROM_FRIEND_OR_AND = "SELECT * FROM FRIEND WHERE ((FRIEND_CODE = ? AND MEMBER_CODE = ?) OR (FRIEND_CODE = ? AND MEMBER_CODE = ?))";
	
	
	
}
