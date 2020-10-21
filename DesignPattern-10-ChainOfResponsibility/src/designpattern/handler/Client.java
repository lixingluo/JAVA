package designpattern.handler;

public class Client {
	public static void main(String[] args) {
		Handler handler = null;
		
		Handler headmaster = new Headmaster(handler);
		Handler vicePresident = new VicePresident(headmaster);
		Handler chairman = new Chairman(vicePresident);
		Handler dean = new Dean(chairman);
		
		Thing thing1 = new Thing();
		Thing thing2 = new Thing();
		Thing thing3 = new Thing();
		Thing thing4 = new Thing();
		Thing thing5 = new Thing();
		thing1.setNameString("Buy some books");
		thing1.setAmountInteger(100);
		thing2.setNameString("Buy some computers");
		thing2.setAmountInteger(10000);
		thing3.setNameString("Repair old building");
		thing3.setAmountInteger(100000);
		thing4.setNameString("Build new school");
		thing4.setAmountInteger(500000);
		thing5.setNameString("Buy a college");
		thing5.setAmountInteger(1000000);
		
		dean.dealWith(thing1);
		dean.dealWith(thing2);
		dean.dealWith(thing3);
		dean.dealWith(thing4);
		dean.dealWith(thing5);
	}
}
