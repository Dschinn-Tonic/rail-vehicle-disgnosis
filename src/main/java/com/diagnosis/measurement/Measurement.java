package com.diagnosis.measurement;

import java.time.ZonedDateTime;

import com.diagnosis.map.MapLocation;

public class Measurement {
	private String measurementID;
	private MapLocation mapLocation;
	private String measuredID;
	private String measuredName;
	private ZonedDateTime time;
	private MeasurementReason reason;
	private double maxAccelerationValue;
	private double maxEngineTemperature;
	private double maxBrakingPower;

	public Measurement(String measurementID, MapLocation mapLocation, String measuredID, String measuredName,
			ZonedDateTime time, MeasurementReason reason, double maxAccelerationValue, double maxEngineTemperature,
			double maxBrakingPower) {
		this.measurementID = measurementID;
		this.mapLocation = mapLocation;
		this.measurementID = measuredID;
		this.measuredName = measuredName;
		this.time = time;
		this.reason = reason;
		this.maxAccelerationValue = maxAccelerationValue;
		this.maxEngineTemperature = maxEngineTemperature;
		this.maxBrakingPower = maxBrakingPower;
	}

	public String getMeasurementID() {
		return measurementID;
	}

	public void setMeasurementID(String measurementID) {
		this.measurementID = measurementID;
	}

	public MapLocation getMapLocation() {
		return mapLocation;
	}

	public void setMapLocation(MapLocation mapLocation) {
		this.mapLocation = mapLocation;
	}

	public String getMeasuredID() {
		return measuredID;
	}

	public void setMeasuredID(String measuredID) {
		this.measuredID = measuredID;
	}

	public String getMeasuredName() {
		return measuredName;
	}

	public void setMeasuredName(String measuredName) {
		this.measuredName = measuredName;
	}

	public ZonedDateTime getTime() {
		return time;
	}

	public void setTime(ZonedDateTime time) {
		this.time = time;
	}

	public MeasurementReason getReason() {
		return reason;
	}

	public void setReason(MeasurementReason reason) {
		this.reason = reason;
	}

	public double getMaxAccelerationValue() {
		return maxAccelerationValue;
	}

	public void setMaxAccelerationValue(double maxAccelerationValue) {
		this.maxAccelerationValue = maxAccelerationValue;
	}

	public double getMaxEngineTemperature() {
		return maxEngineTemperature;
	}

	public void setMaxEngineTemperature(double maxEngineTemperature) {
		this.maxEngineTemperature = maxEngineTemperature;
	}

	public double getMaxBrakingPower() {
		return maxBrakingPower;
	}

	public void setMaxBrakingPower(double maxBrakingPower) {
		this.maxBrakingPower = maxBrakingPower;
	}
}
