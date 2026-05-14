import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public class logDriver {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration c = new Configuration();
		Job job = new Job(c,"Word count");
		job.setJarByClass(logDriver.class);
		job.setMapperClass(logMapper.class);
		job.setReducerClass(logReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		FileInputFormat.addInputPath(job, new Path (args[0]));
		FileOutputFormat.setOutputPath(job, new Path (args[1]));
		System.exit(job.waitForCompletion(true)? 0:1);
		
		
	}

}