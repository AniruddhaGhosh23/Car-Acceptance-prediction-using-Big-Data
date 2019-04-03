package org;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class CarDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf= new Configuration();
		Job job=Job.getInstance(conf);
		
		job.setJarByClass(CarDriver.class);
		job.setMapperClass(CarMapper.class);
//		job.setReducerClass(CarReducer.class);
		//job.setPartitionerClass(SUPartitioner.class);
		
		//job.setMapOutputKeyClass(IntWritable.class);
		//job.setMapOutputValueClass(Text.class);
		job .setOutputKeyClass(NullWritable.class);
		job.setOutputValueClass(Text.class);
		
		job.setNumReduceTasks(0);
		
		
		
		FileInputFormat.addInputPath(job,new Path("cardir"));
		FileOutputFormat.setOutputPath(job,new Path("caroutput"));
		
		
		job.waitForCompletion(true);
		
	}

}
