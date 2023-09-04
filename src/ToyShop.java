import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyShop {
    List<Toy> toys;
    public List<Toy> prizes;

    public ToyShop() {
        toys = new ArrayList<>();
        prizes = new ArrayList<>();
    }

    public void addToy(int id, String name, double weight) {
        Toy toy = new Toy(id, name, weight);
        toys.add(toy);
    }

    public void changeWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public void play() {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        Random random = new Random();
        double randomNumber = random.nextDouble() * totalWeight;

        double currentWeight = 0;
        Toy prize = null;
        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (randomNumber <= currentWeight) {
                prize = toy;
                break;
            }
        }

        if (prize != null) {
            prizes.add(prize);
            toys.remove(prize);
            writeToFile(prize);
        }
    }

    public void writeToFile(Toy toy) {
        try {
            FileWriter writer = new FileWriter("prizes.txt", true);
            writer.write(toy.getId() + "," + toy.getName() + "\n");
            writer.close();
            toy.setWeight(toy.getWeight() - 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
