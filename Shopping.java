//jbvjkwvbkj 
import java.util.Scanner;

class ShoppingItem {
    String itemName;
    ShoppingItem prev;
    ShoppingItem next;

    public ShoppingItem(String itemName) {
        this.itemName = itemName;
        this.prev = null;
        this.next = null;
    }
}

class ShoppingList {
    ShoppingItem head;
    ShoppingItem tail;

    public ShoppingList() {
        head = null;
        tail = null;
    }

    public void addItem(String itemName) {
        ShoppingItem newItem = new ShoppingItem(itemName);
        if (head == null) {
            head = newItem;
            tail = newItem;
        } else {
            tail.next = newItem;
            newItem.prev = tail;
            tail = newItem;
        }
    }

    public void removeItem(String itemName) {
        ShoppingItem current = head;
        while (current != null) {
            if (current.itemName.equalsIgnoreCase(itemName)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    public void printList() {
        ShoppingItem current = head;
        int itemCount = 1;
        System.out.println("Daftar Belanja:");
        while (current != null) {
            System.out.println(itemCount + ". " + current.itemName);
            current = current.next;
            itemCount++;
        }
    }
}

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingList shoppingList = new ShoppingList();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Item");
            System.out.println("2. Hapus Item");
            System.out.println("3. Lihat Daftar Belanja");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Membuang karakter newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama item yang ingin ditambahkan: ");
                    String newItem = scanner.nextLine();
                    shoppingList.addItem(newItem);
                    System.out.println(newItem + " telah ditambahkan ke dalam daftar belanja.");
                    break;
                case 2:
                    System.out.print("Masukkan nama item yang ingin dihapus: ");
                    String itemToRemove = scanner.nextLine();
                    shoppingList.removeItem(itemToRemove);
                    System.out.println(itemToRemove + " telah dihapus dari daftar belanja.");
                    break;
                case 3:
                    shoppingList.printList();
                    break;
                case 4:
                    System.out.println("Terima kasih! Program selesai.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opsi tidak valid. Silakan pilih opsi yang benar.");
            }
        }
    }
}