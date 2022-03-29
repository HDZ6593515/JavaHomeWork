import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;

public class ShowStuInfoFrame4 extends JFrame {
    MyDatabase1 database = new MyDatabase1();
    Student stu = new Student();
    JTable jt;
    JScrollPane jsp;
    public ShowStuInfoFrame4() {
        this.setSize(850, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //界面标题部分
        JLabel titleJL = new JLabel("学生管理系统");
        Font font = new Font("微软雅黑", 1, 15);
        titleJL.setFont(font);
        titleJL.setLayout(null);
        titleJL.setBounds(350, 10, 100, 20);

        //按钮部分
        JPanel buttonJP = new JPanel();
        buttonJP.setLayout(null);
        buttonJP.setBounds(0, 50, 800, 40);

        JButton jbAdd = new JButton("添加学生");
        jbAdd.setBounds(25, 10, 120, 30);
        jbAdd.setBackground(Color.gray);

        JButton jbDelete = new JButton("删除学生");
        jbDelete.setBounds(185, 10, 120, 30);
        jbDelete.setBackground(Color.gray);

        JButton jbModify = new JButton("修改选中");
        jbModify.setBounds(340, 10, 120, 30);
        jbModify.setBackground(Color.gray);

        JButton jbQuery = new JButton("查询选中");
        jbQuery.setBounds(520, 10, 120, 30);
        jbQuery.setBackground(Color.gray);

        JButton jbDeleteSelect= new JButton("删除选中");
        jbDeleteSelect.setBounds(690, 10, 120, 30);
        jbDeleteSelect.setBackground(Color.gray);


        buttonJP.add(jbAdd);
        buttonJP.add(jbDelete);
        buttonJP.add(jbModify);
        buttonJP.add(jbQuery);
        buttonJP.add(jbDeleteSelect);

        JPanel listHeadJP = new JPanel();
        listHeadJP.setBackground(Color.lightGray);
        listHeadJP.setLayout(null);
        listHeadJP.setBounds(0, 120, 830, 30);

        JLabel numHeadJL = new JLabel("学  号");
        numHeadJL.setBackground(Color.gray);
        numHeadJL.setBounds(100, 0, 100, 25);


        JLabel nameHeadJL = new JLabel("姓  名");
        nameHeadJL.setBackground(Color.gray);
        nameHeadJL.setBounds(293, 0, 100, 25);


        JLabel genderHeadJL = new JLabel("性  别");
        genderHeadJL.setBackground(Color.gray);
        genderHeadJL.setBounds(492, 0, 100, 25);

        JLabel ageHeadJL = new JLabel("年  龄");
        ageHeadJL.setBackground(Color.gray);
        ageHeadJL.setBounds(684, 0, 100, 25);

        listHeadJP.add(numHeadJL);
        listHeadJP.add(nameHeadJL);
        listHeadJP.add(genderHeadJL);
        listHeadJP.add(ageHeadJL);

        jt = new JTable(50,4);
        jsp = new JScrollPane(jt);
        jsp.setBounds(10,150,800,300);
        JPanel panel = new JPanel();
        panel.setBounds(10,460,780,35);
        JButton decrease = new JButton("年龄升序");
        decrease.setBackground(Color.PINK);
        panel.add(decrease);
        JButton saveModify = new JButton("保存修改");
        saveModify.setBackground(Color.CYAN);
        panel.add(saveModify);
        JButton clearAll = new JButton("删除所有");
        clearAll.setBackground(Color.CYAN);
        panel.add(clearAll);
        JButton increase = new JButton("年龄降序");
        increase.setBackground(Color.PINK);
        panel.add(increase);
        this.add(titleJL);
        this.add(buttonJP);
        this.add(listHeadJP);
        this.add(jsp);
        this.add(panel);
        this.showAllStuInfo();
        this.setVisible(true);

        //添加学生信息
        jbAdd.addMouseListener(new MouseAdapter(){
            JTextField nameJTF = null;
            JTextField numJTF = null;
            JTextField ageJTF = null;
            JTextField genderJTF = null;
            JTextField schoolJTF = null;
            JTextField classJTF = null;
            JTextField professionalJTF = null;
            @Override
            public void mouseClicked(MouseEvent e) {
                final JFrame addJF = new JFrame("添加");
                addJF.setSize(300, 400);
                addJF.setBackground(Color.gray);
                addJF.setLocationRelativeTo(null);
                addJF.setLayout(new FlowLayout());
                JLabel numJL = new JLabel("学号：");
                numJTF = new JTextField(20);
                JLabel nameJL = new JLabel("姓名：");
                nameJTF = new JTextField(20);
                JLabel ageJL = new JLabel("年龄：");
                ageJTF = new JTextField(20);
                JLabel genderJL = new JLabel("性别：");
                genderJTF = new JTextField(20);
                JLabel schoolJL = new JLabel("学校：");
                schoolJTF = new JTextField(20);
                JLabel classJL = new JLabel("班级：");
                classJTF = new JTextField(20);
                JLabel professionalJL = new JLabel("专业：");
                professionalJTF = new JTextField(20);
                addJF.add(numJL);
                addJF.add(numJTF);
                addJF.add(nameJL);
                addJF.add(nameJTF);
                addJF.add(ageJL);
                addJF.add(ageJTF);
                addJF.add(genderJL);
                addJF.add(genderJTF);
                addJF.add(schoolJL);
                addJF.add(schoolJTF);
                addJF.add(classJL);
                addJF.add(classJTF);
                addJF.add(professionalJL);
                addJF.add(professionalJTF);
                JButton addJB = new JButton("添加");
                addJF.add(addJB);
                addJF.setVisible(true);
                addJB.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String snumAdd = numJTF.getText();
                        String snameAdd = nameJTF.getText();
                        String sageAdd = ageJTF.getText();
                        String sgenderAdd = genderJTF.getText();
                        String sschoolAdd = schoolJTF.getText();
                        String sclassAdd = classJTF.getText();
                        String sprofessionalAdd = professionalJTF.getText();
                        //输入的信息为空的处理
                        if("".equals(snumAdd)||"".equals(snameAdd)||"".equals(sageAdd)||"".equals(sgenderAdd)
                                ||"".equals(sschoolAdd)||"".equals(sclassAdd)||"".equals(sprofessionalAdd)) {
                            JFrame tipJF = new JFrame("提示");
                            tipJF.setSize(280,150);
                            tipJF.setLocationRelativeTo(null);
                            JLabel tipJL = new JLabel("请填入了所有的信息之后再点击提交");
                            tipJF.add(tipJL);
                            tipJF.setVisible(true);
                        }else {
                            stu = new Student();
                            Student stu2 = new Student();
                            stu2.setNumber(snumAdd);
                            stu2.setName(snameAdd);
                            try {
                                stu2.setAge(Integer.parseInt(sageAdd));
                            } catch (NumberFormatException ex) {
                                JFrame addFail = new JFrame("提示");
                                addFail.setLocationRelativeTo(null);
                                addFail.setSize(260, 100);
                                addFail.setVisible(true);
                                addFail.setLayout(new FlowLayout());
                                JLabel SuccessfulJL = new JLabel("输入的格式有误!!!");
                                addFail.add(SuccessfulJL);
                                return;
                            }
                            stu2.setGender(sgenderAdd);
                            stu2.setSchool(sschoolAdd);
                            stu2.setGrade(sclassAdd);
                            stu2.setMajor(sprofessionalAdd);
                            database.writeFile(stu2);
                            addJF.dispose();
                            JFrame addSuccessfulJF = new JFrame("提示");
                            addSuccessfulJF.setLocationRelativeTo(null);
                            addSuccessfulJF.setSize(260, 100);
                            addSuccessfulJF.setVisible(true);
                            addSuccessfulJF.setLayout(new FlowLayout());
                            JLabel SuccessfulJL = new JLabel("添加学生信息成功！");
                            addSuccessfulJF.add(SuccessfulJL);
                            showAllStuInfo();
                        }
                    }
                });
            }
        });

        //删除学生
        jbDelete.addMouseListener(new MouseAdapter() {
            JTextField numJTF = null;
            JTextField nameJTF = null;
            @Override
            public void mouseClicked(MouseEvent e) {
                final JFrame deleteJF = new JFrame("删除");
                deleteJF.setLayout(new FlowLayout());
                deleteJF.setSize(280, 180);
                deleteJF.setVisible(true);
                deleteJF.setLocationRelativeTo(null);
                JLabel numJL = new JLabel("学号:");
                numJTF = new JTextField(20);
                JLabel nameJL= new JLabel("姓名:");
                nameJTF = new JTextField(20);
                JButton numJB = new JButton("提交");
                deleteJF.add(numJL);
                deleteJF.add(numJTF);
                deleteJF.add(nameJL);
                deleteJF.add(nameJTF);
                deleteJF.add(numJB);
                numJB.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String sNumI = numJTF.getText();
                        String sName = nameJTF.getText();
                        int index = database.selectStuInfo(sNumI, sName);
                        boolean flag = database.deleteStuInfo(sNumI, sName);
                        DefaultTableModel model = (DefaultTableModel) jt.getModel();
                        if(flag&&index>=0){
                            model.removeRow(index);
                            deleteJF.dispose();
                            JFrame deleteSuccessfulJF = new JFrame("提示");
                            deleteSuccessfulJF.setLocationRelativeTo(null);
                            deleteSuccessfulJF.setSize(280, 100);
                            deleteSuccessfulJF.setVisible(true);
                            deleteSuccessfulJF.setLayout(new FlowLayout());
                            JLabel SuccessfulJL = new JLabel("删除学生信息成功！");
                            deleteSuccessfulJF.add(SuccessfulJL);
                        }
                        else {
                            JFrame tipJF = new JFrame("提示");
                            tipJF.setSize(280,150);
                            tipJF.setLocationRelativeTo(null);
                            JLabel tipJL = new JLabel("没有该学生!");
                            tipJF.add(tipJL);
                            tipJF.setVisible(true);
                        }
                    }
                });
            }
        });


        //删除选中
        jbDeleteSelect.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int selectedRow = jt.getSelectedRow();
                ArrayList<Student> students = database.readFile();
                if (selectedRow<students.size()){
                    students.remove(selectedRow);
                    DefaultTableModel model = (DefaultTableModel)jt.getModel();
                    model.removeRow(selectedRow);
                    database.writeFile(students);
                    showAllStuInfo();
                }
            }
        });

        //修改选中学生信息
        jbModify.addMouseListener(new MouseAdapter(){
            JTextField nameJTF = null;
            JTextField numJTF = null;
            JTextField ageJTF = null;
            JTextField genderJTF = null;
            JTextField schoolJTF = null;
            JTextField classJTF = null;
            JTextField professionalJTF = null;
            @Override
            public void mouseClicked(MouseEvent e) {
                int index = jt.getSelectedRow();
                if (index<0||index>=database.readFile().size())
                    return;
                ArrayList<Student> students = database.readFile();
                Student student = students.get(index);
                final JFrame modifyJF = new JFrame("修改");
                modifyJF.setSize(300, 400);
                modifyJF.setBackground(Color.gray);
                modifyJF.setLocationRelativeTo(null);
                modifyJF.setLayout(new FlowLayout());
                JLabel numJL = new JLabel("学号：");
                numJTF = new JTextField(20);
                numJTF.setText(student.getNumber());
                JLabel nameJL = new JLabel("姓名：");
                nameJTF = new JTextField(20);
                nameJTF.setText(student.getName());
                JLabel ageJL = new JLabel("年龄：");
                ageJTF = new JTextField(20);
                ageJTF.setText(student.getAge()+"");
                JLabel genderJL = new JLabel("性别：");
                genderJTF = new JTextField(20);
                genderJTF.setText(student.getGender());
                JLabel schoolJL = new JLabel("学校：");
                schoolJTF = new JTextField(20);
                schoolJTF.setText(student.getSchool());
                JLabel classJL = new JLabel("班级：");
                classJTF = new JTextField(20);
                classJTF.setText(student.getGrade());
                JLabel professionalJL = new JLabel("专业：");
                professionalJTF = new JTextField(20);
                professionalJTF.setText(student.getMajor());
                modifyJF.add(numJL);
                modifyJF.add(numJTF);
                modifyJF.add(nameJL);
                modifyJF.add(nameJTF);
                modifyJF.add(ageJL);
                modifyJF.add(ageJTF);
                modifyJF.add(genderJL);
                modifyJF.add(genderJTF);
                modifyJF.add(schoolJL);
                modifyJF.add(schoolJTF);
                modifyJF.add(classJL);
                modifyJF.add(classJTF);
                modifyJF.add(professionalJL);
                modifyJF.add(professionalJTF);
                JButton submitJB = new JButton("提交修改");
                modifyJF.add(submitJB);
                modifyJF.setVisible(true);
                submitJB.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String snumAdd = numJTF.getText();
                        String snameAdd = nameJTF.getText();
                        String sageAdd = ageJTF.getText();
                        String sgenderAdd = genderJTF.getText();
                        String sschoolAdd = schoolJTF.getText();
                        String sclassAdd = classJTF.getText();
                        String sprofessionalAdd = professionalJTF.getText();
                        //输入的信息为空的处理
                        if("".equals(snumAdd)||"".equals(snameAdd)||"".equals(sageAdd)||"".equals(sgenderAdd)
                                ||"".equals(sschoolAdd)||"".equals(sclassAdd)||"".equals(sprofessionalAdd)) {
                            JFrame tipJF = new JFrame("提示");
                            tipJF.setSize(250,150);
                            tipJF.setLocationRelativeTo(null);
                            JLabel tipJL = new JLabel("请填入了所有的信息之后再点击提交");
                            tipJF.add(tipJL);
                            tipJF.setVisible(true);
                        }else {
                            student.setNumber(snumAdd);
                            student.setName(snameAdd);
                            try {
                                student.setAge(Integer.parseInt(sageAdd));
                            } catch (NumberFormatException ex) {
                                JFrame addFail = new JFrame("提示");
                                addFail.setLocationRelativeTo(null);
                                addFail.setSize(260, 100);
                                addFail.setVisible(true);
                                addFail.setLayout(new FlowLayout());
                                JLabel failJL = new JLabel("输入的格式有误!!!");
                                addFail.add(failJL);
                                return;
                            }
                            student.setGender(sgenderAdd);
                            student.setSchool(sschoolAdd);
                            student.setGrade(sclassAdd);
                            student.setMajor(sprofessionalAdd);
                            database.writeFile(students);
                            modifyJF.dispose();
                            JFrame modifySuccessfulJF = new JFrame("提示");
                            modifySuccessfulJF.setLocationRelativeTo(null);
                            modifySuccessfulJF.setSize(260, 100);
                            modifySuccessfulJF.setVisible(true);
                            modifySuccessfulJF.setLayout(new FlowLayout());
                            JLabel SuccessfulJL = new JLabel("修改学生信息成功！");
                            modifySuccessfulJF.add(SuccessfulJL);
                            showAllStuInfo();
                        }
                    }
                });
            }
        });

        //查询选中学生信息
        jbQuery.addMouseListener(new MouseAdapter() {
            JTextField numJTF = null;
            JTextField nameJTF = null;
            JTextField ageJTF = null;
            JTextField genderJTF = null;
            JTextField schoolJTF = null;
            JTextField classJTF = null;
            JTextField professionalJTF = null;
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = jt.getSelectedRow();
                if(selectedRow<0||selectedRow>=database.readFile().size())
                    return;
                ArrayList<Student> students = database.readFile();
                Student student = students.get(selectedRow);
                JFrame modifyJF1 = new JFrame();
                modifyJF1.setSize(300, 400);
                modifyJF1.setBackground(Color.gray);
                modifyJF1.setLocationRelativeTo(null);
                modifyJF1.setVisible(true);
                modifyJF1.setLayout(new FlowLayout());
                JLabel numJL = new JLabel("学号：");
                numJTF = new JTextField(20);
                numJTF.setText(student.getNumber());
                numJTF.setEnabled(false);
                JLabel nameJL = new JLabel("姓名：");
                nameJTF = new JTextField(20);
                nameJTF.setText(student.getName());
                nameJTF.setEnabled(false);
                JLabel ageJL = new JLabel("年龄：");
                ageJTF = new JTextField(20);
                ageJTF.setText(student.getAge()+"");
                ageJTF.setEnabled(false);
                JLabel genderJL = new JLabel("性别：");
                genderJTF = new JTextField(20);
                genderJTF.setText(student.getGender());
                genderJTF.setEnabled(false);
                JLabel schoolJL = new JLabel("学校：");
                schoolJTF = new JTextField(20);
                schoolJTF.setText(student.getSchool());
                schoolJTF.setEnabled(false);
                JLabel classJL = new JLabel("班级：");
                classJTF = new JTextField(20);
                classJTF.setText(student.getGrade());
                classJTF.setEnabled(false);
                JLabel professionalJL = new JLabel("专业：");
                professionalJTF = new JTextField(20);
                professionalJTF.setText(student.getMajor());
                professionalJTF.setEnabled(false);
                modifyJF1.add(numJL);
                modifyJF1.add(numJTF);
                modifyJF1.add(nameJL);
                modifyJF1.add(nameJTF);
                modifyJF1.add(ageJL);
                modifyJF1.add(ageJTF);
                modifyJF1.add(genderJL);
                modifyJF1.add(genderJTF);
                modifyJF1.add(schoolJL);
                modifyJF1.add(schoolJTF);
                modifyJF1.add(classJL);
                modifyJF1.add(classJTF);
                modifyJF1.add(professionalJL);
                modifyJF1.add(professionalJTF);
            }
        });
        //保存修改
        saveModify.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    jt.getCellEditor().stopCellEditing();
                } catch (Exception ex) {

                }
                ArrayList<Student> students = database.readFile();
                for (int i = 0; i < students.size(); i++) {
                    students.get(i).setNumber((String) jt.getValueAt(i,0));
                    students.get(i).setName((String)jt.getValueAt(i,1));
                    try {
                        students.get(i).setAge(Integer.parseInt(jt.getValueAt(i,3)+""));
                    } catch (NumberFormatException ex) {
                        JFrame modifyFail = new JFrame("警告");
                        modifyFail.setLocationRelativeTo(null);
                        modifyFail.setSize(300, 120);
                        modifyFail.setVisible(true);
                        modifyFail.setLayout(new FlowLayout());
                        Font font1 = new Font("宋体",Font.BOLD,25);
                        JLabel modify = new JLabel("您输入的格式不正确!!!");
                        modify.setFont(font1);
                        modify.setForeground(Color.red);
                        modifyFail.add(modify);
                        return;
                    }
                    students.get(i).setGender((String) jt.getValueAt(i,2));
                }
                database.writeFile(students);
                DefaultTableModel model = (DefaultTableModel) jt.getModel();
                for (int i = 0; i < jt.getRowCount(); i++) {
                    model.removeRow(i);
                }
                model.setRowCount(50);
                JFrame modifySuccess = new JFrame("提示");
                modifySuccess.setLocationRelativeTo(null);
                modifySuccess.setSize(260, 100);
                modifySuccess.setVisible(true);
                modifySuccess.setLayout(new FlowLayout());
                JLabel SuccessfulJL = new JLabel("修改学生信息成功！");
                modifySuccess.add(SuccessfulJL);
                showAllStuInfo();
            }
        });

        //清空所有
        clearAll.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame clear = new JFrame("警告");
                clear.setLayout(null);
                JPanel clearPanel = new JPanel();
                clearPanel.setLayout(null);
                clearPanel.setBounds(5, 0, 390, 190);
                clear.setLocationRelativeTo(null);
                clear.setSize(400, 200);
                clear.setVisible(true);
                Font font1 = new Font("宋体", Font.BOLD, 25);
                JLabel modify = new JLabel("您确认要清空所有信息吗？");
                modify.setBounds(25, 10, 380, 50);
                JButton yes = new JButton("确认");
                yes.setBounds(20, 110, 100, 30);
                JButton no = new JButton("取消");
                no.setBounds(250, 110, 100, 30);
                modify.setFont(font1);
                modify.setForeground(Color.red);
                clearPanel.add(modify);
                clearPanel.add(yes);
                clearPanel.add(no);
                clear.add(clearPanel);
                yes.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        ArrayList<Student> students = database.readFile();
                        clear.dispose();
                        DefaultTableModel model = (DefaultTableModel) jt.getModel();
                        for (int i = 0; i < students.size(); i++) {
                            model.removeRow(0);
//                            model.removeRow(i);
                        }
                        students.clear();
                        database.writeFile(students);
                        showAllStuInfo();
                    }
                });
                no.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        clear.dispose();
                        return;
                    }
                });
            }
        });

        //年龄降序
        decrease.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ArrayList<Student> students = database.readFile();
                students.sort(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.getAge()-o2.getAge();
                    }
                });
                database.writeFile(students);
                showAllStuInfo();
            }
        });

        ///年龄升序
        increase.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ArrayList<Student> students = database.readFile();
                students.sort(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o2.getAge()-o1.getAge();
                    }
                });
                database.writeFile(students);
                showAllStuInfo();
            }
        });
    }





    public void showAllStuInfo(){
        ArrayList<Student> students = database.readFile();
        int i = 0;
        for (int j = 0; j<students.size(); j++) {
            Student student = students.get(j);
            String number = student.getNumber();
            String name = student.getName();
            int age = student.getAge();
            String gender = student.getGender();
            String school = student.getSchool();
            String grade = student.getGrade();
            String major = student.getMajor();

            jt.setValueAt(number,j,0);
            jt.setValueAt(name,j,1);
            jt.setValueAt(gender,j,2);
            jt.setValueAt(age,j,3);
        }

    }
    public static void main(String[] args) {
        ShowStuInfoFrame4 show = new ShowStuInfoFrame4();
        show.database.closeConnection();
    }
}
