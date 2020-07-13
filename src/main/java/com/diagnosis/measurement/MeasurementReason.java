package com.diagnosis.measurement;

public class MeasurementReason {
	private MeasurementType measurementType;
	private String description;

	public MeasurementReason(MeasurementType measurementType, String description) {
		this.measurementType = measurementType;
		this.description = description;
	}

	public MeasurementType getMeasurementType() {
		return measurementType;
	}

	public void setMeasurementType(MeasurementType measurementType) {
		this.measurementType = measurementType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
