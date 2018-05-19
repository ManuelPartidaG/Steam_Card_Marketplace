/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steamtradingcardproject.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author 1matt
 */
public class List extends JComboBox{
    
    public List() {
        String csvFile = "data.csv";
        BufferedReader br = null;
        String[] thedata = new String[100];
        String line = "";
        int i = 0;
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] dataSet = line.split(",");
                //Integer temp = Integer.parseInt(dataSet[3]);
                thedata[i] = dataSet[3];
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        
      DefaultComboBoxModel<String> list = new DefaultComboBoxModel<String>(thedata);
        
        this.setModel(list);
        
        
        System.out.println(thedata.toString());
    }
    
    
    
    
}
