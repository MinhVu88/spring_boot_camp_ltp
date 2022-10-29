package com.udemy.ltp.spring_boot_camp.challenges.sec_9_challenge_2_global_superstore;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class StoreController {
	List<Item> items = new ArrayList<>();

	@GetMapping("/")
	public String getForm(
		Model model,
		@RequestParam(required = false) String id
	) {
		int index = getItemIndexById(id);

		model.addAttribute(
			"item",
			index == Constants.NOT_FOUND ? new Item() : items.get(index)
		);

		model.addAttribute("categories", Constants.CATEGORIES);

		return "form2";
	}

	@GetMapping("/inventory")
	public String getInventory(Model model) {
		model.addAttribute("items", items);

		return "inventory";
	}

	@PostMapping("/submit-item")
	public String submitItem(
		Item item,
		RedirectAttributes redirectAttributes
	) {
		int index = getItemIndexById(item.getId());

		String status = Constants.SUCCESS_STATUS;

		if(index == Constants.NOT_FOUND) {
			items.add(item);
		}else if(isWithin5Days(item.getDate(), items.get(index).getDate())) {
			items.set(index, item);
		}else {
			status = Constants.FAILED_STATUS;
		}

		redirectAttributes.addFlashAttribute("status", status);

		return "redirect:/inventory";
	}

	private int getItemIndexById(String id) {
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getId().equalsIgnoreCase(id)) {
				return i;
			}
		}

		return Constants.NOT_FOUND;
	}

	private boolean isWithin5Days(Date newDate, Date oldDate) {
		long diff = Math.abs(newDate.getTime() - oldDate.getTime());

		return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
	}
}
