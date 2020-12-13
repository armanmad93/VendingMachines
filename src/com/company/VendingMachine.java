package com.company;

import com.company.Models.Chips.Doritos;
import com.company.Models.Chips.Lays;
import com.company.Models.Chips.Pringels;
import com.company.Models.Drinks.CocaCola;
import com.company.Models.Drinks.Fanta;
import com.company.Models.Drinks.Sprite;
import com.company.Models.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VendingMachine {

    private HashMap<String, ArrayList<ArrayList<Product>>> board;

    public List<Product> getProducts(Command command) {
        board = new HashMap<>();
        initilazeBoard(board);

        if (command.getRow().equals("A")) {

            return getProductFromBoard(board.get("A"), command.getCount(), command.getColumn());

        } else if (command.getRow().equals("B")) {

            return getProductFromBoard(board.get("B"), command.getCount(), command.getColumn());

        }
        return null;
    }

    private List<Product> getProductFromBoard(ArrayList<ArrayList<Product>> board, int count, int column) {

        if (column <= board.size()) {
            if (board.get(column - 1).size() >= count) {
                System.out.println("VendingMachine balance: " +  + (board.get(column - 1).size() - count));
                return board.get(column - 1).subList(0, count);
            }
        }

        return null;
    }

    private void initilazeBoard(HashMap<String, ArrayList<ArrayList<Product>>> board) {
        ArrayList<ArrayList<Product>> allChips = initializeChips();
        ArrayList<ArrayList<Product>> allDrinks = initializeDrinks();

        board.put("A", allChips);
        board.put("B", allDrinks);

    }

    private ArrayList<ArrayList<Product>> initializeDrinks() {
        ArrayList<Product> cocaCola = new ArrayList<>();
        ArrayList<Product> fanta = new ArrayList<>();
        ArrayList<Product> sprite = new ArrayList<>();

        ArrayList<ArrayList<Product>> allProductsInRow = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            cocaCola.add(new CocaCola());
            fanta.add(new Fanta());
            sprite.add(new Sprite());
        }

        allProductsInRow.add(0, cocaCola);
        allProductsInRow.add(1, fanta);
        allProductsInRow.add(2, sprite);

        return allProductsInRow;

    }

    private ArrayList<ArrayList<Product>> initializeChips() {
        ArrayList<Product> layses = new ArrayList<>();
        ArrayList<Product> doritos = new ArrayList<>();
        ArrayList<Product> pringales = new ArrayList<>();

        ArrayList<ArrayList<Product>> allProductsInRow = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            layses.add(new Lays());
            doritos.add((new Doritos()));
            pringales.add(new Pringels());
        }

        allProductsInRow.add(0, layses);
        allProductsInRow.add(1, doritos);
        allProductsInRow.add(2, pringales);

        return allProductsInRow;
    }

    public HashMap<String, ArrayList<ArrayList<Product>>> getBoard() {
        return board;
    }

    public void setBoard(HashMap<String, ArrayList<ArrayList<Product>>> board) {
        this.board = board;
    }
}
