package praktikum0122021;


public class Individual
{
	private boolean alive;
	private boolean infected;
	private int remainingDaysOfInfection;
	/**
	 * 
	 * @param infected create an object and decide if the individual is infected or not
	 */
	
	public Individual(boolean infected)
	{
		
		this.alive = true;
		this.infected = infected;
		// this.remainingDaysOfInfection = 0 
	}
	
	/**
	 * 
	 * @return if individual is alive
	 */
	
	public boolean isAlive()
	{
		return this.alive;
	}
	
	/**
	 * 
	 * @return if inidividual is infected
	 */
	
	public boolean isInfected()
	{
		return this.infected;
	}
	
	
	/**
	 * sets the individual infected
	 */
	

	
	public void setInfected()
	{
		this.remainingDaysOfInfection = (int)(Math.random()*5)+5;
		this.infected = true;
	}
	
	public void endOfDay()
	{
		
		if(this.isInfected() == true)
		{
			if(Math.random() <= Population.MORTALITY)
		{
			this.alive = false;
		}
		
		if(this.remainingDaysOfInfection > 0)
		{
			this.remainingDaysOfInfection -= 1;
		
			if(this.remainingDaysOfInfection == 0)
			{
				this.infected = false;
			}
		}

		}
		
		
		
	}
}
