package praktikum0122021;

public class Population
{
	private int startSize;
	public double INITIAL_INFECCTION_RATE = 0.001;
	public double INFECTION_RISK = 0.2;
	public static double MORTALITY = 0.001;
	
	Individual[] poparray;
	
	/**
	 * 
	 * @param startSize Sets the amount of Individuals created
	 */
	
	public Population(int startSize)
	{
		this.startSize = startSize;
		poparray  = new Individual[startSize];
		
		for(int i = 0;i<=poparray.length-1;i++)
		{
			poparray[i] = new Individual(false);
		}
		
		int initialinfection = (int) (startSize * INITIAL_INFECCTION_RATE);
		
		
		
		for(int a = 0; a<initialinfection;a++)
		{
			poparray[a].setInfected();
		}
	}
	
	/**
	 * 
	 * @return the start population
	 */
	
	public int getStartSize()
	{
		return this.startSize;
	}
	
	/**
	 * 
	 * @return the people that are still alive
	 */
	
	/**
	 * 
	 * @return the people that are alive
	 */
	
	public int getCurrentSize()
	{
		int amleben = 0;
		for(int a = 0;a<poparray.length;a++)
		{
			if(poparray[a].isAlive() == true)
			{
				amleben++;
			}
		}
		return amleben;
	}
	
	/**
	 * 
	 * @return the people that are alive and infected
	 */
	
	public int getIncidence()
	{
		int amleben1 = 0;
		for(int a = 0;a<=poparray.length-1;a++)
		{
			if(this.poparray[a].isAlive() == true && this.poparray[a].isInfected() == true)
			{
				amleben1++;
			}
		}
		return amleben1;
	}
	
	public void simulateNextDay()
	{
		
		for(int a = 0;a<=poparray.length-1;a++)
		{
				int randomcontact = (int)(Math.random()*poparray.length);	
				simulateContact(poparray[a], poparray[randomcontact]);
				this.poparray[a].endOfDay();
		}
	}
	
	/**
	 * Simulates contact of two individuals 
	 * @param a one individual for contact
	 * @param b other individual for contact
	 */
	
	public void simulateContact(Individual a,Individual b)
	{
		
			if((a.isAlive() == true && b.isAlive() == true) )
			{
				if(a.isInfected() == true ^ b.isInfected() == true)
				{
					if(Math.random() <= INFECTION_RISK)
					{
						//Änderung im vergleich zum vorherigen code
						if(a.isInfected() == true)
						{
							b.setInfected();
						}
						
						if(b.isInfected() == true)
						{
							a.setInfected();
						}						
					}
					
				}
			}
		
	}
}
