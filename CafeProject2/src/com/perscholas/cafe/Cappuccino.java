package com.perscholas.cafe;

public class Cappuccino extends Product{

    public boolean peppermint;
    public boolean whippedCream;
    
    public Cappuccino() {
    	super();
    	this.peppermint = false;
    	this.whippedCream = false;
    }
    
    public Cappuccino(String name, double price, String description) {
    	super(name, price, description);
    	this.peppermint = false;
    	this.whippedCream = false;
    }
    
    

	public Cappuccino(String name, double price, String description, boolean peppermint, boolean whippedCream) {
		super(name, price, description);
		this.peppermint = peppermint;
		this.whippedCream = whippedCream;
	}



	public boolean isPeppermint() {
		return peppermint;
	}



	public void setPeppermint(boolean peppermint) {
		this.peppermint = peppermint;
	}



	public boolean isWhippedCream() {
		return whippedCream;
	}



	public void setWhippedCream(boolean whippedCream) {
		this.whippedCream = whippedCream;
	}



	@Override
	public double ProductTotal() {
		if (peppermint && whippedCream) {
			return (price * quantity) + (2 * quantity) + (2 + quantity);
		}
		else if (peppermint || whippedCream) {
			return (price * quantity) + (2 * quantity);
		}
		else {
			return price * quantity;
		}
	}
	
	@Override
	public void setModifiers(boolean peppermint, boolean whippedCream) {
		this.peppermint = peppermint;
		this.whippedCream = whippedCream;		
	}

	@Override
	public boolean getModifierOne() {
		return peppermint;
	}

	@Override
	public boolean getModifierTwo() {
		return whippedCream;
	}

	@Override
	public String getModifierOneName() {
		return "Peppermint: ";
	}

	@Override
	public String getModifierTwoName() {
		return "Whipped Cream: ";
	}

}
