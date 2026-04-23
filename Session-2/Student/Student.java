class Student {
  private String name,track;
  private int age;

  public Student(String name, String track, int age) {
    this.name = name;
    this.track = track;
    this.age = age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }


  public void setTrack(String track) {
    this.track = track;
  }
  public String getTrack() {
    return track;
  }


  public void setAge(int age) {
    this.age = age;
  }

  public int getAge() {
    return age; 
  }

  public void printData() {
    System.out.println("Name: " + name);
    System.out.println("Track: " + track);
    System.out.println("Age: " + age);
  }

}
