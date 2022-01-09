package edu.shtoiko.atmsimulator.terminal;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

       UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

        JFrame frame = new JFrame("ATM");
        frame.setVisible(true);
        frame.setBounds(300,100,300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
//     frame.add(new MyComponent());


        ButtonGroup choice = new ButtonGroup();
        JRadioButton user = new JRadioButton("user", true);
        choice.add(user);
        JRadioButton service = new JRadioButton("service", false);
        choice.add(service);

     String message = "You want authorithed as..";
     JLabel text = new JLabel();
     text.setText(message);

        JButton autorithed = new JButton();
        autorithed.setText("Autorithed");
        autorithed.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
          if (user.isSelected()){

           text.setText(message + "User");

              frame.setVisible(false);
              UserTerminal user = new UserTerminal();



          }
          if (service.isSelected()){

           text.setText(message + "Service");



          }
         }
        });
//        autorithed.setSize(150,150);



        JPanel panel = new JPanel();
//        panel.setBounds(50,50,500,500);
//
//        Dimension dimension = new Dimension();
//
//        dimension.setSize(frame.getWidth()-100, frame.getHeight()-100);

//        panel.setPreferredSize(dimension);
        panel.setLayout(new BorderLayout());
//        panel.setLocation(100,100);




        panel.add(text, BorderLayout.NORTH);
        panel.add(service, BorderLayout.EAST);
        panel.add(user, BorderLayout.WEST);
        panel.add(autorithed, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);





//        String[] str = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
//        for (String s : str){
//            System.out.println(s);
//        }











//        Frame mainFrame = new Frame("ATMterminal",600,750);
//
//        ButtonGroup choice = new ButtonGroup();
//        JRadioButton user = new JRadioButton("user", true);
//        choice.add(user);
//        JRadioButton service = new JRadioButton("service", false);
//        choice.add(service);
//
//
//        Button button = new Button("button", 50,50);
//
//        Panel panel = new Panel("Panel", 200,300 , button);
//
//        panel.add(user, BorderLayout.CENTER);
//        panel.add(service, BorderLayout.WEST);
//
//        panel.setBackground(Color.GRAY);
//        button.setBounds(new Rectangle(200,100,300,400));
//        panel.setLocation(100,300);







//        Screen screen = new Screen();
//
//        panel.add(screen);
//
//        mainFrame.add(panel);




        }

}
