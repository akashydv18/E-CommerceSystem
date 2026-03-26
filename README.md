# ECommerceProductManagementSystem

A **Core Java** based backend simulation project for an **E-commerce Product Management System**.  
This project uses **HashMap (ProductId → Product)** and **Java Collections Framework** to efficiently manage products like **Mobiles**, **Shirts**, and **TShirts** with separate **Admin Access** and **User Access** functionalities.

It demonstrates real-world backend logic such as:
- Product management
- Filtering
- Counting
- Grouping
- Sorting
- Brand/size/color-based access

---

## 🚀 Features

### 🔐 Admin Access
- Create and manage `Map<ProductId, Product>`
- Add new products
- Remove products by Product ID
- Count all mobile products
- Count all shirt products
- Count shirts of a particular size
- Print and count all available product types
- Count each type of product
- List all available brands
- List all available shirt sizes
- List all different product categories
- Count shirts of a particular brand
- Count shirts available in each brand
- Count shirts available in each size
- Count shirts available in each colour

### 👤 User Access
- Access all products
- Access all shirt products using `instanceof`
- Access all mobile products
- Access all TShirt products
- Access shirts of a specific brand and size
- Access shirts by size and price condition
- Sort shirts by price (Low → High)
- Sort shirts by price (High → Low)
- Sort mobiles by price (Low → High)
- Sort mobiles by price (High → Low)

---

## Tech Stack

- **Java**
- **Core Java**
- **Collections Framework**
- **HashMap**
- **ArrayList**
- **Comparator**
- **instanceof**
- **OOP Concepts**
- **Data Structures**

---

##  Project Structure

```bash
ECommerceProductManagementSystem/
│
├── Product.java
├── Mobile.java
├── Shirt.java
├── TShirt.java
├── ProductService.java
├── Main.java
└── README.md
