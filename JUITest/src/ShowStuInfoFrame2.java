import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;

public class ShowStuInfoFrame2 extends JFrame {
    private MyDatabase1 database = new MyDatabase1();
    private Student stu = new Student();
    private JTable jt;
    private JScrollPane jsp;
    public ShowStuInfoFrame2() {
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
        //  buttonJP.setBackground(Color.blue);
        buttonJP.setBounds(0, 50, 800, 40);

        JButton jbAdd = new JButton("添加学生");
        jbAdd.setBounds(25, 10, 120, 30);
        jbAdd.setBackground(Color.gray);

        JButton jbDelete = new JButton("删除学生");
        jbDelete.setBounds(195, 10, 120, 30);
        jbDelete.setBackground(Color.gray);

        JButton jbModify = new JButton("修改学生");
        jbModify.setBounds(365, 10, 120, 30);
        jbModify.setBackground(Color.gray);

        JButton jbQuery = new JButton("查询//刷新");
        jbQuery.setBounds(535, 10, 120, 30);
        jbQuery.setBackground(Color.gray);

        JButton jbDeleteSelect= new JButton("删除选中");
        jbDeleteSelect.setBounds(705, 10, 120, 30);
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
        numHeadJL.setBounds(52, 0, 100, 25);


        JLabel nameHeadJL = new JLabel("姓  名");
        nameHeadJL.setBackground(Color.gray);
        nameHeadJL.setBounds(162, 0, 100, 25);

        JLabel ageHeadJL = new JLabel("年  龄");
        ageHeadJL.setBackground(Color.gray);
        ageHeadJL.setBounds(272, 0, 100, 25);

        JLabel genderHeadJL = new JLabel("性  别");
        genderHeadJL.setBackground(Color.gray);
        genderHeadJL.setBounds(382, 0, 100, 25);

        JLabel schoolHeadJL = new JLabel("学校");
        schoolHeadJL.setBackground(Color.gray);
        schoolHeadJL.setBounds(492, 0, 100, 25);

        JLabel classHeadJL = new JLabel("班  级");
        classHeadJL.setBackground(Color.gray);
        classHeadJL.setBounds(602, 0, 100, 25);

        JLabel professionalHeadJL = new JLabel("专  业");
        professionalHeadJL.setBackground(Color.gray);
        professionalHeadJL.setBounds(712, 0, 100, 25);

        listHeadJP.add(numHeadJL);
        listHeadJP.add(nameHeadJL);
        listHeadJP.add(ageHeadJL);
        listHeadJP.add(genderHeadJL);
        listHeadJP.add(schoolHeadJL);
        listHeadJP.add(classHeadJL);
        listHeadJP.add(professionalHeadJL);
        jt = new JTable(50,7);
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
            //匿名内部类使用方法的临时变量需要提前，负责会让你改为final，改为final是为了延长变量的声明周期
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
                            tipJF.setSize(250,150);
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
                        boolean flag = database.deleteStuInfo(sNumI, sName);
                        if(flag){
                            deleteJF.dispose();
                            JFrame deleteSuccessfulJF = new JFrame("提示");
                            deleteSuccessfulJF.setLocationRelativeTo(null);
                            deleteSuccessfulJF.setSize(260, 100);
                            deleteSuccessfulJF.setVisible(true);
                            deleteSuccessfulJF.setLayout(new FlowLayout());
                            JLabel SuccessfulJL = new JLabel("删除学生信息成功！");
                            deleteSuccessfulJF.add(SuccessfulJL);
                        }
                        else {
                            JFrame tipJF = new JFrame("提示");
                            tipJF.setSize(250,150);
                            tipJF.setLocationRelativeTo(null);
                            JLabel tipJL = new JLabel("没有该学生");
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

        //修改学生信息
        jbModify.addMouseListener(new MouseAdapter(){
            JTextField num1JTF = null;
            JTextField name1JTF = null;
            @Override
            public void mouseClicked(MouseEvent e) {
                final JFrame modifyJF = new JFrame("修改");
                modifyJF.setSize(280, 180);
                modifyJF.setLocationRelativeTo(null);
                modifyJF.setLayout(new FlowLayout());
                modifyJF.setVisible(true);
                JLabel numJL = new JLabel("学号:");
                num1JTF = new JTextField(20);
                JLabel nameJL= new JLabel("姓名:");
                name1JTF = new JTextField(20);
                JButton numJB = new JButton("提交");
                modifyJF.add(numJL);
                modifyJF.add(num1JTF);
                modifyJF.add(nameJL);
                modifyJF.add(name1JTF);
                modifyJF.add(numJB);
                numJB.addMouseListener(new MouseAdapter() {
                    JTextField ageJTF = null;
                    JTextField genderJTF = null;
                    JTextField schoolJTF = null;
                    JTextField classJTF = null;
                    JTextField professionalJTF = null;
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //查询学生信息
                        String sNum = num1JTF.getText();
                        String sName = name1JTF.getText();
                        int index = database.selectStuInfo(sNum, sName);
                        if(index==-1){
                            JFrame tipJF = new JFrame("提示");
                            tipJF.setSize(270,150);
                            tipJF.setLocationRelativeTo(null);
                            JLabel tipJL = new JLabel("没有该学生");
                            tipJF.add(tipJL);
                            tipJF.setVisible(true);
                            return;
                        }
                        final JFrame modifyJF1 = new JFrame();
                        modifyJF1.setSize(300, 400);
                        modifyJF1.setBackground(Color.gray);
                        modifyJF1.setLocationRelativeTo(null);
                        modifyJF1.setVisible(true);
                        modifyJF1.setLayout(new FlowLayout());
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


                        final Student student = database.readFile().get(index);
                        ageJTF.setText(student.getAge()+"");
                        genderJTF.setText(student.getGender());
                        schoolJTF.setText(student.getSchool());
                        classJTF.setText(student.getGrade());
                        professionalJTF.setText(student.getMajor());

                        JButton submitJB = new JButton("提交修改");
                        modifyJF1.add(submitJB);
                        submitJB.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                String sNum = num1JTF.getText();
                                String sName = name1JTF.getText();
                                String sAge = ageJTF.getText();
                                String sGender = genderJTF.getText();
                                String sShool = schoolJTF.getText();
                                String sClass = classJTF.getText();
                                String sProfessional = professionalJTF.getText();

                                student.setAge(Integer.parseInt(sAge));
                                student.setGrade(sGender);
                                student.setSchool(sShool);
                                student.setGrade(sClass);
                                stu.setMajor(sProfessional);
                                database.modifyStuInfo(student,index);
                                modifyJF1.dispose();
                                JFrame updateSucessfulJF = new JFrame("提示");
                                updateSucessfulJF.setLocationRelativeTo(null);
                                updateSucessfulJF.setSize(260, 100);
                                updateSucessfulJF.setVisible(true);
                                updateSucessfulJF.setLayout(new FlowLayout());
                                JLabel SuccessfulJL = new JLabel("修改学生信息成功！");
                                updateSucessfulJF.add(SuccessfulJL);
                            }

                        });
                        modifyJF.dispose();
                    }
                });
            }
        });

        //查询学生信息
        jbQuery.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //显示所有的学生信息
                showAllStuInfo();
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
                DefaultTableModel model = (DefaultTableModel) jt.getModel();
                for (int i = 0; i < students.size(); i++) {
                    students.get(i).setNumber((String) jt.getValueAt(i,0));
                    students.get(i).setName((String)jt.getValueAt(i,1));
                    try {
                        students.get(i).setAge(Integer.parseInt(jt.getValueAt(i,2)+""));
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
                    students.get(i).setGender((String) jt.getValueAt(i,3));
                    students.get(i).setSchool((String) jt.getValueAt(i,4));
                    students.get(i).setGrade((String) jt.getValueAt(i,5));
                    students.get(i).setMajor((String) jt.getValueAt(i,6));
                }
                database.writeFile(students);
                JFrame modifySuccess = new JFrame("提示");
                modifySuccess.setLocationRelativeTo(null);
                modifySuccess.setSize(260, 100);
                modifySuccess.setVisible(true);
                modifySuccess.setLayout(new FlowLayout());
                JLabel SuccessfulJL = new JLabel("修改学生信息成功！");
                modifySuccess.add(SuccessfulJL);
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
                            model.removeRow(i);
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
        for (Student student : students) {
            String number = student.getNumber();
            String name = student.getName();
            int age = student.getAge();
            String gender = student.getGender();
            String school = student.getSchool();
            String grade = student.getGrade();
            String major = student.getMajor();

            jt.setValueAt(number,i,0);
            jt.setValueAt(name,i,1);
            jt.setValueAt(age,i,2);
            jt.setValueAt(gender,i,3);
            jt.setValueAt(school,i,4);
            jt.setValueAt(grade,i,5);
            jt.setValueAt(major,i,6);

            i++;
        }

    }
    public static void main(String[] args) {
        ShowStuInfoFrame2 show = new ShowStuInfoFrame2();
        show.database.closeConnection();
    }
}
