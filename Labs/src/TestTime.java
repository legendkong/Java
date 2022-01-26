//What is a time?
//-HH:MM:SS


class Time
{
	private int hour;
	private int minute;
	private int second;
	
	//Default constructor
	public Time()
	{
		this(0,0,0);

	}
	//Other consutrctor
	public Time(int hour, int minute, int second)
	{
		//this.hour=hour;
		//this.minute = minute;
		//this.second = second;
		setInfo(hour,minute,second);
	}
	
	//Copy constructor
	public Time(Time t)
	{
		//this.hour=t.hour;
		//this.minute = t.minute;
		//this.second=t.second;
		this(t.hour,t.minute,t.second);
	}
	
	//Accessor method
	public int getHour()
	{
		return hour;
	}
	
	public int getMinute()
	{
		return minute; 
	}
	
	public int getSecond()
	{
		return second;
	}
	
	
	//Mutator method
	public void setInfo(int hour, int minute, int second)
	{
		this.hour=hour;
		this.minute=minute;
		this.second=second;
	}
	
	//Increase the time by 1 second
	public void increment()
	{
		++second;
		int temp = second / 60;
		second = second%60;
		
		minute = minute + temp;
		temp = minute/60;
		minute = minute%60;
		
		hour = hour + temp;
		hour = hour%24;
	}
	
	//Display info method
	public void displayInfo(String s)
	{
		System.out.printf("%s = %02d:%02d:%02d%n", s, hour, minute, second);
	}
}


public class TestTime {

	public static void main(String[] args) {
		Time t0 = new Time();
		Time t1= new Time(5,35,59);
		Time t2 = new Time(13,59,59);
		Time t3= new Time(23, 59,29);
		Time t4= new Time(t3);
		Time t5= t3;		//Here we assign t3 to t5	
		
		
		//Display the object
		t0.displayInfo("t0");
		t1.displayInfo("t1");
		t2.displayInfo("t2");
		t3.displayInfo("t3");
		t4.displayInfo("t4");
		t5.displayInfo("t5");

		
		//Increase the timing by 1 second to all objects
		System.out.println("Increase 1 second to all object ");
		t0.increment();
		t1.increment();
		t2.increment();
		t3.increment();
		t4.increment();
		
		
		//Display new object
		t0.displayInfo("t0");
		t1.displayInfo("t1");
		t2.displayInfo("t2");
		t3.displayInfo("t3");
		t4.displayInfo("t4");
		
		System.out.println("Note that we have assigned t3 to t5");
		t5.displayInfo("t5");
	}

}
