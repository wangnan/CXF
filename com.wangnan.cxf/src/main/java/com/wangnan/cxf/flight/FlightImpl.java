package com.wangnan.cxf.flight;

import java.util.Calendar;
import java.util.Date;

import javax.jws.WebService;

import com.wangnan.cxf.flight.exception.FlightException;
import com.wangnan.cxf.flight.model.FlightData;

@WebService(endpointInterface = "com.wangnan.cxf.flight.FlightSvc", serviceName = "flightSvc")
public class FlightImpl implements FlightSvc {

	@Override
	public FlightData[] getFlightList() throws FlightException {
		// TODO Auto-generated method stub
		
		int length = (int)(Math.random() * 20);
		FlightData[] r = new FlightData[length];
		for(int i = 0; i < length; i++) {
			FlightData f = new FlightData();
			f.setAirLine("Air Line China");
			f.setAirLineId(((int) (Math.random() * 10000 )) + "");
			f.setAirportFrom("Airport From");
			f.setAirportTo("Air port to");
			f.setCityFrom("City from");
			f.setCityTo("City To");
			f.setConnectionId("connection ID");
			f.setFlightDate(Calendar.getInstance().getTime());
			
			r[i] = f;
		}
		System.out.print("Return " + length + " rows");
		return r;
	}

	@Override
	public FlightData getFlightDetail(String airlineid, String connectionID,
			Date FlightDate) throws FlightException {
		// TODO Auto-generated method stub
		FlightData f = new FlightData();
		f.setAirLine("Air Line China");
		f.setAirLineId(((int) (Math.random() * 10000 )) + "");
		f.setAirportFrom("Airport From");
		f.setAirportTo("Air port to");
		f.setCityFrom("City from");
		f.setCityTo("City To");
		f.setConnectionId("connection ID");
		f.setFlightDate(Calendar.getInstance().getTime());

		return f;
	}

}
