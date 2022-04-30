package com.perscholas.cafe;

public class Espresso extends Product {

    public boolean extraShot;
    public boolean macchiato;
    
    public Espresso() {
    	super();
    	this.extraShot = false;
    	this.macchiato = false;
    }
    
    public Espresso(String name, double price, String description) {
    	super(name, price, description);
    	this.extraShot = false;
    	this.macchiato = false;
    }

	public Espresso(String name, double price, String description, boolean extraShot, boolean macchiato) {
		super(name, price, description);
		this.extraShot = extraShot;
		this.macchiato = macchiato;
	}

    public boolean isExtraShot() {
		return extraShot;
	}

	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}

	public boolean isMacchiato() {
		return macchiato;
	}

	public void setMacchiato(boolean macchiato) {
		this.macchiato = macchiato;
	}



	@Override
	public double ProductTotal() {
		if (extraShot && macchiato) {
            return (price * quantity) + (2 * quantity) + quantity; 
        }
        else if (extraShot && !macchiato) {
            return (price * quantity) + (2 * quantity); 
        }
        else if (!extraShot && macchiato) {
            return (price * quantity) + quantity; 
        }
        else {
            return price * quantity; 
        }
	}
	
	@Override
	public void setModifiers(boolean extraShot, boolean macchiato) {
		this.extraShot = extraShot;
		this.macchiato = macchiato;		
	}

	@Override
	public boolean getModifierOne() {
		return extraShot;
	}

	@Override
	public boolean getModifierTwo() {
		return macchiato;
	}

	@Override
	public String getModifierOneName() {
		return "Extra Shot: ";
	}

	@Override
	public String getModifierTwoName() {
		return "Macchiato: ";
	}

}
