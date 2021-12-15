import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class Lab22 {
    public static void main(String args[]) throws IOException
    {
		FileReader reader = new FileReader(args[2]);
		BufferedReader br = new BufferedReader(reader);
		String line = null;
		int y = 0;
		while(y!= Integer.parseInt(args[1]))
		{
			if ((line = br.readLine())==null) break;
			y++;
			System.out.println(line);
		}
		br.close();
     }
}