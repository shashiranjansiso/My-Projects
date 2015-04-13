package com.careercup.facebookinterviewquestions;

public class JobScheduling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int s[] =  {1, 3, 0, 5, 8, 5};
	    int f[] =  {2, 4, 6, 7, 9, 9};
	    Schedule schedule[] = new Schedule[s.length];
	    for(int i = 0; i < s.length; i++)
	    {
	    	schedule[i] = new Schedule(s[i], f[i]);
	    }
	    Schedule f1[] = getSchedule(schedule);
	    for (Schedule sch : f1) {
			System.out.print("start: " + sch.start + "  end: " + sch.end);
			System.out.println();
		}
	}
	//return true if s2 is overlapping with s1
	public static boolean isOverlapping(Schedule s1, Schedule s2)
	{
		if(s1.end >s2.start && s1.end <= s2.end)
			return true;
		return false;
	}
	
	public static Schedule[] getSchedule(Schedule s[])
	{
		Schedule f[] = new Schedule[s.length];
		int i = 0;
		int j = 0;
		while(j < s.length)
		{
			f[i++] = s[j++];
			while(j < s.length && isOverlapping(f[i-1], s[j]))
			{
				j++;
			}
		}
		return f;
	}
	
}
