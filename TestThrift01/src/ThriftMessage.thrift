#!/usr/local/bin/thrift --gen java ThriftTest
namespace java com.ctfo.thrift

struct Message {
  1: string vid,
  2: string lat, 
  3: string lon, 
  4: string mapLon, 
  5: string mapLat, 
  6: string gpsSpeed, 
  7: string head, 
  8: string utc, 
  9: string alarmCode, 
  10: string alarmUtc, 
  11: string alarmSysUtc, 
  12: string vehicleSpeed, 
  13: string basestatus, 
  14: string extendstatus, 
  15: string speedFrom, 
  16: string height, 
  17: string commaddr, 
  18: string tid, 
  19: string oemcode, 
  20: string systemTime, 
  21: string msgid, 
  22: string isValid,  
  23: string msgUtc
}

// 测试thrift服务接口
service SendDataServer {
	//发送数据接口
	string sendData(1:Message message);
}

