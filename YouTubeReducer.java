import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;
public class YouTubeReducer extends Reducer<Text, IntWritable, Text,
IntWritable> {
 public void reduce(Text key, Iterable<IntWritable> values, Context context)
 throws IOException, InterruptedException {
 int totalViews = 0;
 for (IntWritable val : values) {
 totalViews += val.get();
 }
 context.write(key, new IntWritable(totalViews));
 }
}
