class StrWorld extends StrTest{
  public static void main (String[] args)
	{
   StrWorld str  = new StrWorld();
   str.test();
   StrWorld.test();
  }
  StrWorld()
  {
    this("A");
    System.out.println("B");
  }

  static 
  {
    System.out.println("C");
  }

  StrWorld(String s)
    {
    System.out.println("D");
  }
  {
    System.out.println("E");
  }
  static void test()
  {
    System.out.println("F");
  }

}

class StrTest
{
  StrTest()
  {
    System.out.println("G");
  }
  {
    System.out.println("H");
  }
}