package com.wangnan.cxf.flight;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.wangnan.cxf.flight.exception.FlightException;
import com.wangnan.cxf.flight.model.FlightData;

@WebService
public interface FlightSvc {
	@WebMethod(operationName = "getFlightList")
	public FlightData[] getFlightList() throws FlightException;
	@WebMethod(operationName = "getFlightDetail")
	public FlightData getFlightDetail(@WebParam(name="airline")String airlineid, @WebParam(name = "connectionID") String connectionID, @WebParam(name = "FlightDate") Date FlightDate)  throws FlightException;
}
