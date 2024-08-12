import java.util.*;

public class Q6 {
  
}

class University {
}

class Department {
}


class Professor {
  private String name;
  private String id;
  private Department department;

  public Professor(String name, String id, Department department) {
      this.name = name;
      this.id = id;
      this.department = department;
  }

  public String getName() {
      return name;
  }

  public String getId() {
      return id;
  }
}

class Student {
  private String name;
  private String id;
  private String major;

  public Student(String name, String id, String major) {
      this.name = name;
      this.id = id;
      this.major = major;
  }

  public String getName() {
      return name;
  }

  public String getId() {
      return id;
  }

  public String getMajor() {
      return major;
  }
}