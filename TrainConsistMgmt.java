import java.util.*;

public class TrainConsistMgmt {
    public static void main(String[] args) {

        System.out.println("\n================================");
        System.out.println("UC12 Safety Compliance Check for Goods Bogies");
        System.out.println("================================");

        class GoodsBogie {
            String type;
            String cargo;

            GoodsBogie(String type, String cargo) {
                this.type = type;
                this.cargo = cargo;
            }

            void display() {
                System.out.println(type + " -> " + cargo);
            }
        }

        List<GoodsBogie> goodsList = new ArrayList<>();

        goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsList.add(new GoodsBogie("Open", "Coal"));
        goodsList.add(new GoodsBogie("Box", "Grain"));
        goodsList.add(new GoodsBogie("Cylindrical", "Coal")); 

        System.out.println("Goods Bogies in Train:");
        goodsList.forEach(b -> b.display());

        boolean isSafe = goodsList.stream().allMatch(b -> {
            if (b.type.equalsIgnoreCase("Cylindrical")) {
                return b.cargo.equalsIgnoreCase("Petroleum");
            }
            return true;
        });

        System.out.println("Safety Compliance Status: " + isSafe);

        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("UC12 safety validation completed....");
    }
}
