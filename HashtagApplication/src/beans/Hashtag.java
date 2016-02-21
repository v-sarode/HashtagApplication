package beans;

public class Hashtag {

	private String hash="";
	private String message="";
	
	public Hashtag(){
		
	}
	
	public Hashtag(String hash){
		super();
		this.hash = hash;
	}
	
	
	public String getHash() {
		return this.hash;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public void setHash(String hash) {
		this.hash = hash;
	}


	public boolean validate(){
		if(hash.matches("\\^$|\\s+")){
			this.message = "ERROR: Hashyag should not be empty or space";
			return false;	
		}else{
			return true;
		}
	}
	
}
