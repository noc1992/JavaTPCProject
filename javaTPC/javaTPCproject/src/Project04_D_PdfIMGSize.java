import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class Project04_D_PdfIMGSize {

	public static void main(String[] args) {
		Document doc = new Document();
		try {
			PdfWriter.getInstance(doc, new FileOutputStream("ImageScaling.pdf"));
			doc.open();
			
			String fileName = "kim.png";
			Image image = Image.getInstance(fileName);
			doc.add(image);
			
			fileName = "kim.png";
			image = Image.getInstance(fileName);
			image.scaleAbsolute(200f, 200f);
			doc.add(image);
			
			String url = "https://www.google.co.kr/logos/doodles/2020/kim-sowols-118th-birthday-6753651837108317-l.png";
			image = Image.getInstance(url);
			image.scalePercent(200f);
			doc.add(image);
			
			image = Image.getInstance(url);
			image.scaleToFit(100f, 200f);
			doc.add(image);
			
			System.out.println("크기조절 성공");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			doc.close();
		}
	}

}
