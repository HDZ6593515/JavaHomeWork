import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MyStudentSys extends JFrame{
    private MyDatabase1 database = new MyDatabase1();
    private Student stu = new Student();
    private JTable jt;
    private JScrollPane jsp;
    private JList<String> jl;
    private DefaultListModel<String> model;

    public MyStudentSys(){
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

        JButton jbModify = new JButton("修改选中");
        jbModify.setBounds(365, 10, 120, 30);
        jbModify.setBackground(Color.gray);

        JButton jbQuery = new JButton("查询学生");
        jbQuery.setBounds(535, 10, 120, 30);
        jbQuery.setBackground(Color.gray);

        JButton jbDeleteSelect = new JButton("删除选中");
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
//        jt = new JTable(50,7);
        model = new DefaultListModel<>();
        jl = new JList<String>();
        jl.setModel(model);
        jsp = new JScrollPane(jl);
        jsp.setBounds(10, 150, 800, 300);

        JPanel savePanel = new JPanel();
        savePanel.setBounds(350, 460, 130, 35);
        JButton clearAll = new JButton("删除所有");
        clearAll.setBackground(Color.CYAN);
        savePanel.add(clearAll);
        this.add(titleJL);
        this.add(buttonJP);
        this.add(listHeadJP);
        this.add(jsp);
        this.add(savePanel);
//        this.showAllStuInfo();
        this.setVisible(true);

        jbAdd.addMouseListener(new MouseAdapter() {
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
                        if ("".equals(snumAdd) || "".equals(snameAdd) || "".equals(sageAdd) || "".equals(sgenderAdd)
                                || "".equals(sschoolAdd) || "".equals(sclassAdd) || "".equals(sprofessionalAdd)) {
                            JFrame tipJF = new JFrame("提示");
                            tipJF.setSize(250, 150);
                            tipJF.setLocationRelativeTo(null);
                            JLabel tipJL = new JLabel("请填入了所有的信息之后再点击提交");
                            tipJF.add(tipJL);
                            tipJF.setVisible(true);
                        } else {
                            stu = new Student();
                            Student stu2 = new Student();
                            stu2.setNumber(snumAdd);
                            stu2.setName(snameAdd);
                            stu2.setAge(Integer.parseInt(sageAdd));
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
        //删除学生信息
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
                JLabel numJL = new JLabel("要删除的学号:");
                numJTF = new JTextField(20);
                JLabel nameJL= new JLabel("要删除的姓名:");
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
                int[] ints = jl.getSelectedIndices();

                ArrayList<Student> students = database.readFile();
                for (int i = 0; i < ints.length; i++) {
                    students.remove(ints[i]);
                    model.remove(ints[i]);
                }
                database.writeFile(students);
            }
        });


    }
}
