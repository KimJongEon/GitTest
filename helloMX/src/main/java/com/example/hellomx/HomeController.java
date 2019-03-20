package com.example.hellomx;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.hellomx.domain.MemberVO;
import com.example.hellomx.service.CustomerService;

import lombok.AllArgsConstructor;



/**
 * Handles requests for the application home page.
 */
@Controller
@AllArgsConstructor
public class HomeController {
	
   private CustomerService customerService;
   
   @RequestMapping(value = "/", method=RequestMethod.GET)
   public String home(Model model) {
//	   model.addAttribute("list", customerService.getList());
	   return "home";
   }
   
   @RequestMapping(value = "/login", method=RequestMethod.GET)
   public String login(Model model) {
	   
	   return "login";
   }
   
   @RequestMapping("login.do")
   	@ResponseBody
   public String loginCheck(Model model,HttpSession session, @RequestParam String id, @RequestParam String password){
	
	   ArrayList<MemberVO> member = new ArrayList<MemberVO>();
	   member = customerService.login(id);
	   
	   if(member.size() != 0) {
	         
	         if(member.get(0).getPassword().equals(password)) {
	            model.addAttribute("id",member.get(0).getUserid());
	            session.setAttribute("id", member.get(0).getUserid());
	            return "success";
	         }else {
	            return "fail";
	         }
	      }else {
	         return "fail";
	      }
	  
	   
   }
//   @RequestMapping("sing.do")
//   public String signup(Model model, @RequestParam String id ,@RequestParam String password) {
//	   
//   }
//   
   
   
   @RequestMapping(value = "/signup", method=RequestMethod.GET)
   public String signup(Model model) {
	   
	   return "signup";
   }

		

	
}
