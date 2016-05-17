package com.broker.itest.provider;

public abstract class ProviderLoader {

	//QueueFactory Name
	protected static final String qcfName = "testQCF";
	//TopicFactory Name
	protected static final String tcfName = "testTCF";
	//Timeout
	public static final long TIMEOUT = 10 * 1000;

	public static Provider getProvider() {
		return new ActiveMQProvider();
	}
}
