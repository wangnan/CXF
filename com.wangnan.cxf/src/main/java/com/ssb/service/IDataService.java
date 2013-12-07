package com.ssb.service;

import javax.jws.WebMethod; 
import javax.jws.WebParam; 
import javax.jws.WebService; 
import javax.xml.ws.WebFault;

import com.ssb.service.SomeException; 
import com.ssb.model.Data;

@WebService 
public interface IDataService { 
    @WebMethod(operationName="getData") 
    public Data  getData(@WebParam(name="id")String id) throws SomeException; 
}

