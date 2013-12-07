package com.ssb.service;

import javax.jws.WebService;

import com.ssb.service.SomeException;
import com.ssb.model.Data;

/**
 * @author shreyas.purohit
 * 
 */
@WebService(endpointInterface = "com.ssb.service.IDataService", serviceName = "dataService")
public class DataServiceImpl implements IDataService {

	/** 
     * 
     */
	public DataServiceImpl() {
	}

	public Data getData(String id) throws SomeException {
		Data data = new Data();
		return data;
	}

}