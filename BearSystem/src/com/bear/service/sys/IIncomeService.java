package com.bear.service.sys;

import com.bear.dto.QueryIncomeSumReq;
import com.bear.dto.QueryIncomeSumRsp;

public interface IIncomeService {
	public QueryIncomeSumRsp queryIncomSum(QueryIncomeSumReq req);
}
