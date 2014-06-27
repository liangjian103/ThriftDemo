#!/bin/bash
######################################################################
# 服务启动脚本模板
# by LiangJian
# 2013-03-05
######################################################################

CUR_DIR=`pwd`
CLASSPATH="$CLASSPATH:$CUR_DIR:."
LANG="zh_CN.UTF-8"
JAVA_HOME="/opt/web_app/jdk"

JAVA_OPS="-server -Xmx1024m -Xms1024m -Xss128k -XX:PermSize=128m -XX:MaxPermSize=128m -XX:+UseThreadPriorities"

APP_PACKAGE_NAME="com.ctfo.thrift.test.SendDataClientTest"

export LANG

function startServer() {
	APP_PID=`jps -l | grep $APP_PACKAGE_NAME | cut -d' ' -f 1`

	if [ -n "$APP_PID" ]; then
		echo "Server already started !!  PID: $APP_PID    #_#"
		exit 1
	fi

	for _jar in ./*.jar; do
		CLASSPATH="$CLASSPATH:${_jar}"
	done

	$JAVA_HOME/bin/java $JAVA_OPS -cp $CLASSPATH $APP_PACKAGE_NAME >> console.log 2>&1 &
	echo "server start  successful   ^_^"
}

function stopServer() {
	APP_PID=`jps -l | grep $APP_PACKAGE_NAME | cut -d' ' -f 1`
	if [ -n "$APP_PID" ]; then
		echo "$APP_PID process is killed    *_*"
		kill -9 $APP_PID
	fi
}

function restartServer() {
	stopServer
	sleep 1
	startServer
}
 
function usage() {
	echo "Usage: $0 [start | stop | restart]    @_@"
	exit 1
}

if [  $# -ne 1  ]; then
	usage
fi

case $1 in
	start) startServer;;
	stop) stopServer;;
	restart) restartServer;;
	*) usage;;
esac

