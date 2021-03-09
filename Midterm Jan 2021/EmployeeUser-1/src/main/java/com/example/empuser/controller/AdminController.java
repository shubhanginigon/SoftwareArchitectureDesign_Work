package com.example.empuser.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.empuser.dao.EmployeeDao;
import com.example.empuser.model.Employee;
import com.example.empuser.model.Level;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	EmployeeDao dao;

	@RequestMapping(path = "/add", method = RequestMethod.GET)
	public ModelAndView showAddForm(Employee emp) {
		Level level;
		ModelAndView mv = new ModelAndView("addEmployee.jsp");
		mv.addObject("levels", Level.values());
		return mv;
	}

	// Add Employee to DB
	@RequestMapping(path = "/employee", method = RequestMethod.POST)
	public ModelAndView addNewEmployee(Employee emp,
			@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate birthDay) {
		ModelAndView mv = new ModelAndView("empAdded.jsp");
		dao.save(emp);
		System.out.println("Employee added. Showing employee details");
		mv.addObject("emp", emp);
		return mv;
	}
}
