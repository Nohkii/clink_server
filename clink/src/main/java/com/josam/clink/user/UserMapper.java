package com.josam.clink.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {
	// 회원가입
	int insert(User_MasterVO vo);

	// 로그인
	User_MasterVO login(User_MasterVO vo);

	// 아이디 중복체크
	int checkDuplicateId(String user_id);

	User_MasterVO selectUserById(int user_id);
	
	// 프로필 사진 업로드
	int profileImage(User_MasterVO vo);

	// 개인정보 업데이트
	int update(User_MasterVO vo);

	// 계좌등록
	int registAccount(Account_DetailVO vo);
	
	
	// 계좌 수정
	int updateAccount(Account_DetailVO vo);

	// 계좌확인
	List<Account_DetailVO> checkAccount(Account_DetailVO vo);
}
