package test.hadoop.rpc;
import java.io.IOException;

import org.apache.hadoop.ipc.ProtocolSignature;


public class ServiceImpl implements IService {

	@Override
	public long getProtocolVersion(String protocol, long clientVersion)
			throws IOException {
		return IService.versionID;
	}

	@Override
	public ProtocolSignature getProtocolSignature(String protocol,
			long clientVersion, int clientMethodsHash) throws IOException {
		return new ProtocolSignature(IService.versionID, null);
	}

	@Override
	public String hello(String name) {
		return "hello "+name;
	}

}
