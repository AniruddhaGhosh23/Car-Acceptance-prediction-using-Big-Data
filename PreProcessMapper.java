package pre;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class PreProcessMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

	
	private Text outkey=new Text();
	private IntWritable outvalue=new IntWritable(1);
	
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		String line=value.toString();
		String[] f = line.split(",");
		/*if(f[6].equalsIgnoreCase("unacc")){
			f[6]="1";
		}
		else{
			f[6]="0";
		}*/
		
	
		//String n =f[0]+" , "+f[1]+" , "+f[2]+" , "+f[3]+" , "+f[4]+" , "+f[5]+" , "+f[6];
		outkey.set(f[6].trim()+" , "+"buying : "+f[0]);
		context.write(outkey,outvalue);
		outkey.set(f[6].trim()+" , "+"maint : "+f[1]);
		context.write(outkey, outvalue);
		outkey.set(f[6].trim()+" , "+"doors : "+f[2]);
		context.write(outkey, outvalue);
		outkey.set(f[6].trim()+" , "+"persons : "+f[3]);
		context.write(outkey, outvalue);
		outkey.set(f[6].trim()+" , "+"lug_boot : "+f[4]);
		context.write(outkey, outvalue);
		outkey.set(f[6].trim()+" , "+"safety : "+f[5]);
		context.write(outkey, outvalue);
	}

	
}