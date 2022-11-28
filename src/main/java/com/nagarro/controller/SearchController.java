package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nagarro.dao.ProductSearchDao;
import com.nagarro.model.TShirt;

@Controller
public class SearchController {

	@Autowired
	ProductSearchDao productSearchDao;

	@RequestMapping("/search")
	public String search(HttpServletRequest req, HttpServletResponse res, ModelMap model, HttpSession session) {

		String color = req.getParameter("color");
		String size = req.getParameter("size");
		String gender = req.getParameter("gender");
		String outputPreference = req.getParameter("outputp");

		List<TShirt> list;
		list = productSearchDao.search(color, size, gender, outputPreference);

		model.put("list", list);

		return "welcome";
	}
}
