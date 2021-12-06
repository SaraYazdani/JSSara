import Lab.{LabTest, Labs, SourisDeux, SourisUn}
import akka.actor.{ActorSystem, Props}

import java.awt.Color
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.swing._
import java.util._



object DisplayScala extends Thread{
  var frame: JFrame = null
  var lc: String = null
  var rc: String = null
  var mode = false

  def startDisply() {
    frame = new JFrame("Projet de session INF 756 - Sara");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setSize(1000, 1000);

    var labChoicesTitle = new JTextField("Choisissez un labyrinthe: ");
    labChoicesTitle.setBounds(10, 20, 180, 30);
    labChoicesTitle.setEditable(false);

    var ratChoicesTitle = new JTextField("Choisissez un Souris: ");
    ratChoicesTitle.setBounds(10, 50, 180, 30);
    ratChoicesTitle.setEditable(false);

    var gameModeChoice = new JTextField("2 Souris avec les même intelligent?");
    gameModeChoice.setBounds(10, 80, 240, 30);
    gameModeChoice.setEditable(false);

    var lanceButton = new JButton("Lancez la simulation");
    lanceButton.setBounds(50, 110, 200, 30);


    var value = new SpinnerNumberModel(0, 0, 2, 1);
    var labChoices = new JSpinner(value);
    labChoices.setBounds(200, 20, 100, 30);

    var value1 = new SpinnerNumberModel(0, 0, 2, 1);
    var ratChoices = new JSpinner(value1);
    ratChoices.setBounds(200, 50, 100, 30);

    var modeChoice = new JCheckBox();
    modeChoice.setBounds(260, 80, 30, 30);

    lanceButton.addActionListener(e => onClick())

    def onClick(): Unit = {
      rc = ratChoices.getValue().toString();
      lc = labChoices.getValue().toString();
      mode = modeChoice.isSelected();

      labChoices.setEnabled(false);
      ratChoices.setEnabled(false);
      lanceButton.setEnabled(false);

      var dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
      var now = LocalDateTime.now();

      var msg = new JTextArea();
      msg.setEditable(false);
      msg.setVisible(true);
      msg.setBounds(20, 200, 350, 300);
      msg.setBackground(Color.cyan);

      msg.append(dtf.format(now) + " : \n");
      msg.append("En traitment ... \n");
      msg.append("Vous avez choisi Labyrinthe : " + lc +
        ", et Souris: " + rc + "\n");

      if (lc.equals("1")) {
        msg.append("\nVous avez choisi ce labyrinthe: \n \n");
        var l = new Labs;
        msg.append(l.lab1());

      } else if (lc.equals("2")) {

      } else msg.append("\nTraitement n'est pas possible. Choisissez un labyrithe valide.")
      msg.setLineWrap(true);

      frame.getContentPane().add(msg);
      frame.getContentPane().revalidate();
      frame.getContentPane().repaint();

      associe()
    }

    frame.getContentPane().add(lanceButton);
    frame.getContentPane().add(labChoicesTitle);
    frame.getContentPane().add(ratChoicesTitle);
    frame.getContentPane().add(labChoices);
    frame.getContentPane().add(gameModeChoice);
    frame.getContentPane().add(modeChoice);
    frame.getContentPane().add(ratChoices);
    frame.getContentPane().setBackground(Color.WHITE);

    frame.setLayout(null);
    frame.setVisible(true);


  }

  def associe(): Unit = {
    if(lc == "1" && mode == true) {
      var lt = new Labs
      lt.setMazeTable1()

      var s1 = new SourisUn(lt.mazeTable1)
      var r1 = s1.résoudre()

      var s2 = new SourisDeux(lt.mazeTable1)
      var r2 = s2.résoudre()

      var results = new JTextArea();
      results.setEditable(false)
      results.setBounds(500, 20, 250, 500)
      results.append("Souris 1:")
      results.append(r1)

      results.append("\n\nSouris 2:")
      results.append(r2)

      frame.getContentPane().add(results)
      frame.getContentPane().revalidate();
      frame.getContentPane().repaint();

    } else if (lc == "2") {
      // TODO: complete the rest
    }
  }
}

object RUN {
  def main(args: Array[String]): Unit = {
    DisplayScala.startDisply()
  }
}