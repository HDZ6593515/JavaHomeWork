import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ShowStuInfoFrame extends JFrame {
    private MyDatabase1 database = new MyDatabase1();
    private Student stu = new Student();
    private JTextArea stuInfoListJTA = null;
    public ShowStuInfoFrame() {
        this.setSize(850, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        //������ⲿ��
        JLabel titleJL = new JLabel("ѧ������ϵͳ");
        Font font = new Font("΢���ź�", 1, 15);
        titleJL.setFont(font);
        titleJL.setLayout(null);
        titleJL.setBounds(350, 10, 100, 20);

        //��ť����
        JPanel buttonJP = new JPanel();
        buttonJP.setLayout(null);
        //  buttonJP.setBackground(Color.blue);
        buttonJP.setBounds(0, 50, 800, 40);

        JButton jbAdd = new JButton("���ѧ����Ϣ");
        jbAdd.setBounds(25, 10, 150, 30);
        jbAdd.setBackground(Color.gray);

        JButton jbDelete = new JButton("ɾ��ѧ����Ϣ");
        jbDelete.setBounds(225, 10, 150, 30);
        jbDelete.setBackground(Color.gray);

        JButton jbModify = new JButton("�޸�ѧ����Ϣ");
        jbModify.setBounds(425, 10, 150, 30);
        jbModify.setBackground(Color.gray);

        JButton jbQuery = new JButton("��ѯѧ����Ϣ");
        jbQuery.setBounds(625, 10, 150, 30);
        jbQuery.setBackground(Color.gray);

        //  buttonJP.setLayout(new FlowLayout());
        buttonJP.add(jbAdd);
        buttonJP.add(jbDelete);
        buttonJP.add(jbModify);
        buttonJP.add(jbQuery);

        JPanel listHeadJP = new JPanel();
        listHeadJP.setBackground(Color.lightGray);
        listHeadJP.setLayout(null);
        listHeadJP.setBounds(0, 120, 830, 30);

        JLabel numHeadJL = new JLabel("ѧ  ��");
        numHeadJL.setBackground(Color.gray);
        numHeadJL.setBounds(30, 0, 100, 25);


        JLabel nameHeadJL = new JLabel("��  ��");
        nameHeadJL.setBackground(Color.gray);
        nameHeadJL.setBounds(140, 0, 100, 25);

        JLabel ageHeadJL = new JLabel("��  ��");
        ageHeadJL.setBackground(Color.gray);
        ageHeadJL.setBounds(250, 0, 100, 25);

        JLabel genderHeadJL = new JLabel("��  ��");
        genderHeadJL.setBackground(Color.gray);
        genderHeadJL.setBounds(360, 0, 100, 25);

        JLabel schoolHeadJL = new JLabel("ѧУ");
        schoolHeadJL.setBackground(Color.gray);
        schoolHeadJL.setBounds(470, 0, 100, 25);

        JLabel classHeadJL = new JLabel("��  ��");
        classHeadJL.setBackground(Color.gray);
        classHeadJL.setBounds(580, 0, 100, 25);

        JLabel professionalHeadJL = new JLabel("ר  ҵ");
        professionalHeadJL.setBackground(Color.gray);
        professionalHeadJL.setBounds(690, 0, 100, 25);

        listHeadJP.add(numHeadJL);
        listHeadJP.add(nameHeadJL);
        listHeadJP.add(ageHeadJL);
        listHeadJP.add(genderHeadJL);
        listHeadJP.add(schoolHeadJL);
        listHeadJP.add(classHeadJL);
        listHeadJP.add(professionalHeadJL);

        Font stuInfoListFont = new Font("΢���ź�", 0, 13);
        stuInfoListJTA = new JTextArea(20, 20);
        stuInfoListJTA.setBounds(10, 152, 830, 400);
        stuInfoListJTA.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 5));
        stuInfoListJTA.setColumns(20);
        stuInfoListJTA.setRows(20);//�൱�������ı�������ĳ�ʼ��С,������˵һ��ֻ��д0
        stuInfoListJTA.setFont(stuInfoListFont);

        this.add(titleJL);
        this.add(buttonJP);
        this.add(listHeadJP);
        this.add(stuInfoListJTA);
        this.showAllStuInfo();
        this.setVisible(true);

        //���ѧ����Ϣ
        jbAdd.addMouseListener(new MouseAdapter(){
            //�����ڲ���ʹ�÷�������ʱ������Ҫ��ǰ������������Ϊfinal����Ϊfinal��Ϊ���ӳ���������������
            JTextField nameJTF = null;
            JTextField numJTF = null;
            JTextField ageJTF = null;
            JTextField genderJTF = null;
            JTextField schoolJTF = null;
            JTextField classJTF = null;
            JTextField professionalJTF = null;
            @Override
            public void mouseClicked(MouseEvent e) {
                final JFrame addJF = new JFrame("���");
                addJF.setSize(300, 400);
                addJF.setBackground(Color.gray);
                addJF.setLocationRelativeTo(null);
                addJF.setLayout(new FlowLayout());
                JLabel numJL = new JLabel("ѧ�ţ�");
                numJTF = new JTextField(20);
                JLabel nameJL = new JLabel("������");
                nameJTF = new JTextField(20);
                JLabel ageJL = new JLabel("���䣺");
                ageJTF = new JTextField(20);
                JLabel genderJL = new JLabel("�Ա�");
                genderJTF = new JTextField(20);
                JLabel schoolJL = new JLabel("ѧУ��");
                schoolJTF = new JTextField(20);
                JLabel classJL = new JLabel("�༶��");
                classJTF = new JTextField(20);
                JLabel professionalJL = new JLabel("רҵ��");
                professionalJTF = new JTextField(20);
                //addJF.dispose();//�����Ӵ���
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
                JButton addJB = new JButton("���");
                addJF.add(addJB);
                addJF.setVisible(true);
                addJB.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
//                        Integer snumAddI = new Integer(numJTF.getText().toString());
//                        int snumAdd = snumAddI;
                        String snumAdd = numJTF.getText();
                        String snameAdd = nameJTF.getText();
                        String sageAdd = ageJTF.getText();
                        String sgenderAdd = genderJTF.getText();
                        String sschoolAdd = schoolJTF.getText();
                        String sclassAdd = classJTF.getText();
                        String sprofessionalAdd = professionalJTF.getText();
                        //�������ϢΪ�յĴ���
                        if("".equals(snumAdd)||"".equals(snameAdd)||"".equals(sageAdd)||"".equals(sgenderAdd)
                                ||"".equals(sschoolAdd)||"".equals(sclassAdd)||"".equals(sprofessionalAdd)) {
                            JFrame tipJF = new JFrame("��ʾ");
                            tipJF.setSize(250,150);
                            tipJF.setLocationRelativeTo(null);
                            JLabel tipJL = new JLabel("�����������е���Ϣ֮���ٵ���ύ");
                            tipJF.add(tipJL);
                            tipJF.setVisible(true);
                        }else {
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
                            JFrame addSuccessfulJF = new JFrame("��ʾ");
                            addSuccessfulJF.setLocationRelativeTo(null);
                            addSuccessfulJF.setSize(260, 100);
                            addSuccessfulJF.setVisible(true);
                            addSuccessfulJF.setLayout(new FlowLayout());
                            JLabel SuccessfulJL = new JLabel("���ѧ����Ϣ�ɹ���");
                            addSuccessfulJF.add(SuccessfulJL);
                        }
                    }
                });
            }
        });
        jbDelete.addMouseListener(new MouseAdapter() {
            JTextField numJTF = null;
            JTextField nameJTF = null;
            @Override
            public void mouseClicked(MouseEvent e) {
                final JFrame deleteJF = new JFrame("ɾ��");
                deleteJF.setLayout(new FlowLayout());
                deleteJF.setSize(280, 180);
                deleteJF.setVisible(true);
                deleteJF.setLocationRelativeTo(null);
                JLabel numJL = new JLabel("ѧ��:");
                numJTF = new JTextField(20);
                JLabel nameJL= new JLabel("����:");
                nameJTF = new JTextField(20);
                JButton numJB = new JButton("�ύ");
                deleteJF.add(numJL);
                deleteJF.add(numJTF);
                deleteJF.add(nameJL);
                deleteJF.add(nameJTF);
                deleteJF.add(numJB);
                numJB.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e) {
//                        Integer sNumI = new Integer(numJTF.getText().toString());
                        String sNumI = numJTF.getText();
                        String sName = nameJTF.getText();
                        boolean flag = database.deleteStuInfo(sNumI, sName);
                        if(flag){
                            deleteJF.dispose();
                            JFrame deleteSuccessfulJF = new JFrame("��ʾ");
                            deleteSuccessfulJF.setLocationRelativeTo(null);
                            deleteSuccessfulJF.setSize(260, 100);
                            deleteSuccessfulJF.setVisible(true);
                            deleteSuccessfulJF.setLayout(new FlowLayout());
                            JLabel SuccessfulJL = new JLabel("ɾ��ѧ����Ϣ�ɹ���");
                            deleteSuccessfulJF.add(SuccessfulJL);
                        }
                        else {
                            JFrame tipJF = new JFrame("��ʾ");
                            tipJF.setSize(250,150);
                            tipJF.setLocationRelativeTo(null);
                            JLabel tipJL = new JLabel("û�и�ѧ��");
                            tipJF.add(tipJL);
                            tipJF.setVisible(true);
                        }
                    }
                });
            }
        });

        //�޸�ѧ����Ϣ
        jbModify.addMouseListener(new MouseAdapter(){
            JTextField num1JTF = null;
            JTextField name1JTF = null;
            @Override
            public void mouseClicked(MouseEvent e) {
                final JFrame modifyJF = new JFrame("�޸�");
                modifyJF.setSize(280, 180);
                modifyJF.setLocationRelativeTo(null);
                modifyJF.setLayout(new FlowLayout());
                modifyJF.setVisible(true);
                JLabel numJL = new JLabel("ѧ��:");
                num1JTF = new JTextField(20);
                JLabel nameJL= new JLabel("����:");
                name1JTF = new JTextField(20);
                JButton numJB = new JButton("�ύ");
                modifyJF.add(numJL);
                modifyJF.add(num1JTF);
                modifyJF.add(nameJL);
                modifyJF.add(name1JTF);
                modifyJF.add(numJB);
                numJB.addMouseListener(new MouseAdapter() {
//                    JTextField numJTF = null;
//                    JTextField nameJTF = null;
                    JTextField ageJTF = null;
                    JTextField genderJTF = null;
                    JTextField schoolJTF = null;
                    JTextField classJTF = null;
                    JTextField professionalJTF = null;
//                    String tempNum = null;
//                    String tempName = null;
                    String tempAge = null;
                    String tempGender = null;
                    String tempSchool = null;
                    String tempClass = null;
                    String tempProfessional = null;
//                    Connection conn = null;
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //��ѯѧ����Ϣ
//                        Integer sNum = new Integer(num1JTF.getText().toString());
                        String sNum = num1JTF.getText();
                        String sName = name1JTF.getText();
                        int index = database.selectStuInfo(sNum, sName);
                        if(index==-1){
                            JFrame tipJF = new JFrame("��ʾ");
                            tipJF.setSize(270,150);
                            tipJF.setLocationRelativeTo(null);
                            JLabel tipJL = new JLabel("û�и�ѧ��");
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
//                        JLabel numJL = new JLabel("ѧ�ţ�");
//                        numJTF = new JTextField(20);
//                        JLabel nameJL = new JLabel("������");
//                        nameJTF = new JTextField(20);
                        JLabel ageJL = new JLabel("���䣺");
                        ageJTF = new JTextField(20);
                        JLabel genderJL = new JLabel("�Ա�");
                        genderJTF = new JTextField(20);
                        JLabel schoolJL = new JLabel("ѧУ��");
                        schoolJTF = new JTextField(20);
                        JLabel classJL = new JLabel("�༶��");
                        classJTF = new JTextField(20);
                        JLabel professionalJL = new JLabel("רҵ��");
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
//                        final Student stuRet = stu.queryStuInfo(sNum);

//                        numJTF.setText(sNum);
//                        nameJTF.setText(sName);
                        ageJTF.setText(student.getAge()+"");
                        genderJTF.setText(student.getGender());
                        schoolJTF.setText(student.getSchool());
                        classJTF.setText(student.getGrade());
                        professionalJTF.setText(student.getMajor());

                        JButton submitJB = new JButton("�ύ�޸�");
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
                                JFrame updateSucessfulJF = new JFrame("��ʾ");
                                updateSucessfulJF.setLocationRelativeTo(null);
                                updateSucessfulJF.setSize(260, 100);
                                updateSucessfulJF.setVisible(true);
                                updateSucessfulJF.setLayout(new FlowLayout());
                                JLabel SuccessfulJL = new JLabel("�޸�ѧ����Ϣ�ɹ���");
                                updateSucessfulJF.add(SuccessfulJL);
                            }

                        });
                        modifyJF.dispose();
                    }
                });
            }
        });

        //��ѯѧ����Ϣ
        jbQuery.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //��ʾ���е�ѧ����Ϣ
                showAllStuInfo();
//                JFrame selectAllJF = new JFrame("��ʾ");
//                selectAllJF.setLocationRelativeTo(null);
//                selectAllJF.setSize(300, 200);
//                selectAllJF.setVisible(true);
//                selectAllJF.setLayout(new FlowLayout());
//                JLabel SuccessfulJL = new JLabel("��ѯѧ����Ϣ�ɹ���");
//                selectAllJF.add(SuccessfulJL);
            }
        });
    }



    public void showAllStuInfo(){
        stuInfoListJTA.setText("");
        ArrayList<Student> students = database.readFile();
        for (Student student : students) {
            String number = student.getNumber();
            String name = student.getName();
            int age = student.getAge();
            String gender = student.getGender();
            String school = student.getSchool();
            String grade = student.getGrade();
            String major = student.getMajor();
            stuInfoListJTA.setText(stuInfoListJTA.getText()
            +String.format("%-25s",number)+String.format("%-23s",name)+String.format("%-23s",age+"")+ String.format("%-23s",gender)
                    +String.format("%-23s",school)+String.format("%-23s",grade)+String.format("%-23s",major)+"\n");
//            stuInfoListJTA.setText(stuInfoListJTA.getText()
//                    +number+setStringLen(number.getBytes().length)
//                    +name+setStringLen(name.getBytes().length)
//                    +age+setStringLen((age+"").getBytes().length)
//                    +gender+setStringLen(gender.getBytes().length)
//                    +school+setStringLen(school.getBytes().length)
//                    +grade+setStringLen(gender.getBytes().length)
//                    +major+setStringLen(major.getBytes().length)+"\n");
        }
    }
//    public String setStringLen(int len) {
//        String string = "";
//        for(int i = 0; i < 23-len; ++i) {
//            string += " ";
//        }
//        return string;
//    }




    public static void main(String[] args) {
        ShowStuInfoFrame show = new ShowStuInfoFrame();
        show.database.closeConnection();
    }
}
