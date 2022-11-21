import java.util.Date;

public class Block {
	public String hash;
	public String previoushash;
	private String data;// message
	private long timeStamp; // nb of milliseconds since 1970

	public Block(String dat, String prev) {
		previoushash = prev;
		data = dat;
		timeStamp = new Date().getTime();
		hash = calculateHash();
	}

	public String calculateHash() {
		String calculatedhash = StringUtil.applySha256(previoushash + Long.toString(timeStamp) + data);
		return calculatedhash;
	}

	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); // Create a string with difficulty * "0"
		while (!hash.substring(0, difficulty).equals(target)) {
			hash = calculateHash();
		}
		System.out.println("Block Mined!!! : " + hash);
	}
}