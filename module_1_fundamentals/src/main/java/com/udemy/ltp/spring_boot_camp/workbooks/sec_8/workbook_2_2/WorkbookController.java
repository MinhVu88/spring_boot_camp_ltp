package com.udemy.ltp.spring_boot_camp.workbooks.sec_8.workbook_2_2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WorkbookController {
	List<Show> shows = new ArrayList<>();

	@GetMapping("/")
	public String getShows(Model model) {
		shows.add(new Show("Breaking Bad", "Ozymandias", 10.0));
		shows.add(new Show("Attack on Titan", "Hero", 9.9));
		shows.add(new Show("Attack on Titan", "Perfect Game", 9.9));
		shows.add(new Show("Star Wars: The Clone Wars", "Victory and Death", 9.9));
		shows.add(new Show("Mr. Robot", "407 Proxy Authentication Required", 9.9));

		model.addAttribute("shows", shows);

		return "shows_2_2";
	}
}
