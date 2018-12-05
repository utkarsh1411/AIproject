public class pathByName
{
  public path item;
  public pathByName(path it)
  {
	  item = it;
  }

  boolean operator(path p)
  {
	boolean val = (p.end.name.equals(item.end.name));
	return val;
  }
}