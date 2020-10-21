package designpattern.handler;

public class Headmaster extends Handler {

	public Headmaster(Handler handler) {
		super(handler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dealWith(Thing thing) {
		// TODO Auto-generated method stub
		if(thing.getAmountInteger() < 1000000) {
			System.out.println("I am a headmaster, I can handle " + thing.getNameString() + " , total spend " + thing.getAmountInteger());
		} else {
			System.out.println("What you order is so much!");
		}
	}

}
