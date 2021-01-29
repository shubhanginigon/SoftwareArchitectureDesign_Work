package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserJPADao;
import com.example.demo.model.User;

@Controller
public class UserController {
	
	@Autowired
	UserDao dao;
	
	@Autowired
	UserJPADao jpaDao;
	
	@RequestMapping(path="/", method = RequestMethod.GET)
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping(path="/addUser", method = RequestMethod.GET)
	public String addUser(User user) {
		dao.save(user);
		
		System.out.println(dao.findByNationality("Hong Kong"));
		System.out.println(dao.findByUidGreaterThan(101));
		System.out.println(dao.findByNationalitySorted("Hong Kong"));
		
		return "home.jsp";
	}
	
	@RequestMapping(path ="/getUser" , method = RequestMethod.GET)
	public ModelAndView getUser(@RequestParam int uid) {
		ModelAndView mv = new ModelAndView("showUser.jsp");
		User e =dao.findById(uid).orElse(new User());
		mv.addObject(e);
		
		
		return mv;
	}
	
	@RequestMapping(path="/users", method = RequestMethod.GET)
	@ResponseBody
	public String getUsersRest() {
		return dao.findAll().toString();
	}
	
	@RequestMapping(path = "/usersJPA", method =RequestMethod.GET)
	@ResponseBody
	public List<User> getUsersRESTJPA(){
		return jpaDao.findAll();
	}
	
	@RequestMapping(path="/user/{uid}", method = RequestMethod.GET)
	@ResponseBody
	public String getUserRest(@PathVariable("uid") int uid) {
		return dao.findById(uid).toString();
	}
	
	@RequestMapping(path="/userJPA/{uid}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Optional<User> getUserRESTJPA(@PathVariable("uid") int uid) {
		return jpaDao.findById(uid);
	}
	
	@RequestMapping(path="/userJPA", method = RequestMethod.POST)
	@ResponseBody
	public User postUser(@RequestBody User user) {
		jpaDao.save(user);
		return user;
	}
	
	@RequestMapping(path="/userJPA", method = RequestMethod.PUT , consumes="application/json")
	@ResponseBody
	public String saveOrUpdateUser(@RequestBody User user) {
		jpaDao.save(user);
		return "updated";
	}
	
	@RequestMapping(path="/userJPA/{uid}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deleteUser(@PathVariable("uid") int uid) {
		User user = jpaDao.getOne(uid);
		jpaDao.delete(user);
		return "deleted";
	}
}
