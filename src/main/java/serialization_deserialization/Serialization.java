package serialization_deserialization;

import java.io.*;

public class Serialization {
    public static void main(String[] args) {

//		User user1 = new User(1L, "John Coffee", "456-43-3423");
//		User user2 = new User(2L, "Tony Stark", "755-43-3423");
//		User user3 = new User(3L, "James Bond", "876-43-3423");
//
//
//		try(FileOutputStream fos = new FileOutputStream("user.ser")){
//			try(ObjectOutputStream oos=new ObjectOutputStream(fos)){
//
//				oos.writeObject(user1);
//				oos.writeObject(user2);
//				oos.writeObject(user3);
//
//				System.out.println("All Objects has been serialized");
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

        readObjects();


    }


    static void readObjects() {

        try(FileInputStream fis=new FileInputStream("user.ser")){

            try(ObjectInputStream ois=new ObjectInputStream(fis)){

                try {
                    User user1= (User) ois.readObject();
                    User user2= (User) ois.readObject();
                    User user3= (User) ois.readObject();
//                    User user4= (User) ois.readObject();





                    System.out.println(user1.toString());
                    System.out.println(user2.toString());
                    System.out.println(user3.toString());
//                    System.out.println(user4.toString());

                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}

class User implements Serializable{

    private static final long serialVersionUID = 1L; // is used to ensure that during deserialization the same class is loaded.


    private Long id;
    private String name;
    private String ssn;

    public User(Long id, String name, String ssn) {
        this.id = id;
        this.name = name;
        this.ssn = ssn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", ssn=" + ssn + "]";
    }


}
