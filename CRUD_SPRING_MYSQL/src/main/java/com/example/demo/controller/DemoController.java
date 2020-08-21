package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.demo.models.User;
import com.example.demo.models.UserRepository;

@Controller
public class DemoController {
	@Autowired
	private UserRepository userRepository;
	@RequestMapping("")
	public String home(Model model) 
	{
		return "home";
	}
	
	@RequestMapping(value = "/addUsers",method = RequestMethod.GET)
	public String addUsers() 
	{
		return "addUser";
	}

	@RequestMapping(value = "/addUsers",method = RequestMethod.POST)
	public String addUsersDone(@ModelAttribute User user,Model model) 
	{
		System.out.println("User : "+user+" RR : ");
		if(userRepository.findById(user.getRollno()).isPresent())
		{
			model.addAttribute("message", "Roll No. Already Present");
			return "ShowMessage";
		}
		userRepository.save(user);
		model.addAttribute("message", "Added Successfully");
		return "ShowMessage";
	} 
	@RequestMapping(value = "/removeUser",method = RequestMethod.GET)
	public String removeUsers(Model model) 
	{
		model.addAttribute("user_list",userRepository.findAll());
		return "removeUser";
	}

	@RequestMapping(value = "/removeUser",method = RequestMethod.POST)
	public String remUsersDone(@ModelAttribute User user,Model model) 
	{
		System.out.println("User being Remove : "+user);
		if(userRepository.findById(user.getRollno()).isPresent())
		{
			userRepository.delete(user);
			model.addAttribute("message", "Removed Successfully");
		}
		else
			model.addAttribute("message","Not Found");
		return "ShowMessage";
	}
	@RequestMapping("/listUsers")
	public String listUser(Model model)
	{
		model.addAttribute("list_users", userRepository.findAll());
		return "listUser";
	}
	@RequestMapping("/updateList")
	public String update1(Model model)
	{
		model.addAttribute("user_list", userRepository.findAll());
		return "updateList1";
	}
	@RequestMapping(value = "/updateList2",method = RequestMethod.POST)
	public String update2(@ModelAttribute User user,Model model)
	{
		System.out.println("User : "+user+" RR : ");
		if(userRepository.findById(user.getRollno()).isPresent())
		{
			userRepository.save(user);
			model.addAttribute("message", "Updated Successfully");
			return "ShowMessage";
		}
		model.addAttribute("message", "Roll No. Not Present");
		return "ShowMessage";		
	}
}
