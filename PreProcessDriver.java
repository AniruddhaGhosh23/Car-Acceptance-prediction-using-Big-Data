package pre;

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


public class PreProcessDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf= new Configuration();
		Job job=Job.getInstance(conf);
		
		job.setJarByClass( PreProcessDriver.class);
		job.setMapperClass( PreProcessMapper.class);
		job.setReducerClass( PreProcessReducer.class);
		//job.setPartitionerClass(SUPartitioner.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job .setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		job.setNumReduceTasks(1);
		
		
		
		FileInputFormat.addInputPath(job,new Path("caroutput"));
		FileOutputFormat.setOutputPath(job,new Path("preprocessoutput"));
		
		
		job.waitForCompletion(true);
		
	}

}
