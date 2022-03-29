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

        JButton jbAdd = new JButton("���ѧ��");
        jbAdd.setBounds(25, 10, 120, 30);
        jbAdd.setBackground(Color.gray);

        JButton jbDelete = new JButton("ɾ��ѧ��");
        jbDelete.setBounds(195, 10, 120, 30);
        jbDelete.setBackground(Color.gray);

        JButton jbModify = new JButton("�޸�ѧ��");
        jbModify.setBounds(365, 10, 120, 30);
        jbModify.setBackground(Color.gray);

        JButton jbQuery = new JButton("��ѯ//ˢ��");
        jbQuery.setBounds(535, 10, 120, 30);
        jbQuery.setBackground(Color.gray);

        JButton jbDeleteSelect= new JButton("ɾ��ѡ��");
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

        JLabel numHeadJL = new JLabel("ѧ  ��");
        numHeadJL.setBackground(Color.gray);
        numHeadJL.setBounds(52, 0, 100, 25);


        JLabel nameHeadJL = new JLabel("��  ��");
        nameHeadJL.setBackground(Color.gray);
        nameHeadJL.setBounds(162, 0, 100, 25);

        JLabel ageHeadJL = new JLabel("��  ��");
        ageHeadJL.setBackground(Color.gray);
        ageHeadJL.setBounds(272, 0, 100, 25);

        JLabel genderHeadJL = new JLabel("��  ��");
        genderHeadJL.setBackground(Color.gray);
        genderHeadJL.setBounds(382, 0, 100, 25);

        JLabel schoolHeadJL = new JLabel("ѧУ");
        schoolHeadJL.setBackground(Color.gray);
        schoolHeadJL.setBounds(492, 0, 100, 25);

        JLabel classHeadJL = new JLabel("��  ��");
        classHeadJL.setBackground(Color.gray);
        classHeadJL.setBounds(602, 0, 100, 25);

        JLabel professionalHeadJL = new JLabel("ר  ҵ");
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
        JButton decrease = new JButton("��������");
        decrease.setBackground(Color.PINK);
        panel.add(decrease);
        JButton saveModify = new JButton("�����޸�");
        saveModify.setBackground(Color.CYAN);
        panel.add(saveModify);
        JButton clearAll = new JButton("ɾ������");
        clearAll.setBackground(Color.CYAN);
        panel.add(clearAll);
        JButton increase = new JButton("���併��");
        increase.setBackground(Color.PINK);
        panel.add(increase);
        this.add(titleJL);
        this.add(buttonJP);
        this.add(listHeadJP);
        this.add(jsp);
        this.add(panel);
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
                            try {
                                stu2.setAge(Integer.parseInt(sageAdd));
                            } catch (NumberFormatException ex) {
                                JFrame addFail = new JFrame("��ʾ");
                                addFail.setLocationRelativeTo(null);
                                addFail.setSize(260, 100);
                                addFail.setVisible(true);
                                addFail.setLayout(new FlowLayout());
                                JLabel SuccessfulJL = new JLabel("����ĸ�ʽ����!!!");
                                addFail.add(SuccessfulJL);
                                return;
                            }
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

        //ɾ��ѧ��
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


        //ɾ��ѡ��
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
                    JTextField ageJTF = null;
                    JTextField genderJTF = null;
                    JTextField schoolJTF = null;
                    JTextField classJTF = null;
                    JTextField professionalJTF = null;
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        //��ѯѧ����Ϣ
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
            }
        });
        //�����޸�
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
                        JFrame modifyFail = new JFrame("����");
                        modifyFail.setLocationRelativeTo(null);
                        modifyFail.setSize(300, 120);
                        modifyFail.setVisible(true);
                        modifyFail.setLayout(new FlowLayout());
                        Font font1 = new Font("����",Font.BOLD,25);
                        JLabel modify = new JLabel("������ĸ�ʽ����ȷ!!!");
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
                JFrame modifySuccess = new JFrame("��ʾ");
                modifySuccess.setLocationRelativeTo(null);
                modifySuccess.setSize(260, 100);
                modifySuccess.setVisible(true);
                modifySuccess.setLayout(new FlowLayout());
                JLabel SuccessfulJL = new JLabel("�޸�ѧ����Ϣ�ɹ���");
                modifySuccess.add(SuccessfulJL);
            }
        });

        //�������
        clearAll.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame clear = new JFrame("����");
                clear.setLayout(null);
                JPanel clearPanel = new JPanel();
                clearPanel.setLayout(null);
                clearPanel.setBounds(5, 0, 390, 190);
                clear.setLocationRelativeTo(null);
                clear.setSize(400, 200);
                clear.setVisible(true);
                Font font1 = new Font("����", Font.BOLD, 25);
                JLabel modify = new JLabel("��ȷ��Ҫ���������Ϣ��");
                modify.setBounds(25, 10, 380, 50);
                JButton yes = new JButton("ȷ��");
                yes.setBounds(20, 110, 100, 30);
                JButton no = new JButton("ȡ��");
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

        //���併��
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

        ///��������
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
