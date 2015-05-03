package test.hadoop.mapred;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMaper extends Mapper<LongWritable, Text, Text, IntWritable> {
	
	private static final IntWritable one = new IntWritable(1);
	private Text word = new Text();
	
	@Override
	protected void map(LongWritable key, Text value,
			Context context)
			throws IOException, InterruptedException {
		StringTokenizer itr = new StringTokenizer(value.toString());
		while (itr.hasMoreTokens()) {
			this.word.set(itr.nextToken());
			context.write(word, one);
		}
	}

}
