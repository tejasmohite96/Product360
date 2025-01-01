# Product Management System

This repository contains a comprehensive project for managing products in a database. The project provides a set of features to perform CRUD (Create, Read, Update, Delete) operations along with advanced querying functionalities. Built using Hibernate and MySQL, the system ensures robust handling of database operations and user-friendly responses.


## Features

### 1. Add Product to Database  
Allows users to add new products by providing details like Product ID, Name, Quantity, Price, Manufacturing Date, and Expiry Date.  
- **Success Criteria**:  
  - Success: "Added Successfully"  
  - Failure: "Product already exists" or "Something went wrong"

---

### 2. Delete Product from Database  
Enables deletion of a product by its unique Product ID.  
- **Success Criteria**:  
  - Success: "Deleted Successfully"  
  - Failure: "Product Not exists for delete" or "Something went wrong"

---

### 3. Retrieve Specific Product by ID  
Fetches details of a specific product based on the Product ID.  
- **Success Criteria**:  
  - Success: Returns product details  
  - Failure: "Resource not exist" or "Something went wrong"

---

### 4. Update Specific Product  
Updates the information of an existing product based on provided details.  
- **Success Criteria**:  
  - Success: "Updated Successfully"  
  - Failure: "Product Not exists to update" or "Something went wrong"

---

### 5. Retrieve All Products  
Fetches details of all products in the database.  
- **Success Criteria**:  
  - Success: Returns a list of all products  
  - Failure: "No products found" or "Something went wrong"

---

### 6. Retrieve Products in Ascending Order by Parameter  
Fetches all products sorted in ascending order based on a specified parameter (e.g., Price, Name).  
- **Success Criteria**:  
  - Success: Returns a sorted list of products  
  - Failure: "Something went wrong"

---

### 7. Retrieve Product by Name  
Searches and retrieves a product based on its name.  
- **Success Criteria**:  
  - Success: Returns product details  
  - Failure: "Product not found"

---

### 8. Retrieve Products with Price Greater Than Specified Value  
Fetches products whose prices are greater than a user-specified amount.  
- **Success Criteria**:  
  - Success: Returns matching products  
  - Failure: "No products found" or "Something went wrong"

---

### 9. Retrieve Products by Name Pattern  
Searches for products matching a specified name pattern.  
- **Success Criteria**:  
  - Success: Returns matching products  
  - Failure: "No matching products found"

---

### 10. Retrieve Products Within Price Range  
Fetches products within a specified price range.  
- **Success Criteria**:  
  - Success: Returns matching products  
  - Failure: "No products found" or "Something went wrong"

---

### 11. Retrieve Maximum Product Price  
Fetches the highest price among all products.  
- **Success Criteria**:  
  - Success: Returns the maximum price  
  - Failure: "Something went wrong"

---

## Technologies Used  
- **Backend**: Hibernate (ORM Framework), Java  
- **Database**: MySQL  
- **Build Tool**: Maven  
