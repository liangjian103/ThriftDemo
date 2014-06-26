package testStorm;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;

public class WordcountStart {

	public static void main(String[] args) {
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("1", new Wordcountspout());
		builder.setBolt("2", new SplitSentence()).fieldsGrouping("1", new Fields("word"));
		builder.setBolt("3", new Wordcount()).fieldsGrouping("2", new Fields("word"));

		Config conf = new Config();
		conf.setDebug(true);
		conf.setNumWorkers(20);

		LocalCluster cluster = new LocalCluster();
		cluster.submitTopology("wordcount-demo", conf, builder.createTopology());
		try {
			cluster.submitTopology("wordcount-demo", conf, builder.createTopology());
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		cluster.killTopology("wordcount-demo");
		cluster.shutdown();

		//Test GitHub
		
		//测试合并
		
		//测试基线
		
	}

}
