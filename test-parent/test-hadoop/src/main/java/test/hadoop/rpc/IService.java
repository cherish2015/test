package test.hadoop.rpc;

import org.apache.hadoop.ipc.VersionedProtocol;

public interface IService extends VersionedProtocol{
	
	public static final long versionID = 99999L;
	
	public abstract String hello(String name);

}
