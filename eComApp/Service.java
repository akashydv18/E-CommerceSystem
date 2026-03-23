package eComApp;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Service {

	Map<String, Product> products = new HashMap<>();
	Scanner sc = new Scanner(System.in);

	static {
		System.out.println("Application starts!!");

	}

	{
		
		products.put("P101", new Shirt("Blkbry", 4065.0, 42, "Black", "full"));
		products.put("P102", new Mobile("Samsung",15999.99, 6, "Black", 128));
		products.put("P103", new Laptop("Dell", 55999.99, 8, "Silver", 512));
		products.put("P104", new Shirt("Levis", 2499.99, 42, "White", "Half"));
		products.put("P105", new Mobile("Apple", 69999.99, 4, "White", 64));
		products.put("P106", new Laptop("HP", 45999.99, 16, "Black", 1024));
		products.put("P107", new Shirt("Arrow", 2999.99, 38, "Pink", "Full"));
		products.put("P108", new Mobile("OnePlus", 39999.99, 8, "Red", 256));
		products.put("P109", new Laptop("Lenovo", 35999.99, 12, "Grey", 512));
		products.put("P110", new Shirt("Polo", 1800.99, 38, "green", "half"));
		products.put("P111", new Tshirt("H&M", 3089.0, 34, "grey", "half"));
		products.put("P112", new Tshirt("Nike", 3009.0, 38, "yellow", "half"));
		products.put("P113", new Tshirt("Duke", 5000.0, 42, "white", "half"));
		products.put("P114", new Shirt("Blkbry", 1900.0, 42, "Black", "full"));
		products.put("P115", new Shirt("Polo", 1999.99, 40, "Blue", "Full"));
	}

	public void start() {
		System.out.println("Enter Admin/User: ");
		String choice = sc.nextLine();
		if (choice.equalsIgnoreCase("admin")) {
			// admin code
			// validation code for admin
			do {
				adminAccess();
			} while (selectContinue());
			System.out.println("Thank You! Application Ends!");

		} else if (choice.equalsIgnoreCase("user")) {
			// user code
			// validation code for user
			do {
				userAccess();
			} while (selectContinue());
			System.out.println("Thank You! Application Ends!");
		} else {
			System.out.println("Invalid choice!Please select valid options");
			start();
		}
	}

	public void adminAccess() {
		System.out.println("You have Selected Admin");
		System.out.println("Press 1 to Access all products");
		System.out.println("Press 2 to add products");
		System.out.println("Press 3 to Remove a product with given ProductId");
		System.out.println("Press 4 to Count all Products of any Type");
		System.out.println("Press 5 to get details about all products");
		System.out.println("Press 6 to know count about each products");
		System.out.println("Press 7 to Count all Shirt Products of a particular size");
		System.out.println("Press 8 to List the all brands available");
		System.out.println("Press 9 to List all the size available in shirt");
		System.out.println("Press 10 to Count the number of shirts available for a particular brand as per user input");
		System.out.println("Press 11 to Count the number of shirts available in each colour");
		System.out.println("Press 12 to Count the number of shirts available in each size");
	
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			System.out.println("Product List: ");
			products.forEach((k, v) -> {
				System.out.println("ProductId: " + k + "\t" + v);
			});
			break;
		case 2:
			addProduct();
			break;
		case 3:
			System.out.println("Enter ProductId to remove: ");
			String pid = sc.nextLine();
			if (products.containsKey(pid)) {
				products.remove(pid);
				System.out.println("Product with ProductId " + pid + " removed successfully!");
			} else
				System.out.println("Such product is NOT Found!!");
			break;
		case 4:
			System.out.println("Enter the product Type: ");
			String productType = sc.nextLine();
			if (productType.equalsIgnoreCase("mobile"))
				System.out.println("Total Mobile Products are: " + Mobile.getCount());
			else if (productType.equalsIgnoreCase("shirt"))
				System.out.println("Total Shirt Products are: " + Shirt.getCount());
			else if (productType.equalsIgnoreCase("laptop"))
				System.out.println("Total Laptop Products are: " + Laptop.getCount());
			else
				System.out.println("Unknown Type Product Found!");
			break;
		case 5:
			printAllProductDetails();
			break;
		case 6:
			printAllProductCount();
			break;
		case 7:
			countShirtBySize();
			break;
		case 8:
			listAllBrands();
			break;
		case 9:
			listAllShirtSizes();
			break;
		case 10:
			countShirtsByBrand();
			break;
		case 11:
			countShirtsByColour();
			break;
		case 12:
			countShirtsBySize();
			break;
		default:
			System.out.println("Invalid Choice! Please select valid option");
		}
	}
   //User
	public void userAccess() {
		System.out.println("You have Selected User");
		System.out.println("Press 1 to Access all products");
		System.out.println("Press 2 for Access all shirt Products");
		System.out.println("Press 3 to Access all Mobile Products");
		System.out.println("Press 4 to Access all TShirt Products");
		System.out.println("Press 5 to Access shirt of Blackbery in size 42");
		System.out.println("Press 6 to Access all shirts of size 40 and price>2000");
		System.out.println("Press 7 to Sort all shirts on price low to high");
		System.out.println("Press 8 to Sort all shirts on price high to low");
		System.out.println("Press 9 to Sort all Mobile on price low to high");
		System.out.println("Press 10 to Sort all Mobiles on price High to Low");

		
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			System.out.println("Product List: ");
			products.forEach((k, v) -> {
				System.out.println("ProductId: " + k + "\t" + v);
			});
			break;
		case 2:
			accessAllShirts();
			break;
		case 3:
			 accessAllMobile();
			 break;
		case 4:
			accessAllTshirt();
			break;
		case 5:
			accessShirtsByBrandAndSize();
			break;
		case 6:
			accessShirtsBySizeAndPrice();
			break;
		case 7:
			sortShirtsByPriceLowToHigh();
			break;
		case 8:
			sortShirtsByPriceHighToLow();
			break;
		case 9:
			sortMobileByPriceLowToHigh();
			break;
		case 10:
			sortMobileByPriceHighToLow();
			break;
			default:
				System.out.println("Invalid Choice! Please select valid option");
			
		}
	}

	public void addProduct() {
		System.out.println("Enter ProductId: ");
		String pid = sc.nextLine();
		products.put(pid, getProduct());
	}
	public Product getProduct() {
		System.out.println("Press 1 for Shirt");
		System.out.println("Press 2 for Mobile");
		System.out.println("Press 3 for Laptop");
		int choice = Integer.parseInt(sc.nextLine());
		switch (choice) {
		case 1:
			System.out.println("Enter Brand: ");
			String sBrand = sc.nextLine();
			System.out.println("Enter Price: ");
			double sPrice = Double.parseDouble(sc.nextLine());
			System.out.println("Enter Size: ");
			int sSize = Integer.parseInt(sc.nextLine());
			System.out.println("Enter Color: ");
			String sColor = sc.nextLine();
			System.out.println("Enter Type (half/full): ");
			String sType = sc.nextLine();
			return new Shirt(sBrand, sPrice, sSize, sColor, sType);
		case 2:
			System.out.println("Enter Brand: ");
			String mBrand = sc.nextLine();
			System.out.println("Enter Price: ");
			double mPrice = Double.parseDouble(sc.nextLine());
			System.out.println("Enter RAM Size: ");
			int mRam = Integer.parseInt(sc.nextLine());
			System.out.println("Enter Color: ");
			String mColor = sc.nextLine();
			System.out.println("Enter HD Size: ");
			int mHd = Integer.parseInt(sc.nextLine());
			return new Mobile(mBrand, mPrice, mRam, mColor, mHd);
		case 3:
			System.out.println("Enter Brand: ");
			String lBrand = sc.nextLine();
			System.out.println("Enter Price: ");
			double lPrice = Double.parseDouble(sc.nextLine());
			System.out.println("Enter RAM Size: ");
			int lRam = Integer.parseInt(sc.nextLine());
			System.out.println("Enter Color: ");
			String lColor = sc.nextLine();
			System.out.println("Enter HD Size: ");
			int lHd = Integer.parseInt(sc.nextLine());
			return new Laptop(lBrand, lPrice, lRam, lColor, lHd);
		default:
			System.out.println("Invalid Choice! Please select valid option");
			return getProduct();
		}
	}

	public boolean selectContinue() {
		System.out.println("Press Yes to Continue... ");
		String choice = sc.nextLine();
		return choice.equalsIgnoreCase("yes");
	}

	public void printAllProductDetails() {
		Set<String> p = new HashSet<>();
		for (String k : products.keySet()) {
			String n = products.get(k).getClass().getName();
			String name = n.substring(n.lastIndexOf('.') + 1);
			p.add(name);
		}
		System.out.println("All Products are: " + p);
		System.out.println("Total products are: " + p.size());
	}

	public void printAllProductCount() {
		Map<String, Integer> m = new HashMap<>();
		for (String k : products.keySet()) {
			String n = products.get(k).getClass().getName();
			String name = n.substring(n.lastIndexOf('.') + 1);
			int val = m.getOrDefault(name, 0);
			m.put(name, val + 1);
		}
		System.out.println("All Product counts: ");
		m.forEach((k, v) -> System.out.println(k + " product is: " + v));
	}

	public void countShirtBySize() {
		System.out.println("Enter Shirt Size to count: ");
		int size = Integer.parseInt(sc.nextLine());

		int count = 0;
		for (Product p : products.values()) {
			if (p instanceof Shirt) {
				Shirt s = (Shirt) p;
				if (s.getSize() == size)
					count++;
			}
		}
		System.out.println("Total Shirt Products of size " + size + " are: " + count);
	}
	public void listAllBrands() {
	    Set<String> brands = new HashSet<>();

	    for (Product p : products.values()) {
	        brands.add(p.getBrand());
	    }

	    for (String b : brands) {
	        System.out.println(b);
	    }
	    System.out.println("Total Brands: " + brands.size());
	}
	
	public void listAllShirtSizes() {
	    Set<Integer> sizes = new HashSet<>();

	    for (Product p : products.values())
	        if (p instanceof Shirt)
	            sizes.add(((Shirt) p).getSize());

	    System.out.println(sizes);
	}
	public void countShirtsByBrand() {
	    System.out.println("Enter Shirt Brand: ");
	    String brand = sc.nextLine();

	    int count = 0;
	    for (Product p : products.values())
	        if (p instanceof Shirt &&
	            p.getBrand().equalsIgnoreCase(brand))
	            count++;

	    System.out.println("Total shirts of brand " + brand + ": " + count);
	}
	public void countShirtsByColour() {
	    Map<String, Integer> colourCount = new HashMap<>();

	    for (Product p : products.values())
	        if (p instanceof Shirt) {
	            String colour = ((Shirt) p).getColor();
	            colourCount.put(colour, colourCount.getOrDefault(colour, 0) + 1);
	        }

	    colourCount.forEach((c, n) ->
	        System.out.println(c + " shirts: " + n));
	}
	public void countShirtsBySize() {
	    Map<Integer, Integer> sizeCount = new HashMap<>();

	    for (Product p : products.values())
	        if (p instanceof Shirt) {
	            int size = ((Shirt) p).getSize();
	            sizeCount.put(size, sizeCount.getOrDefault(size, 0) + 1);
	        }

	    sizeCount.forEach((s, c) ->
	        System.out.println("Size " + s + " shirts: " + c));
	}
	//User Code
	public void accessAllShirts() {
	    for (Product p : products.values())
	        if (p instanceof Shirt)
	            System.out.println(p);
	}

	public void accessAllMobile() {
	    for (Product p : products.values())
	        if (p instanceof Mobile)
	            System.out.println(p);
	}
	public void accessAllTshirt() {
	    for (Product p : products.values())
	        if (p instanceof Tshirt)
	            System.out.println(p);
	}
	public void accessShirtsByBrandAndSize() {
	    for (Product p : products.values())
	        if (p instanceof Shirt) {
	            Shirt s = (Shirt) p;
	            if (s.getBrand().equalsIgnoreCase("Blackberry") && s.getSize() == 42)
	                System.out.println(s);
	        }
	}
	public void accessShirtsBySizeAndPrice() {
	    for (Product p : products.values())
	        if (p instanceof Shirt) {
	            Shirt s = (Shirt) p;
	            if (s.getSize() == 42 && s.getPrice()>2000)
	                System.out.println(s);
	        }
	}
	public void sortShirtsByPriceLowToHigh() {

	    List<Shirt> list = new ArrayList<>();

	    for (Product p : products.values()) {
	        if (p instanceof Shirt) 
	            list.add((Shirt) p);
	        }
	    
	    Collections.sort(list, (s1, s2) ->
	            Double.compare(s1.getPrice(), s2.getPrice()));

	    for (Shirt s : list) {
	        System.out.println(s);
	    }
	}

	public void sortShirtsByPriceHighToLow() {

	    List<Shirt> list = new ArrayList<>();

	    for (Product p : products.values()) {
	        if (p instanceof Shirt) 
	            list.add((Shirt) p);
	        }
	    
	    Collections.sort(list, (s1, s2) ->
	            Double.compare(s2.getPrice(), s1.getPrice()));

	    for (Shirt s : list) {
	        System.out.println(s);
	    }
	}
	public void sortMobileByPriceLowToHigh() {

	    List<Mobile> list = new ArrayList<>();

	    for (Product p : products.values()) {
	        if (p instanceof Mobile) 
	            list.add((Mobile) p);
	        }
	    
	    Collections.sort(list, (s1, s2) ->
	            Double.compare(s1.getPrice(), s2.getPrice()));

	    for (Mobile m : list) {
	        System.out.println(m);
	    }
	}
	public void sortMobileByPriceHighToLow() {

	    List<Mobile> list = new ArrayList<>();

	    for (Product p : products.values()) {
	        if (p instanceof Mobile) 
	            list.add((Mobile) p);
	        }
	    
	    Collections.sort(list, (s1, s2) ->
	            Double.compare(s2.getPrice(), s1.getPrice()));

	    for (Mobile m : list) {
	        System.out.println(m);
	    }
	}
}
