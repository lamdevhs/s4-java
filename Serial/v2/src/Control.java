import java.awt.Checkbox;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Control implements ItemListener, WindowListener{
	String dataFile;
	String folderPath;
	Model model;
	
	Control(String folderPath, String dataFile, String nonePath) throws Exception{
		this.folderPath = folderPath;
		this.dataFile = dataFile;
		this.model = new Model(this, nonePath);
		//this.loadData();
		this.loadXMLData();
	}
	
	public int saveData() {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(this.dataFile);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(this.model.images);
			oos.close();
			fos.close();
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
			return -1;
		}
		return 0;
	}
	
	void loadData() throws Exception{
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(this.dataFile);
			ois = new ObjectInputStream(fis);
			
			this.model.images = (ArrayList<RatedImage>)ois.readObject();
			
			ois.close();
			fis.close();
		}
		catch (IOException ioe){
			System.out.println("IOException Error :)");
			this.initData();
			
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFound Error :)");
			this.initData();
		}
	}
	
	private void initData() throws Exception {
		File folder = new File(this.folderPath);
		File[] files = folder.listFiles();
		if (files == null) {
			throw new Exception("Folder given does not exit!");
		}
		this.model.fromFolder(files);
		System.out.println(this.model.images);
	}
	
	
	
	void loadXMLData() throws Exception{
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		XMLDecoder decoder = null;
		try {
			fis = new FileInputStream(this.dataFile);
			bis = new BufferedInputStream(fis);
			decoder = new XMLDecoder(bis);
			
			this.model.images = (ArrayList<RatedImage>)decoder.readObject();
			
			bis.close();
			fis.close();
		}
		catch (IOException ioe){
			System.out.println("IOException Error :) (XML)");
			this.initData();
			
		}
	}
	
	public int saveXMLData() {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		XMLEncoder encoder = null;
		try {
			fos = new FileOutputStream(this.dataFile);
			bos = new BufferedOutputStream(fos);
			encoder = new XMLEncoder(bos);
			
			encoder.writeObject(this.model.images);
			encoder.flush();
			encoder.close();
			bos.close();
			fos.close();
		}
		catch(IOException ioe) {
			ioe.printStackTrace();
			return -1;
		}
		return 0;
	}
	
	

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource().getClass() == ImgList.class) {
			ImgList imgList = (ImgList)arg0.getSource();
			int index = imgList.getSelectedIndex();
			this.model.setCurrentImage(index);
		}
		else if (arg0.getSource().getClass() == RatingBox.class) {
			RatingBox checkbox = (RatingBox)arg0.getSource();
			this.model.setRating(checkbox.stars);
		}
	}
	
	

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		int res = this.saveXMLData();
		System.out.println("Was data saving successful? " + String.valueOf(res == 0));
		System.exit(0);
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
