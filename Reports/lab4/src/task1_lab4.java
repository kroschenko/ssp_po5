import java.util.ArrayList;
import java.util.List;

public class task1_lab4 {

    public static void main(String[] args) {
        Payment payment = new Payment();
        Payment.Product productFirst = payment.new Product("Семена", 123);
        Payment.Product productSecond = payment.new Product("Соль", 1);
        Payment.Product productThird = payment.new Product("Макароны", 25);
        Payment.Product productForth = payment.new Product("Водка", 6);
        Payment.Product productFifth = payment.new Product("Влад", 3);

        payment.buyProduct(productFirst);
        payment.buyProduct(productSecond);
        payment.buyProduct(productThird);
        payment.buyProduct(productForth);
        payment.buyProduct(productFifth);

        System.out.println(payment.sum());
    }
}

class Payment {
    private List<Product> productList;
    public Payment() {
        productList = new ArrayList<>();
    }
    public Product buyProduct(Product product){
        productList.add(product);
        return product;
    }
    public int sum(){
        return productList.stream().mapToInt(Product::getPrice).sum();
    }
    public class Product {
        private String name;
        private Integer price;
        public Integer getPrice() {
            return price;
        }
        public Product(String name, Integer price) {
            this.name = name;
            this.price = price;        }
        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}