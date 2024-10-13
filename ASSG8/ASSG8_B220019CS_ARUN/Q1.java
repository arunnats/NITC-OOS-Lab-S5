import java.util.ArrayList;
import java.util.List;

public class Q1{
    public static void main(String[] args){
        MessController controller = new MessController();
        
        MealPlan vegetarianPlan = new MealPlanImpl("Vegetarian Plan", 10.0);
        vegetarianPlan.addMenuItem(new MenuItem("Salad", 5.0));
        vegetarianPlan.addMenuItem(new MenuItem("Fruit", 3.0));
        
        controller.addMealPlan(vegetarianPlan);
        
        StudentImpl student1 = new StudentImpl("Alice", "S001");
        
        controller.subscribeStudentToMealPlan(student1, vegetarianPlan);
        
        controller.printSubscriptionStatus(student1);
        
        controller.unsubscribeStudentFromMealPlan(student1, vegetarianPlan);
        
        controller.printSubscriptionStatus(student1);
    }
}

interface Person {
    String getName();
    String getID();    
}

interface Student extends Person {
    List<MealPlan> getSubscribedMealPlans();
    void subscribeMealPlan(MealPlan mealPlan);
    void unsubscribeMealPlan(MealPlan mealPlan);
}

interface MealPlan {
    String getPlanName();
    List<MenuItem> getMenuItems();
    double getPrice();
    void addMenuItem(MenuItem menuItem);
}

class MealPlanImpl implements MealPlan {
    private String planName;
    private double price;
    private List<MenuItem> menuItems;

    public MealPlanImpl(String name, double price){
        this.planName = name;
        this.price = price;
        this.menuItems = new ArrayList<>();
    }

    public String getPlanName(){
        return this.planName;
    }

    public List<MenuItem> getMenuItems(){
        return this.menuItems;
    }

    public double getPrice(){
        double totalPrice = 0.0;
        for(MenuItem menuItem : menuItems){
            totalPrice += menuItem.getPrice();
        }
        return totalPrice;
    }

    public void addMenuItem(MenuItem menuItem){
        this.menuItems.add(menuItem);
    }
}

class MenuItem {
    private String itemName;
    private double price;

    public MenuItem(String name, double price){
        this.itemName = name;
        this.price = price;
    }

    public String getItemName(){
        return this.itemName;
    }

    public double getPrice(){
        return this.price;
    }
}

class StudentImpl implements Student {
    private String name;
    private String id;
    private List<MealPlan> subscribedMealPlans;

    public StudentImpl(String name, String id){
        this.name = name;
        this.id = id;
        this.subscribedMealPlans = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public String getID(){
        return this.id;
    }

    public List<MealPlan> getSubscribedMealPlans(){
        return this.subscribedMealPlans;
    }

    public void subscribeMealPlan(MealPlan mealPlan){
        if(!subscribedMealPlans.contains(mealPlan)){
            subscribedMealPlans.add(mealPlan);
            System.out.println(mealPlan.getPlanName() + " was subscribed.");
        } else {
            System.out.println("Already subscribed to " + mealPlan.getPlanName() + ".");
        }
    }

    public void unsubscribeMealPlan(MealPlan mealPlan){
        if(subscribedMealPlans.remove(mealPlan)){
            System.out.println(mealPlan.getPlanName() + " was unsubscribed.");
        } else {
            System.out.println("Meal plan " + mealPlan.getPlanName() + " not found in subscriptions.");
        }
    }
}

class MessController {
    private List<MealPlan> mealPlans;

    public MessController(){
        this.mealPlans = new ArrayList<>();
    }

    public void addMealPlan(MealPlan mealPlan){
        mealPlans.add(mealPlan);
        System.out.println(mealPlan.getPlanName() + " has been added to the system.");
    }

    public void subscribeStudentToMealPlan(Student student, MealPlan mealPlan){
        if(mealPlans.contains(mealPlan)){
            student.subscribeMealPlan(mealPlan);
        } else {
            System.out.println("Meal plan " + mealPlan.getPlanName() + " does not exist.");
        }
    }

    public void unsubscribeStudentFromMealPlan(Student student, MealPlan mealPlan){
        student.unsubscribeMealPlan(mealPlan);
    }

    public void printSubscriptionStatus(Student student){
        System.out.println("Subscription Status for " + student.getName() + " (ID: " + student.getID() + "):");
        List<MealPlan> subscriptions = student.getSubscribedMealPlans();
        if(subscriptions.isEmpty()){
            System.out.println("No active meal plan subscriptions.");
        } else {
            for(MealPlan mealPlan : subscriptions){
                System.out.println("- " + mealPlan.getPlanName() + " (Price: $" + mealPlan.getPrice() + ")");
            }
        }
    }
}


