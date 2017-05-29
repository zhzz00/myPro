package com.bear.service.sys.impl;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bear.dao.IncomeDao;
import com.bear.dto.QueryIncomeSumReq;
import com.bear.dto.QueryIncomeSumRsp;
import com.bear.exception.HandelException;
import com.bear.service.sys.IIncomeService;
import com.google.common.collect.Maps;

@Service("incomeService")
public class IncomServiceImpl implements IIncomeService{

	@Autowired
	private IncomeDao incomedao;
	@Override
	public QueryIncomeSumRsp queryIncomSum(QueryIncomeSumReq req) {
		Map<String, Object> qm = Maps.newHashMap();
		QueryIncomeSumRsp rsp = new QueryIncomeSumRsp();
		if(req.getUserId() != null){
			qm.put("userId", req.getUserId());
		}
		if(req.getSiteId() != null){
			qm.put("siteId", req.getSiteId());
		}
		if(StringUtils.isNotBlank(req.getStartTime())){
			qm.put("startTime", req.getStartTime());
		}
		if(StringUtils.isNotBlank(req.getStartTime())){
			qm.put("startTime", req.getStartTime());
		}
		if(StringUtils.isNotBlank(req.getEndTime())){
			qm.put("endTime", req.getEndTime());
		}
		try {
			String sum  = incomedao.queryIncomeSum(qm);
			rsp.setMoneySum(sum);
		} catch (Exception e) {
			throw new HandelException("query queryIncomSum exception", -3000);
		}
		
		return rsp;
	}

}
