package com.jbk.utility;

import java.util.Scanner;

import com.jbk.entity.Product;

public class UserData {

	public static Product getProductInfoFromUser() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Product Name: ");
		String productName = sc.nextLine();
		
		System.out.print("Enter Product Qty: ");
		int productQty = sc.nextInt();
		
		System.out.print("Enter Product Price: ");
		double productPrice = sc.nextDouble();
		
		System.out.print("Enter Product MfgDate: ");
		String productMfgDate = sc.next();
		
		System.out.print("Enter Product ExpDate: ");
		String productExpDate = sc.next();
		
		Product product = new Product(productName, productQty, productPrice, productMfgDate, productExpDate);
		return product;

	}
}
