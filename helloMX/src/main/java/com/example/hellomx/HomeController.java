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
	            System.out.println(session.getAttribute("id"));
	            return "success";
	         }else {
	            return "fail";
	         }
	      }else {
	         return "fail";
	      }
	  
	   
   }
   @RequestMapping("sign.do")
   	@ResponseBody
   public String sign(Model model, @RequestParam String id ,@RequestParam String password, @RequestParam String email, @RequestParam String name, @RequestParam String adress) {
	   
	   MemberVO insert = new MemberVO();
	   
	   insert.setUserid(id);
	   insert.setPassword(password);
	   insert.setEmail(email);
	   insert.setName(name);
	   insert.setAdress(adress);
	    
	   int suc = customerService.sign(insert);
	  
	
	   return "signup";
	   
   }
   
   @RequestMapping("logout.do")
  	@ResponseBody
  public String logout(Model model,HttpSession session){
	if(session != null) {
	   session.invalidate();
		return "success";
	}else {
		return "know";
	}
 
  }
   
   
   
   @RequestMapping(value = "/signup", method=RequestMethod.GET)
   public String signup(Model model) {
	   
	   return "signup";
   }
   
   @RequestMapping(value = "/page", method=RequestMethod.GET)
   public String menuPage(Model model) {
	   
	   return "page";
   }
   
   //각 기능 페이지 이동 Mapping
   
   @RequestMapping(value = "/hotel", method=RequestMethod.GET)
   public String hotel(Model model) {
	   
	   return "service/hotel";
   }
   
   @RequestMapping(value = "/hospital", method=RequestMethod.GET)
   public String hospital(Model model) {
	   
	   return "service/hospital";
   }
   @RequestMapping(value = "/goodbye", method=RequestMethod.GET)
   public String goodbye(Model model) {
	   
	   return "service/goodbye";
   }
   
   @RequestMapping(value = "/goodbye2", method=RequestMethod.GET)
   public String goodbye2(Model model) {
	   
	   return "service/goodbye2";
   }
   
   
   

		

	
}
