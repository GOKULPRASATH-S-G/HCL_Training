package library;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Manages a FIFO (First-In, First-Out) waitlist for library books
 * using the Java Collections Queue interface backed by a LinkedList.
 */
public class LibraryWaitlist {

    private final String bookTitle;
    private final Queue<String> waitlist;
    private final int capacity;

    public static final int DEFAULT_MAX_CAPACITY = 100;

    /**
     * Default constructor for a general library resource waitlist.
     */
    public LibraryWaitlist() {
        this("General Collection", DEFAULT_MAX_CAPACITY);
    }

    /**
     * Constructs a waitlist for a specific book with default capacity.
     *
     * @param bookTitle Title of the book
     */
    public LibraryWaitlist(String bookTitle) {
        this(bookTitle, DEFAULT_MAX_CAPACITY);
    }

    /**
     * Constructs a waitlist for a specific book with a maximum capacity limit.
     *
     * @param bookTitle Title of the book
     * @param capacity  Maximum number of patrons allowed in the waitlist
     */
    public LibraryWaitlist(String bookTitle, int capacity) {
        if (bookTitle == null || bookTitle.trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be null or empty.");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("Waitlist capacity must be greater than zero.");
        }
        this.bookTitle = bookTitle.trim();
        this.capacity = capacity;
        this.waitlist = new LinkedList<>();
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getWaitlistSize() {
        return waitlist.size();
    }

    public boolean isEmpty() {
        return waitlist.isEmpty();
    }

    public boolean isFull() {
        return waitlist.size() >= capacity;
    }

    /**
     * Adds a patron to the end of the waitlist (FIFO enqueue).
     *
     * @param patronName Name of the patron requesting the book
     * @return true if successfully added, false otherwise
     */
    public boolean addToWaitlist(String patronName) {
        if (patronName == null || patronName.trim().isEmpty()) {
            System.out.println("[FAILED] Patron name cannot be null or blank.");
            return false;
        }

        String formattedName = patronName.trim();

        if (waitlist.contains(formattedName)) {
            System.out.println("[WARNING] '" + formattedName + "' is already in the waitlist for '" + bookTitle + "'.");
            return false;
        }

        if (isFull()) {
            System.out.println("[WARNING] Waitlist for '" + bookTitle + "' is full (Capacity: " + capacity + "). Cannot add " + formattedName + ".");
            return false;
        }

        boolean added = waitlist.offer(formattedName);
        if (added) {
            System.out.println("[SUCCESS] Added '" + formattedName + "' to waitlist for '" + bookTitle + "' at position #" + waitlist.size() + ".");
        }
        return added;
    }

    /**
     * Retrieves and removes the next patron at the front of the queue (FIFO dequeue).
     *
     * @return The patron name served, or null if the waitlist is empty
     */
    public String serveNextPatron() {
        if (waitlist.isEmpty()) {
            System.out.println("[INFO] Waitlist for '" + bookTitle + "' is empty. No patrons to serve.");
            return null;
        }

        String servedPatron = waitlist.poll();
        System.out.println("[SERVED] Book '" + bookTitle + "' allocated to: " + servedPatron);
        return servedPatron;
    }

    /**
     * Peeks at the next patron in line without removing them from the queue.
     *
     * @return The name of the next patron, or null if empty
     */
    public String peekNextPatron() {
        if (waitlist.isEmpty()) {
            System.out.println("[INFO] Waitlist for '" + bookTitle + "' is currently empty.");
            return null;
        }

        String nextPatron = waitlist.peek();
        System.out.println("[NEXT] Next in line for '" + bookTitle + "': " + nextPatron);
        return nextPatron;
    }

    /**
     * Cancels a reservation by removing a patron from the waitlist.
     *
     * @param patronName Name of the patron wishing to cancel
     * @return true if found and removed, false otherwise
     */
    public boolean cancelReservation(String patronName) {
        if (patronName == null || patronName.trim().isEmpty()) {
            System.out.println("[FAILED] Invalid patron name provided for cancellation.");
            return false;
        }

        String formattedName = patronName.trim();
        boolean removed = waitlist.remove(formattedName);
        if (removed) {
            System.out.println("[CANCELLED] Removed reservation for: " + formattedName);
        } else {
            System.out.println("[WARNING] Patron '" + formattedName + "' was not found in the waitlist for '" + bookTitle + "'.");
        }
        return removed;
    }

    /**
     * Returns the 1-based position of a patron in the queue, or -1 if not present.
     *
     * @param patronName Name of the patron
     * @return Position (1 to N), or -1 if not found
     */
    public int getPosition(String patronName) {
        if (patronName == null) {
            return -1;
        }

        int position = 1;
        for (String patron : waitlist) {
            if (patron.equalsIgnoreCase(patronName.trim())) {
                return position;
            }
            position++;
        }
        return -1;
    }

    /**
     * Checks if a patron is present in the waitlist.
     *
     * @param patronName Name of the patron
     * @return true if present, false otherwise
     */
    public boolean contains(String patronName) {
        if (patronName == null) {
            return false;
        }
        return waitlist.contains(patronName.trim());
    }

    /**
     * Returns an unmodifiable view of current waitlist elements in FIFO order.
     *
     * @return Unmodifiable List of patron names
     */
    public List<String> getWaitlistSnapshot() {
        return Collections.unmodifiableList(new LinkedList<>(waitlist));
    }

    /**
     * Clears all patrons from the waitlist.
     */
    public void clearWaitlist() {
        waitlist.clear();
        System.out.println("[CLEARED] Waitlist for '" + bookTitle + "' has been cleared.");
    }

    /**
     * Displays all patrons currently waiting in order.
     */
    public void displayWaitlist() {
        System.out.println("\n--------------------------------------------------");
        System.out.println("Waitlist for: \"" + bookTitle + "\"");
        System.out.println("Total Waiting: " + waitlist.size() + " / Capacity: " + capacity);
        System.out.println("--------------------------------------------------");

        if (waitlist.isEmpty()) {
            System.out.println("   (No patrons waiting)");
        } else {
            int pos = 1;
            for (String patron : waitlist) {
                System.out.printf("   %2d. %s%n", pos++, patron);
            }
        }
        System.out.println("--------------------------------------------------\n");
    }

    /**
     * Demonstrates the functionality of the LibraryWaitlist queue operations.
     */
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   HCL Training - Day 7: Library Waitlist Demo");
        System.out.println("==================================================\n");

        // 1. Initialize waitlist with capacity limit of 3 for testing
        LibraryWaitlist waitlist = new LibraryWaitlist("Effective Java (3rd Edition)", 3);

        // 2. Add patrons (FIFO Enqueue)
        System.out.println(">>> 1. Adding patrons to waitlist (offer):");
        waitlist.addToWaitlist("Alice Johnson");
        waitlist.addToWaitlist("Bob Smith");

        // 3. Testing duplicate prevention
        System.out.println("\n>>> 2. Testing duplicate prevention:");
        waitlist.addToWaitlist("Alice Johnson");

        // 4. Fill up to capacity
        System.out.println("\n>>> 3. Adding third patron to reach capacity:");
        waitlist.addToWaitlist("Charlie Brown");

        // 5. Attempting to add beyond capacity
        System.out.println("\n>>> 4. Testing capacity limit:");
        waitlist.addToWaitlist("David Miller");

        // 6. Display current waitlist
        waitlist.displayWaitlist();

        // 7. Peek next patron (without removing)
        System.out.println(">>> 5. Inspecting next patron (peek):");
        waitlist.peekNextPatron();

        // 8. Check position of a patron
        System.out.println("\n>>> 6. Tracking queue position:");
        String searchPatron = "Bob Smith";
        int pos = waitlist.getPosition(searchPatron);
        System.out.println("Position of '" + searchPatron + "': " + (pos != -1 ? "#" + pos : "Not found"));

        // 9. Serve next patron when book is returned (FIFO Dequeue)
        System.out.println("\n>>> 7. Serving patrons as books become available (poll):");
        waitlist.serveNextPatron();
        waitlist.displayWaitlist();

        // 10. Cancellation: Charlie decides to cancel his reservation
        System.out.println(">>> 8. Cancelling a reservation mid-queue:");
        waitlist.cancelReservation("Charlie Brown");
        waitlist.displayWaitlist();

        // 11. Now that a slot is free, add a new patron
        System.out.println(">>> 9. Adding new patron into newly available slot:");
        waitlist.addToWaitlist("David Miller");
        waitlist.displayWaitlist();

        // 12. Emptying out the queue
        System.out.println(">>> 10. Serving remaining patrons until empty:");
        while (!waitlist.isEmpty()) {
            waitlist.serveNextPatron();
        }

        // 13. Polling from empty queue
        System.out.println("\n>>> 11. Attempting to serve from empty queue:");
        waitlist.serveNextPatron();

        System.out.println("\n==================================================");
        System.out.println("   Library Waitlist Demo Completed Successfully!");
        System.out.println("==================================================");
    }
}
