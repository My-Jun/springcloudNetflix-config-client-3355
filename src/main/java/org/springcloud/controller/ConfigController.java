package org.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

	/**
	 * 项目名字
	 */
	@Value("${spring.application.name}")
	private String application;

	/**
	 * eureka服务
	 */
	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServer;

	/**
	 * port服务端口
	 */
	@Value("${server.port}")
	private String port;

	/**
	 * 获取远程配置内容
	 * 
	 * @return
	 */
	@RequestMapping("/config")
	public String getConfig() {
		String s = "application=%s;eurekaServer=%s;port=%s;";
		return String.format(s, application, eurekaServer, port);
	}

}
