package com.diagnosis.test;

import static org.junit.Assert.fail;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.BeforeClass;
import org.junit.Test;

import com.diagnosis.measurement.Measurement;
import com.diagnosis.service.MeasurementReceiverService;
import com.diagnosis.serviceImpl.DummyData;

public class DataIntegrityTest {
	private static List<Measurement> measurements = new ArrayList<Measurement>();

	@BeforeClass
	public static void init() {
		MeasurementReceiverService measurementReceiver = new DummyData();
		measurements = measurementReceiver.receiveMeasurements();
	}

	// test if measurements are not empty
	@Test
	public void testNotEmpty() {
		if (measurements.size() == 0) {
			fail("No measurements found");
		}

	}

	// test for deprecated measurements
	@Test
	public void testMeasureRelevance() {
		List<ZonedDateTime> times = measurements.stream().map(Measurement::getTime).collect(Collectors.toList());
		int thisYear = Calendar.getInstance().get(Calendar.YEAR);
		for (ZonedDateTime time : times) {
			int measuredYear = time.getYear();
			if ((measuredYear == thisYear) || (measuredYear == thisYear)) {
				continue;
			} else {
				fail("Deprecated measurements found");
			}
		}

	}

}
