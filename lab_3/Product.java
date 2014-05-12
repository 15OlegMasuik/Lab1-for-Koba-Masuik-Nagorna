package lab;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Product {
	protected static String calories;
	protected static String proteins;
	protected static String fats;
	protected static String carbohydrates;
	public String surrogates;
	public String duedate;
	public String time;
	public int rating = 1;
	public int quantity = 0;
	public int db_id = 0;
	public Boolean alarm = false;
	static String dayofbirth;
	static int[] mas=new int[3];
	static int[] dayofbirtharray=new int[3];
	
	static int[] get(int[] mas) throws DateException {
		if((mas[0]<1)||(mas[0]>31)||(mas[1]<1)||(mas[1]>12)||(mas[2]<1900)||(mas[2]>2014)) {
		throw new DateException(mas);
		} else return mas;}
		
	public Product() {
		carbohydrates = "0";
		proteins = "0";
		fats = "0";
		calories = "0";
	}
	
	public String getCalories() {
		return calories;
	}
	
	public String getProteins() {
		return proteins;
	}
	
	public String getFats() {
		return fats;
	}
	
	public String getCarbohydrates() {
		return carbohydrates;
	}
	
	public String getCaloriesTitle() {
		return "Calories/100g:";
	}
	
	public String getCarbohydratesTitle() {
		return "Carbohydrates/100g:";
	}
	
	public String getProteinsTitle() {
		return "Proteins/100g:";
	}
	
	public String getFatsTitle() {
		return "Fats/100g:";
	}
	
	public String getQuantity() {
		return Integer.toString(quantity);
	}
	
	public String getDaysLeft() {
		Date endDate = parseDate(duedate);
		Date curDate = parseDate(giveCurrentDate());
	    Calendar cal1 = Calendar.getInstance();
	    cal1.setTime(curDate);
	    Calendar cal2 = Calendar.getInstance();
	    cal2.setTime(endDate);
	    long daysLeft = daysBetween(cal1, cal2);
	    if (daysLeft == 1) return "1 day";
	    else return Long.toString(daysLeft) + " days";
	}
	 
	public String getName() {
		return "Product";
	}
	
	public String getNameUA() {
		return "�������";
	}
	
	private Date parseDate(String dateString) {
	    DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
	    try {
	    	Date endDate =  df.parse(dateString);
		    return endDate;
	    } catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String giveCurrentDate()
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(cal.getTime());
    }
	
	private long daysBetween(Calendar startDate, Calendar endDate) {
        Calendar date = (Calendar) startDate.clone();
        long daysBetween = 0;
        while (date.before(endDate)) {
            date.add(Calendar.DAY_OF_MONTH, 1);
            daysBetween++;
        }
        return daysBetween;
    }
	
	public static ArrayList getProductTypes() {
		ArrayList<String> resultArray = new ArrayList<String>();
		resultArray.add("Meat Products");
		resultArray.add("Beverages");
		resultArray.add("Bread Products");
		resultArray.add("Eggs");
		resultArray.add("Fish Products");
		resultArray.add("Fruits");
		resultArray.add("Milk Products");
		resultArray.add("Sauces");
		resultArray.add("Vegetables");
		return resultArray;
	}
	
	public static ArrayList getProductTypesUA() {
		ArrayList<String> resultArray = new ArrayList<String>();
		resultArray.add("�'���");
		resultArray.add("�������");
		resultArray.add("����-�������");
		resultArray.add("����");
		resultArray.add("����");
		resultArray.add("������");
		resultArray.add("�������");
		resultArray.add("�����");
		resultArray.add("�����");
		return resultArray;
	}
	
	public static ArrayList getProductsUA() {
		ArrayList<String> resultArray = new ArrayList<String>();
		resultArray.add("�������");
		resultArray.add("������");
		resultArray.add("������");
		resultArray.add("���������");
		resultArray.add("��������");
		resultArray.add("��������");
		resultArray.add("����");
		resultArray.add("������");
		resultArray.add("������");	
		resultArray.add("������");
		resultArray.add("ó�����");
		resultArray.add("�����");
		resultArray.add("������");
		resultArray.add("������");
		resultArray.add("ѳ�");
		resultArray.add("����");
		resultArray.add("���");
		resultArray.add("���� ������");
		return resultArray;
	}
	
	public static ArrayList getProducts() {
		ArrayList<String> resultArray = new ArrayList<String>();
		resultArray.add("Ananas");
		resultArray.add("Apple");
		resultArray.add("Banana");
		resultArray.add("Beef");
		resultArray.add("Veal");
		resultArray.add("Chicken");
		resultArray.add("Esox");
		resultArray.add("Carassius");
		resultArray.add("Milk");
		resultArray.add("Ketchup");
		resultArray.add("Mustard");
		resultArray.add("Cucumber");
		resultArray.add("Tomato");
		resultArray.add("Carrot");
		resultArray.add("Juice");
		resultArray.add("Cola");
		resultArray.add("Bread");
		resultArray.add("ChickenEggs");
		return resultArray;
	}
	
	public static String getProductNameEN(String productNameUA) {
		for (int i = 0; i < getProducts().size(); i++) {
			if (productNameUA.equalsIgnoreCase(getProductsUA().get(i).toString())) {
				return getProducts().get(i).toString();
			}
		}
		return "not found";
	}
	
	
	public static void main (String args []) throws Exception {
		Scanner d = new Scanner(System.in);
		System.out.println("Input day of birth DD.MM.YYYY");
		dayofbirth=d.next();
		try {
			mas[0]=Integer.parseInt(dayofbirth.substring(0,2));
			mas[1]=Integer.parseInt(dayofbirth.substring(3,5));
			mas[2]=Integer.parseInt(dayofbirth.substring(6));
			dayofbirtharray=get(mas);
		} catch (NumberFormatException | StringIndexOutOfBoundsException | DateException e) {
			System.out.println("Error");
		}

		System.out.println(Arrays.toString(dayofbirtharray));
}
}	
	
