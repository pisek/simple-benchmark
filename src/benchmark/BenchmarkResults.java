package benchmark;

import java.util.ArrayList;
import java.util.List;

public class BenchmarkResults {

	private List<Long> timeResults = new ArrayList<Long>();
	
	private Long max = null;
	private Long min = null;
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (Long timeResult : timeResults) {
			sb.append(++i).append(": ").append(timeResult).append('\n');
		}
		sb.append("average: ").append(getAverage()).append('\n');
		sb.append("min: ").append(getMin()).append('\n');
		sb.append("max: ").append(getMax()).append('\n');
		return sb.toString();
	}
	

	public void addTimeResult(Long time) {
		timeResults.add(time);
		setMax(time);
		setMin(time);		
	}
	

	private void setMin(Long time) {
		if (this.min == null) {
			this.min = time;
		} else {
			if (this.min > time) {
				this.min = time;
			}
		}
	}


	private void setMax(Long time) {
		if (this.max == null) {
			this.max = time;
		} else {
			if (this.max < time) {
				this.max = time;
			}
		}
	}



	public Long getAverage() {
		long average = 0L;
		for (Long timeResult : timeResults) {
			average += timeResult;
		}
		average /= timeResults.size();
		return average;
	}

	public Long getMax() {
		return this.max;
	}
	
	public Long getMin() {
		return this.min;
	}
	
	public List<Long> getTimeResults() {
		return timeResults;
	}
}
