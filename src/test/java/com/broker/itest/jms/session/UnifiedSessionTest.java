package com.broker.itest.jms.session;

import static org.junit.Assert.fail;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.ServerSessionPool;
import javax.jms.TemporaryQueue;
import javax.jms.TemporaryTopic;
import javax.jms.Topic;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.broker.itest.testcase.UnifiedConnectionTestCase;

/**
 * Test unified JMS 1.1 sessions. <br />
 * See JMS 1.1 specifications
 * 
 * @since JMS 1.1
 */
public class UnifiedSessionTest extends UnifiedConnectionTestCase {

	@Rule
	public TestName name = new TestName();

	@Override
	public String getTestName() {
		return name.getMethodName();
	}

	/**
	 * Test that a call to <code>createDurableConnectionConsumer()</code> method on a <code>QueueConnection</code>
	 * throws a <code>javax.jms.IllegalStateException</code>. (see JMS 1.1 specs, table 4-1).
	 * 
	 * @since JMS 1.1
	 */

	@Test
	public void testCreateDurableConnectionConsumerOnQueueConnection() {
		try {
			queueConnection.createDurableConnectionConsumer(topic, "subscriptionName", "", (ServerSessionPool) null, 1);
			fail("Should throw a javax.jms.IllegalStateException");
		} catch (javax.jms.IllegalStateException e) {
		} catch (JMSException e) {
			fail("Should throw a javax.jms.IllegalStateException, not a " + e);
		}
	}

	/**
	 * Test that a call to <code>createDurableSubscriber()</code> method on a <code>QueueSession</code> throws a
	 * <code>javax.jms.IllegalStateException</code>. (see JMS 1.1 specs, table 4-1).
	 * 
	 * @since JMS 1.1
	 */
	@Test
	public void testCreateDurableSubscriberOnQueueSession() {
		try {
			queueSession.createDurableSubscriber(topic, "subscriptionName");
			fail("Should throw a javax.jms.IllegalStateException");
		} catch (javax.jms.IllegalStateException e) {
		} catch (JMSException e) {
			fail("Should throw a javax.jms.IllegalStateException, not a " + e);
		}
	}

	/**
	 * Test that a call to <code>createTemporaryTopic()</code> method on a <code>QueueSession</code> throws a
	 * <code>javax.jms.IllegalStateException</code>. (see JMS 1.1 specs, table 4-1).
	 * 
	 * @since JMS 1.1
	 */
	@Test
	public void testCreateTemporaryTopicOnQueueSession() {
		try {
			@SuppressWarnings("unused")
			TemporaryTopic tempTopic = queueSession.createTemporaryTopic();
			fail("Should throw a javax.jms.IllegalStateException");
		} catch (javax.jms.IllegalStateException e) {
		} catch (JMSException e) {
			fail("Should throw a javax.jms.IllegalStateException, not a " + e);
		}
	}

	/**
	 * Test that a call to <code>createTopic()</code> method on a <code>QueueSession</code> throws a
	 * <code>javax.jms.IllegalStateException</code>. (see JMS 1.1 specs, table 4-1).
	 * 
	 * @since JMS 1.1
	 */
	@Test
	public void testCreateTopicOnQueueSession() {
		try {
			@SuppressWarnings("unused")
			Topic tempTopic = queueSession.createTopic("topic_name");
			fail("Should throw a javax.jms.IllegalStateException");
		} catch (javax.jms.IllegalStateException e) {
		} catch (JMSException e) {
			fail("Should throw a javax.jms.IllegalStateException, not a " + e);
		}
	}

	/**
	 * Test that a call to <code>unsubscribe()</code> method on a <code>QueueSession</code> throws a
	 * <code>javax.jms.IllegalStateException</code>. (see JMS 1.1 specs, table 4-1).
	 * 
	 * @since JMS 1.1
	 */
	@Test
	public void testUnsubscribeOnQueueSession() {
		try {
			queueSession.unsubscribe("subscriptionName");
			fail("Should throw a javax.jms.IllegalStateException");
		} catch (javax.jms.IllegalStateException e) {
		} catch (JMSException e) {
			fail("Should throw a javax.jms.IllegalStateException, not a " + e);
		}
	}

	/**
	 * Test that a call to <code>createBrowser()</code> method on a <code>TopicSession</code> throws a
	 * <code>javax.jms.IllegalStateException</code>. (see JMS 1.1 specs, table 4-1).
	 * 
	 * @since JMS 1.1
	 */
	@Test
	public void testCreateBrowserOnTopicSession() {
		try {
			@SuppressWarnings("unused")
			QueueBrowser queueBrowser = topicSession.createBrowser(queue);
			fail("Should throw a javax.jms.IllegalStateException");
		} catch (javax.jms.IllegalStateException e) {
		} catch (JMSException e) {
			fail("Should throw a javax.jms.IllegalStateException, not a " + e);
		}
	}

	/**
	 * Test that a call to <code>createQueue()</code> method on a <code>TopicSession</code> throws a
	 * <code>javax.jms.IllegalStateException</code>. (see JMS 1.1 specs, table 4-1).
	 * 
	 * @since JMS 1.1
	 */
	@Test
	public void testCreateQueueOnTopicSession() {
		try {
			@SuppressWarnings("unused")
			Queue tempQueue = topicSession.createQueue("queue_name");
			fail("Should throw a javax.jms.IllegalStateException");
		} catch (javax.jms.IllegalStateException e) {
		} catch (JMSException e) {
			fail("Should throw a javax.jms.IllegalStateException, not a " + e);
		}
	}

	/**
	 * Test that a call to <code>createTemporaryQueue()</code> method on a <code>TopicSession</code> throws a
	 * <code>javax.jms.IllegalStateException</code>. (see JMS 1.1 specs, table 4-1).
	 * 
	 * @since JMS 1.1
	 */
	@Test
	public void testCreateTemporaryQueueOnTopicSession() {
		try {
			@SuppressWarnings("unused")
			TemporaryQueue tempQueue = topicSession.createTemporaryQueue();
			fail("Should throw a javax.jms.IllegalStateException");
		} catch (javax.jms.IllegalStateException e) {
		} catch (JMSException e) {
			fail("Should throw a javax.jms.IllegalStateException, not a " + e);
		}
	}
}
