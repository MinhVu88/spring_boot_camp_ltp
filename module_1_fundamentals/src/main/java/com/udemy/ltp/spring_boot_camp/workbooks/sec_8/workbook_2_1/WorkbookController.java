package com.udemy.ltp.spring_boot_camp.workbooks.sec_8.workbook_2_1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkbookController {
	@GetMapping("/")
	public String getShows() {
		return "shows_2_1";
	}
}
