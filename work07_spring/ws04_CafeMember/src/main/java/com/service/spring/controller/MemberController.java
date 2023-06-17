package com.service.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.spring.domain.MemberVO;
import com.service.spring.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping("/register.do")
	public ModelAndView register(MemberVO vo) throws Exception {
		memberService.registerMember(vo);
		return new ModelAndView("register_result", "vo", vo);
	}

	@RequestMapping("/login.do")
	public ModelAndView login(HttpServletRequest request, MemberVO vo) throws Exception {
		MemberVO memberVO = memberService.getMember(vo.getId());
		if (memberVO != null && vo.getPassword().equals(memberVO.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("vo", memberVO);
			return new ModelAndView("login_result", "vo", memberVO);
		}
		return null; // 로그인 실패 페이지나 안내 메시지 띄어야 하는건가?
	}

	// session과 model은 독립적인 기능을 하는 것? yes
	// session이 여기서 나오는 이유는 로그인 후에 로그인을 유지한 채로 쓸 수 있는 기능들을 보여주려고? yes
	// 한 번 로그인해서 sessionID저장하면 그 이후 어떤 기능 요구할때마다 알아서 자동으로 그 sessionID로 처리해주나?
	// 매번 매핑할때 id같은지 확인 안해도 되나??
	// modelandView는 후처리 객체? 페이지 넘어가면서 넘겨주고 페이지 바인딩, 네비게이션 역할? yes

	@RequestMapping("/update.do")
	public ModelAndView update(MemberVO vo) throws Exception {
		memberService.updateMember(vo);
		return new ModelAndView("update_result", "vo", vo);
	}

	@RequestMapping("/find.do")
	public ModelAndView find(String id) throws Exception {
		MemberVO vo = memberService.getMember(id);
		return new ModelAndView("find_ok", "vo", vo);
	}

	// 왜 여긴 request가 없지? request는 session을 위한 기능인가? - 프레임워크 일인가?
	@RequestMapping("/showAll.do")
	public ModelAndView showAll() throws Exception {
		List<MemberVO> list = memberService.showAllMember();
		return new ModelAndView("allView", "list", list);
		// 뷰의 경로, 변수 이름, 데이터 값
	}

}
