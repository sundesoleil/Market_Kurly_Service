package com.kurly.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.kurly.vo.LoginVO;
import com.kurly.vo.SimpleMemberVO;

@Mapper
public interface MemberMapper {
	public Integer memberLogin(LoginVO vo);
	public SimpleMemberVO selectSimpleMemberInfo(LoginVO vo);
	
}
