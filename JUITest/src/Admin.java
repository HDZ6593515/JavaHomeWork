import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

public class Admin{
    JLabel usernameJL;
    JTextField usernameJTF;
    JLabel passwordJL;
    JTextField passwordJTF;
    JButton login;
    public Admin(){
        JFrame admin = new JFrame("管理员登录");
        String username = "sunjiawen123";
        String password = "123";
        admin.setLocation(650,400);
        admin.setSize(450,350);
        admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        admin.setLayout(null);
        JPanel panel = new JPanel(null);
        panel.setBounds(5,5,420,330);
        usernameJL = new JLabel("请输入用户名：");
        usernameJL.setBounds(5,10,120,30);
        usernameJTF = new JTextField(20);
        usernameJTF.setBounds(130,10,150,30);
        passwordJL = new JLabel("请输入密码：    ");
        passwordJL.setBounds(5,60,120,30);
        passwordJTF = new JTextField(20);
        passwordJTF.setBounds(130,60,150,30);
        login = new JButton("登录");
        login.setBounds(150,200,100,30);
        login.setBackground(Color.CYAN);
        panel.add(usernameJL);
        panel.add(usernameJTF);
        panel.add(passwordJL);
        panel.add(passwordJTF);
        panel.add(login);
        admin.add(panel);
        admin.setVisible(true);
        login.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String username1 = usernameJTF.getText();
                String password1 = passwordJTF.getText();
                if(username1.equals(username)&&password1.equals(password)){
                    admin.dispose();
                    ShowStuInfoFrame4 show = new ShowStuInfoFrame4();
                    show.database.closeConnection();
                }
                else {
                    JFrame modifyFail = new JFrame("警告");
                    modifyFail.setLocationRelativeTo(null);
                    modifyFail.setSize(280, 120);
                    modifyFail.setVisible(true);
                    modifyFail.setLayout(new FlowLayout());
                    Font font1 = new Font("宋体",Font.BOLD,25);
                    JLabel modify = new JLabel("用户名或密码错误!");
                    modify.setFont(font1);
                    modify.setForeground(Color.red);
                    modifyFail.add(modify);
                    return;
                }
            }
        });
    }

    public static void main(String[] args) {
        new Admin();
    }
}
class MyDatabase {
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
