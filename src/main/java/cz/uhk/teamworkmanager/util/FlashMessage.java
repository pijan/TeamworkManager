package cz.uhk.teamworkmanager.util;

public class FlashMessage {

	private int type;
	private String message;
	
	public final static int MESSAGE_OK = 1;
	public final static int MESSAGE_INFO = 2;
	public final static int MESSAGE_GENERAL = 3;
	public final static int MESSAGE_ERROR = 4;
			
	public FlashMessage(){
		
	}
	
	public FlashMessage(int type, String message){
		this.type = type;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
	
}
