
public final class Arrays
{
	public static city[] initializeWithDefaultcityInstances(int length)
	{
		city[] array = new city[length];
		for (int i = 0; i < length; i++)
		{
			array[i] = new city();
		}
		return array;
	}

	public static road[] initializeWithDefaultroadInstances(int length)
	{
		road[] array = new road[length];
		for (int i = 0; i < length; i++)
		{
			array[i] = new road();
		}
		return array;
	}
}