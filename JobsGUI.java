import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 * Provides a GUI interface for the job submission system.
 * Only shows a selection of possible functions: add job, list jobs 
 * waiting record job done.
 * 
 * @author Natallia Akulenka
 * @version 12/01/2014
 */
public class JobsGUI 
{
    // assigns an object of class Branch to the Manager mmm variable
    private Manager mmm = new Branch("Watford");

    private JFrame myFrame = new JFrame("Jobs GUI");
    private Container contentPane = myFrame.getContentPane();

    private JButton quitButton = new JButton("Quit");
    private JButton addJobButton = new JButton ("Add Job");
    private JButton clearListButton = new JButton ("Clear List");

    private JLabel custNameLabel = new JLabel("Enter Customer name");
    private JTextField custNameText = new JTextField("enter customer's name");

    private JLabel jobRequirLabel = new JLabel("Job Requirements");
    private JCheckBox onSiteLabel = new JCheckBox("On Site");
    private JCheckBox shorthandLabel = new JCheckBox("Shorthand");
    private JCheckBox translationLabel = new JCheckBox("Translation");

    private JPanel eastPanel = new JPanel();
    private JPanel westPanel = new JPanel(); 
    private JPanel centerPanel = new JPanel();
    private JPanel northPanel = new JPanel();
    private JPanel southPanel = new JPanel();

    private JTextArea textArea = new JTextArea();

    public JobsGUI()
    {
        addAllStaff();
        makeFrame();
        makeMenus(myFrame);
    }

    private void addAllStaff()
    {
        // add a clerk
        mmm.addStaff("CL1", "Ann");
        mmm.addStaff("CL2", "Bob");
        // add a typist
        mmm.addStaff("TY1", "Che", false, true);
        mmm.addStaff("TY2", "Dan", false, false);
        mmm.addStaff("TY3", "Eve", true, true);
        mmm.addStaff("TY4", "Fez", true, false);
        // add a translator
        mmm.addStaff("TR1", "Gil", false, true, "French", 50.00);
        mmm.addStaff("TR2", "Han", false, false, "French", 50.00);
        mmm.addStaff("TR3", "Kit", true, true, "German", 60.00);
        mmm.addStaff("TR4", "Lil", true, false, "German", 60.00);
    }

    private void addAllJobs()
    {
        // add a job
        mmm.addJob("Anna", true, true, "German");
        mmm.addJob("Tom", true, false, "English");
        mmm.addJob("Bill", false, false, "French");
        mmm.addJob("Georg", false, false, "French");
    }

    /**
     * Create the main frame's menu bar.
     * @param frame is a frame of the class JFrame
     */
    private void makeMenus(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        // create the File menu
        JMenu fileMenu = new JMenu("Jobs");
        menubar.add(fileMenu);
        // create a menu item "Add Job"
        JMenuItem addJobItem = new JMenuItem("Add Job");
        addJobItem.addActionListener(new AddJobItemHandler());
        fileMenu.add(addJobItem);
        // create a menu item "Job Done"
        JMenuItem doneItem = new JMenuItem("Job Done");
        doneItem.addActionListener(new DoneHandler());
        fileMenu.add(doneItem);
        // create a menu item "List Waiting"
        JMenuItem listWaitingItem = new JMenuItem("List Waiting");
        listWaitingItem.addActionListener(new ListWaitingHandler());
        fileMenu.add(listWaitingItem);
    }

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {    
        contentPane.setLayout(new BorderLayout());
        contentPane.add(eastPanel, BorderLayout.EAST);
        contentPane.add(southPanel, BorderLayout.SOUTH);
        contentPane.add(westPanel, BorderLayout.WEST);
        contentPane.add(centerPanel, BorderLayout.CENTER);
        contentPane.add(northPanel, BorderLayout.NORTH);
        // set panel layout and add components

        southPanel.add(quitButton);
        quitButton.setVisible(true);
        quitButton.addActionListener(new QuitButtonHandler());

        // set the layout of the east panel to a grid with 4 rows and 1 colomn
        eastPanel.setLayout(new GridLayout(4,1));
        // add a button "Add Job"
        addJobButton = new JButton ("Add Job");
        addJobButton.setVisible(false);
        addJobButton.addActionListener(new AddJobButtonHandler());
        eastPanel.add(addJobButton);

        // add a button "Clear List"
        clearListButton = new JButton ("Clear List");
        clearListButton.setVisible(false);
        clearListButton.addActionListener(new ClearListButtonHandler());
        eastPanel.add(clearListButton);

        // to the central panel add a text area in which job information can be listed
        addAllStaff();
        addAllJobs();
        textArea = new JTextArea("",20,20);
        textArea.setLineWrap(true);
        textArea.setVisible(false);
        centerPanel.add(textArea);

        // the north panel provides components to capture the customer's name
        northPanel.setLayout(new GridLayout(4,1));

        custNameLabel = new JLabel("Enter Customer name");
        custNameLabel.setVisible(false);
        northPanel.add(custNameLabel);

        custNameText = new JTextField("enter customer's name");
        custNameText.setVisible(false);
        northPanel.add(custNameText);

        // add job components to the west panel
        BoxLayout boxLayout2 = new BoxLayout (westPanel, BoxLayout.Y_AXIS);
        westPanel.setLayout(boxLayout2);

        jobRequirLabel = new JLabel("Job Requirements");
        jobRequirLabel.setVisible(false);
        westPanel.add(jobRequirLabel);

        onSiteLabel = new JCheckBox("On Site");
        onSiteLabel.setVisible(false);
        westPanel.add(onSiteLabel);

        shorthandLabel = new JCheckBox("Shorthand");
        shorthandLabel.setVisible(false);
        westPanel.add(shorthandLabel);

        translationLabel = new JCheckBox("Translation");
        translationLabel.setVisible(false);
        westPanel.add(translationLabel);

        // building is done - arrange the components and show        
        myFrame.pack();
        myFrame.setVisible(true);
    }

    private void makeTypes()
    {
        westPanel.setVisible(false);
        centerPanel.setVisible(false);
        northPanel.setVisible(false);
        contentPane.add(westPanel, BorderLayout.WEST);
        contentPane.add(centerPanel, BorderLayout.CENTER);
        contentPane.add(northPanel, BorderLayout.NORTH);
        // set panel layout and add components
        centerPanel.setLayout(new FlowLayout());
        northPanel.setLayout(new GridLayout(4,1));

    }

    private class DoneHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            String result = "";
            String inputValue = JOptionPane.showInputDialog("Job No ");
            int jNo = Integer.parseInt(inputValue);
            String hrsValue = JOptionPane.showInputDialog("Hours: ");
            int hrs = Integer.parseInt(hrsValue);
            if(mmm.setJobDone(jNo,hrs)== -1)
            {
                result = "No such job";
            }
            else
            {
                result = "Job Done.Cost of job is : "+ 
                (mmm.getJobCost(jNo));
            }

            JOptionPane.showMessageDialog(myFrame,result);    
        }
    }

    private class QuitButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            int answer = JOptionPane.showConfirmDialog(myFrame,
                    "Are you sure you want to quit?","Finish",
                    JOptionPane.YES_NO_OPTION);
            // closes the application
            if (answer == JOptionPane.YES_OPTION)
            {
                System.exit(0); //closes the application
            }              
        }
    }

    private class AddJobItemHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            // set desired items visible
            addJobButton.setVisible(true);
            custNameLabel.setVisible(true);
            custNameText.setVisible(true);
            jobRequirLabel.setVisible(true);
            onSiteLabel.setVisible(true);
            shorthandLabel.setVisible(true);
            translationLabel.setVisible(true);

            // set the rest invisible
            textArea.setVisible(false);
            clearListButton.setVisible(false);
        }
    }

    private class AddJobButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            // if translation is required, ask the required language
            String lang = "English";
            if (translationLabel.isSelected())
            {
                lang = JOptionPane.showInputDialog("Which language is required?: "); 
            }
            // add a job
            String addedJob = mmm.addJob(custNameText.getText(),onSiteLabel.isSelected(),shorthandLabel.isSelected(),lang);

            // set everything invisible
            addJobButton.setVisible(false);
            custNameLabel.setVisible(false);
            custNameText.setVisible(false);
            jobRequirLabel.setVisible(false);
            onSiteLabel.setVisible(false);
            shorthandLabel.setVisible(false);
            translationLabel.setVisible(false);
            textArea.setVisible(false);
            clearListButton.setVisible(false);

            // display results
            JOptionPane.showMessageDialog(null,addedJob);   
        }
    }

    private class ListWaitingHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            mmm.getJobsWaiting();
            textArea.setText(mmm.getJobsWaiting());

            // set desired elements visible
            textArea.setVisible(true);
            clearListButton.setVisible(true);

            // set everything else invisible
            addJobButton.setVisible(false);
            custNameLabel.setVisible(false);
            custNameText.setVisible(false);
            jobRequirLabel.setVisible(false);
            onSiteLabel.setVisible(false);
            shorthandLabel.setVisible(false);
            translationLabel.setVisible(false);
        }
    }

    private class ClearListButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            textArea.setVisible(false);
            clearListButton.setVisible(false);
        }
    }
}

