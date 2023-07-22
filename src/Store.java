import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Store {
    private HashMap<Long, Toy> toys = new HashMap<>();
    private ArrayList<Toy> lotteryToys = new ArrayList<>();

    public void addToy(Toy toy){
        if (isToyExist(toy)){
            System.out.println("Игрушка уже существует!");
            return;
        }

        long idToy = toy.getId();

        if (toys.containsKey(idToy)){
            System.out.println("Игрушка с таким идентификатором уже существует!");
            return;
        }

        toys.put(idToy, toy);
    }

    public void removeToy(long idToy){
        if (!toys.containsKey(idToy)){
            System.out.println("Игрушка с таким идентификатором не существует!");
            return;
        }

        toys.remove(idToy);
    }

    public void removeToy(Toy toy){
        long id = toy.getId();
        removeToy(id);
    }

    public Toy getToyById(long id){
        if (!toys.containsKey(id)){
            System.out.println("Игрушка с таким идентификатором не существует!");
            return null;
        }

        return toys.get(id);
    }

    /**Метод уменьшения количества игрушек
     * @param toy Игрушка
     * @param quantity Величина уменьшения
     * */
    private void reduceToy(Toy toy, int quantity){
        Toy reduceToy = toys.get(toy.getId());
        int lost = reduceToy.reduce(quantity);

        if (lost == 0) removeToy(reduceToy);
    }

    public  void choiceLotteryToy(){
        ArrayList<Toy> temp = new ArrayList<>();
        Random random = new Random();

        while (temp.size() == 0){
            for (Map.Entry<Long, Toy> entry : toys.entrySet()){
                Toy toy = entry.getValue();


                int randomValue = random.nextInt(0, 101);

                if (randomValue <= toy.getFrequency()){
                    Toy newToy = new Toy(toy.getId() , toy.getName(), 1, toy.getFrequency());
                    temp.add(newToy);
                }
            }
        }

        int randomIndex = random.nextInt(0, temp.size());
        Toy randomToy = temp.get(randomIndex);

        reduceToy(randomToy, 1);
        lotteryToys.add(randomToy);
    }

    public void getLotteryToy(){
        if (lotteryToys.isEmpty()) {
            System.out.println("Нечего разыгрывать");
            return;
        }

        Toy toy = lotteryToys.get(0);
        lotteryToys.remove(0);

        String description = toy.getId() + " " + toy.getName() + "\n";
        FileHandler.appendInFile("Lottery.txt", description);
    }

    private boolean isToyExist(Toy toy){
        String nameAddingToy = toy.getName();
        for (Map.Entry<Long, Toy> entry : toys.entrySet()){
            if (entry.getValue().getName().equals(nameAddingToy)){
                return true;
            }
        }
        return false;
    }

    public void printState(){
        System.out.println("========= СПИСОК ИГРУШЕК НА СКЛАДЕ =========");
        for (Map.Entry<Long, Toy> entry : toys.entrySet()){
            Toy toy = entry.getValue();
            System.out.println("ID: " + toy.getId() + "; Название: " + toy.getName() + "; Количество: " + toy.getQuantity());
        }

        System.out.println("========= СПИСОК ИГРУШЕК ДЛЯ РОЗЫГРЫША =========");
        for (Toy lotteryToy : lotteryToys) {
            System.out.println("ID: " + lotteryToy.getId() + "; Название: " + lotteryToy.getName());
        }
    }
}
