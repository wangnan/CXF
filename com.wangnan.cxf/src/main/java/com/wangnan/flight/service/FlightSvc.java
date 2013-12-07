package com.wangnan.flight.service;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.wangnan.flight.service.exception.FlightException;
import com.wangnan.flight.service.model.FlightData;

@WebService
public interface FlightSvc {
	@WebMethod(operationName = "getFlightList")
	public FlightData[] getFlightList() throws FlightException;
	@WebMethod(operationName = "getFlightDetail")
	public FlightData getFlightDetail(@WebParam(name="airline")String airlineid, @WebParam(name = "connectionID") String connectionID, @WebParam(name = "FlightDate") Date FlightDate)  throws FlightException;
}
