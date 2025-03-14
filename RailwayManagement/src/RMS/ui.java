package RMS;

public class ui {
	void adminui()
	{
		System.out.println("                   -:-:-:-:-: Welcome to Tours && Travels :-:-:-:-:-\n\n   ");
		
		for(int i=0;i<7;i++)
		{
			System.out.print("                                 ");
			for(int j=0;j<22;j++)
			{
				if(i==0||i==6||j==0||j==21)
					System.out.print("*");
				else if(i==2)
				{
					System.out.print("     1:Log in       *");
					break;
				}
				else if(i==3)
				{
					System.out.print("     2:Register     *");
					break;
				}
				else if(i==4)
				{
					System.out.print("     3:Exit         *");
					break;
				}
				else
					 System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	void customerui()
	{
		System.out.println("                   -:-:-:-:-: Welcome to Tours && Travels :-:-:-:-:-\n\n   ");
		
		for(int i=0;i<7;i++)
		{
			System.out.print("                                 ");
			for(int j=0;j<22;j++)
			{
				if(i==0||i==6||j==0||j==21)
					System.out.print("*");
				else if(i==2)
				{
					System.out.print("     1:Log in       *");
					break;
				}
				else if(i==3)
				{
					System.out.print("     2:Register     *");
					break;
				}
				else if(i==4)
				{
					System.out.print("     3:Exit         *");
					break;
				}
				else
					 System.out.print(" ");
			}
			System.out.println();
		}
		
	}
}
