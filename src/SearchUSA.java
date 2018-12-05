
import static java.util.Collections.sort;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchUSA
{
	public static city[] cities = Arrays.initializeWithDefaultcityInstances(DefineConstants.NUMCITIES);
	public static int cur_city = 0;
        public static int noOfRoads = 0;      
	public static city goal;
	public static Map<String , Integer> visit = new HashMap<String , Integer>();
	

	public static void make_city(String name, double lat, double lon)
	{
	  city c = new city();
          cities[cur_city] = c;
	  c.name = name;
	  c.lat = lat;
	  c.lon = lon;
	  cur_city++;
	}

	public static city find_city(String name)
	{
	  city city = null;
	  for (int i = 0;i < cur_city;i++)
	  {
           
                
		if (cities[i] != null && cities[i].name.equals(name))
		{
		  city = cities[i];
                  
		}
	  }
	  return city;
	}
	public static road[] roads = Arrays.initializeWithDefaultroadInstances(DefineConstants.NUMROADS);
	public static int cur_road = 0;

	public static void make_1way(city a, city b, int len)
	{
	  if (a == null || b == null)
	  {
		System.err.printf("Trying to make road to null city: road #" + cur_road);
                return;
	  }
	  road r = new road();
	  roads[cur_road] = r;
	  r.a = a;
	  r.b = b;
	  r.len = len;
	  cur_road++;
	}

	public static void make_road(String name1, String name2, int len)
	{
	  city a = SearchUSA.find_city(name1);
	  city b = SearchUSA.find_city(name2);
	  SearchUSA.make_1way(a, b, len);
	  SearchUSA.make_1way(b, a, len);
      noOfRoads+=2;
	}
	public static void make_cities()
	{
	  SearchUSA.make_city("albanyGA", 31.58, 84.17);
	  SearchUSA.make_city("albanyNY", 42.66, 73.78);
	  SearchUSA.make_city("albuquerque", 35.11, 106.61);
	  SearchUSA.make_city("atlanta", 33.76, 84.40);
	  SearchUSA.make_city("augusta", 33.43, 82.02);
	  SearchUSA.make_city("austin", 30.30, 97.75);
	  SearchUSA.make_city("bakersfield", 35.36, 119.03);
	  SearchUSA.make_city("baltimore", 39.31, 76.62);
	  SearchUSA.make_city("batonRouge", 30.46, 91.14);
	  SearchUSA.make_city("beaumont", 30.08, 94.13);
	  SearchUSA.make_city("boise", 43.61, 116.24);
	  SearchUSA.make_city("boston", 42.32, 71.09);
	  SearchUSA.make_city("buffalo", 42.90, 78.85);
	  SearchUSA.make_city("calgary", 51.00, 114.00);
	  SearchUSA.make_city("charlotte", 35.21, 80.83);
	  SearchUSA.make_city("chattanooga", 35.05, 85.27);
	  SearchUSA.make_city("chicago", 41.84, 87.68);
	  SearchUSA.make_city("cincinnati", 39.14, 84.50);
	  SearchUSA.make_city("cleveland", 41.48, 81.67);
	  SearchUSA.make_city("coloradoSprings", 38.86, 104.79);
	  SearchUSA.make_city("columbus", 39.99, 82.99);
	  SearchUSA.make_city("dallas", 32.80, 96.79);
	  SearchUSA.make_city("dayton", 39.76, 84.20);
	  SearchUSA.make_city("daytonaBeach", 29.21, 81.04);
	  SearchUSA.make_city("denver", 39.73, 104.97);
	  SearchUSA.make_city("desMoines", 41.59, 93.62);
	  SearchUSA.make_city("elPaso", 31.79, 106.42);
	  SearchUSA.make_city("eugene", 44.06, 123.11);
	  SearchUSA.make_city("europe", 48.87, 2.33);
	  SearchUSA.make_city("ftWorth", 32.74, 97.33);
	  SearchUSA.make_city("fresno", 36.78, 119.79);
	  SearchUSA.make_city("grandJunction", 39.08, 108.56);
	  SearchUSA.make_city("greenBay", 44.51, 88.02);
	  SearchUSA.make_city("greensboro", 36.08, 79.82);
	  SearchUSA.make_city("houston", 29.76, 95.38);
	  SearchUSA.make_city("indianapolis", 39.79, 86.15);
	  SearchUSA.make_city("jacksonville", 30.32, 81.66);
	  SearchUSA.make_city("japan", 35.68, 220.23);
	  SearchUSA.make_city("kansasCity", 39.08, 94.56);
	  SearchUSA.make_city("keyWest", 24.56, 81.78);
	  SearchUSA.make_city("lafayette", 30.21, 92.03);
	  SearchUSA.make_city("lakeCity", 30.19, 82.64);
	  SearchUSA.make_city("laredo", 27.52, 99.49);
	  SearchUSA.make_city("lasVegas", 36.19, 115.22);
	  SearchUSA.make_city("lincoln", 40.81, 96.68);
	  SearchUSA.make_city("littleRock", 34.74, 92.33);
	  SearchUSA.make_city("losAngeles", 34.03, 118.17);
	  SearchUSA.make_city("macon", 32.83, 83.65);
	  SearchUSA.make_city("medford", 42.33, 122.86);
	  SearchUSA.make_city("memphis", 35.12, 89.97);
	  SearchUSA.make_city("mexia", 31.68, 96.48);
	  SearchUSA.make_city("mexico", 19.40, 99.12);
	  SearchUSA.make_city("miami", 25.79, 80.22);
	  SearchUSA.make_city("midland", 43.62, 84.23);
	  SearchUSA.make_city("milwaukee", 43.05, 87.96);
	  SearchUSA.make_city("minneapolis", 44.96, 93.27);
	  SearchUSA.make_city("modesto", 37.66, 120.99);
	  SearchUSA.make_city("montreal", 45.50, 73.67);
	  SearchUSA.make_city("nashville", 36.15, 86.76);
	  SearchUSA.make_city("newHaven", 41.31, 72.92);
	  SearchUSA.make_city("newOrleans", 29.97, 90.06);
	  SearchUSA.make_city("newYork", 40.70, 73.92);
	  SearchUSA.make_city("norfolk", 36.89, 76.26);
	  SearchUSA.make_city("oakland", 37.80, 122.23);
	  SearchUSA.make_city("oklahomaCity", 35.48, 97.53);
	  SearchUSA.make_city("omaha", 41.26, 96.01);
	  SearchUSA.make_city("orlando", 28.53, 81.38);
	  SearchUSA.make_city("ottawa", 45.42, 75.69);
	  SearchUSA.make_city("pensacola", 30.44, 87.21);
	  SearchUSA.make_city("philadelphia", 40.72, 76.12);
	  SearchUSA.make_city("phoenix", 33.53, 112.08);
	  SearchUSA.make_city("pittsburgh", 40.40, 79.84);
	  SearchUSA.make_city("pointReyes", 38.07, 122.81);
	  SearchUSA.make_city("portland", 45.52, 122.64);
	  SearchUSA.make_city("providence", 41.80, 71.36);
	  SearchUSA.make_city("provo", 40.24, 111.66);
	  SearchUSA.make_city("raleigh", 35.82, 78.64);
	  SearchUSA.make_city("redding", 40.58, 122.37);
	  SearchUSA.make_city("reno", 39.53, 119.82);
	  SearchUSA.make_city("richmond", 37.54, 77.46);
	  SearchUSA.make_city("rochester", 43.17, 77.61);
	  SearchUSA.make_city("sacramento", 38.56, 121.47);
	  SearchUSA.make_city("salem", 44.93, 123.03);
	  SearchUSA.make_city("salinas", 36.68, 121.64);
	  SearchUSA.make_city("saltLakeCity", 40.75, 111.89);
	  SearchUSA.make_city("sanAntonio", 29.45, 98.51);
	  SearchUSA.make_city("sanDiego", 32.78, 117.15);
	  SearchUSA.make_city("sanFrancisco", 37.76, 122.44);
	  SearchUSA.make_city("sanJose", 37.30, 121.87);
	  SearchUSA.make_city("sanLuisObispo", 35.27, 120.66);
	  SearchUSA.make_city("santaFe", 35.67, 105.96);
	  SearchUSA.make_city("saultSteMarie", 46.49, 84.35);
	  SearchUSA.make_city("savannah", 32.05, 81.10);
	  SearchUSA.make_city("seattle", 47.63, 122.33);
	  SearchUSA.make_city("stLouis", 38.63, 90.24);
	  SearchUSA.make_city("stamford", 41.07, 73.54);
	  SearchUSA.make_city("stockton", 37.98, 121.30);
	  SearchUSA.make_city("tallahassee", 30.45, 84.27);
	  SearchUSA.make_city("tampa", 27.97, 82.46);
	  SearchUSA.make_city("thunderBay", 48.38, 89.25);
	  SearchUSA.make_city("toledo", 41.67, 83.58);
	  SearchUSA.make_city("toronto", 43.65, 79.38);
	  SearchUSA.make_city("tucson", 32.21, 110.92);
	  SearchUSA.make_city("tulsa", 36.13, 95.94);
	  SearchUSA.make_city("uk1", 51.30, 0.00);
	  SearchUSA.make_city("uk2", 51.30, 0.00);
	  SearchUSA.make_city("vancouver", 49.25, 123.10);
	  SearchUSA.make_city("washington", 38.91, 77.01);
	  SearchUSA.make_city("westPalmBeach", 26.43, 80.03);
	  SearchUSA.make_city("wichita", 37.69, 97.34);
	  SearchUSA.make_city("winnipeg", 49.90, 97.13);
	  SearchUSA.make_city("yuma", 32.69, 114.62);
	}
	public static void make_roads()
	{


	  SearchUSA.make_road("albanyNY", "montreal", 226);
	  SearchUSA.make_road("albanyNY", "boston", 166);
	  SearchUSA.make_road("albanyNY", "rochester", 148);
	  SearchUSA.make_road("albanyGA", "tallahassee", 120);
	  SearchUSA.make_road("albanyGA", "macon", 106);
	  SearchUSA.make_road("albuquerque", "elPaso", 267);
	  SearchUSA.make_road("albuquerque", "santaFe", 61);
	  SearchUSA.make_road("atlanta", "macon", 82);
	  SearchUSA.make_road("atlanta", "chattanooga", 117);
	  SearchUSA.make_road("augusta", "charlotte", 161);
	  SearchUSA.make_road("augusta", "savannah", 131);
	  SearchUSA.make_road("austin", "houston", 186);
	  SearchUSA.make_road("austin", "sanAntonio", 79);
	  SearchUSA.make_road("bakersfield", "losAngeles", 112);
	  SearchUSA.make_road("bakersfield", "fresno", 107);
	  SearchUSA.make_road("baltimore", "philadelphia", 102);
	  SearchUSA.make_road("baltimore", "washington", 45);
	  SearchUSA.make_road("batonRouge", "lafayette", 50);
	  SearchUSA.make_road("batonRouge", "newOrleans", 80);
	  SearchUSA.make_road("beaumont", "houston", 69);
	  SearchUSA.make_road("beaumont", "lafayette", 122);
	  SearchUSA.make_road("boise", "saltLakeCity", 349);
	  SearchUSA.make_road("boise", "portland", 428);
	  SearchUSA.make_road("boston", "providence", 51);
	  SearchUSA.make_road("buffalo", "toronto", 105);
	  SearchUSA.make_road("buffalo", "rochester", 64);
	  SearchUSA.make_road("buffalo", "cleveland", 191);
	  SearchUSA.make_road("calgary", "vancouver", 605);
	  SearchUSA.make_road("calgary", "winnipeg", 829);
	  SearchUSA.make_road("charlotte", "greensboro", 91);
	  SearchUSA.make_road("chattanooga", "nashville", 129);
	  SearchUSA.make_road("chicago", "milwaukee", 90);
	  SearchUSA.make_road("chicago", "midland", 279);
	  SearchUSA.make_road("cincinnati", "indianapolis", 110);
	  SearchUSA.make_road("cincinnati", "dayton", 56);
	  SearchUSA.make_road("cleveland", "pittsburgh", 157);
	  SearchUSA.make_road("cleveland", "columbus", 142);
	  SearchUSA.make_road("coloradoSprings", "denver", 70);
	  SearchUSA.make_road("coloradoSprings", "santaFe", 316);
	  SearchUSA.make_road("columbus", "dayton", 72);
	  SearchUSA.make_road("dallas", "denver", 792);
	  SearchUSA.make_road("dallas", "mexia", 83);
	  SearchUSA.make_road("daytonaBeach", "jacksonville", 92);
	  SearchUSA.make_road("daytonaBeach", "orlando", 54);
	  SearchUSA.make_road("denver", "wichita", 523);
	  SearchUSA.make_road("denver", "grandJunction", 246);
	  SearchUSA.make_road("desMoines", "omaha", 135);
	  SearchUSA.make_road("desMoines", "minneapolis", 246);
	  SearchUSA.make_road("elPaso", "sanAntonio", 580);
	  SearchUSA.make_road("elPaso", "tucson", 320);
	  SearchUSA.make_road("eugene", "salem", 63);
	  SearchUSA.make_road("eugene", "medford", 165);
	  SearchUSA.make_road("europe", "philadelphia", 3939);
	  SearchUSA.make_road("ftWorth", "oklahomaCity", 209);
	  SearchUSA.make_road("fresno", "modesto", 109);
	  SearchUSA.make_road("grandJunction", "provo", 220);
	  SearchUSA.make_road("greenBay", "minneapolis", 304);
	  SearchUSA.make_road("greenBay", "milwaukee", 117);
	  SearchUSA.make_road("greensboro", "raleigh", 74);
	  SearchUSA.make_road("houston", "mexia", 165);
	  SearchUSA.make_road("indianapolis", "stLouis", 246);
	  SearchUSA.make_road("jacksonville", "savannah", 140);
	  SearchUSA.make_road("jacksonville", "lakeCity", 113);
	  SearchUSA.make_road("japan", "pointReyes", 5131);
	  SearchUSA.make_road("japan", "sanLuisObispo", 5451);
	  SearchUSA.make_road("kansasCity", "tulsa", 249);
	  SearchUSA.make_road("kansasCity", "stLouis", 256);
	  SearchUSA.make_road("kansasCity", "wichita", 190);
	  SearchUSA.make_road("keyWest", "tampa", 446);
	  SearchUSA.make_road("lakeCity", "tampa", 169);
	  SearchUSA.make_road("lakeCity", "tallahassee", 104);
	  SearchUSA.make_road("laredo", "sanAntonio", 154);
	  SearchUSA.make_road("laredo", "mexico", 741);
	  SearchUSA.make_road("lasVegas", "losAngeles", 275);
	  SearchUSA.make_road("lasVegas", "saltLakeCity", 486);
	  SearchUSA.make_road("lincoln", "wichita", 277);
	  SearchUSA.make_road("lincoln", "omaha", 58);
	  SearchUSA.make_road("littleRock", "memphis", 137);
	  SearchUSA.make_road("littleRock", "tulsa", 276);
	  SearchUSA.make_road("losAngeles", "sanDiego", 124);
	  SearchUSA.make_road("losAngeles", "sanLuisObispo", 182);
	  SearchUSA.make_road("medford", "redding", 150);
	  SearchUSA.make_road("memphis", "nashville", 210);
	  SearchUSA.make_road("miami", "westPalmBeach", 67);
	  SearchUSA.make_road("midland", "toledo", 82);
	  SearchUSA.make_road("minneapolis", "winnipeg", 463);
	  SearchUSA.make_road("modesto", "stockton", 29);
	  SearchUSA.make_road("montreal", "ottawa", 132);
	  SearchUSA.make_road("newHaven", "providence", 110);
	  SearchUSA.make_road("newHaven", "stamford", 92);
	  SearchUSA.make_road("newOrleans", "pensacola", 268);
	  SearchUSA.make_road("newYork", "philadelphia", 101);
	  SearchUSA.make_road("norfolk", "richmond", 92);
	  SearchUSA.make_road("norfolk", "raleigh", 174);
	  SearchUSA.make_road("oakland", "sanFrancisco", 8);
	  SearchUSA.make_road("oakland", "sanJose", 42);
	  SearchUSA.make_road("oklahomaCity", "tulsa", 105);
	  SearchUSA.make_road("orlando", "westPalmBeach", 168);
	  SearchUSA.make_road("orlando", "tampa", 84);
	  SearchUSA.make_road("ottawa", "toronto", 269);
	  SearchUSA.make_road("pensacola", "tallahassee", 120);
	  SearchUSA.make_road("philadelphia", "pittsburgh", 319);
	  SearchUSA.make_road("philadelphia", "newYork", 101);
	  SearchUSA.make_road("philadelphia", "uk1", 3548);
	  SearchUSA.make_road("philadelphia", "uk2", 3548);
	  SearchUSA.make_road("phoenix", "tucson", 117);
	  SearchUSA.make_road("phoenix", "yuma", 178);
	  SearchUSA.make_road("pointReyes", "redding", 215);
	  SearchUSA.make_road("pointReyes", "sacramento", 115);
	  SearchUSA.make_road("portland", "seattle", 174);
	  SearchUSA.make_road("portland", "salem", 47);
	  SearchUSA.make_road("reno", "saltLakeCity", 520);
	  SearchUSA.make_road("reno", "sacramento", 133);
	  SearchUSA.make_road("richmond", "washington", 105);
	  SearchUSA.make_road("sacramento", "sanFrancisco", 95);
	  SearchUSA.make_road("sacramento", "stockton", 51);
	  SearchUSA.make_road("salinas", "sanJose", 31);
	  SearchUSA.make_road("salinas", "sanLuisObispo", 137);
	  SearchUSA.make_road("sanDiego", "yuma", 172);
	  SearchUSA.make_road("saultSteMarie", "thunderBay", 442);
	  SearchUSA.make_road("saultSteMarie", "toronto", 436);
	  SearchUSA.make_road("seattle", "vancouver", 115);
	  SearchUSA.make_road("thunderBay", "winnipeg", 440);
	}

	public static int path_count(path p)
	{
	  int i = 0;
	  while (p != null)
	  {
		p = p.prev;
		i++;
	  }
	  return i;
	}

	public static double distance(city city1, city city2)
	{
	  //calculate average latitude
	  double avglat = city1.lat + city2.lat / 2;
	  //distance between two degrees of longitude is dependent on the latitude
	  double londist = 69.5 * Math.cos(avglat * DefineConstants.PI / 180);
	  //calculate L2 norm distance
	  return Math.sqrt(Math.pow(londist,2) + Math.pow((city2.lat - city1.lat) * 69.5, 2));
	}

	public static deque<path> neighbors(path cur)
	{
	  deque<path> n = new deque<path>();
	  for (int i = 0; i < noOfRoads; i++)
	  {
		road r = roads[i];
                	
                    if (r != null && cur!= null && !visit.containsKey(r.b.name) && r.a.name.equals(cur.end.name))
                    {
                      path p = new path();
                      p.end = r.b;
                      p.prev = cur;
                      p.cost = cur.cost + r.len;
                      n.push_back(p);
                    }
	  }
	  return n;
	}

        
        public static Comparator<path> astar_compare()
        {   
         Comparator comp = new Comparator<path>(){
             @Override
             public int compare(path p1, path p2)
             {
                 return (p1.cost + SearchUSA.distance(p1.end, goal)) < (p2.cost + SearchUSA.distance(p2.end, goal)) ? 1 : 0;
             }        
         };
         return comp;
        }  

	public static void print_queue(deque<path> q)
	{
            List<path> ls = q.getList();
          
            for(path a:ls){
                System.out.print(a.end.name);
                System.out.print(", ");
            }
            System.out.print("\n");
	}
        
        public static int find_if(List<path> ls , path p){
            int idx = 0;
            
            for(path a : ls){
                if(a == p){
                    return idx;
                }
                idx++;
            }
            
            return -1;
        }
        
	public static void greedy_add_paths(deque<path> open, deque<path> closed, deque<path> paths)
	{

          List<path> pathsLs = paths.getList();
          List<path> openLs = closed.getList();
          List<path> closedLs = open.getList();
          //adds neighbor to open list, including duplicates
	  for (int i = 0; i < pathsLs.size(); i++)
	  {
		int j = find_if(closedLs , pathsLs.get(i));
                
		if (j != -1) //neighbor already in closed, don't add
			continue;
		j = find_if(openLs , pathsLs.get(i));
		if (j == -1) //not a duplicate, safe to add
		{
		  open.push_back(pathsLs.get(i)); //neither already closed nor dup, add to open list
		}
	  }
	}

	public static void add_paths(deque<path> open, deque<path> closed, deque<path> paths)
	{
	
          List<path> pathsLs = paths.getList();
          List<path> openLs = closed.getList();
          List<path> closedLs = open.getList();
	  //adds neighbor to open list, duplicates included
	  for (int i = 0; i < pathsLs.size(); i++)
	  {
		int j = find_if(closedLs , pathsLs.get(i));
		if (j != -1) //don't add, because neighbour is already closed
			continue;
		j = find_if(openLs , pathsLs.get(i));
		if (j != -1) //if duplicate path is found
		{
		  if (pathsLs.get(i).cost < openLs.get(j).cost) //shorter new path
		  {
			open.erase(j); //erases the old path
			open.push_back(pathsLs.get(i)); //adds a new path
		  } //short old path
		  else
			  continue;
		}
		else
		{
		  open.push_back(pathsLs.get(i)); //already closed and no duplicates, added to open list
		}
	  }
	}
	
	
	public static soln astar(city start, city dest)
	{
	  deque<path> open = new deque<path>();
	  deque<path> closed = new deque<path>();
	  goal = dest;
	  visit.clear();
	  path s = new path();
	  s.prev = null;
	  s.end = start;
	  s.cost = 0;
	  open.push_back(s);
	  	
	  
	  while (!open.empty())
	  {
		path cur = open.front();
		open.pop_front();
		closed.push_back(cur);

		if (cur.end.name.equals(goal.name))
		{
		  soln sol = new soln();
		  sol.p = cur;
		  sol.closed = closed;
		  return sol;
		}
		
		visit.put(cur.end.name, 1);
		
		deque<path> n = SearchUSA.neighbors(cur);
		SearchUSA.add_paths(open, closed, n);
	    
	    List<path> temp = open.getList();
	    sort(temp , SearchUSA.astar_compare());
	    open.setDeque(temp);
	  }
	  System.err.println("Couldn't find path");
	  System.exit(1);
          return null;
	}

        
        public static Comparator<path> greedy_compare()
        {   
         Comparator comp = new Comparator<path>(){
             @Override
             public int compare(path p1, path p2)
             {
                 return SearchUSA.distance(p1.end, goal) < SearchUSA.distance(p2.end, goal) ? 1 : 0;
             }        
         };
         return comp;
        }  

	public static soln greedy(city start, city dest)
	{
	  deque<path> open = new deque<path>();
	  deque<path> closed = new deque<path>();
	  goal = dest;
	  visit.clear();
	  path s = new path();
	  s.prev = null;
	  s.end = start;
	  s.cost = 0;
	  open.push_back(s);

	  while (!open.empty())
	  {
		path cur = open.front();
		open.pop_front();
		closed.push_back(cur);

		if (cur.end.name.equals(goal.name))
		{
		  soln sol = new soln();
		  sol.p = cur;
		  sol.closed = closed;
		  return sol;
		}
		visit.put(cur.end.name, 1);
		
		deque<path> n = SearchUSA.neighbors(cur);

		SearchUSA.greedy_add_paths(open, closed, n);

		List<path> temp = open.getList();
                sort(temp , SearchUSA.greedy_compare());
                open.setDeque(temp);
	  }
	  System.err.println("Couldn't find path");
	  System.exit(1);
          return null;
	}

	
        public static Comparator<path> dynamic_compare()
        {   
         Comparator comp = new Comparator<path>(){
             @Override
             public int compare(path p1, path p2)
             {
                 return p1.cost < p2.cost ? 1 : 0;
             }        
         };
         return comp;
        }  
    
    public static void printDequeue(deque<path> dq) {
    	List<path> ls = dq.getList();
    	
    	for(path a : ls) {
    		System.out.print(a.end.name + " ");
    	}
    	System.out.println();
    }
    
	public static soln dynamic(city start, city dest)
	{
		deque<path> open = new deque<path>();
		deque<path> closed = new deque<path>();
	  goal = dest;
	  visit.clear();
	  path s = new path();
	  s.prev = null;
	  s.end = start;
	  s.cost = 0;
	  open.push_back(s);

	  while (!open.empty())
	  {
		path cur = open.front();
		open.pop_front();
		closed.push_back(cur);

		if (cur.end.name.equals(goal.name))
		{
		  soln sol = new soln();
		  sol.p = cur;
		  sol.closed = closed;
		  return sol;
		}
		visit.put(cur.end.name, 1);
		
		deque<path> n = SearchUSA.neighbors(cur);
		
		SearchUSA.add_paths(open, closed, n);
                
                List<path> temp = open.getList();
                sort(temp , SearchUSA.dynamic_compare());
                open.setDeque(temp);
                
	  }
	  System.err.println("Couldn't find path");
	  System.exit(1);
          return null;
	}

	public static void print_path(path p)
	{
	  deque<String> names = new deque<String>();
	  while (p != null && p.end != null)
	  {
		names.push_front(p.end.name);
		p = p.prev;
	  }
	  while (!names.empty())
	  {
		String n = names.front();
		names.pop_front();
		System.out.print(n);
		System.out.print(", ");
	  }
	}

	public static void print_soln(soln s)
	{
	  System.out.print("Number of expanded nodes: ");
	  System.out.print(s.closed.getList().size());
	  System.out.print("\n");
	  System.out.print("Expanded nodes: ");
	  SearchUSA.print_queue(s.closed);
	  System.out.print("\n");
	  System.out.print("Number of path nodes: ");
	  System.out.print(SearchUSA.path_count(s.p));
	  System.out.print("\n");
	  System.out.print("Path length: ");
	  System.out.print(s.p.cost);
	  System.out.print("\n");
	  System.out.print("Path: ");
	  SearchUSA.print_path(s.p);
	  System.out.print("\n");
	}

	public static void main(String[] args)
	{
          if (args.length < 3)
	  {
		System.out.print("Please use astar, greedy, dynamic sourcecity destination\n");
	  }
	  else
	  {     
                make_cities();
                make_roads();
                
		city start = SearchUSA.find_city(args[1]);
		if (start == null)
		{
		  System.err.printf("Error: start city " + start + " could not be found.");
		}

		city dest = SearchUSA.find_city(args[2]);
		if (dest == null)
		{
		  System.err.printf("Error: destination city " + dest + " could not be found.");
		}

		if (args[0].equals("astar"))
		{
		  soln s = SearchUSA.astar(start, dest);
		  SearchUSA.print_soln(s);
		}
		else if (args[0].equals("greedy"))
		{
		  soln s = SearchUSA.greedy(start, dest);
		  SearchUSA.print_soln(s);
		}
		else if (args[0].equals("dynamic"))
		{
		  soln s = SearchUSA.dynamic(start, dest);
		  SearchUSA.print_soln(s);
		}
		else
		{
		  System.out.print("Please use astar, greedy or dynamic sourcecity destination city\n");
		}
	  }
	}
}