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
		this.remainingDaysOfInfection = 0;
		this.infected = infected;
		
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
		this.remainingDaysOfInfection = (int)(Math.random()*4)+5;
		this.infected = true;
		this.alive = true;
	}
	
	public void endOfDay()
	{
		double mortal = Population.MORTALITY;
		
		if(Math.random() < mortal)
		{
			this.alive = false;
		}
		
		this.remainingDaysOfInfection -= 1;
		
		if(this.remainingDaysOfInfection == 0)
		{
			this.infected = false;
		}
	}
}
