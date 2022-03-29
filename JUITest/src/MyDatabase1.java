import java.io.*;
import java.util.ArrayList;

public class MyDatabase1 {
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    public boolean deleteStuInfo(String number,String name){
        int flag = selectStuInfo(number, name);
        if(flag==-1){
            return false;
        }
        else {
            ArrayList<Student> students = readFile();
            students.remove(flag);
            writeFile(students);
            return true;
        }
    }

    public int selectStuInfo(String number,String name){
        ArrayList<Student> students = readFile();
        int flag = -1;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if(student.getNumber().equals(number)&&student.getName().equals(name)){
                return i;
            }
        }
        return flag;
    }
    public void modifyStuInfo(Student student,int index){
        ArrayList<Student> students = readFile();
        Student student1 = students.get(index);
        student1.setNumber(student.getNumber());
        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setGender(student.getGender());
        student1.setSchool(student.getSchool());
        student1.setGrade(student.getGender());
        student1.setMajor(student.getMajor());
        writeFile(students);
    }

    public void writeFile(Student student){
        ArrayList<Student> students = readFile();
        if(student!=null)
            students.add(student);
        try {
            oos = new ObjectOutputStream(new FileOutputStream("student.txt"));
            oos.writeObject(students);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(ArrayList<Student> list){
        try {
            oos = new ObjectOutputStream(new FileOutputStream("student.txt"));
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> readFile(){
        ArrayList<Student> students = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("student.txt"));
            students =  (ArrayList<Student>)ois.readObject();

        } catch (IOException e) {
            return new ArrayList<Student>();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void closeConnection(){
        try {
            if (oos!=null)
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if(ois!=null)
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
