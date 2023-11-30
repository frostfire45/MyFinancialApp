/**
 * 
 */
package com.frostfire.myfinancialapp.Controller;

import com.frostfire.myfinancialapp.Models.Bank;
import com.frostfire.myfinancialapp.services.MockBank;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
	private final MockBank banksDao;

	public HomeController(){
		this.banksDao = new MockBank();
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "/index";
	}
	@RequestMapping(value="/hello2")
    public ModelAndView hello(@RequestParam(required=false, defaultValue="World") String name) {
        ModelAndView ret = new ModelAndView("home");

        // Adds an object to be used in home.jsp
        //ret.addObject("name", testingMethod());
        
        //logs to console 
        //practiceLoop();
        
        return ret;
    }
	@RequestMapping(value = "/hello")
	public ModelAndView byeWorld() {
		ModelAndView mv = new ModelAndView("home");

		List<Bank> banks = new ArrayList<Bank>();
		banks.addAll(banksDao.getAllBanks());
		mv.addObject("banks",banks);

		return mv;
	}
}
