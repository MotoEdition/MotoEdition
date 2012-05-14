    import java.awt.*;
    import java.applet.*;
    import java.awt.event.*;
    import java.awt.Graphics;
    import javax.swing.*;
    import javax.swing.JApplet;
    import java.util.Vector;
    public class nio2 extends JApplet implements Runnable , ActionListener{
    static final long serialVersionUID = -116069779446114664L;
    JButton b1;
    Toolkit tk;
    JLabel lab;
    Image plaat;
    ImageIcon imic;
    Container ctain;
    Graphics g;
    public void init()
    {
    ctain=getContentPane();
    b1=new JButton("Load ");
    b1.setBounds(200, 10, 180, 60);
    b1.addActionListener(this);
    ctain.add(b1);
    lab=new JLabel("here image");
    lab.setBounds(200, 220, 300, 250);
    ctain.add(lab);
    this.setBackground(Color.lightGray);
    }
    public void start(){
    }
    public void run(){
    }
    public void actionPerformed(ActionEvent e){
    if(e.getSource()==b1){
    try{
    lab.setIcon(new ImageIcon("C:\\test.gif"));
    }catch(Exception ex4){}
    }
    }}