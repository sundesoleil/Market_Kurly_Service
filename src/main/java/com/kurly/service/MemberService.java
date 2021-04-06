package com.kurly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kurly.mapper.MemberMapper;
import com.kurly.vo.LoginVO;
import com.kurly.vo.SimpleMemberVO;

@Service
public class MemberService {
	@Autowired
	MemberMapper mapper;
	
	public boolean memberLogin(LoginVO vo) {
		/* if (mapper.memberLogin(vo) == 1 return true;
		 else return false; */
		return mapper.memberLogin(vo) == 1; 
	}
	
	public SimpleMemberVO selectSimpleMemberInfo(LoginVO vo) {
		return mapper.selectSimpleMemberInfo(vo);
	}
}
