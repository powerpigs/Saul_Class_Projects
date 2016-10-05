import java.util.*;
import java.io.*;

public class BadgeReader  {
	List<String> badges;
	// int currentBadge;
	
	public BadgeReader(String dataFile) {
        badges = new ArrayList<String>();
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(dataFile)));

	        String str;
	        while ((str = br.readLine()) != null) {
	            badges.add(str);
	        }

	        br.close();
		}catch (Exception e) {}
	}
}