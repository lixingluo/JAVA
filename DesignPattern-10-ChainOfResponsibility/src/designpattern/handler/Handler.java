package designpattern.handler;

public abstract class Handler {
	Handler handler;
	public Handler(Handler handler) {
		// TODO Auto-generated constructor stub
		this.handler = handler;
	}
	public abstract void dealWith(Thing thing);
}
