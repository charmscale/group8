package db;
/**
 * 
 * @author mehra
 * MYSQL database schema :coursedatabase
 * user :coursedatabase_admin
 * pass :Test1234
 * 
 */
public interface MyDB {

	String USER="root";
	String PASS="Hermes!7";
	String CONN_URL="jdbc:mysql://127.0.0.1:3306/coursedatabase";
	
	
}
/**
CREATE TABLE `customer` (
`userId` char(20) NOT NULL,
`password` char(10) DEFAULT NULL,
`name` char(20) DEFAULT NULL,
`admin` tinyint(4) DEFAULT NULL,
PRIMARY KEY (`userId`));

)
/**
 CREATE TABLE `comments`(
 `userID` char(20) NOT NULL,
 `comment` char(100) DEFAULT NULL,
 `time` TIMESTAMP NOT NULL,
 `reviewed` TINYINT NOT NULL DEFAULT 1,
 `page` char(45) DEFAULT NULL,
 
 PRIMARY KEY (`userID`, `time`));
 /**


jdbc:mysql://127.0.0.1:3306/coursedatabase?user=coursedatabase_admin

*/
