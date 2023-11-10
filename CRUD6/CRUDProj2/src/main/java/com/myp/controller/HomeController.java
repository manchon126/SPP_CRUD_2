package com.myp.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * url 주소 미지정시 home.jsp 뷰를 호출하는 컨트롤러
 * @author 최욱철
 * @since 2023-10-11
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * url 주소에 아무것도 입력하지 않으면 home.jsp 뷰로 mapping
	 * @author 최욱철
	 * @since 2023-10-11
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/**
	 * test.jsp
	 * @author 최욱철
	 * @since 2023-10-16
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String ajaxTest() {
		logger.info("Welcome home! Test!{}");
		
		return "test";
	}
	
}
