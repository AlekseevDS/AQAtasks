package animals;

public class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void changeBowlAmount(int changeQuantity) {
        this.foodAmount += changeQuantity;
    }
}