package com.broker.itest.jms.topic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TemporaryTopic;
import javax.jms.TextMessage;
import javax.jms.TopicSubscriber;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.broker.itest.provider.ProviderLoader;
import com.broker.itest.testcase.TopicConnectionTestCase;

/**
 * Test the <code>javax.jms.TemporaryTopic</code> features.
 */
public class TemporaryTopicTest extends TopicConnectionTestCase {

	private TemporaryTopic tempTopic;
	private TopicSubscriber tempSubscriber;

	@Rule
	public TestName name = new TestName();

	@Override
	public String getTestName() {
		return name.getMethodName();
	}

	/**
	 * Test a TemporaryTopic
	 */
	@Test
	public void testTemporaryTopic() {
		try {
			// we stop both publisher and subscriber connections
			//      publisherConnection.stop();
			//      subscriberConnection.stop();

			// we create a temporary topic to receive messages
			tempTopic = subscriberSession.createTemporaryTopic();
			// we recreate the sender because it has been
			// already created with another Destination as parameter
			publisher = publisherSession.createPublisher(tempTopic);
			// we create a temporary subscriber on the temporary topic
			tempSubscriber = subscriberSession.createSubscriber(tempTopic);
			subscriberConnection.start();
			publisherConnection.start();

			TextMessage message = publisherSession.createTextMessage();
			message.setText("testTemporaryTopic");
			publisher.publish(message);

			Message m = tempSubscriber.receive(ProviderLoader.TIMEOUT);
			assertTrue(m instanceof TextMessage);
			TextMessage msg = (TextMessage) m;
			assertEquals("testTemporaryTopic", msg.getText());
		} catch (JMSException e) {
			fail(e.getMessage());
		}
	}
}
