public class gameController
{

	public gameController()
	{
	}
	
	//distributing scores for the bubbles. 
	public int getScore(int num)
	{
		if (num==2)
			return 2;
		else if (num==3)
			return 3;
		else if (num==4)
			return 4;
		else
			return 0;
	}
	
	//return the random value between 0 and 255 to create random color    
	public int colorSwitcher()
	{
		return (int)(Math.random()*255);
	}
	
	public int size1()
	{
		return (int)(Math.random()*20)+10;
	}
	
	public int size2()
	{
		return (int)(Math.random()*30)+30;
	}
	
	public int size3()
	{
		return (int)(Math.random()*30)+60;
	}
}