package designpattern.handler; 

public class VicePresident extends Handler {

	public VicePresident(Handler handler) {
		super(handler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dealWith(Thing thing) {
		// TODO Auto-generated method stub
		if(thing.getAmountInteger() < 500000) {
			System.out.println("I am a vicePresident, I can handle " + thing.getNameString() + " , total spend " + thing.getAmountInteger());
		} else {
			this.handler.dealWith(thing);
		}
	}

}
