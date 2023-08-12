package telran.measure;

public enum LengthUnit {
	MM(1), CM(10), IN(25.4f), FT(304.8f), M(1000), KM(1_000_000);

	float value;

	LengthUnit(float nMillimeters) {
		value = nMillimeters;
	}

	public float getValue() {
		return this.value;
	}
	
	public Length between (Length length1, Length length2)
	 {
		Length size1= length1.convert(this);
		Length size2= length2.convert(this);
		return new Length (size2.getAmount() - size1.getAmount(),this);
	 }

}
