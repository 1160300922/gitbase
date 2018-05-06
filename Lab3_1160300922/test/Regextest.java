import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

public class Regextest {
	public static void main(String args[])
	{
		String a = "Vertex = <\"Computer1\", \"Computer\", <\"192.168.1.101\">> ";
		String pattern = "\"(\\S+)\"";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(a);
		List<String> l = new ArrayList<>();
		int i = 0;
		while(m.find())
		{
			l.add(m.group(1));
			System.out.println(l.get(i));
			i++;
		}
		
	}
}
