package test.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.spring.mvc.dao.TestDao;
import test.spring.mvc.po.TCommodity;
import test.spring.mvc.po.TOrder;

@Service
public class TestService {
	
	@Autowired(required=true)
	private TestDao testDao;
	
	public List<TCommodity> getTCommodityAll() throws Exception{
		return testDao.getTCommodityAll();
	}
	
	public Long getUserQQBeforeInsertByGoodId(TOrder order) {
		return null;
	}
	
	public Long getUserQQBeforeInsertByOrderId(TOrder order) {
		return null;
	}

}
