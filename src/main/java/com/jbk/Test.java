package com.jbk;

import java.util.List;
import java.util.Scanner;

import com.jbk.entity.Product;
import com.jbk.operation.Operation;
import com.jbk.utility.UserData;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Operation operation = new Operation();
		int choice;
		boolean wantToContinue = true;

		do {
			System.out.println("Press 1 for Add Product");
			System.out.println("Press 2 for Delete Product by ID");
			System.out.println("Press 3 for Get Product by ID");
			System.out.println("Press 4 for Update Product");
			System.out.println("Press 5  for get All Product");
			System.out.println("Press 6 for get All Product by order");
			System.out.println("Press 7 for get Limited Product");
			System.out.println("Press 8 for get Limited Product by order");
			System.out.println("Press 9 for get  Product by name");
			System.out.println("Press 10  Product Whose Price Is Greater than");
			System.out.println("Press 11 to get Product Count");
			System.out.println("Press 12 to get minimum Product Price");
			System.out.println("Press 13 to get maximum Product Price");

			System.out.println("Press 14 to Querry Ex1");
			System.out.println("Press 15 to Querry Ex2");
			System.out.println("Press 16 to Querry Ex3");
			System.out.println("Press 17 to get Product inbetween");
			System.out.println("Press 18 to get Product by NamePattern");
			System.out.println("Press 0 for Exit ");

			choice = sc.nextInt();

			switch (choice) {

			case 0: {
				wantToContinue = false;
				break;
			}
			case 1: {
				Product product = UserData.getProductInfoFromUser();
				String msg = operation.addProduct(product);
				System.out.println(msg);

				break;
			}
			case 2: {
				System.out.println("Enter Product Id");
				int productId = sc.nextInt();
				String msg = operation.deleteProduct(productId);
				System.out.println(msg);

				break;
			}
			case 3: {
				System.out.println("Enter Product Id");
				int productId = sc.nextInt();
				Object obj = operation.getProductById(productId);
				System.out.println(obj);
				break;
			}
			case 4: {
				System.out.println("Enter product Id");
				int id = sc.nextInt();
				Product product = UserData.getProductInfoFromUser();
				product.setProductId(id);
				String msg = operation.updateProduct(product);
				System.out.println(msg);
				break;
			}
			case 5: {
				List<Product> allProducts = operation.getAllProducts();
				if (!allProducts.isEmpty()) {
					for (Product product : allProducts) {
						System.out.println(product);
					}
				} else {
					System.out.println("No Record Found");
				}
				break;
			}
			case 6: {
				List<Product> allProducts = operation.getAllProductsByOrder();
				if (!allProducts.isEmpty()) {
					for (Product product : allProducts) {
						System.out.println(product);
					}
				} else {
					System.out.println("No Record Found");
				}
				break;
			}
			case 7: {
				List<Product> allProducts = operation.getLimitedProduct();
				if (!allProducts.isEmpty()) {
					for (Product product : allProducts) {
						System.out.println(product);
					}
				} else {
					System.out.println("No Record Found");
				}
				break;
			}
			case 8: {
				List<Product> allProducts = operation.getLimitedProductByOrder();
				if (!allProducts.isEmpty()) {
					for (Product product : allProducts) {
						System.out.println(product);
					}
				} else {
					System.out.println("No Record Found");
				}
				break;
			}
			case 9: {
				System.out.print("Enter Product Name:");
				String name = sc.next();
				List<Product> allProducts = operation.getProductByName(name);
				if (!allProducts.isEmpty()) {
					for (Product product : allProducts) {
						System.out.println(product);
					}
				} else {
					System.out.println("No Record Found");
				}
				break;
			}
			case 10: {
				System.out.print("Enter Product Price:");
				double price = sc.nextDouble();
				List<Product> allProducts = operation.getProductWhosePriceIsGreaterThan(price);
				if (!allProducts.isEmpty()) {
					for (Product product : allProducts) {
						System.out.println(product);
					}
				} else {
					System.out.println("No Record Found");
				}
				break;
			}

			case 11: {
				long Count = operation.getproductCount();
				System.out.println(Count);
				break;
			}
			case 12: {
				double Count = operation.getMinPriceOfProduct();
				System.out.println(Count);
				break;
			}
			case 13: {
				double Count = operation.getMaxPriceOfProduct();
				System.out.println(Count);
				break;
			}
			case 14: {
				List<Product> list = operation.queryEx1();
				if (!list.isEmpty()) {
					for (Product product : list) {
						System.out.println(product);
					}
				} else {
					System.out.println("No Record Found");
				}
				break;
			}
			case 15: {
				List<Object[]> list = operation.queryEx2();
				if (!list.isEmpty()) {
					for (Object[] obj : list) {
						System.out.print(obj[0]);
						System.out.print(obj[1]);
						System.out.println(obj[2]);
					}
				} else {
					System.out.println("No Record Found");
				}
				break;
			}
			case 16: {
				List<Product> list = operation.queryEx3();
				if (!list.isEmpty()) {
					for (Object obj : list) {
						System.out.println(obj);
					}
				} else {
					System.out.println("No Record Found");
				}
				break;
			}
			case 17: {
				List<Product> list = operation.getproductInBetween();
				if (!list.isEmpty()) {
					for (Object obj : list) {
						System.out.println(obj);
					}
				} else {
					System.out.println("No Record Found");
				}
				break;
			}
			
			case 18: {
				System.out.println("Enter NamePattern");
				String Pattern = sc.next();
				List<Product> list = operation.getProductsByNamePattern(Pattern);
				if (!list.isEmpty()) {
					for (Object obj : list) {
						System.out.println(obj);
					}
				} else {
					System.out.println("No Record Found");
				}
				break;
			}

			default: {
				System.out.println("invalid choice");
				break;
			}
			}
		} while (wantToContinue);
		{
			System.out.println("App Terminated");
		}
	}

}