package designpattern.handler;

public class Dean extends Handler {

	public Dean(Handler handler) {
		super(handler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dealWith(Thing thing) {
		// TODO Auto-generated method stub
		if(thing.getAmountInteger() < 10000) {
			System.out.println("I am dean, I can handle " + thing.getNameString() + ", total spend " + thing.getAmountInteger());
		} else {
			this.handler.dealWith(thing);
		}
	}

}
