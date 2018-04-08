package edu.handong.csee.java; //package name
/**
 * This class defines Salesman object.<br>
 * It is used for array(team) , has getter and setter for member names and sales 
 * @author YJW <br>
 * 
 */
public class Salesman {
	
	private String mName; //member's name
	private double sales; //member's sales
	/**
	 * This method is mName getter of Salesman Class <br>
	 * @return mName
	 */
	public String getmName() {
		return mName; // getmName() do return mName
	}
	/**
	 * This method is mName setter of Salesman Class <br>
	 * @parameter String mName
	 */
	public void setmName(String mName) {
		this.mName = mName; //store mName in this.mName
	}
	/**
	 * This method is Sales getter of Salesman Class <br>
	 * @return sales
	 */
	public double getSales() {
		return sales; //getSales() do return sales
	}
	/**
	 * This method is Sales setter of Salesman Class <br>
	 * @parameter double sales
	 */
	public void setSales(double sales) {
		this.sales = sales; //store sales in this.sales
	}
	
	

}
