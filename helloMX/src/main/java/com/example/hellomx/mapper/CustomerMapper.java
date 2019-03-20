package com.example.hellomx.mapper;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Select;
import com.example.hellomx.domain.CustomerVO;
import com.example.hellomx.domain.MemberVO;

public interface CustomerMapper {
	//@Select("select * from customer")
	public ArrayList<CustomerVO> getList();
	
	public ArrayList<MemberVO> login(String id);
}