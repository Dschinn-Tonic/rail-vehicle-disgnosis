package com.diagnosis.service;

import java.util.List;

import com.diagnosis.measurement.Measurement;

public interface MeasurementReceiverService {
	public List<Measurement> receiveMeasurements();
}
