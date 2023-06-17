package spring.aop.prob;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.lf5.viewer.LogFactor5Dialog;

/*
 * 비지니스 로직(Core concern)이 들어가 있는 Target
 * 핵심적인 로직들 사이에 부수적인 관심사(Cross Cutting Concern)가 산발적으로 있다.
 * OOP의 본질을 흐리고 있다.
 * 
 * 부수적인 관심사...log파일 출력기능...
 */
public class ProductService {

	private Log log = LogFactory.getLog(getClass());

	public String deleteProduct(String id) {
		System.out.println(id + "deleteProduct...logic..회원삭제 성공");
		log.info(id + " deleteProduct info...");

		return "삭제된 상품 ID :" + id;
	}

	public void findMember(String id) {
		System.out.println("findMember...logic..회원검색 성공");

	}

}
