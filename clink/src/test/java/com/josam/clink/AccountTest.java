package com.josam.clink;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.josam.clink.challenge.ChallengeMapper;
import com.josam.clink.challenge.ChallengeService;
import com.josam.clink.challenge.ChartVO;
import com.josam.clink.challenge.SuccessVO;
import com.josam.clink.user.UserVO;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountTest {
	
	@Test
	public void test() {
		System.out.println("sss");
	}
	
	@Autowired
	ChallengeMapper mapper;
	
	@Autowired
	ChallengeService cs = new ChallengeService();
	/*
	 * 초기 데이터 입력용도
	 * */
	@Test
	public void insertAllSuccess() {
		UserVO uvo = new UserVO();
		uvo.setUser_no("00000");

		List<SuccessVO> list = mapper.getAllHistoryForInsertSuccess(uvo);
		BigDecimal goal = new BigDecimal(50000);
		for(SuccessVO svo: list) {	
			if (svo.getChallenge_detail_success_amount().compareTo(goal)<=0) {
				svo.setChallenge_no("10721");
				svo.setRegister_id("01010");
				mapper.insertSuccess(svo);
			}
		}
	}
	
	@Test
	public void weekData() {
		
		UserVO uvo = new UserVO();
		uvo.setUser_no("00000");
		
		List<ChartVO> list = mapper.weekHistory(uvo);
		for(ChartVO vo: list) {
			System.out.println(vo.getDate()+" "+vo.getC1()+" "+vo.getC2()+" "+vo.getC3());
		}
		
	}
}
