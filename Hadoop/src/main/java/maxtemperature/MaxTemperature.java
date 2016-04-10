package maxtemperature;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.InputStream;
import java.net.URI;

public class MaxTemperature {
    public static void main(String[] args) throws Exception {
//        if (args.length != 2) {
//            System.err.println("Usage: MaxTemperature <input path> <output path>");
//            System.exit(-1);
//        }

        //这里两个参数本来在执行main方法的args里面配置，这里写死在这里方便调试
        String[] args1={"hdfs://192.168.1.111:9000/input",   "hdfs://192.168.1.111:9000/output"};

        Configuration conf = new Configuration();
        // 每个人的maven仓库的路径不一样，这里使用你的MAVEN仓库路径，比如我的MAVEN就暴露出了盘很多，报名为me.j360.hadoop，F:\\Maven\\repo
        // 如果缺少这一句，会提示ClassNotFound
        conf.set("mapred.jar", "E:\\Repository\\JavaTech\\Hadoop\\build\\libs\\Hadoop-1.0-SNAPSHOT.jar");

        // 以下都是默认配置，端口号和hadoop集群的配置必须要一致
        conf.setBoolean("mapreduce.app-submission.cross-platform", true);      // 配置使用跨平台提交任务
        String flag=conf.get("mapreduce.app-submission.cross-platform");
        System.out.println(flag);
        conf.set("fs.defaultFS", "hdfs://192.168.1.111:9000");                       //指定namenode
        conf.set("mapreduce.framework.name", "yarn");                            // 指定使用yarn框架
        conf.set("yarn.resourcemanager.address", "192.168.1.111:8032");             // 指定resourcemanager
        conf.set("yarn.resourcemanager.scheduler.address", "192.168.1.111:8030");  // 指定资源分配器
        conf.set("mapreduce.jobhistory.address","192.168.1.111:10020");

        Job job = Job.getInstance(conf, "MaxTemperature");
        job.setJarByClass(MaxTemperature.class);
        job.setJobName("Max temperature");

        FileInputFormat.addInputPath(job, new Path(args1[0]));
        FileOutputFormat.setOutputPath(job, new Path(args1[1]));

        job.setMapperClass(MaxTemperatureMapper.class);
        job.setReducerClass(MaxTemperatureReducer.class);

        job.setOutputKeyClass(Text.class);              //注1
        job.setOutputValueClass(IntWritable.class);


        if(job.waitForCompletion(true)){
            System.out.println("执行完成...");

            //使用hdfs的api打印出结果
            FileSystem fs = FileSystem.get(URI.create("hdfs://192.168.1.111:9000"), conf);

            // 列出hdfs上/tmp/output/目录下的所有文件和目录
            FileStatus[] statuses = fs.listStatus(new Path("/output"));
            for (FileStatus status : statuses) {
                System.out.println(status);
                System.out.println(status.getPath());

            }

            // 显示在hdfs的/tmp/output下指定文件的内容
            InputStream is = fs.open(new Path("/output/part-r-00000"));
            IOUtils.copyBytes(is, System.out, 1024, true);

        }
    }
}