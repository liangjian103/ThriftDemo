package com.ctfo.thrift.test;

import org.apache.log4j.Logger;

import com.ctfo.thrift.Message;

public class SendDataClientTest {
	
	private static Logger logger = Logger.getLogger(SendDataClientTest.class);
	private static long time = System.currentTimeMillis();

	private static SendDataClient client = new SendDataClient("192.168.110.113", 8888, 90000);

	public static void main(String[] args) {

		logger.info("Start:"+time);
//		try {
//			for (int i = 1; i <= 1; i++) {
//				final int x = i;
//				Thread t = new Thread() {
//					@Override
//					public void run() {
						send(1);
//					}
//				};
//				t.start();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public static void send(int x) {
		try {
			for (int t = 0; t < 5000; t++) {
				Message message = new Message();
				message.setAlarmCode("testtesttesttest" + t);
				message.setTid("testtesttesttest" + t);
				message.setLat("testtesttesttest" + t);
				message.setLon("testtesttesttest" + t);
				message.setMapLat("testtesttesttest" + t);
				message.setMapLon("testtesttesttest" + t);
				message.setGpsSpeed("testtesttesttest" + t);
				message.setHead("testtesttesttest" + t);
				message.setUtc("testtesttesttest" + t);
				message.setAlarmCode("testtesttesttest" + t);
				message.setAlarmSysUtc("testtesttesttest" + t);
				message.setAlarmUtc("testtesttesttest" + t);
				message.setVehicleSpeed("testtesttesttest" + t);
				message.setBasestatus("testtesttesttest" + t);
				message.setExtendstatus("testtesttesttest" + t);
				message.setSpeedFrom("1111111111111" + t);
				message.setHeight("111111111111111111" + t);
				message.setCommaddr("testtesttesttest" + t);
				message.setTid("testtesttesttest" + t);
				message.setOemcode("testtesttesttest" + t);
				message.setSystemTime("testtesttesttest" + t);
				message.setIsValid("testtesttesttest" + t);
				message.setMsgid("testtesttesttest" + t);
				message.setMsgUtc("22222222222" + t);
				client.sendData(message);
			}
			logger.info("线程:["+x+"]OK:"+(System.currentTimeMillis()-time)+"ms");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
