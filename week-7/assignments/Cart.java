/**
 * Student Name: Rehaan Ajani
 * Registration Number: RA2511026010673
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AK1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 7 - S7 - OOP Fundamental - Assignment Practice Problem (HW)
 * Category C - Problem 5: The Shopping Cart
 */
public class Cart {

    private final String cartId;
    private final int[] itemPrices;
    private int itemCount;

    /**
     * Constructs Cart with fixed ID and maximum items capacity.
     *
     * @param cartId   Fixed identifier for the cart
     * @param maxItems Maximum number of items the cart can store
     */
    public Cart(String cartId, int maxItems) {
        if (cartId == null || cartId.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Cart ID cannot be null or empty.");
        }
        if (maxItems <= 0) {
            throw new IllegalArgumentException("Error: Max items must be greater than 0.");
        }
        this.cartId = cartId;
        this.itemPrices = new int[maxItems];
        this.itemCount = 0;
    }

    public String getCartId() {
        return cartId;
    }

    /**
     * Adds an item price to the cart.
     *
     * @param price Price of item
     */
    public void addItem(int price) {
        if (price < 0) {
            System.out.println("Invalid price: Cannot add negative price.");
            return;
        }
        if (itemCount >= itemPrices.length) {
            System.out.println("Cart is full. Cannot add item with price " + price + ".");
            return;
        }
        itemPrices[itemCount] = price;
        itemCount++;
    }

    /**
     * Read-only total computed dynamically on request by summing internal prices.
     *
     * @return Sum of all item prices in cart
     */
    public int getTotal() {
        int total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += itemPrices[i];
        }
        return total;
    }

    /**
     * Read-only count of items added.
     *
     * @return Number of items in cart
     */
    public int getItemCount() {
        return itemCount;
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 5: The Shopping Cart ---");

        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Added Prices: 250, 99, 151");
        System.out.println("cart.getTotal()     -> " + cart.getTotal());
        System.out.println("cart.getItemCount() -> " + cart.getItemCount());
    }
}