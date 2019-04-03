package nb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.HashMap;





public class NaiveBayes {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader breader = new BufferedReader(new FileReader("count.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		while(true){
			String line = breader.readLine();
			if(line == null||line.trim().length()==0){
				break;
			}
			String f[] = line.split("\\t");
			map.put(f[0], Integer.parseInt(f[1].trim()));
			
		}
		for(java.util.Map.Entry<String, Integer> e:map.entrySet()){
			String outkey = e.getKey();
			double value = e.getValue();
			double pval =0;

			/*int sold = map.get("0 ");
			int unsold = map.get("1 ");*/
			
			double k= map.get(outkey);
			pval= (k*100)/1728;
			System.out.println(pval);
			
			/*if(outkey.equals("0")){
				pval = sold/100;
				
			}
			if(outkey.equals("1")){
				pval = unsold/100;
				
			}
			if(outkey.startsWith("0")){
				pval = pval/sold;
				
			}
			if(outkey.startsWith("1")){
				pval = pval/unsold;
			}*/
			pw.println(outkey+", "+pval);
		}
		pw.close();
	}

}
