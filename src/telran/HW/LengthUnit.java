package telran.HW;

import telran.measure.Length;
import telran.measure.WeigthUnit;


public enum LengthUnit {
	MM(1), CM(10), IN(25.4f), FT(304.8f), M(1000), KM(1_000_000);

	float value;

	LengthUnit(float nMillimeters) {
		value = nMillimeters;
	}

	public float getValue() {
		return this.value;
	}
	
	public Length berween (Length length1, Length length2)
	 {
		Length size1= length1.convert(this);
		Length size2= length1.convert(this);
		return new Length (size1.getAmount()-size2.getAmount(),this);
	 }

}
