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

        //������ⲿ��
        JLabel titleJL = new JLabel("ѧ������ϵͳ");
        Font font = new Font("΢���ź�", 1, 15);
        titleJL.setFont(font);
        titleJL.setLayout(null);
        titleJL.setBounds(350, 10, 100, 20);

        //��ť����
        JPanel buttonJP = new JPanel();
        buttonJP.setLayout(null);
        buttonJP.setBounds(0, 50, 800, 40);

        JButton jbAdd = new JButton("���ѧ��");
        jbAdd.setBounds(25, 10, 120, 30);
        jbAdd.setBackground(Color.gray);

        JButton jbDelete = new JButton("ɾ��ѧ��");
        jbDelete.setBounds(185, 10, 120, 30);
        jbDelete.setBackground(Color.gray);

        JButton jbModify = new JButton("�޸�ѡ��");
        jbModify.setBounds(340, 10, 120, 30);
        jbModify.setBackground(Color.gray);

        JButton jbQuery = new JButton("��ѯѡ��");
        jbQuery.setBounds(520, 10, 120, 30);
        jbQuery.setBackground(Color.gray);

        JButton jbDeleteSelect= new JButton("ɾ��ѡ��");
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

        JLabel numHeadJL = new JLabel("ѧ  ��");
        numHeadJL.setBackground(Color.gray);
        numHeadJL.setBounds(100, 0, 100, 25);


        JLabel nameHeadJL = new JLabel("��  ��");
        nameHeadJL.setBackground(Color.gray);
        nameHeadJL.setBounds(293, 0, 100, 25);


        JLabel genderHeadJL = new JLabel("��  ��");
        genderHeadJL.setBackground(Color.gray);
        genderHeadJL.setBounds(492, 0, 100, 25);

        JLabel ageHeadJL = new JLabel("��  ��");
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
                            tipJF.setSize(280,150);
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
                            showAllStuInfo();
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
                        int index = database.selectStuInfo(sNumI, sName);
                        boolean flag = database.deleteStuInfo(sNumI, sName);
                        DefaultTableModel model = (DefaultTableModel) jt.getModel();
                        if(flag&&index>=0){
                            model.removeRow(index);
                            deleteJF.dispose();
                            JFrame deleteSuccessfulJF = new JFrame("��ʾ");
                            deleteSuccessfulJF.setLocationRelativeTo(null);
                            deleteSuccessfulJF.setSize(280, 100);
                            deleteSuccessfulJF.setVisible(true);
                            deleteSuccessfulJF.setLayout(new FlowLayout());
                            JLabel SuccessfulJL = new JLabel("ɾ��ѧ����Ϣ�ɹ���");
                            deleteSuccessfulJF.add(SuccessfulJL);
                        }
                        else {
                            JFrame tipJF = new JFrame("��ʾ");
                            tipJF.setSize(280,150);
                            tipJF.setLocationRelativeTo(null);
                            JLabel tipJL = new JLabel("û�и�ѧ��!");
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

        //�޸�ѡ��ѧ����Ϣ
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
                final JFrame modifyJF = new JFrame("�޸�");
                modifyJF.setSize(300, 400);
                modifyJF.setBackground(Color.gray);
                modifyJF.setLocationRelativeTo(null);
                modifyJF.setLayout(new FlowLayout());
                JLabel numJL = new JLabel("ѧ�ţ�");
                numJTF = new JTextField(20);
                numJTF.setText(student.getNumber());
                JLabel nameJL = new JLabel("������");
                nameJTF = new JTextField(20);
                nameJTF.setText(student.getName());
                JLabel ageJL = new JLabel("���䣺");
                ageJTF = new JTextField(20);
                ageJTF.setText(student.getAge()+"");
                JLabel genderJL = new JLabel("�Ա�");
                genderJTF = new JTextField(20);
                genderJTF.setText(student.getGender());
                JLabel schoolJL = new JLabel("ѧУ��");
                schoolJTF = new JTextField(20);
                schoolJTF.setText(student.getSchool());
                JLabel classJL = new JLabel("�༶��");
                classJTF = new JTextField(20);
                classJTF.setText(student.getGrade());
                JLabel professionalJL = new JLabel("רҵ��");
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
                JButton submitJB = new JButton("�ύ�޸�");
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
                            student.setNumber(snumAdd);
                            student.setName(snameAdd);
                            try {
                                student.setAge(Integer.parseInt(sageAdd));
                            } catch (NumberFormatException ex) {
                                JFrame addFail = new JFrame("��ʾ");
                                addFail.setLocationRelativeTo(null);
                                addFail.setSize(260, 100);
                                addFail.setVisible(true);
                                addFail.setLayout(new FlowLayout());
                                JLabel failJL = new JLabel("����ĸ�ʽ����!!!");
                                addFail.add(failJL);
                                return;
                            }
                            student.setGender(sgenderAdd);
                            student.setSchool(sschoolAdd);
                            student.setGrade(sclassAdd);
                            student.setMajor(sprofessionalAdd);
                            database.writeFile(students);
                            modifyJF.dispose();
                            JFrame modifySuccessfulJF = new JFrame("��ʾ");
                            modifySuccessfulJF.setLocationRelativeTo(null);
                            modifySuccessfulJF.setSize(260, 100);
                            modifySuccessfulJF.setVisible(true);
                            modifySuccessfulJF.setLayout(new FlowLayout());
                            JLabel SuccessfulJL = new JLabel("�޸�ѧ����Ϣ�ɹ���");
                            modifySuccessfulJF.add(SuccessfulJL);
                            showAllStuInfo();
                        }
                    }
                });
            }
        });

        //��ѯѡ��ѧ����Ϣ
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
                JLabel numJL = new JLabel("ѧ�ţ�");
                numJTF = new JTextField(20);
                numJTF.setText(student.getNumber());
                numJTF.setEnabled(false);
                JLabel nameJL = new JLabel("������");
                nameJTF = new JTextField(20);
                nameJTF.setText(student.getName());
                nameJTF.setEnabled(false);
                JLabel ageJL = new JLabel("���䣺");
                ageJTF = new JTextField(20);
                ageJTF.setText(student.getAge()+"");
                ageJTF.setEnabled(false);
                JLabel genderJL = new JLabel("�Ա�");
                genderJTF = new JTextField(20);
                genderJTF.setText(student.getGender());
                genderJTF.setEnabled(false);
                JLabel schoolJL = new JLabel("ѧУ��");
                schoolJTF = new JTextField(20);
                schoolJTF.setText(student.getSchool());
                schoolJTF.setEnabled(false);
                JLabel classJL = new JLabel("�༶��");
                classJTF = new JTextField(20);
                classJTF.setText(student.getGrade());
                classJTF.setEnabled(false);
                JLabel professionalJL = new JLabel("רҵ��");
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
        //�����޸�
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
                    students.get(i).setGender((String) jt.getValueAt(i,2));
                }
                database.writeFile(students);
                DefaultTableModel model = (DefaultTableModel) jt.getModel();
                for (int i = 0; i < jt.getRowCount(); i++) {
                    model.removeRow(i);
                }
                model.setRowCount(50);
                JFrame modifySuccess = new JFrame("��ʾ");
                modifySuccess.setLocationRelativeTo(null);
                modifySuccess.setSize(260, 100);
                modifySuccess.setVisible(true);
                modifySuccess.setLayout(new FlowLayout());
                JLabel SuccessfulJL = new JLabel("�޸�ѧ����Ϣ�ɹ���");
                modifySuccess.add(SuccessfulJL);
                showAllStuInfo();
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
