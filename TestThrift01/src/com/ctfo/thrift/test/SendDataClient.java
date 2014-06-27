package com.ctfo.thrift.test;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import com.ctfo.thrift.Message;
import com.ctfo.thrift.SendDataServer;
import com.ctfo.thrift.SendDataServer.Iface;

/**
 * 客户端类
 * @author 梁健
 * 2013-11-27 21:15:42
 */
public class SendDataClient implements Iface{

	private static SendDataServer.Client client = null;
	private static TTransport transport = null;
	
	
	SendDataClient(String serverIP,int port,int timeout){
		transport = new TSocket(serverIP, port,timeout);
		client = new SendDataServer.Client(new TBinaryProtocol(transport));
	}
	
	@Override
	public String sendData(Message message) throws TException {
		if(!transport.isOpen())
			transport.open();
		return client.sendData(message);
	}
	
}
