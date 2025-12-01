import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
public class YouTubeMapper extends Mapper<LongWritable, Text, Text,
IntWritable> {
 private Text category = new Text();
 private IntWritable views = new IntWritable();
 public void map(LongWritable key, Text value, Context context)
 throws IOException, InterruptedException {
 String[] fields = value.toString().split(",");
 if (fields.length > 5) {
 category.set(fields[3]);
 try {
 int viewCount = Integer.parseInt(fields[4]);
 views.set(viewCount);
 context.write(category, views);
 } catch (NumberFormatException e) {
 // skip invalid data
 }
 }
 }
}
