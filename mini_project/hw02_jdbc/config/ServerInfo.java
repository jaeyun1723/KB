package config;

public interface ServerInfo {	
	String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String USER = "scott";
	String PASS = "tiger";
	
	String SELECT_AQUERY = "SELECT name, bankname, balance FROM bank WHERE name=?";
	String DECREASE_UPDATE = "UPDATE bank SET balance=balance-? WHERE name=?";  
	String INCREASE_UPDATE = "UPDATE bank SET balance=balance+? WHERE name=?";  
	String SELECT_QUERY = "SELECT id, name, bankname, balance FROM bank";
}
