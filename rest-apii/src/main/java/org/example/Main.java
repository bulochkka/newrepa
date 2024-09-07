package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        apiClient.getAllUsers();
        User newUser = new User(3L, "James", "Brown", (byte) 25);
        apiClient.addUser(newUser);
        newUser.setName("Thomas");
        newUser.setLastName("Shelby");
        apiClient.updateUser(newUser);
        apiClient.deleteUser(3L);
    }
}