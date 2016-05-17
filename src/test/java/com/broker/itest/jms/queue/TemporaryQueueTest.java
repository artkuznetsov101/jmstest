package com.broker.itest.jms.queue;

import javax.jms.QueueReceiver;
import javax.jms.TemporaryQueue;

import org.junit.Rule;
import org.junit.rules.TestName;

import com.broker.itest.testcase.QueueConnectionTestCase;

/**
 * Test the <code>javax.jms.TemporaryQueue</code> features.
 */
public class TemporaryQueueTest extends QueueConnectionTestCase {

	@Rule
	public TestName name = new TestName();

	@Override
	public String getTestName() {
		return name.getMethodName();
	}

	private TemporaryQueue tempQueue;
	private QueueReceiver tempReceiver;

	/**
	 * Test a TemporaryQueue
	 */
	//	public void testTemporaryQueue() {
	//		try {
	//			// we stop both sender and receiver connections
	//			senderConnection.stop();
	//			receiverConnection.stop();
	//			// we create a temporary queue to receive messages
	//			tempQueue = receiverSession.createTemporaryQueue();
	//			// we recreate the sender because it has been
	//			// already created with a Destination as parameter
	//			sender = senderSession.createSender(null);
	//			// we create a receiver on the temporary queue
	//			tempReceiver = receiverSession.createReceiver(tempQueue);
	//			receiverConnection.start();
	//			senderConnection.start();
	//
	//			TextMessage message = senderSession.createTextMessage();
	//			message.setText("testTemporaryQueue");
	//			sender.send(tempQueue, message);
	//
	//			Message m = tempReceiver.receive(TestConfig.TIMEOUT);
	//			assertTrue("No message was received", m != null);
	//			if (m == null)
	//				return;
	//			assertTrue(m instanceof TextMessage);
	//			TextMessage msg = (TextMessage) m;
	//			assertEquals("testTemporaryQueue", msg.getText());
	//		} catch (JMSException e) {
	//			fail(e);
	//		}
	//	}

}
