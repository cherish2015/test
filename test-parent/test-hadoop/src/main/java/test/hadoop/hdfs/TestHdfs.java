package test.hadoop.hdfs;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.ChecksumFileSystem;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RawLocalFileSystem;
import org.apache.hadoop.io.IOUtils;

@SuppressWarnings("unused")
public class TestHdfs {

	public static void main(String[] args) {
		System.setProperty("hadoop.home.dir", "E:/hadoop/hadoop-2.6.0");
		testCopyLocaleToHDFS();
	}
	
	private static void testHdfs(){
		String urlStr = "hdfs://192.168.1.104:9000/hello";
		InputStream in = null;
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
		try {
			URL url = new URL(urlStr);
			in = url.openStream();
			IOUtils.copyBytes(in, System.out, 10, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testFileSystem(){
		URI uri;
		try {
			uri = new URI("hdfs://192.168.1.104:9000/");
			FileSystem fs = FileSystem.get(uri, new Configuration());
			fs.mkdirs(new Path("/test"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testCopyLocaleToHDFS(){
		URI uri;
		try {
			uri = new URI("hdfs://192.168.1.104:9000/");
			FileSystem fs = FileSystem.get(uri, new Configuration());
			Path src = new Path("c:/ftnstat.stat");
			Path dst = new Path("/test");
			fs.copyFromLocalFile(false, true, src, dst);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testFS() throws Exception{
		FileSystem fs = new RawLocalFileSystem();
		fs.initialize(null, new Configuration());
		
		FileSystem fsCheck = new ChecksumFileSystem(fs){};
	}

}
