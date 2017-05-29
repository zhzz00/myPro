package com.bear.service.site.impl;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bear.dao.CarDao;
import com.bear.dao.SiteDao;
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
import com.bear.entity.CarStock;
import com.bear.entity.Site;
import com.bear.exception.HandelException;
import com.bear.service.site.ICarService;
import com.bear.service.site.ISiteService;
import com.google.common.collect.Maps;



/**
 * 车辆实现类
 * @author lzx
 * @since 2017-04-17
 */
@Service("carService")
public class CarServiceImpl  implements ICarService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CarDao carDao;
	

	/**
	 * 查询站点车辆列表
	 */
	@Override
	public QueryCarListRsp queryCarList(QueryCarListReq req) {
		
		QueryCarListRsp rsp = null;
		try {
			rsp = new QueryCarListRsp();
			
			Map<String, Object> qm = Maps.newHashMap();
			qm.put("page", (req.getPage()-1) * req.getPageSize());
			qm.put("pageSize", req.getPageSize());
			qm.put("siteId", req.getSiteId());
			if(req.getCarNo()!= null){
				qm.put("carNo", req.getCarNo());
			}
			List<CarStock> carList =  carDao.queryCarList(qm);
			int count = carDao.queryCarListCount(qm);
			
			if(carList == null){
				throw new HandelException("未查询到记录！", -10000);
			}
			rsp.setCarStocks(carList);
			rsp.setRows(count);
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("query car exception", e);
			throw new HandelException("查询车辆信息异常！", -10000);
		}
		return rsp;
	}


	/**
	 * 添加车辆
	 */
	@Transactional
	@Override
	public AddCarRsp addCar(AddCarReq req) {
		CarStock car = new CarStock();
		//BeanUtils.copyProperties(req, car, new String[]{});
		car.setCarNo(req.getCarNo());
		car.setStationId(req.getStationId());
		
		AddCarRsp rsp=new AddCarRsp();
		try{
			// 查询车牌号
			int count = carDao.queryCarNoExists(req.getCarNo());
			if(count>0){
				throw new HandelException("该车牌号已存在！", -10000);
			}
			carDao.insertCar(car);
			rsp.setId(car.getId());
			rsp.setCarNo(car.getCarNo());
			rsp.setStationId(car.getStationId());
			rsp.setCarStatus(0);
		}catch(HandelException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("新增车辆异常！",e );
			throw new HandelException("新增车辆异常！", -10000);
		}
		return rsp;
	}

	/**
	 * 查询车辆详情
	 */
	@Override
	public QueryCarDetailRsp queryCarDetail(QueryCarDetailReq req) {
		
		QueryCarDetailRsp rsp=new QueryCarDetailRsp();
		try{
			
			CarStock car = carDao.queryCarDetail(req.getId());
			if(car == null){
				throw new HandelException("该车辆不存在！", -10000);
			}
			rsp.setId(car.getId());
			rsp.setCarNo(car.getCarNo());
			rsp.setStationId(car.getStationId());
			rsp.setCarStatus(car.getCarStatus());
		}catch(HandelException e){
			throw e;
		}catch(Exception e){
			e.printStackTrace();
			logger.error("查询车辆异常！",e );
			throw new HandelException("查询车辆异常！", -10000);
		}
		return rsp;
	}
	
}
