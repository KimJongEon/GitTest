package com.example.hellomx.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.example.hellomx.domain.CustomerVO;
import com.example.hellomx.domain.MemberVO;
import com.example.hellomx.mapper.CustomerMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImplement implements CustomerService {
	private CustomerMapper mapper;

	@Override
	public ArrayList<CustomerVO> getList() {
		return mapper.getList();
	}

	@Override
	public ArrayList<MemberVO> login(String id) {
		// TODO Auto-generated method stub
		return mapper.login(id);
	}

	@Override
	public int sign(MemberVO insert) {
		// TODO Auto-generated method stub
		return mapper.sign(insert);
	}


}