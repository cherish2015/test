package test.hadoop.rpc;

import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.Server;

public class TestRpcServer {

	public static void main(String[] args) {
		System.setProperty("hadoop.home.dir", "E:/hadoop/hadoop-2.6.0");
		startServer();
	}
	
	private static void startServer(){
		IService service = new ServiceImpl();
		try {
			Server server = new RPC.Builder(new Configuration()).setProtocol(IService.class)
			.setInstance(service).setBindAddress("localhost").setPort(8888).build();
			server.start();
		} catch (HadoopIllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
