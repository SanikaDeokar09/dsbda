import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class logMapper extends Mapper <LongWritable,Text,Text,IntWritable>{
	public void map(LongWritable key,Text value,Context con) throws IOException, InterruptedException{
		String[] lines=value.toString().split("\\R");
		
		for(String word:lines) {
			String[] ad = word.toString().split(" ");
			con.write(new Text(ad[0]),new IntWritable(1));
	 }
	}

}
