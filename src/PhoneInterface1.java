    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;
    import java.io.File;
    import java.util.Vector;
    import java.awt.image.*;
    public class PhoneInterface1 extends JFrame implements ActionListener
    {
    private JPanel imagePan;
    private JPanel numberPad = new JPanel();
    private JTextArea text = new JTextArea();
    private JButton loadButton, closeButton;
    private JLabel status;
    public PhoneInterface1()
    {
    status = new JLabel();
    this.text = new JTextArea(5,5);
    JScrollBar vBar = new JScrollBar(JScrollBar.VERTICAL);
    this.text.setWrapStyleWord(true);
    this.text.setLineWrap(true);
    JButton[] buttons = new JButton[15];
    numberPad.setLayout(new GridLayout(5,3));
    for(int i=0; i<15; i++)
    {
    if (i==0){
    buttons[i] = new JButton("Load Image",new ImageIcon("load.gif"));
    loadButton = buttons[i];
    buttons[i].addActionListener(this);
    }
    else if (i==1){
    buttons[i] = new JButton("Menu");
    buttons[i].addActionListener(this);
    }
    else if (i==2){
    buttons[i] = new JButton("Close All");
    closeButton = buttons[i];
    buttons[i].addActionListener(this);
    }
    else if (i>2 && i<12){
    buttons[i] = new JButton(""+(i-2));
    buttons[i].addActionListener(this);
    }
    else if (i==12){
    buttons[i] = new JButton(""+"*");
    buttons[i].addActionListener(this);
    }
    else if (i==13){
    buttons[i] = new JButton(""+0);
    buttons[i].addActionListener(this);
    }
    else if (i==14){
    buttons[i] = new JButton(""+"#");
    buttons[i].addActionListener(this);
    }
    numberPad.add(buttons[i]);
    }
    this.setSize(400,400); // set the size to 400 x 400
    this.show(); // display the frame
    this.setStatus("Application Started");
    this.add("North", imagePan);
    this.add("Center", text);
    this.add("South", numberPad);
    this.getContentPane().add("East",vBar);
    this.pack();
    this.setVisible(true); //displays the frame
    }
    public void actionPerformed(ActionEvent e)
    {
    Image loadedImage;
    if (e.getSource().equals(loadButton))
    {
    JFileChooser chooser = new JFileChooser();
    int returnVal = chooser.showOpenDialog(this);
    if(returnVal == JFileChooser.APPROVE_OPTION)
    {
    new ImagePanel();
    }
    }
    }
    private void setStatus(String s)
    {
    this.status.setText("Status: "+s);
    }
    public static void main(String args[])
    {
        PhoneInterface1 pi1 = new PhoneInterface1();
        }
    }
    class ImagePanel extends JPanel {
    Image img;
    public ImagePanel(){
    // make sure the parent JPanel constructor is called
    // so it does whatever it needs to do first.
    super();
    img = loadImage(new File("/home/student/workspace/MotoEdition/logo.png"));
    }
    public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if(img != null) {
    g.drawImage(img, 0, 0, this);
    }
    }
    public Image loadImage(File f) {
    Image image = getToolkit().getImage(f.getPath());
    return image;
    }
    }


