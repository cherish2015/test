package test.spring.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import test.spring.mvc.po.TCommodity;
import test.spring.mvc.po.TOrder;

@Repository
public class TestDao {
	
	@Autowired(required=true)
	private JdbcTemplate jdbcTemplate;

	public List<TCommodity> getTCommodityAll() {
		String sql = "SELECT * FROM t_commodity";
		List<TCommodity> result = null;
		result = jdbcTemplate.query(sql, new RowMapper<TCommodity>() {

			@Override
			public TCommodity mapRow(ResultSet rs, int rowNum) throws SQLException {
				String id = rs.getString(1);
				String c_goods_code =  rs.getString(2);
				long c_user_qq = rs.getLong(3);
				String c_orders_code = rs.getString(4);
				String c_create_date = rs.getString(5);
				
				TCommodity commodity = new TCommodity();
				commodity.setId(id);
				commodity.setC_goods_code(c_goods_code);
				commodity.setC_user_qq(c_user_qq);
				commodity.setC_orders_code(c_orders_code);
				commodity.setC_create_date(c_create_date);
				return commodity;
			}
		});
		return result;
	}

	public Long getUserQQBeforeInsertByGoodId(TOrder order) {
		return null;
	}

	public Long getUserQQBeforeInsertByOrderId(TOrder order) {
		return null;
	}

}
