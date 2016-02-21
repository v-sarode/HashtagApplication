package model;

public class Hashtag {

	private String hash="";
	private String message="";
	
	public Hashtag() {
		super();
	}


	public Hashtag(String hash){
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
		//if(!hash.matches("\\^$|\\s+")){
			//if(hash.matches("/^[\\s]*$/")){//|(\s+$)"){
				if(hash.length() == 0 || hash.contains(" ") || hash.equals(null)){
			//	this.message = "ERROR: Hashtag should not be empty or space";
					message = "hashtag cannot be empty. please enter with some value...";
			return false;
			
		}else{
			message = "Input is valid...";

			return true;

		}
	}
	
}
