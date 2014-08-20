/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainPage.java
 *
 * Created on Mar 11, 2014, 10:25:54 PM
 */
/**
 *
 * @author BJOSHI
 */
import java.io.BufferedReader;
import javax.swing.table.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.*;
class Utility {
    Connection con;
    String DbUrl;
    Statement smt;
    static ResultSet rs;
    static ResultSetMetaData rsm;
    String DbUser,DbPass;
    
     Utility(String Url,String U,String Pass){
         DbUrl=Url;
         con=null;
        smt=null;
        DbUser=U;
        DbPass=Pass;
        rs=null;
        
    }
     void Update(String Url,String U,String Pass){
         DbUrl=Url;
         con=null;
        smt=null;
        DbUser=U;
        DbPass=Pass;
        rs=null;
        
    }
     
     boolean TestConnection(String str){
        
         try {
             System.out.println(DbPass);
                 System.out.println(DbUser);
                 System.out.println(DbUrl);
                 con = DriverManager.getConnection(DbUrl, DbUser, DbPass);
               
                 smt = con.createStatement();
             
                 rs = smt.executeQuery(str);//"select * from user where");
                 
                
                 if(rs!=null) {
                     return true;
                 }
                 else{
                     return false;
                 }
          } 
         catch (SQLException ex) {
                 // logging
                         JOptionPane.showMessageDialog(null,"Sql error");
                         
                         return false;

          }
         finally {
             try {
                    if (rs != null) {
                   rs.close();
                }
             if (smt != null) {
                    smt.close();
                }   
             if (con != null) {
                    con.close();
                }
             } catch (SQLException ex) {
                     
             }
         }
         
     }
     
       boolean ExceuteUpdate(String str){
        
         try {
             System.out.println(DbPass);
                 System.out.println(DbUser);
                 System.out.println(DbUrl);
                 con = DriverManager.getConnection(DbUrl, DbUser, DbPass);
               
                 smt = con.createStatement();
             
                 smt.executeUpdate(str);//"select * from user where");
           
                
                 return true;
          } 
         catch (SQLException ex) {
                 // logging
                         JOptionPane.showMessageDialog(null,"Sql error");
                         
                         return false;

          }
         finally {
             try {
                    if (rs != null) {
                   rs.close();
                }
             if (smt != null) {
                    smt.close();
                }   
             if (con != null) {
                    con.close();
                }
             } catch (SQLException ex) {
                     
             }
         }
         
     }
       boolean ExceuteSelect(String str){
         Globals.QueryResult=new ArrayList<ArrayList>();
         Globals.TableHeaderName=new ArrayList();
         try {
                 con = DriverManager.getConnection(DbUrl, DbUser, DbPass);
                 smt = con.createStatement();
                 System.out.println("test1");
                 rs = smt.executeQuery(str);
                 System.out.println("test1");
                 rsm=rs.getMetaData();
                 System.out.println("test1");
                 Globals.TableColumnCount=rsm.getColumnCount();
                 System.out.println("test1");
                    for(int i=0;i<Globals.TableColumnCount;i++)
                    {
                        
                       Globals.TableHeaderName.add(rsm.getColumnName(i+1));
                        System.out.println(Globals.TableHeaderName.get(i));
                    }
                    System.out.println("test1");
                 while (rs.next()) {
                     ArrayList temp=new ArrayList();
                     for(int i=1;i<Globals.TableColumnCount+1;i++)
                        {
                           temp.add(rs.getString(i));
                           System.out.println("---"+rs.getString(i));
                          System.out.println(temp);
                            //System.out.println("test "+(i+1));
                        }
                 Globals.QueryResult.add(temp);
                 System.out.println("test2");
            }
                 System.out.println("test3");
                 return true;
          } 
         catch (SQLException ex) {
                 // logging
                JOptionPane.showMessageDialog(null,"Sql error");
                 return false;
          }
         finally {
             try {
                    if (rs != null) {
                   rs.close();
                }
             if (smt != null) {
                    smt.close();
                }   
             if (con != null) {
                    con.close();
                }
             } catch (SQLException ex) {
                     
             }
         }
         
     }
     
}

class Globals{
    static Utility U1=null;
    static ArrayList<ArrayList> QueryResult = null;
    static int TableColumnCount;
    static ArrayList TableHeaderName = null;
    static boolean AllowManageAccess=false;
}
public class MainPage extends javax.swing.JFrame {

    /** Creates new form MainPage */
    public MainPage() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainOpWindow = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DBTableList = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        OpList = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        DBConnectivity = new javax.swing.JFrame();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        HNTF = new javax.swing.JTextField();
        HPTF = new javax.swing.JTextField();
        UnameTF = new javax.swing.JTextField();
        DBTF = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        PassPW = new javax.swing.JPasswordField();
        CDBWin = new javax.swing.JFrame();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        DBname = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        DbTable = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        CTableWin = new javax.swing.JFrame();
        jLabel18 = new javax.swing.JLabel();
        NTableName = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        NCname = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        NColumnType = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        NColumnConstraint = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        CFKWin = new javax.swing.JFrame();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        FTName = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        FCName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        PTName = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        PCName = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        CPKWin = new javax.swing.JFrame();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        PKColumn = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        PKTable = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        CCustomWin = new javax.swing.JFrame();
        jLabel22 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        CustomQuery = new javax.swing.JTextArea();
        STableWin = new javax.swing.JFrame();
        jScrollPane4 = new javax.swing.JScrollPane();
        STableTable = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        NCname3 = new javax.swing.JTextField();
        CColumnWin = new javax.swing.JFrame();
        NColumnConstraint1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        NColumnType1 = new javax.swing.JTextField();
        NTableName1 = new javax.swing.JTextField();
        jButton21 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        NCname1 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        CDropCWin = new javax.swing.JFrame();
        NTableName2 = new javax.swing.JTextField();
        jButton23 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jButton24 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        NCname2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        DBSetting = new javax.swing.JButton();
        MDB = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        MainOpWindow.setMinimumSize(new java.awt.Dimension(640, 480));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel1.setText("Welcome To JavaMySQL Utility");

        DBTableList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Table Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(DBTableList);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel3.setText("   Select Operation ");

        OpList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Create Database", "Create Table", "Show Table", "Add Column", "Drop Column", "Add Primary Key", "Add Foreign Key", "Custom Query Execution" }));
        OpList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpListActionPerformed(evt);
            }
        });

        jButton3.setText("Perform Operation");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Reload Table List");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("BACK");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("EXIT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainOpWindowLayout = new javax.swing.GroupLayout(MainOpWindow.getContentPane());
        MainOpWindow.getContentPane().setLayout(MainOpWindowLayout);
        MainOpWindowLayout.setHorizontalGroup(
            MainOpWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainOpWindowLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addGroup(MainOpWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OpList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainOpWindowLayout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(116, 116, 116))
        );
        MainOpWindowLayout.setVerticalGroup(
            MainOpWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainOpWindowLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(MainOpWindowLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainOpWindowLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(OpList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        DBConnectivity.setMinimumSize(new java.awt.Dimension(540, 400));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel5.setText("WelCome To JavaMySQL Utility");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel6.setText("Enter Host Name Here");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel7.setText("Host Port(Usually 3306)");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel8.setText("Enter Username Here");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel9.setText("Enter Password Here");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel10.setText("Enter Database To Use");

        HNTF.setText("localhost");
        HNTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HNTFActionPerformed(evt);
            }
        });

        HPTF.setText("3306");
        HPTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HPTFActionPerformed(evt);
            }
        });

        UnameTF.setText("root");
        UnameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UnameTFActionPerformed(evt);
            }
        });

        DBTF.setText("jMySql");
        DBTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DBTFActionPerformed(evt);
            }
        });

        jButton8.setText("Save And Test");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("BACK");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("EXIT");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        PassPW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassPWActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DBConnectivityLayout = new javax.swing.GroupLayout(DBConnectivity.getContentPane());
        DBConnectivity.getContentPane().setLayout(DBConnectivityLayout);
        DBConnectivityLayout.setHorizontalGroup(
            DBConnectivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DBConnectivityLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(DBConnectivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DBConnectivityLayout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DBConnectivityLayout.createSequentialGroup()
                        .addGroup(DBConnectivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addGroup(DBConnectivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HPTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HNTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DBConnectivityLayout.createSequentialGroup()
                        .addGroup(DBConnectivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DBConnectivityLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE))
                            .addComponent(jLabel9)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
                        .addGroup(DBConnectivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UnameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(DBTF, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(PassPW))))
                .addGap(25, 25, 25))
            .addGroup(DBConnectivityLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel5)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        DBConnectivityLayout.setVerticalGroup(
            DBConnectivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DBConnectivityLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(DBConnectivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HNTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(21, 21, 21)
                .addGroup(DBConnectivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HPTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(DBConnectivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UnameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(DBConnectivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(PassPW, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DBConnectivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DBTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(DBConnectivityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10)
                    .addComponent(jButton9)
                    .addComponent(jButton8))
                .addGap(30, 30, 30))
        );

        CDBWin.setMinimumSize(new java.awt.Dimension(420, 420));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel11.setText("WelCome To JavaMySQL Utility");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel12.setText("Enter Name Of Database");

        DBname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DBnameActionPerformed(evt);
            }
        });

        DbTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Database Added"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(DbTable);

        jButton11.setText("Add Database");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("BACK");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CDBWinLayout = new javax.swing.GroupLayout(CDBWin.getContentPane());
        CDBWin.getContentPane().setLayout(CDBWinLayout);
        CDBWinLayout.setHorizontalGroup(
            CDBWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CDBWinLayout.createSequentialGroup()
                .addGroup(CDBWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CDBWinLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CDBWinLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel11))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CDBWinLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12)
                        .addGap(68, 68, 68)
                        .addComponent(DBname, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CDBWinLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        CDBWinLayout.setVerticalGroup(
            CDBWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CDBWinLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(CDBWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(DBname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(CDBWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(jButton12))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        CTableWin.setMinimumSize(new java.awt.Dimension(420, 350));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel18.setText("Enter Name Of Table");

        NTableName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NTableNameActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel23.setText("WelCome To JavaMySQL Utility");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel24.setText("Name Of First Column");

        NCname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NCnameActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel25.setText("Type Of First Column");

        NColumnType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NColumnTypeActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel26.setText("Constraint On First Column");

        NColumnConstraint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NColumnConstraintActionPerformed(evt);
            }
        });

        jButton19.setText("Create Table With Initial Column");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setText("BACK");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CTableWinLayout = new javax.swing.GroupLayout(CTableWin.getContentPane());
        CTableWin.getContentPane().setLayout(CTableWinLayout);
        CTableWinLayout.setHorizontalGroup(
            CTableWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CTableWinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CTableWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CTableWinLayout.createSequentialGroup()
                        .addComponent(jButton19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CTableWinLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel23))
                    .addGroup(CTableWinLayout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(NTableName, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                    .addGroup(CTableWinLayout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NCname, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                    .addGroup(CTableWinLayout.createSequentialGroup()
                        .addGroup(CTableWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(29, 29, 29)
                        .addGroup(CTableWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NColumnType, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(NColumnConstraint, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))))
                .addGap(38, 38, 38))
        );
        CTableWinLayout.setVerticalGroup(
            CTableWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CTableWinLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(CTableWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(NTableName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CTableWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(NCname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CTableWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(NColumnType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CTableWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(NColumnConstraint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(CTableWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19)
                    .addComponent(jButton20))
                .addGap(21, 21, 21))
        );

        CFKWin.setMinimumSize(new java.awt.Dimension(440, 340));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel13.setText("Enter Foreign Key Table");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel14.setText("WelCome To JavaMySQL Utility");

        FTName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FTNameActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel15.setText("Enter Foreign Key Column");

        FCName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FCNameActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel16.setText("Enter Primary Key Table");

        PTName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PTNameActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel17.setText("Enter Primary Key Column");

        PCName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PCNameActionPerformed(evt);
            }
        });

        jButton13.setText("Add Foreign Key");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("BACK");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CFKWinLayout = new javax.swing.GroupLayout(CFKWin.getContentPane());
        CFKWin.getContentPane().setLayout(CFKWinLayout);
        CFKWinLayout.setHorizontalGroup(
            CFKWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CFKWinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CFKWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CFKWinLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel14))
                    .addGroup(CFKWinLayout.createSequentialGroup()
                        .addGroup(CFKWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15))
                        .addGap(51, 51, 51)
                        .addGroup(CFKWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PCName, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(PTName, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(FCName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(FTName, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))))
                .addGap(15, 15, 15))
            .addGroup(CFKWinLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        CFKWinLayout.setVerticalGroup(
            CFKWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CFKWinLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(CFKWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(FTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CFKWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FCName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CFKWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(PTName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CFKWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(PCName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CFKWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13)
                    .addComponent(jButton14))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        CPKWin.setMinimumSize(new java.awt.Dimension(400, 270));

        jButton15.setText("BACK");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Add Primary Key");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        PKColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PKColumnActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel19.setText("WelCome To JavaMySQL Utility");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel20.setText("Enter Primary Key Table");

        PKTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PKTableActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel21.setText("Enter Primary Key Column");

        javax.swing.GroupLayout CPKWinLayout = new javax.swing.GroupLayout(CPKWin.getContentPane());
        CPKWin.getContentPane().setLayout(CPKWinLayout);
        CPKWinLayout.setHorizontalGroup(
            CPKWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CPKWinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CPKWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CPKWinLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addContainerGap(238, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CPKWinLayout.createSequentialGroup()
                        .addGroup(CPKWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CPKWinLayout.createSequentialGroup()
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CPKWinLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel19))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CPKWinLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(51, 51, 51)
                                .addGroup(CPKWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PKColumn, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                    .addComponent(PKTable, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        CPKWinLayout.setVerticalGroup(
            CPKWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CPKWinLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(CPKWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(PKTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CPKWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PKColumn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(26, 26, 26)
                .addGroup(CPKWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16)
                    .addComponent(jButton15))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        CCustomWin.setMinimumSize(new java.awt.Dimension(400, 300));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel22.setText("WelCome To JavaMySQL Utility");

        jButton17.setText("Execute");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("BACK");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        CustomQuery.setColumns(20);
        CustomQuery.setRows(5);
        CustomQuery.setText("Enter Your Custom query and hit Exceute.");
        jScrollPane3.setViewportView(CustomQuery);

        javax.swing.GroupLayout CCustomWinLayout = new javax.swing.GroupLayout(CCustomWin.getContentPane());
        CCustomWin.getContentPane().setLayout(CCustomWinLayout);
        CCustomWinLayout.setHorizontalGroup(
            CCustomWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CCustomWinLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel22)
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(CCustomWinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(CCustomWinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        CCustomWinLayout.setVerticalGroup(
            CCustomWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CCustomWinLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(CCustomWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17)
                    .addComponent(jButton18))
                .addGap(31, 31, 31))
        );

        STableWin.setMinimumSize(new java.awt.Dimension(380, 640));

        STableTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(STableTable);

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel35.setText("WelCome To JavaMySQL Utility");

        jButton25.setText("Execute");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setText("BACK");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel36.setText("Enter Table To View");

        javax.swing.GroupLayout STableWinLayout = new javax.swing.GroupLayout(STableWin.getContentPane());
        STableWin.getContentPane().setLayout(STableWinLayout);
        STableWinLayout.setHorizontalGroup(
            STableWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(STableWinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(STableWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(STableWinLayout.createSequentialGroup()
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, 0, 0, Short.MAX_VALUE)
                    .addGroup(STableWinLayout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(NCname3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        STableWinLayout.setVerticalGroup(
            STableWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(STableWinLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(STableWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NCname3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(STableWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton25)
                    .addComponent(jButton26))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        CColumnWin.setMinimumSize(new java.awt.Dimension(420, 340));

        NColumnConstraint1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NColumnConstraint1ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel27.setText("Constraint On new Column");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel28.setText("Enter Name Of Table");

        NColumnType1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NColumnType1ActionPerformed(evt);
            }
        });

        NTableName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NTableName1ActionPerformed(evt);
            }
        });

        jButton21.setText("Add New Column");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel29.setText("WelCome To JavaMySQL Utility");

        jButton22.setText("BACK");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel30.setText("Enter Column Name");

        NCname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NCname1ActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel31.setText("Enter Column type");

        javax.swing.GroupLayout CColumnWinLayout = new javax.swing.GroupLayout(CColumnWin.getContentPane());
        CColumnWin.getContentPane().setLayout(CColumnWinLayout);
        CColumnWinLayout.setHorizontalGroup(
            CColumnWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(CColumnWinLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CColumnWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CColumnWinLayout.createSequentialGroup()
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CColumnWinLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel29))
                    .addGroup(CColumnWinLayout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(NTableName1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                    .addGroup(CColumnWinLayout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NCname1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                    .addGroup(CColumnWinLayout.createSequentialGroup()
                        .addGroup(CColumnWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(29, 29, 29)
                        .addGroup(CColumnWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NColumnType1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(NColumnConstraint1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))))
                .addGap(38, 38, 38))
        );
        CColumnWinLayout.setVerticalGroup(
            CColumnWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(CColumnWinLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(CColumnWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(NTableName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CColumnWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(NCname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CColumnWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(NColumnType1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CColumnWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(NColumnConstraint1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(CColumnWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton21)
                    .addComponent(jButton22))
                .addGap(21, 21, 21))
        );

        CDropCWin.setMinimumSize(new java.awt.Dimension(380, 280));

        NTableName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NTableName2ActionPerformed(evt);
            }
        });

        jButton23.setText("BACK");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel32.setText("Enter Column Name");

        jButton24.setText("Drop Column");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel33.setText("WelCome To JavaMySQL Utility");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel34.setText("Enter Name Of Table");

        NCname2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NCname2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CDropCWinLayout = new javax.swing.GroupLayout(CDropCWin.getContentPane());
        CDropCWin.getContentPane().setLayout(CDropCWinLayout);
        CDropCWinLayout.setHorizontalGroup(
            CDropCWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CDropCWinLayout.createSequentialGroup()
                .addGroup(CDropCWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CDropCWinLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(CDropCWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CDropCWinLayout.createSequentialGroup()
                                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CDropCWinLayout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(NTableName2, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                            .addGroup(CDropCWinLayout.createSequentialGroup()
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(NCname2, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))))
                    .addGroup(CDropCWinLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel33)))
                .addContainerGap())
        );
        CDropCWinLayout.setVerticalGroup(
            CDropCWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CDropCWinLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(CDropCWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(NTableName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CDropCWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(NCname2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(CDropCWinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton24)
                    .addComponent(jButton23))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24));
        jLabel4.setText("WelCome To JavaMySQL Utility");

        DBSetting.setText("Connectivity And Database");
        DBSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DBSettingActionPerformed(evt);
            }
        });

        MDB.setText("Manage Database");
        MDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MDBActionPerformed(evt);
            }
        });

        jButton7.setText("EXIT");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(MDB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DBSetting, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(DBSetting, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(MDB, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void OpListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpListActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_OpListActionPerformed

private void DBSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DBSettingActionPerformed
// TODO add your handling code here:
this.setVisible(false);
DBConnectivity.setVisible(true);
}//GEN-LAST:event_DBSettingActionPerformed

private void MDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MDBActionPerformed
if(Globals.AllowManageAccess==false)
{
    JOptionPane.showMessageDialog(null,"Please Enter Database Settings First");
    return;
}// TODO add your handling code here:
this.setVisible(false);
MainOpWindow.setVisible(true);
}//GEN-LAST:event_MDBActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
// TODO add your handling code here:
int SelectedOp = OpList.getSelectedIndex();
switch(SelectedOp){
    case 0:
            DefaultTableModel Tmodel = (DefaultTableModel) DbTable.getModel();
            int rows = Tmodel.getRowCount(); 
            for(int i = rows - 1; i >=0; i--)
            {
                 Tmodel.removeRow(i); 
            }
            MainOpWindow.setVisible(false);
            CDBWin.setVisible(true);
            break;
    case 1:
            MainOpWindow.setVisible(false);
            CTableWin.setVisible(true);
            break; 
    case 2:
            MainOpWindow.setVisible(false);
            STableWin.setVisible(true);
            break;
     case 3:
            MainOpWindow.setVisible(false);
            CColumnWin.setVisible(true);
            break;
     case 4:
            MainOpWindow.setVisible(false);
            CDropCWin.setVisible(true);
            break;
    case 5:
            MainOpWindow.setVisible(false);
            CPKWin.setVisible(true);
            break;
    case 6:
            MainOpWindow.setVisible(false);
            CFKWin.setVisible(true);
            break;
   case 7:
            MainOpWindow.setVisible(false);
            CCustomWin.setVisible(true);
            break;
            
}
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 DefaultTableModel Tmodel = (DefaultTableModel) DBTableList.getModel();
    int rows = Tmodel.getRowCount(); 
    for(int i = rows - 1; i >=0; i--)
    {
         Tmodel.removeRow(i); 
    }
    Tmodel.setColumnCount(0);
    Globals.U1.ExceuteSelect("show tables");
     for(int i=0;i<Globals.TableHeaderName.size();i++)
        {
           Tmodel.addColumn(Globals.TableHeaderName.get(i));
           Tmodel.fireTableDataChanged();
        }
     Tmodel.fireTableDataChanged();
    for(int i=0;i<Globals.QueryResult.size();i++)
    {
       System.out.println(Globals.QueryResult.size());
        ArrayList Current=Globals.QueryResult.get(i);
        System.out.println(Current);
        
        Object[] currentobj=new Object[Current.size()]; 
        for(int j=0;j<Current.size();j++)
        {
            currentobj[j]=Current.get(j);
        }
        System.out.println(currentobj);
        Tmodel.addRow(currentobj);
    }
    // TODO add your handling code here:
}//GEN-LAST:event_jButton4ActionPerformed

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
this.setVisible(true);
MainOpWindow.setVisible(false);// TODO add your handling code here:
}//GEN-LAST:event_jButton5ActionPerformed

private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
System.exit(0);// TODO add your handling code here:
}//GEN-LAST:event_jButton6ActionPerformed

private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
System.exit(0);// TODO add your handling code here:
}//GEN-LAST:event_jButton7ActionPerformed

private void HNTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HNTFActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_HNTFActionPerformed

private void HPTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HPTFActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_HPTFActionPerformed

private void UnameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnameTFActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_UnameTFActionPerformed

private void DBTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DBTFActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_DBTFActionPerformed

private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
this.setVisible(true);
DBConnectivity.setVisible(false);// TODO add your handling code here:
}//GEN-LAST:event_jButton9ActionPerformed

private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
// TODO add your handling code here:
    String DBUrl="jdbc:mysql://";
    String Pass="";
    String Hname=HNTF.getText();
    String HPort=HPTF.getText();
    String Uname=UnameTF.getText();
    Pass=new String(PassPW.getPassword());
    if(Pass==null)
       Pass="";
    String DBname=DBTF.getText();
   DBUrl+=Hname+":"+HPort+"/"+DBname;
    if(Globals.U1==null)
    {
        System.out.println(DBUrl+"-"+Uname+"-"+Pass);
        Globals.U1=new Utility(DBUrl,Uname,Pass);  //static Utility U1=new Utility("jdbc:mysql://localhost:3306/billing_system","root","");
        boolean test= Globals.U1.TestConnection("show tables");
        if(test)
            {
                JOptionPane.showMessageDialog(null,"Your Details have been Saved and Verified");
                Globals.AllowManageAccess=true;
                DBConnectivity.setVisible(false);
                this.setVisible(true);
            }
        else{
                JOptionPane.showMessageDialog(null,"Your details are incorrect please enter correct details");
            }
        
    }
else{
       System.out.println(DBUrl+"-"+Uname+"-"+Pass);
        Globals.U1.Update(DBUrl,Uname,Pass);  //static Utility U1=new Utility("jdbc:mysql://localhost:3306/billing_system","root","");
        boolean test= Globals.U1.TestConnection("show tables");
        if(test)
            {
                JOptionPane.showMessageDialog(null,"Your Details have been Saved and Verified");
                Globals.AllowManageAccess=true;
                DBConnectivity.setVisible(false);
                this.setVisible(true);
            }
        else{
                JOptionPane.showMessageDialog(null,"Your details are incorrect please enter correct details");
            }
        
    }
}//GEN-LAST:event_jButton8ActionPerformed

private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
System.exit(0);// TODO add your handling code here:
}//GEN-LAST:event_jButton10ActionPerformed

private void DBnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DBnameActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_DBnameActionPerformed

private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
    DefaultTableModel Tmodel = (DefaultTableModel) DbTable.getModel();
    
    String Db=DBname.getText();
   if(Globals.U1.ExceuteUpdate("Create Database "+Db)){
        Tmodel.addRow(new Object[]{Db});
   }
   else{
        JOptionPane.showMessageDialog(null,"Some Error Occured Please Verify that You Database name is unique");    
   }

// TODO add your handling code here:
}//GEN-LAST:event_jButton11ActionPerformed

private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
MainOpWindow.setVisible(true);
CDBWin.setVisible(false);// TODO add your handling code here:
}//GEN-LAST:event_jButton12ActionPerformed

private void FTNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FTNameActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_FTNameActionPerformed

private void FCNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FCNameActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_FCNameActionPerformed

private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
DefaultTableModel Tmodel = (DefaultTableModel) DbTable.getModel();
    
   
   if(Globals.U1.ExceuteUpdate("alter table "+FTName.getText()+" add constraint foreign key ("+FCName.getText()+") references "+PTName.getText()+" ("+PCName.getText()+")")){
       JOptionPane.showMessageDialog(null,"Foreign Key Has been Added to defined column");
   }
   else{
        JOptionPane.showMessageDialog(null,"Cannot Add Primary Key Please make sure Primary Key doesnot already exist");    
   }// TODO add your handling code here:
}//GEN-LAST:event_jButton13ActionPerformed

private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
MainOpWindow.setVisible(true);
CFKWin.setVisible(false);// TODO add your handling code here:
}//GEN-LAST:event_jButton14ActionPerformed

private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
MainOpWindow.setVisible(true);
CPKWin.setVisible(false);// TODO add your handling code here:
}//GEN-LAST:event_jButton15ActionPerformed

private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
if(Globals.U1.ExceuteUpdate("alter table "+PKTable.getText()+" add constraint primary key ("+PKColumn.getText()+")")){
       JOptionPane.showMessageDialog(null,"Primary Key Has been Added to defined column");
   }
   else{
        JOptionPane.showMessageDialog(null,"Cannot Add Primary Key Please make sure Primary Key doesnot already exist");    
   }// TODO add your handling code here:
}//GEN-LAST:event_jButton16ActionPerformed

private void PKColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PKColumnActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_PKColumnActionPerformed

private void PKTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PKTableActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_PKTableActionPerformed

private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
if(Globals.U1.ExceuteUpdate(CustomQuery.getText())){
       JOptionPane.showMessageDialog(null,"Your query Successfully Execute.");
   }
   else{
        JOptionPane.showMessageDialog(null,"Your Query Cannot be executed please make sure the it is error free.");    
   }// TODO add your handling code here:
}//GEN-LAST:event_jButton17ActionPerformed

private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
MainOpWindow.setVisible(true);
CCustomWin.setVisible(false);// TODO add your handling code here:
}//GEN-LAST:event_jButton18ActionPerformed

private void PassPWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassPWActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_PassPWActionPerformed

private void NTableNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NTableNameActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_NTableNameActionPerformed

private void NCnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NCnameActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_NCnameActionPerformed

private void NColumnTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NColumnTypeActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_NColumnTypeActionPerformed

private void NColumnConstraintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NColumnConstraintActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_NColumnConstraintActionPerformed

private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
MainOpWindow.setVisible(true);
CTableWin.setVisible(false);// TODO add your handling code here:
}//GEN-LAST:event_jButton20ActionPerformed

private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
     boolean suc=Globals.U1.ExceuteUpdate("Create table "+NTableName.getText()+"( "+NCname.getText()+" "+NColumnType.getText()+" "+NColumnConstraint.getText()+" )");
    if(suc){
       JOptionPane.showMessageDialog(null,"Your Table Has been Created"); 
   }
   else{
        JOptionPane.showMessageDialog(null,"Some Error Occured Please Verify that You Database name is unique");    
   }// TODO add your handling code here:
}//GEN-LAST:event_jButton19ActionPerformed

private void NColumnConstraint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NColumnConstraint1ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_NColumnConstraint1ActionPerformed

private void NColumnType1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NColumnType1ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_NColumnType1ActionPerformed

private void NTableName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NTableName1ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_NTableName1ActionPerformed

private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
  boolean suc=Globals.U1.ExceuteUpdate("Alter table "+NTableName1.getText()+" add column "+NCname1.getText()+" "+NColumnType1.getText()+" "+NColumnConstraint1.getText()+"");
    if(suc){
       JOptionPane.showMessageDialog(null,"Your Column has been added"); 
   }
   else{
        JOptionPane.showMessageDialog(null,"Some Error Occured Please Verify that You table exist and column name is unique");    
   }// TODO add your handling code here:
}//GEN-LAST:event_jButton21ActionPerformed

private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
MainOpWindow.setVisible(true);
CColumnWin.setVisible(false);// TODO add your handling code here:
}//GEN-LAST:event_jButton22ActionPerformed

private void NCname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NCname1ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_NCname1ActionPerformed

private void NTableName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NTableName2ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_NTableName2ActionPerformed

private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
MainOpWindow.setVisible(true);
CDropCWin.setVisible(false);// TODO add your handling code here:
}//GEN-LAST:event_jButton23ActionPerformed

private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
 boolean suc=Globals.U1.ExceuteUpdate("Alter table "+NTableName2.getText()+" drop column "+NCname2.getText()+"");
    if(suc){
       JOptionPane.showMessageDialog(null,"Your Column has been dropped"); 
   }
   else{
        JOptionPane.showMessageDialog(null,"Some Error Occured Please Verify that You table exist and column correct");    
   }// TODO add your handling code here:
}//GEN-LAST:event_jButton24ActionPerformed

private void NCname2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NCname2ActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_NCname2ActionPerformed

private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
    DefaultTableModel Tmodel = (DefaultTableModel) STableTable.getModel();
    int rows = Tmodel.getRowCount(); 
    for(int i = rows - 1; i >=0; i--)
    {
         Tmodel.removeRow(i); 
    }
    Tmodel.setColumnCount(0);
    Globals.U1.ExceuteSelect("select * from "+NCname3.getText());
     for(int i=0;i<Globals.TableHeaderName.size();i++)
        {
           Tmodel.addColumn(Globals.TableHeaderName.get(i));
           Tmodel.fireTableDataChanged();
        }
     Tmodel.fireTableDataChanged();
    for(int i=0;i<Globals.QueryResult.size();i++)
    {
       System.out.println(Globals.QueryResult.size());
        ArrayList Current=Globals.QueryResult.get(i);
        System.out.println(Current);
        
        Object[] currentobj=new Object[Current.size()]; 
        for(int j=0;j<Current.size();j++)
        {
            currentobj[j]=Current.get(j);
        }
        System.out.println(currentobj);
        Tmodel.addRow(currentobj);
    }
    // TODO add your handling code here:
}//GEN-LAST:event_jButton25ActionPerformed

private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
STableWin.setVisible(false);
MainOpWindow.setVisible(true);// TODO add your handling code here:
}//GEN-LAST:event_jButton26ActionPerformed

private void PCNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCNameActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_PCNameActionPerformed

private void PTNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PTNameActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_PTNameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainPage().setVisible(true);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame CColumnWin;
    private javax.swing.JFrame CCustomWin;
    private javax.swing.JFrame CDBWin;
    private javax.swing.JFrame CDropCWin;
    private javax.swing.JFrame CFKWin;
    private javax.swing.JFrame CPKWin;
    private javax.swing.JFrame CTableWin;
    private javax.swing.JTextArea CustomQuery;
    private javax.swing.JFrame DBConnectivity;
    private javax.swing.JButton DBSetting;
    private javax.swing.JTextField DBTF;
    private javax.swing.JTable DBTableList;
    private javax.swing.JTextField DBname;
    private javax.swing.JTable DbTable;
    private javax.swing.JTextField FCName;
    private javax.swing.JTextField FTName;
    private javax.swing.JTextField HNTF;
    private javax.swing.JTextField HPTF;
    private javax.swing.JButton MDB;
    private javax.swing.JFrame MainOpWindow;
    private javax.swing.JTextField NCname;
    private javax.swing.JTextField NCname1;
    private javax.swing.JTextField NCname2;
    private javax.swing.JTextField NCname3;
    private javax.swing.JTextField NColumnConstraint;
    private javax.swing.JTextField NColumnConstraint1;
    private javax.swing.JTextField NColumnType;
    private javax.swing.JTextField NColumnType1;
    private javax.swing.JTextField NTableName;
    private javax.swing.JTextField NTableName1;
    private javax.swing.JTextField NTableName2;
    private javax.swing.JComboBox OpList;
    private javax.swing.JTextField PCName;
    private javax.swing.JTextField PKColumn;
    private javax.swing.JTextField PKTable;
    private javax.swing.JTextField PTName;
    private javax.swing.JPasswordField PassPW;
    private javax.swing.JTable STableTable;
    private javax.swing.JFrame STableWin;
    private javax.swing.JTextField UnameTF;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
