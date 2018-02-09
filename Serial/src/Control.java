import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Control implements ListSelectionListener{
	String dataFile;
	String folderPath;
	Model model;
	
	Control(String folderPath, String dataFile, String nonePath) throws Exception{
		this.folderPath = folderPath;
		this.dataFile = dataFile;
		this.model = new Model(this, nonePath);
		this.loadData();
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

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		ImgList imgList = (ImgList)arg0.getSource();
		int index = imgList.getSelectedIndex();
		if (index == -1) {
			// ^ no selection or multiple selection
			this.model.setNoCurrentImage();
		}
		
	}

	
}
