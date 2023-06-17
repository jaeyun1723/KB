package spring.aop.solv;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.lf5.viewer.LogFactor5Dialog;

/*
 * Target
 */
public class ProductService {

	public String deleteProduct(String id) {
		System.out.println(id + " deleteProduct...logic..회원삭제 성공");

		return "삭제된 상품 ID :" + id;
	}

	public void findMember(String id) {
		System.out.println("findMember...logic..회원검색 성공");

	}

}
