package com.bit.controller.space;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpaceController {
	
	@GetMapping("/sidenav")
	public String sidebar() {
		return "common/sidenav";
	}
	
	@GetMapping("/nav")
	public String navigation() {
		return "common/sidenavDrawer";
	}
}
