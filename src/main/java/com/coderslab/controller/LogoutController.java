/**
 * 
 */
package com.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cyclingbd007
 *
 */
@Controller
@RequestMapping("/logout")
public class LogoutController {

	@RequestMapping
	public String loadLoginPage() {
		return "redirect:/login";
	}
	
}
