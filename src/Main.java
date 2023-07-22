public class Main {
    public static void main(String[] args) {
        FileHandler.clear("Lottery.txt");

        Store store = new Store();
        Toy toy = new Toy(1L, "Машинка", 50, 60);
        Toy toy2 = new Toy(2L, "Кукла", 100, 40);
        Toy toy3 = new Toy(3L, "Робот", 10, 25);
        Toy toy4 = new Toy(4L, "Крутое Лего", 3, 10);
        Toy toy5 = new Toy(5L, "SUBOTECH BG1513B, 4WD", 1, 5);

        store.addToy(toy);
        store.addToy(toy2);
        store.addToy(toy3);
        store.addToy(toy4);
        store.addToy(toy5);

        //Определение разыгрываемых игрушек
        for (int i = 0; i < 100; i++) {
            store.choiceLotteryToy();
        }

        //Розыгрыш
        for (int i = 0; i < 30; i++) {
            store.getLotteryToy();
        }

        store.printState();
    }
}