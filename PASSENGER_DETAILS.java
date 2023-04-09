import java.awt.*;
import java.awt.event.*;
import java.time.*;
class PASSENGER_DETAILS extends Frame implements ActionListener, WindowListener {
   static PASSENGER_DETAILS F;
   String s1 = "";
   Button submit, clear,search,add;
   Label n, g, dob, d, b, you;
   TextField name, dateofbirth;
   TextArea ye;
   CheckboxGroup gender;
   Checkbox male, female;
   Choice deg;

   PASSENGER_DETAILS() {

      setLayout(new FlowLayout());
      addWindowListener(this);
      n = new Label("Name");
      add(n);
      name = new TextField(10);
      add(name);
      dob = new Label("Date of Birth(in yyyy-mm-dd format)");
      add(dob);
      dateofbirth = new TextField(10);
      add(dateofbirth);
      g = new Label("Gender");
      add(g);
      gender = new CheckboxGroup();
      male = new Checkbox("MALE", false, gender);
      female = new Checkbox("FEMALE", false, gender);
      add(male);
      add(female);
      d = new Label("Berth preference");
      add(d);
      deg = new Choice();
      deg.add("Lower");
      deg.add("Middle");
      deg.add("Upper");
      add(deg);
      submit = new Button("SUBMIT");
      add(submit);
      clear = new Button("CLEAR");
      add(clear);
      search= new Button("SEARCH");
      add(search);
      add= new Button("ADD");
      add(add);
      clear.addActionListener(this);
      submit.addActionListener(this);
      search.addActionListener(this);
      add.addActionListener(this);
      you = new Label("You Entered");
      add(you);
      ye = new TextArea(10, 40);
      add(ye);

   }

   public void actionPerformed(ActionEvent ae) {
      String o = name.getText();
      String dateof = dateofbirth.getText();
      try {
         LocalDate date1 = LocalDate.parse(dateof);
         LocalDate currentDate = LocalDate.now();
         Period period = date1.until(currentDate);
         int yearsBetween = period.getYears();
         ye.append("BOOKING TRAIN TICKETS\n");
         if (yearsBetween > 60)
            ye.append("You are a Senior Citizen\n");
         if (ae.getSource() == clear) {
            ye.setText("");
         }
         if ((ae.getSource() == submit) && (!(o.equals(""))) && (!(dateof.equals("")))) {

            s1 = s1.concat("Name: " + name.getText());
            s1 = s1.concat("\nDate of Birth: " + dateofbirth.getText());
            s1 = s1.concat("\nAge: " + yearsBetween);
            if (male.getState()) {
               s1 = s1.concat("\nGender: Male");
            }
            if (female.getState()) {
               s1 = s1.concat("\nGender: Female");
            }
            s1 = s1.concat("\nBerth preference: " + deg.getSelectedItem());

            ye.append(s1);

         }
      } catch (Exception check) {
         ye.append("\nDate of Birth is in wrong format\nPlease enter in YYYY-MM-DD format");
         System.out.println("\nDate of birth is in wrong format\nPlease enter in YYYY-MM-DD format");
      }

   }
      

   public static void main(String args[]) {
      try {
         F = new PASSENGER_DETAILS();
         F.setSize(1000, 1000);
         F.setVisible(true);
        
      } catch (Exception e) {
         System.out.println(e);
      }
   }

   public void windowActivated(WindowEvent e) {
   }

   public void windowClosed(WindowEvent e) {
      System.exit(0);
   }

   public void windowClosing(WindowEvent e) {
      System.exit(0);
   }

   public void windowDeactivated(WindowEvent e) {
   }

   public void windowDeiconified(WindowEvent e) {
   }

   public void windowIconified(WindowEvent e) {
   }

   public void windowOpened(WindowEvent e) {
   }

}