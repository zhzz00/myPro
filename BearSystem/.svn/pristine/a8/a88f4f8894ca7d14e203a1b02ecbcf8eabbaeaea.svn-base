package com.bear.web.sys;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bear.dto.OrderListReq;
import com.bear.dto.OrderListRsp;
import com.bear.dto.ReturnVo;
import com.bear.exception.HandelException;
import com.bear.service.sys.IOrderService;
import com.bear.utils.JsonUtil;
import com.bear.web.BaseController;
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private IOrderService service;
	@RequestMapping(value="/queryOrder",method = RequestMethod.POST,produces={"application/json;charset=UTF-8"})
	public ReturnVo<OrderListRsp> queryOrder(@RequestBody String body){
		logger.info("user reg request param：" + body);
		OrderListReq req=JsonUtil.getObject(OrderListReq.class,body);
		if(null==req){
			throw new HandelException("Json消息非法", -8888);
		}
		ReturnVo<OrderListRsp> vo;
		try{
			OrderListRsp rsp=service.queryOrder(req);
			vo=new ReturnVo("10000", rsp.getOrderList());
		}catch(HandelException e){
			logger.error(e.getMessage(),e);
			vo=new ReturnVo<OrderListRsp>(e.getCode()+"", e.getMessage());
		}catch(Exception e){
			logger.error(e.getMessage(),e);
			vo=new ReturnVo<OrderListRsp>("-9999"+"", e.getMessage());
		}
		
		return vo;
	}
}
