package com.diagnosis.measurement;

public enum MeasurementType
{
	FAILURE("Failure"), ROUTINE("Routine");

	public final String name;

	private MeasurementType(String name)
	{
		this.name = name;
	}
}
