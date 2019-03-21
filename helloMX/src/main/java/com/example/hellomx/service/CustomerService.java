package com.example.hellomx.service;

import java.util.ArrayList;
import com.example.hellomx.domain.CustomerVO;
import com.example.hellomx.domain.MemberVO;

public interface CustomerService {
	public ArrayList<CustomerVO> getList();
	
	public ArrayList<MemberVO> login(String id);

	public int sign(MemberVO insert);
}