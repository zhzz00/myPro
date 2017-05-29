package com.bear.web.site;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bear.dto.AddCarReq;
import com.bear.dto.AddCarRsp;
import com.bear.dto.QueryCarBySiteReq;
import com.bear.dto.QueryCarBySiteRsp;
import com.bear.dto.QueryCarDetailReq;
import com.bear.dto.QueryCarDetailRsp;
import com.bear.dto.QueryCarListReq;
import com.bear.dto.QueryCarListRsp;
import com.bear.dto.QuerySiteInfoReq;
import com.bear.dto.QuerySiteInfoRsp;
import com.bear.dto.ReturnVo;
import com.bear.exception.HandelException;
import com.bear.service.site.ICarService;
import com.bear.service.site.ISiteService;
import com.bear.utils.JsonUtil;
import com.bear.utils.ParametersCheckUtil;
import com.bear.web.BaseController;


@RestController
@RequestMapping({"/car"})
public class CarController extends BaseController{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ICarService carService;	
	
	/**
	 * 查询车辆列表
	 * @param body
	 * @param request
	 * @return
	 */
	@RequestMapping(value={"/queryCarList"}, method={RequestMethod.POST}, produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public ReturnVo<QueryCarListRsp> queryCarList(@RequestBody String body, HttpServletRequest request)
	{
		logger.info("querySiteInfo request param：" + body);
		//把body转换成对象
		QueryCarListReq req = JsonUtil.getObject(QueryCarListReq.class,body);
		if (null == req) {
			throw new HandelException("Json消息非法", -8888);
		}
		ParametersCheckUtil.checkParams(req.getSiteId(), "siteId");
		ReturnVo<QueryCarListRsp> vo;
		try {
			QueryCarListRsp rsp = carService.queryCarList(req);
			vo = new ReturnVo("10000","success",rsp.getCarStocks());
		} catch (HandelException e) {
			logger.error(e.getMessage(), e);
			vo = new ReturnVo<QueryCarListRsp>(e.getCode().toString(), e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			vo = new ReturnVo<QueryCarListRsp>("-9999", e.getMessage());
		}
		return vo;
	}
	
	/**
	 * 添加车辆信息
	 * @param body
	 * @param ip
	 * @param source
	 * @return
	 */
	@RequestMapping(value={"/addCar"}, method={RequestMethod.POST}, produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public ReturnVo<AddCarRsp> addCar(@RequestBody String body, HttpServletRequest request){
		logger.info("addCar request param：" + body);
		
		ReturnVo<AddCarRsp> result;
		AddCarReq req = JsonUtil.getObject(AddCarReq.class,body);
		if(null == req){
			throw new HandelException("Json消息非法", -8888);
		}
		ParametersCheckUtil.checkParams(req.getCarNo(), "carNo");
		ParametersCheckUtil.checkParams(req.getStationId(), "stationId");
		AddCarRsp rsp = new AddCarRsp();
		try {
			rsp = carService.addCar(req);
			result = new ReturnVo<AddCarRsp>("10000","success", rsp);
		} catch (HandelException e) {
			logger.error(e.getMessage(), e);
			result = new ReturnVo<AddCarRsp>(e.getCode()+"", e.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = new ReturnVo<AddCarRsp>("-9999", e.getMessage());
		}
		return result;
	}
	
	/**
	 * 查询车辆详情
	 * @param body
	 * @param ip
	 * @param source
	 * @return
	 */
	@RequestMapping(value={"/queryCarDetail"}, method={RequestMethod.POST}, produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public ReturnVo<QueryCarDetailRsp> queryCarDetail(@RequestBody String body, HttpServletRequest request){
		
		ReturnVo<QueryCarDetailRsp> result;
		QueryCarDetailReq req = JsonUtil.getObject(QueryCarDetailReq.class,body);
		if(null == req){
			throw new HandelException("Json消息非法", -8888);
		}
		ParametersCheckUtil.checkParams(req.getId(), "id");
		
		QueryCarDetailRsp rsp = new QueryCarDetailRsp();
		try {
			rsp = carService.queryCarDetail(req);
			result = new ReturnVo<QueryCarDetailRsp>("10000","success",rsp);
		} catch (HandelException e) {
			logger.error(e.getMessage(), e);
			result = new ReturnVo<QueryCarDetailRsp>(e.getCode()+"", e.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = new ReturnVo<QueryCarDetailRsp>("-9999", e.getMessage());
		}
		return result;
	}
	
	
/*	*//**
	 * 修改车辆信息
	 * @param body
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value={"/updateCarInfo"}, method={RequestMethod.POST}, produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public ReturnVo<UpdateCarInfoRsp> updateCarInfo(@RequestBody String body, HttpServletRequest request){
		
		ReturnVo<UpdateCarInfoRsp> result;
		UpdateCarInfoReq req = JsonUtil.getObject(UpdateCarInfoReq.class,body);
		if(null == req){
			throw new HandelException("Json消息非法", -8888);
		}
		ParametersCheckUtil.checkParams(req.getId(), "id");
		
		UpdateCarInfoRsp rsp = new UpdateCarInfoRsp();
		try {
			rsp = carService.queryCarDetail(req);
			result = new ReturnVo<UpdateCarInfoRsp>("10000","success", rsp);
		} catch (HandelException e) {
			logger.error(e.getMessage(), e);
			result = new ReturnVo<UpdateCarInfoRsp>(e.getCode()+"", e.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = new ReturnVo<UpdateCarInfoRsp>("-9999", e.getMessage());
		}
		return result;
	}*/
	
	
	

	
	
}
