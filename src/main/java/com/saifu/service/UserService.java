package com.saifu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.saifu.model.OAuthModel;

/**
 * Zaimユーザ情報に関するサービス
 * @author kxn4t
 */
@Service
public class UserService {

	@Autowired
	HttpClientService httpClientService;

	@Value("${zaim.api.user}")
	private String userVerifyURL;

	/**
	 * ユーザ情報を取得
	 * @param oAuthModel
	 * @return ユーザ情報(JSON)
	 * @throws Exception
	 */
	public String getUserVerify(OAuthModel oAuthModel) throws Exception {
		oAuthModel.setURL(userVerifyURL);
		return httpClientService.getRequestToZaim(oAuthModel);
	}

}
