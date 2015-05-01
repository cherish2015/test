package test.hadoop.rpc;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

public class TestRpcClient {

	public static void main(String[] args) {
		System.setProperty("hadoop.home.dir", "E:/hadoop/hadoop-2.6.0");
		testRpcClient();
	}

	private static void testRpcClient() {
		try {
			IService client = (IService) RPC.getProxy(IService.class,
					IService.versionID,
					new InetSocketAddress("localhost", 8888),
					new Configuration());
			String result = client.hello("Jake");
			System.err.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
