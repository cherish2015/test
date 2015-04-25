package test.spring.mvc.util;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import test.spring.mvc.po.TCommodity;
import test.spring.mvc.service.TestService;

@Component
public class StartupInitial {
	
	private static Logger logger = LoggerFactory.getLogger(StartupInitial.class);
	
	@Autowired(required=true)
	private TestService testService;
	
	public void test(){
		List<TCommodity> result;
		try {
			result = testService.getTCommodityAll();
			for (int i = 0; i < result.size(); i++) {
				logger.warn(ToStringBuilder.reflectionToString(result.get(i), ToStringStyle.MULTI_LINE_STYLE));			
			}
		} catch (Exception e) {
			logger.debug("testService.getTCommodityAll() ERROR", e);
		}
	}

}
