package telran.measure;

public class Length implements Comparable<Length>{
	
	private final float amount;
	private final LengthUnit unit;
	
	
	public Length(float amount, LengthUnit unit) {
		this.amount = amount;
		this.unit = unit;
	}

	@Override
	public int compareTo(Length obj) {
		 if (obj == null) {
		        throw new NullPointerException("Cannot compare with null object");
		    }
		 float thisUnit = this.amount * this.unit.getValue();
		 float objUnit = obj.amount * obj.unit.getValue();
		 return Float.compare(thisUnit, objUnit);
	}
	
	@Override
	public boolean equals(Object obj) {
	
		return compareTo((Length)obj) == 0;
	}

	@Override
	public String toString() {
		return amount + unit.name();
	}

	public LengthUnit getUnit()
	{
		return unit;
	}
	

	public float getAmount()
	{
		return amount;
	}
		
	public Length convert (LengthUnit to)
	{
		float res = amount * unit.getValue()/to.getValue();
		return new Length (res,to);
	}
}