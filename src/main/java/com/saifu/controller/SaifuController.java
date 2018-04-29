package com.saifu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saifu.model.OAuthModel;
import com.saifu.service.UserService;

/**
 * 認証済みページのつもり
 * @author kxn4t
 */
@Controller
public class SaifuController {

	@Autowired
	UserService userService;

	@RequestMapping("/saifu")
	public String saifuTop(@CookieValue(value = "accessToken") String accessToken,
			@CookieValue(value = "accessTokenSecret") String accessTokenSecret, Model model) throws Exception {

		OAuthModel oAuthModel = new OAuthModel(accessToken, accessTokenSecret);

		// TODO:テストでリクエストしてみる
		model.addAttribute("zaimUserVerify", userService.getUserVerify(oAuthModel));

		return "saifu";
	}


}
