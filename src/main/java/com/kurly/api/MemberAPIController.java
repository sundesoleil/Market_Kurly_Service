package com.kurly.api;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kurly.service.MemberService;
import com.kurly.vo.LoginVO;
import com.kurly.vo.SimpleMemberVO;

@RestController
public class MemberAPIController {
	@Autowired
	MemberService service;
	
	@PostMapping("/member/login")
	// httpservletresponse: ajax 없이 브라우저로 바로 통신
	public Map<String, String> postLogin(
			@RequestBody LoginVO vo, 
			HttpServletResponse response,
			HttpSession session){
		Map<String, String> resultMap = new LinkedHashMap<String, String>();
		
		if(vo.getId() == null || vo.getPwd() == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST); 
			resultMap.put("message", "필드명 [id] 또는 [pwd]가 비어 있습니다.");
			return resultMap;
		}
		
		if(service.memberLogin(vo)) {
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			resultMap.put("message", "로그인 되었습니다.");
			
			SimpleMemberVO memberInfo = service.selectSimpleMemberInfo(vo);
			session.setAttribute("memberInfo", memberInfo);
		}
		else {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			resultMap.put("message", "로그인에 실패하였습니다.");
		}
		
		return resultMap;
		
	}
}
