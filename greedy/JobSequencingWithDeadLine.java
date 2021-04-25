package greedy;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
public class JobSequencingWithDeadLine {
	private static class Job{
		private int profit;
		private int deadline;
		private int jobId;
		public Job(int profit,int deadline,int jobId) {
			this.profit=profit;this.deadline=deadline;this.jobId=jobId;
		}
		public int getProfit() {
			return profit;
		}
		public int getDeadline() {
			return deadline;
		}
		public int getJobId() {
			return jobId;
		}
	}
	public static void main(String[] args) {
		int []profits= new int[]{35,30,25,20,15,12,5};
		int []deadlines=new int[]{3,4,4,2,3,1,2};
		josSequrnce(profits,deadlines);
	}
	public static void josSequrnce(int []profits,int []deadlines) {
		int maxTimeSlot=deadlines[1];
		for(int i=1;i<deadlines.length;i++) {
			if(maxTimeSlot<deadlines[i]) maxTimeSlot=deadlines[i];
		}
		int []timeSlots=new int[maxTimeSlot+1];
		Arrays.fill(timeSlots,-1);
		PriorityQueue<Job> pq=new PriorityQueue<>(Comparator.comparing(Job::getProfit).reversed());
		for(int i=0;i<profits.length;i++) {
			pq.add(new JobSequencingWithDeadLine.Job(profits[i],deadlines[i],i));
		}
		int maxProfit=0;
		while(!pq.isEmpty()) {
			int profit=pq.peek().getProfit();
			int deadline=pq.peek().getDeadline();
			int jobId=pq.peek().getJobId();
			while(deadline>=1 && timeSlots[deadline]!=-1) deadline--;
			if(deadline>=1 && timeSlots[deadline]==-1) {// we have got a desired slot
				timeSlots[deadline]=jobId;
				maxProfit+=profit;
			}
			pq.poll();
		}
		System.out.println("Maximum profit will be : "+maxProfit);
		System.out.println(Arrays.toString(timeSlots));
		
	}

}
