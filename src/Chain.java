import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.*;
import java.util.Date;

public class Chain {

	public static double load = 0;
	public static double Hash = 0;
	public static int n = 0;
	public static long time = 0;
	public static String hashCode = "";
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty = 0;

	public static double getAverageSystemLoad() {
		double averageUsage;

		OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
		if (osBean instanceof com.sun.management.OperatingSystemMXBean) {
			com.sun.management.OperatingSystemMXBean nativeOsBean = (com.sun.management.OperatingSystemMXBean) osBean;
			averageUsage = nativeOsBean.getCpuLoad();
		} else {
			int availableProcessors = osBean.getAvailableProcessors();
			averageUsage = osBean.getSystemLoadAverage() / availableProcessors;
		}
		if (averageUsage < 0) {
			averageUsage = -1; // If unavailable, getSystemLoadAverage() returns -1
		}
		return averageUsage * 100.0;
	}

	public static void run() {

		// keep z or else we get 0 System Load Allocation and Infinite Hash Rate
		double z = getAverageSystemLoad();
		n = 0;
		long finish = System.currentTimeMillis() + 90000;
		long timeStart = new Date().getTime();
		blockchain.add(new Block("BLOCK 1", "0"));
		System.out.println("Trying to Mine block 1");
		while (System.currentTimeMillis() <= finish) {
			blockchain.get(0).mineBlock(difficulty);
			n++;
		}
		// System.out.println();
		hashCode = "" + blockchain.get(0).toString();
		// System.out.println("HashCode: " + hashCode);
		long timeEnd = new Date().getTime();
		time = (timeEnd - timeStart) / 1000;
		long HR = n / time;
		load = getAverageSystemLoad();
		Hash = HR * (100 / load);

		/*
		 * System.out.println("System Load Allocation: " + load + "%");
		 * System.out.println("Time taken: " + time + " seconds");
		 * System.out.println("Hash counter: " + n); System.out.println("Hashrate:" +
		 * Hash + " Hash/S");
		 */

	}

	public static Boolean isChainValid() {
		Block currentBlock;
		Block previousBlock;
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');

		// loop through blockchain to check hashes:
		for (int i = 1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i - 1);
			// compare registered hash and calculated hash:
			if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
				System.out.println("Current Hashes not equal");
				return false;
			}
			// compare previous hash and registered previous hash
			if (!previousBlock.hash.equals(currentBlock.previoushash)) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			// check if hash is solved
			if (!currentBlock.hash.substring(0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}
		}
		return true;
	}
}