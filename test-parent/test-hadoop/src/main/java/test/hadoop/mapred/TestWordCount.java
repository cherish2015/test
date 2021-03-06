package test.hadoop.mapred;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class TestWordCount {
	
	static {
		System.setProperty("hadoop.home.dir", "E:/hadoop/hadoop-2.6.0");
	}

	public static void main(String[] args) {
		testWordCount(args);
	}
	
	protected static void testWordCount(String[] args){
		Configuration conf = new Configuration();
		try {
			String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();
			if (otherArgs.length < 2) {
				System.err.println("Usage: wordcount <in> [<in>...] <out>");
				//System.exit(1);
			}
			Job job = Job.getInstance(conf, "WordCount");
			job.setJarByClass(TestWordCount.class);
			job.setMapperClass(WordCountMaper.class);
			job.setCombinerClass(WordCountReducer.class);
			job.setReducerClass(WordCountReducer.class);
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);
			
			for (int i = 0; i < otherArgs.length-1; i++) {
				FileInputFormat.addInputPath(job, new Path(otherArgs[i]));
			}
			FileOutputFormat.setOutputPath(job, new Path(otherArgs[otherArgs.length-1]));
			
			System.exit(job.waitForCompletion(true)? 0:1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
