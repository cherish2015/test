package test.commons.net;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试FTP
 * 
 * @author Administrator
 * @version 1.0
 * 
 */
public final class TestFTP {

	private static Logger log = LoggerFactory.getLogger(TestFTP.class);

	private int BufferSize = 1024 * 1024;

	private FTPClient client = null;

	private int replyCode;

	private String reply = "";

	public static void main(String[] args) {
		boolean test = false;
		if (test) {
		} else {

			testFtpLoginWithUsernamePassword();
		}
	}

	/**
	 * 登录FTP服务器
	 * 
	 * @param host
	 *            FTP主机地址
	 * @param port
	 *            FTP主机端口
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @throws Exception
	 *             登录失败
	 */
	public void ftpLogin(String host, int port, String username, String password)
			throws Exception {
		client = new FTPClient();
		// 设定连接超时时间
		client.setConnectTimeout(10*1000);
		try {
			client.connect(host, port);
			client.login(username, password);
			replyCode = client.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				reply = client.getReplyString().trim();
				throw new Exception("FTP 登录失败，响应消息:" + reply);
			}
			log.info("FTP 登录成功");

			// 设置缓冲区
			client.setBufferSize(BufferSize);
			// 设置传输模式
			// client.setFileType(FTP.BINARY_FILE_TYPE);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new Exception("FTP 登录失败");
		}
	}

	/**
	 * 切换目录
	 * 
	 * @param remotePath
	 *            目的目录
	 * @throws Exception
	 *             切换失败
	 */
	public void changeDirectory(String remotePath) throws Exception {
		try {
			client.pwd();
			replyCode = client.getReplyCode();
			reply = client.getReplyString().trim();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				throw new Exception("FTP 获取当前目录失败，响应消息:" + reply);
			}
			log.info("FTP 当前目录:{}", reply);

			client.changeWorkingDirectory(remotePath);
			replyCode = client.getReplyCode();
			reply = client.getReplyString().trim();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				throw new Exception("FTP 切换目录失败，响应消息:" + reply);
			}
			log.info("FTP 切换目录成功");

			client.pwd();
			replyCode = client.getReplyCode();
			reply = client.getReplyString().trim();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				throw new Exception("FTP 获取当前目录失败，响应消息:" + reply);
			}
			log.info("FTP 当前目录:{}", reply);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new Exception("FTP 切换目录失败");
		}
	}

	public FTPFile[] ftpListFiles(final String fileNameRegex) throws Exception {
		FTPFileFilter filter = null;
		FTPFile[] files = null;
		try {
			if (StringUtils.isNotBlank(fileNameRegex)) {
				filter = null;
				new FTPFileFilter() {

					public boolean accept(FTPFile file) {
						if (file.isFile()
								&& file.getName().matches(fileNameRegex)) {
							return true;
						}
						return false;
					}
				};
				files = client.listFiles(".", filter);

			} else {
				files = client.listFiles();
			}
			replyCode = client.getReplyCode();
			reply = client.getReplyString().trim();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				throw new Exception("FTP 获取文件列表失败，响应消息:" + reply);
			}
			log.info("FTP 获取文件列表成功");
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			throw new Exception("FTP 获取文件列表失败");
		}
		return files;
	}

	/**
	 * 断开FTP连接
	 */
	public void ftpDisconnect() {
		if (client == null) {
			return;
		}
		if (client.isConnected()) {
			try {
				client.disconnect();
				log.info("FTP 断开连接成功");
			} catch (Exception e) {
				log.error("FTP 断开连接失败", e);
			}
		}
	}

	public static void testFtpLoginWithUsernamePassword() {
		String host = "192.168.1.104";
		int port = 21;
		String username = "root";
		String password = "123456";
		TestFTP test = new TestFTP();
		try {
			test.ftpLogin(host, port, username, password);

			test.changeDirectory("..");

			FTPFile[] files = test.ftpListFiles(null);
			for (FTPFile ftpFile : files) {
				log.info(ftpFile.getRawListing());
			}

			test.changeDirectory("/home/ming/test/test-commons");

			files = test.ftpListFiles(null);
			for (FTPFile ftpFile : files) {
				log.info(ftpFile.getRawListing());
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			test.ftpDisconnect();
		}
	}

}
