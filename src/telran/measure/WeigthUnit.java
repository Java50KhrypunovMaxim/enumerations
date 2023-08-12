package telran.measure;

public enum WeigthUnit {
	GR(1.0f), LBS(453.592f), KG(1000.0f), CN(100_000.0f), TN(1_000_000.0f);
	float value;
	WeigthUnit(float nGrams) {
		value=nGrams;
	}
	public float convert(WeigthUnit to, float amount)
	{
		return value*amount/to.value;
	}

}
