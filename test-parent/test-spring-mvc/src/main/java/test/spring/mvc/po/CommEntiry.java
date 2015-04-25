package test.spring.mvc.po;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CommEntiry {
	
	private String cmd;
	private String content;
	private String code;
	private String response;
	private String commissionRatePercent;
	private String commission;
	private String zkPrice;
	private String name;
	
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCommission() {
		return commission;
	}

	public void setCommission(String commission) {
		this.commission = commission;
	}

	public String getCommissionRatePercent() {
		return commissionRatePercent;
	}

	public void setCommissionRatePercent(String commissionRatePercent) {
		this.commissionRatePercent = commissionRatePercent;
	}

	public String getZkPrice() {
		return zkPrice;
	}

	public void setZkPrice(String zkPrice) {
		this.zkPrice = zkPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws Exception {
		this.name = name;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
