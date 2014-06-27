@echo off
thrift --gen java -out . ThriftMessage.thrift

@echo "make successful"