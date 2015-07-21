package test.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import test.spring.domain.RespData;
import test.spring.domain.StudentPo;

@Controller
@RequestMapping("/test")
public class TestController implements ApplicationContextAware{
	
	/**
	 * 测试感知接口
	 */
	private ApplicationContext ctx;

	private static Logger logger = LoggerFactory
			.getLogger(TestController.class);

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public RespData test() {
		RequestMappingHandlerMapping handler = ctx.getBean("requestMappingHandlerMapping",RequestMappingHandlerMapping.class);
		StudentPo studentPo = testConfig();
		RespData respData = new RespData();
		respData.setData(studentPo);
		logger.debug(respData.toString());
		return respData;
	}
	
	/**
	 * 测试 外部化Bean配置
	 * @return
	 */
	private StudentPo testConfig(){
		StudentPo student = ctx.getBean("test_Student", StudentPo.class);
		return student;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.ctx = applicationContext;
	}

}
