


public class Main {



    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();
        toyShop.addToy(1, "Медведь", 20);
        toyShop.addToy(2, "Кошка", 40);
        toyShop.addToy(3, "Собака", 30);
        toyShop.addToy(5,"Машинка",100);
        toyShop.addToy(6, "Робот", 30);
        toyShop.addToy(7,"Кукла",100);
        toyShop.addToy(8, "Мяч", 30);
        toyShop.addToy(9,"шарик",100);




        toyShop.play();


        System.out.println("Количество игрушек учавствующих в розыгрыше: " + toyShop.prizes.size());
        System.out.println("Осталось игрушек:");
        for (Toy toy : toyShop.toys) {
            System.out.println(toy.getName() + " - " + toy.getWeight() + "%");
        }
    }


}
