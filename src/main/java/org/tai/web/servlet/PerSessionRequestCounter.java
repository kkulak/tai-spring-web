package org.tai.web.servlet;

import java.util.concurrent.atomic.AtomicInteger;

public class PerSessionRequestCounter {
	
	public final AtomicInteger requestCount = new AtomicInteger(0);
	
	public void newRequest(){
		requestCount.incrementAndGet();
	}
	
	public int requestCount(){
		return requestCount.intValue();
	}

}
