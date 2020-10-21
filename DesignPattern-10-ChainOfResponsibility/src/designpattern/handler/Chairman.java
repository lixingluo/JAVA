package designpattern.handler;

public class Chairman extends Handler {

	public Chairman(Handler handler) {
		super(handler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dealWith(Thing thing) {
		// TODO Auto-generated method stub
		if(thing.getAmountInteger() < 100000) {
			System.out.println("I am chairman, I can handle " + thing.getNameString() + ", total spend " + thing.getAmountInteger());
		} else {
			this.handler.dealWith(thing);
		}
	}

}
