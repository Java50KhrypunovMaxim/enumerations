package telran.time;

public enum DayOfWeek {
	MON("Mon#Monday"), TUE("Tue#Tuesday"), WED("Wed#Wednesday"), THU ("Thu#Thursday"), 
	FRI("Fri#Friday"), SAT("Sat#Saturday"), SUN("Sun#Sunday");
	String shortName;
	String fullName;
	static int N_DAYS = values().length;

	DayOfWeek(String name) {
		String[] tokens = name.split("#");
		shortName = tokens[0];
		fullName =tokens[1];
	}
	
	public String displayName(TypeDisplay type)
	{
		return type == TypeDisplay.SHORT? shortName:fullName;
	}
	
	public int getValue()
	{
		return ordinal()+1;
	}
	
	public DayOfWeek plusDays(int days)
	{
		int index = (ordinal() + days)% N_DAYS;
		if (index < 0)
		{
			index +=N_DAYS;
		}
		return values()[index];
	}
	public DayOfWeek minusDays(int days)
	{
		return plusDays(-days);
	}
	 public static int berween (DayOfWeek day1,DayOfWeek day2)
	 {
		 int res =day2.ordinal()-day1.ordinal();
		 if (res < 0)
		 {
			 res += N_DAYS;
		 }
		 return res;
	 }
	 public int berween (DayOfWeek other)
	 {
		 return DayOfWeek.berween(this, other);
	 }
	

}
