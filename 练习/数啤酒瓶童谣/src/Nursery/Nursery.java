package Nursery;

public class Nursery {
	public static void main(String[] args) {
		int num = 99;
		
		String[] song = new String[8];
		song[0] = " bottles of beer on the wall,";
		song[1] = " bottles of beer.";
		song[2] = "Take one down.";
		song[3] = "Pass it around.";
		song[4] = "bottles of beer on the wall.";
		song[5] = "bottle of beer on the wall";
		song[6] = "No more bottles of beer on the wall";
		song[7] = " bottle of beer.";
		//��while()�����
		while(num >= 0)
		{
			if(num == 1)
			{
				System.out.println(num + " " + song[5] + "," + num  + song[7] + "\n" + song[2] + "\n" + song[3] + "\n" + (num-1) + " " + song[5] + ".");
			}
			else if(num == 2)
			{
				System.out.println(num  + song[0] + num  + song[1] + "\n" + song[2] + "\n" + song[3] + "\n" + (num-1) + song[5] + ".");
			}
			else if(num == 0)
			{
				System.out.println(song[6]);
			}
			else
			{
				System.out.println(num  + song[0] + num  + song[1] + "\n" + song[2] + "\n" + song[3] + "\n" + (num-1) + " " + song[4]);
			}
			System.out.println("\n");
			num--;
		}
		
		//��do while()���
		num = 99;
		do
		{
			if(num == 1)
			{
				System.out.println(num + " " + song[5] + "," + num  + song[7] + "\n" + song[2] + "\n" + song[3] + "\n" + (num-1) + " " + song[5] + ".");
			}
			else if(num == 2)
			{
				System.out.println(num  + song[0] + num  + song[1] + "\n" + song[2] + "\n" + song[3] + "\n" + (num-1) + " " + song[5] + ".");
			}
			else if(num == 0)
			{
				System.out.println(song[6]);
			}
			else
			{
				System.out.println(num  + song[0] + num  + song[1] + "\n" + song[2] + "\n" + song[3] + "\n" + (num-1) + " " + song[4]);
			}
			System.out.println("\n");
			num--;
		}while(num >= 0);
		
		//��for()���
		for(num = 99;num >= 0;num--)
		{
			if(num == 1)
			{
				System.out.println(num + " " + song[5] + "," + num  + song[7] + "\n" + song[2] + "\n" + song[3] + "\n" + (num-1) + " " + song[5] + ".");
			}
			else if(num == 2)
			{
				System.out.println(num  + song[0] + num  + song[1] + "\n" + song[2] + "\n" + song[3] + "\n" + (num-1) + song[5] + ".");
			}
			else if(num == 0)
			{
				System.out.println(song[6]);
			}
			else
			{
				System.out.println(num  + song[0] + num  + song[1] + "\n" + song[2] + "\n" + song[3] + "\n" + (num-1) + " " + song[4]);
			}
			System.out.println("\n");
		}
	}
}
