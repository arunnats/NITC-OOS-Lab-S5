import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        HierarchicalManager<Entity> manager = new HierarchicalManager<>();

        Employee employee1 = new Employee("Aditya Kamble");
        Manager manager1 = new Manager("Arun Natarajan");

        manager.addEntity(employee1);
        manager.addEntity(manager1);

        manager.printHierarchy();

        List<Entity> managers = manager.getEntitiesByType(Manager.class);
        for (Entity e : managers) {
            System.out.println(e);
        }

        manager.removeEntity(employee1);

        manager.printHierarchy();
    }
}

class Entity {
    private String name;

    public Entity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + name;
    }
}

class Employee extends Entity {
    public Employee(String name) {
        super(name);
    }
}

class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }
}

class HierarchicalManager<T extends Entity> {
    private List<T> entities = new ArrayList<>();

    public void addEntity(T entity) {
        entities.add(entity);
    }

    public void removeEntity(T entity) {
        entities.remove(entity);
    }

    public List<T> getAllEntities() {
        return new ArrayList<>(entities);
    }

    public List<T> getEntitiesByType(Class<? extends T> type) {
        List<T> result = new ArrayList<>();
        for (T entity : entities) {
            if (type.isInstance(entity)) {
                result.add(entity);
            }
        }
        return result;
    }

    public void printHierarchy() {
        if (entities.isEmpty()) {
            System.out.println("No entities.");
        } else {
            for (T entity : entities) {
                System.out.println(entity);
            }
        }
    }    
}
