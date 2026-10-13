import java.util.Scanner;
class Product {
    private String productName;
    private double startingPrice;
    private double currentHighestBid;
    private String highestBidder;
    Product(String productName, double startingPrice) {
        this.productName = productName.trim().toUpperCase();
        this.startingPrice = startingPrice;
        this.currentHighestBid = startingPrice;
        this.highestBidder = "No bids yet";
    }
    String getProductName() {
        return productName;
    }
    double getStartingPrice() {
        return startingPrice;
    }
    double getCurrentHighestBid() {
        return currentHighestBid;
    }
    String getHighestBidder() {
        return highestBidder;
    }
    void updateHighestBid(String bidderName, double amount) {
        this.highestBidder = bidderName;
        this.currentHighestBid = amount;
    }
}
class Bidder {
    private String name;
    private String email;
    private String phone;
    Bidder(String name) {
        this.name = name.trim().toUpperCase();
        this.email = "Not provided";
        this.phone = "Not provided";
    }
    Bidder(String name, String email, String phone) {
        this.name = name.trim().toUpperCase();
        this.email = email.trim();
        this.phone = phone.trim();
    }
    String getName() {
        return name;
    }
    String getEmail() {
        return email;
    }
    String getPhone() {
        return phone;
    }
}
class Auction {
    private Product product;
    private boolean hasWinner;
    Auction(Product product) {
        this.product = product;
        this.hasWinner = false;
    }
    private String formatMoney(double amount) {
        long totalPaise = Math.round(amount * 100);
        long rupees = totalPaise / 100;
        long paise = totalPaise % 100;
        String paiseText = paise < 10 ? "0" + paise : String.valueOf(paise);
        return "Rs. " + rupees + "." + paiseText;
    }
    void displayHeader() {
        System.out.println();
        System.out.println("========== ONLINE AUCTION PLATFORM ==========");
        System.out.println();
        System.out.println("Product Name       : " + product.getProductName());
        System.out.println("Starting Price     : " + formatMoney(product.getStartingPrice()));
        System.out.println();
    }
    void placeBid(String bidderName, double amount) {
        placeBid(new Bidder(bidderName), amount);
    }
    void placeBid(String bidderName, String email, String phone, double amount) {
        placeBid(new Bidder(bidderName, email, phone), amount);
    }
    private void placeBid(Bidder bidder, double amount) {
        String status;
        if (amount > product.getCurrentHighestBid()) {
            product.updateHighestBid(bidder.getName(), amount);
            hasWinner = true;
            status = "Bid Accepted";
        } else {
            status = "Bid Rejected - Bid Must Be Higher";
        }
        System.out.println();
        System.out.println("Bidder Name        : " + bidder.getName());
        if (!bidder.getEmail().equals("Not provided")) {
            System.out.println("Email              : " + bidder.getEmail());
            System.out.println("Phone              : " + bidder.getPhone());
        }
        System.out.println("Bid Amount         : " + formatMoney(amount));
        System.out.println("Bid Status         : " + status);
        System.out.println();
    }
    void closeAuction() {
        System.out.println("---------- AUCTION SUMMARY ----------");
        System.out.println("Product Name       : " + product.getProductName());
        if (hasWinner) {
            System.out.println("Winning Bidder     : " + product.getHighestBidder());
            System.out.println("Final Bid Amount   : " + formatMoney(product.getCurrentHighestBid()));
        } else {
            System.out.println("No valid bids were placed. Auction closed without a winner.");
        }
        System.out.println("==============================================");
    }
}
public class AuctionPlatform {
    private static Scanner scanner = new Scanner(System.in);
    private static double readAmount(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value > 0) {
                    return value;
                }
                System.out.println("Amount must be greater than zero. Try again.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    private static boolean askYesNo(String message) {
        while (true) {
            System.out.print(message + " (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (answer.equals("yes") || answer.equals("y")) {
                return true;
            }
            if (answer.equals("no") || answer.equals("n")) {
                return false;
            }
            System.out.println("Please type yes or no.");
        }
    }
    public static void main(String[] args) {
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        double startingPrice = readAmount("Enter starting price (Rs.): ");

        Product product = new Product(productName, startingPrice);
        Auction auction = new Auction(product);
        auction.displayHeader();
        while (askYesNo("Do you want to place a bid?")) {
            System.out.print("Enter bidder name: ");
            String bidderName = scanner.nextLine();
            boolean withDetails = askYesNo("Do you want to provide contact details?");
            String email = "";
            String phone = "";
            if (withDetails) {
                System.out.print("Enter email: ");
                email = scanner.nextLine();
                System.out.print("Enter phone: ");
                phone = scanner.nextLine();
            }
            double amount = readAmount("Enter bid amount (Rs.): ");
            if (withDetails) {
                auction.placeBid(bidderName, email, phone, amount);
            } else {
                auction.placeBid(bidderName, amount);
            }
        }
        auction.closeAuction();
        scanner.close();
    }
}