package test.hadoop.mapred;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class TestMapred extends Configured implements Tool{
	
	static{
		System.setProperty("hadoop.home.dir", "E:/hadoop/hadoop-2.6.0");
		System.setProperty("user.name", "hadoop");
	}
	
	enum Counter{
		LINESKIP;	//记录错误行数
	}

	public static void main(String[] args) {
		try {
			int ret = ToolRunner.run(new Configuration(), new TestMapred(), args);
			System.out.println(ret);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public int run(String[] args) throws Exception {
		Configuration conf = getConf();
		Job job = Job.getInstance(conf, "TestMapred");
		job.setJarByClass(TestMapred.class);
		
		FileInputFormat.addInputPath(job, new Path("hdfs://hadoop:9000/user/hadoop/input"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://hadoop:9000/user/hadoop/output3"));
		
		job.setMapperClass(Map.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		job.setOutputKeyClass(NullWritable.class);
		job.setOutputValueClass(Text.class);
		
		job.waitForCompletion(true);
		return job.isSuccessful() ? 0:1;
	}
	
	public static class Map extends Mapper<LongWritable, Text, NullWritable, Text>{
		@Override
		protected void map(LongWritable key, Text value,
				Context context)
				throws IOException, InterruptedException {
			String line = value.toString();
			try {
				String[] lineSplit = line.split("[ ]");
				String month = lineSplit[0];
				String time = lineSplit[1];
				String mac = lineSplit[6];
				Text out = new Text(month+"-"+time+"@"+mac);
				context.write(NullWritable.get(), out);
			} catch (Exception e) {
				context.getCounter(Counter.LINESKIP).increment(1);
			}
		}
	}

}
