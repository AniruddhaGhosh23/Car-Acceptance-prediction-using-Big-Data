package org;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CarMapper extends Mapper<LongWritable, Text, NullWritable, Text>{

	
	private NullWritable outkey=NullWritable.get();
	private Text outvalue= new Text();
	@Override
	protected void map(LongWritable key, Text value,Context context)
			throws IOException, InterruptedException {
		String line=value.toString();
		String[] f = line.split(",");
		if(f[6].equalsIgnoreCase("unacc")){
			f[6]="1";
		}
		else{
			f[6]="0";
		}
		
	
		String n =f[0]+" , "+f[1]+" , "+f[2]+" , "+f[3]+" , "+f[4]+" , "+f[5]+" , "+f[6];

		outvalue.set(n);
		context.write(outkey, outvalue);
	}

	
}