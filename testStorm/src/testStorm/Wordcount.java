package testStorm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;

public class Wordcount implements IRichBolt {
	OutputCollector _collector;
	public Map<String, Integer> countMap = new HashMap<String, Integer>();

	@Override
	public void prepare(Map stormConf, TopologyContext context, OutputCollector collector) {
		_collector = collector;
	}

	@Override
	public void execute(Tuple input) {
		String word = input.getString(0);
		Integer count = this.countMap.get(word);
		if (null == count) {
			count = 0;
		}
		count++;
		this.countMap.put(word, count);

		Iterator<String> iter = this.countMap.keySet().iterator();
		while (iter.hasNext()) {
			String next = iter.next();
			System.out.println(next + ":" + this.countMap.get(next));
		}

		this._collector.ack(input);
	}

	@Override
	public void cleanup() {

	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		declarer.declare(new Fields("word"));
	}

	@Override
	public Map<String, Object> getComponentConfiguration() {
		return null;
	}

}
