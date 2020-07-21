package model;

import java.util.ArrayList;
import javafx.beans.property.*;

public class SalesModel
{
    
    private final IntegerProperty speed = new SimpleIntegerProperty(this, "speed");
    private final StringProperty internetTraffic = new SimpleStringProperty(this, "internetTraffic");
    private final IntegerProperty contract = new SimpleIntegerProperty(this, "contract");
    private final StringProperty nameSurname = new SimpleStringProperty(this, "nameSurname");
    private final StringProperty address = new SimpleStringProperty(this, "address");
    private final ObjectProperty<ArrayList<String>> errorList = new SimpleObjectProperty<>(this, "errorList", new ArrayList<>());//s

    public SalesModel()
    {

    }

    public SalesModel(int speed, String internetTraffic, int contract, String nameSurname, String address)
    {
	this.speed.set(speed);
	this.internetTraffic.set(internetTraffic);
	this.contract.set(contract);
	this.nameSurname.set(nameSurname);
	this.address.set(address);
    }

    public int getSpeed()
    {
	return speed.get();
    }

    public void setSpeed(int speed)
    {
	this.speed.set(speed);
    }

    public IntegerProperty speedProperty()
    {
	return speed;
    }

    
    public String getInternetTraffic()
    {
	return internetTraffic.get();
    }

    
    public void setInterneTraffic(String internetTraffic)
    {
	this.internetTraffic.set(internetTraffic);
    }

    
    public StringProperty InternetProperty()
    {
	return internetTraffic;
    }

    public int getContract()
    {
	return contract.get();
    }

    public void setContract(int contract)
    {
	this.contract.set(contract);
    }

    public IntegerProperty contractProperty()
    {
	return contract;
    }


    public String getNameSurname()
    {
	return nameSurname.get();
    }

    public void setNameSurname(String nameSurname)
    {
	this.nameSurname.set(nameSurname);
    }

    public StringProperty nameSurnameProperty()
    {
	return nameSurname;
    }

    public String getAddress()
    {
	return address.get();
    }

    public void setAddress(String address)
    {
	this.address.set(address);
    }

    public StringProperty addressProperty()
    {
	return address;
    }

    public ObjectProperty<ArrayList<String>> errorsProperty()
    {
	return errorList;
    }

    //////////////////////////////////////////////////
    public boolean check()
    {
	boolean check = true;

	if(nameSurname.get() != null && nameSurname.get().equals(""))
	{
	    errorList.getValue().add("Name Surname field can't be empty!");
	    check = false;
	}
	if(internetTraffic.get() != null && internetTraffic.get().equals(""))
	{
	    errorList.getValue().add("InternetTraffic field can't be empty!");
	    check = false;
	}

	if(address.get() != null && address.get().equals(""))
	{
	    errorList.getValue().add("Address field can't be empty!");
	    check = false;
	}

	return check;
    }

    @Override
    public String toString()
    {
	return "Name and Surname: " + nameSurname.get() + "\n" + "Address: " + address.get() + "\n" + "Contract: " + contract.get() + "\n" + "Internet speed: " + speed.get() + "\n" + "Internet traffic: " + internetTraffic.get();
    }
}
