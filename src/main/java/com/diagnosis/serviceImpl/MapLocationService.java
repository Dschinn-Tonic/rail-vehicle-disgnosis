package com.diagnosis.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import com.diagnosis.measurement.Measurement;
import com.diagnosis.service.MeasurementReceiverService;

/**
 * Demo backend that accepts up to 100 fishing spots. Data is shared with all
 * users.
 */
@Service
@ApplicationScope
public class MapLocationService {

	private List<Measurement> measurements = new ArrayList<Measurement>();
	private MeasurementReceiverService measurementReceiver = new DummyData();

	@PostConstruct
	private void init() {
		// save all measurements locally
		measurements = measurementReceiver.receiveMeasurements();
	}

	public List<Measurement> getAll() {

		return Collections.unmodifiableList(measurements);
	}

	public void addSpot(Measurement measurement) {

		// protect concurrent access since MapLocationService is a singleton
		synchronized (measurements) {

			measurements.add(measurement);

			if (measurements.size() > 100) {
				measurements.remove(0);
			}
		}
	}
}
