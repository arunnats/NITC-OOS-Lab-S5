import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Inventory<Product> inventory = new Inventory<>();

        Electronics laptop = new Electronics("Laptop", 24);
        Clothing shirt = new Clothing("Shirt", "M");

        inventory.addProduct(laptop);
        inventory.addProduct(shirt);

        inventory.listProducts();

        inventory.removeProduct(laptop);

        inventory.listProducts();
    }
}

class Inventory<T extends Product> {
    private List<T> products = new ArrayList<>();

    public void addProduct(T product) {
        products.add(product);
    }

    public void removeProduct(T product) {
        products.remove(product);
    }

    public void listProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (T product : products) {
                System.out.println(product);
            }
        }
    }
}

class Product {
  private String name;

  public Product(String name) {
      this.name = name;
  }

  public String getName() {
      return name;
  }

  @Override
  public String toString() {
      return "Product: " + name;
  }
}

class Electronics extends Product {
    private int warrantyPeriod;

    public Electronics(String name, int warrantyPeriod) {
        super(name);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    @Override
    public String toString() {
        return "Electronics: " + getName() + ", Warranty Period: " + warrantyPeriod + " months";
    }
}

class Clothing extends Product {
    private String size;

    public Clothing(String name, String size) {
        super(name);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Clothing: " + getName() + ", Size: " + size;
    }
}
