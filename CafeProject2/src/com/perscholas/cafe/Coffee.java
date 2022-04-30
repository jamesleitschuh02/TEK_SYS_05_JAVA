package com.perscholas.cafe;

public class Coffee extends Product {

    public boolean sugar;
    public boolean milk;

    public Coffee() {
        super();
        this.sugar = false;
        this.milk = false;
    }
    
    public Coffee(String name, double price, String description) {
    	super(name, price, description);
    	this.sugar = false;
    	this.milk = false;
    }

    public Coffee(String name, double price, String description, boolean sugar, boolean milk) {
        super(name, price, description);
        this.sugar = sugar;
        this.milk = milk;
    }

    public boolean isMilk() {
		return milk;
	}

	public void setMilk(boolean milk) {
		this.milk = milk;
	}

	public boolean isSugar() {
		return sugar;
	}

	public void setSugar(boolean sugar) {
		this.sugar = sugar;
	}

	@Override
	public double ProductTotal() {
		return price * quantity;
	}

	@Override
	public void setModifiers(boolean milk, boolean sugar) {
		this.milk = milk;
		this.sugar = sugar;	
	}

	@Override
	public boolean getModifierOne() {
		return milk;
	}

	@Override
	public boolean getModifierTwo() {
		return sugar;
	}

	@Override
	public String getModifierOneName() {
		return "Milk: ";
	}

	@Override
	public String getModifierTwoName() {
		return "Sugar: ";
	}

	

}
