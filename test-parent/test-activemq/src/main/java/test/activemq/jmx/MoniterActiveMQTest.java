package test.activemq.jmx;



import java.util.Iterator;
import java.util.Set;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.broker.jmx.QueueViewMBean;

public class MoniterActiveMQTest {

	public static void main(String[] args) {
		test();
	}
	
	private static void test(){
		String surl = "service:jmx:rmi:///jndi/rmi://192.168.1.100:1099/jmxrmi";
		JMXConnector jmxc = null;
		try {
			JMXServiceURL url = new JMXServiceURL(surl);
			jmxc = JMXConnectorFactory.connect(url, null);
			MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
			
			System.out.println("\nDomains:---------------");
			String domains[] = mbsc.getDomains();
			for (int i = 0; i < domains.length; i++){
				System.out.println("\tDomain[" + i + "] = " + domains[i]);
			}
			
			System.out.println("\nall ObjectName：---------------");
			Set<ObjectInstance> set = mbsc.queryMBeans(null, null);
			for (Iterator<ObjectInstance> it = set.iterator(); it.hasNext();) {
				ObjectInstance oi = (ObjectInstance) it.next();
				System.out.println("\t" + oi.getObjectName());
			}
			
			System.out.println("\nqueue test.queue：---------------");
			ObjectName mbeanName = new ObjectName("org.apache.activemq:type=Broker,brokerName=localhost,destinationType=Queue,destinationName=test.queue");
			//MBeanServerInvocationHandler.newProxyInstance(mbsc, mbeanName, QueueViewMBean.class, notificationBroadcaster)
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (jmxc != null) {
				try {
					jmxc.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
