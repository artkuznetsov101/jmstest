package com.broker.itest.jms.message;

import static org.junit.Assert.assertEquals;

import javax.jms.DeliveryMode;
import javax.jms.Message;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import com.broker.itest.testcase.QueueConnectionTestCase;

/**
 * Test the default constants of the <code>javax.jms.Message</code> interface.
 */
public class MessageDefaultTest extends QueueConnectionTestCase {

	@Rule
	public TestName name = new TestName();

	@Override
	public String getTestName() {
		return name.getMethodName();
	}

	/**
	 * test that the <code>DEFAULT_DELIVERY_MODE</code> of <code>javax.jms.Message</code> corresponds to
	 * <code>javax.jms.Delivery.PERSISTENT</code>.
	 */
	@Test
	public void testDEFAULT_DELIVERY_MODE() {
		assertEquals("The delivery mode is persistent by default.\n", DeliveryMode.PERSISTENT, Message.DEFAULT_DELIVERY_MODE);
	}

	/**
	 * test that the <code>DEFAULT_PRIORITY</code> of <code>javax.jms.Message</code> corresponds to 4.
	 */
	@Test
	public void testDEFAULT_PRIORITY() {
		assertEquals("The default priority is 4.\n", 4, Message.DEFAULT_PRIORITY);
	}

	@Override
	public void setUp() {

	}

	@Override
	public void tearDown() {

	}
}
