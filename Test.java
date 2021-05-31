public class Test
{
	
	

	
	public static void main(String[] args) throws InterruptedException
	{
		int[]val = new int[13];
    val[0] = 10;
    val[1] = new Integer(5);
    val[2] = 15;
    for(int i = 1;i<val.length;i++)

    System.out.println(val[i]-val[i-1]);
			

	}
	

	
}
