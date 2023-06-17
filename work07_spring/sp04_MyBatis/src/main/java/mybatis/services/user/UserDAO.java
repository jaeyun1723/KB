package mybatis.services.user;

import java.util.List;

import mybatis.services.domain.User;

//~~mapping10.xml
/*
 * ~~mapping10.xml의 쿼리문 태그의 id값이 기능의 이름이 된다.
 * parameter type은 기능의 인자값
 * resultType, resultMap 기능의 반환값으로 생각...
 */
public interface UserDAO {
	int addUser(User user) throws Exception;

	int updateUser(User user) throws Exception;

	int removeUser(String userId) throws Exception;

	User getUser(String userId) throws Exception;

	List<User> getUserList(User user) throws Exception;
}
