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
@RequestMapping("/login")
public class LoginController {

	@RequestMapping
	public String loadLoginPage() {
		return "views/login";
	}
	
}
