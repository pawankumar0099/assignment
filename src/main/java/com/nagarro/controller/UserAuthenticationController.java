package com.nagarro.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.dao.UserAuthenticationDao;

@Controller
@SessionAttributes("username")
public class UserAuthenticationController {

	@Autowired
	UserAuthenticationDao userAuthenticationDao;

	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response) throws IOException {

		boolean validation = false;
		validation = userAuthenticationDao.ValidateUser(username, password);

		request.getSession().setAttribute("username", username);
		return "welcome";

	}

	@RequestMapping("/validateUsername")
	public ModelAndView validateUsername(@RequestParam("username") String username, HttpServletRequest request,
			HttpServletResponse response) {

		boolean validation = false;
		validation = userAuthenticationDao.isUserExist(username);

		ModelAndView modelAndView = new ModelAndView();
		if (validation == true)
			modelAndView.setViewName("resetpassword");
		else
			modelAndView.setViewName("home");
		return modelAndView;
	}

	@RequestMapping("/updatePassword")
	public ModelAndView updatePassword(HttpServletRequest req, HttpServletResponse res) {

		String username = req.getParameter("username");
		String password = req.getParameter("pass1");
		ModelAndView modelAndView = new ModelAndView();

		userAuthenticationDao.updatePassword(username, password);
		modelAndView.setViewName("home");

//		r.insertCsvRecordIntoDatabase();

		return modelAndView;
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest req, HttpServletResponse res) {
		req.getSession().removeAttribute("username");
		req.getSession().invalidate();
		return "home";
	}

	@RequestMapping("/veryfyusername")
	public String ver() {
		return "veryfyusername";
	}
}
