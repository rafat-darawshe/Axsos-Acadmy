package com.DisplayDatee.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controller1 {
	

	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEEEE',' 'the' d 'of' MMMMM',' y");
		model.addAttribute("date", sdf.format(new Date()));
		return "date.jsp";
	}

	@RequestMapping("/time")
	public String time(Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("K:mm a");
		model.addAttribute("time", sdf.format(new Date()));
		return "time.jsp";
	}

}
