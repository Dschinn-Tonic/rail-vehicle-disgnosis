package com.diagnosis.serviceImpl;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import com.diagnosis.map.MapLocation;
import com.diagnosis.measurement.Measurement;
import com.diagnosis.measurement.MeasurementReason;
import com.diagnosis.measurement.MeasurementType;
import com.diagnosis.service.MeasurementReceiverService;

public class DummyData implements MeasurementReceiverService
{

	@Override
	public List<Measurement> receiveMeasurements()
	{
		List<Measurement> measurements = new ArrayList<Measurement>();

		MapLocation location1 = new MapLocation(51.065996, 13.776512, "Radeberg Vorstadt");
		MeasurementReason reason1 = new MeasurementReason(MeasurementType.ROUTINE, "description1");
		ZonedDateTime time1 = ZonedDateTime.of(2020, 7, 9, 12, 10, 5, 0, ZoneId.of("UTC+1"));
		Measurement m1 = new Measurement("AAAAAAAA", location1, "BBBBBBBB", "Straßenbahn Linie 11", time1, reason1,
				1.2d, 78.8d, 1.5d);
		measurements.add(m1);
		MapLocation location2 = new MapLocation(51.035997, 13.762093, "Großer Garten");
		MeasurementReason reason2 = new MeasurementReason(MeasurementType.FAILURE, "description2");
		ZonedDateTime time2 = ZonedDateTime.of(2020, 7, 9, 12, 10, 5, 0, ZoneId.of("UTC+1"));
		Measurement m2 = new Measurement("CCCCCCCC", location2, "DDDDDDDD", "Parkbahn", time2, reason2, 5.1d, 130.3d,
				3.1d);
		measurements.add(m2);
		MapLocation location3 = new MapLocation(51.040315, 13.732395, "Hauptbahnhof");
		MeasurementReason reason3 = new MeasurementReason(MeasurementType.ROUTINE, "description2");
		ZonedDateTime time3 = ZonedDateTime.of(2020, 7, 9, 12, 10, 5, 0, ZoneId.of("UTC+1"));
		Measurement m3 = new Measurement("EEEEEEEE", location3, "FFFFFFFF", "Regio 3", time3, reason3, 5.1d, 130.3d,
				3.1d);
		measurements.add(m3);
		return measurements;
	}

}
