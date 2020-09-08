import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class Project04_C_PdfInsertIMG {
	public static void main(String[] args) {
		Document doc = new Document();
		try {
			PdfWriter.getInstance(doc, new FileOutputStream("ImageDemo.pdf"));
			doc.open();
			
			String fileName = "kim.png";
			Image image = Image.getInstance(fileName);
			doc.add(image);
			
			String url = "http://image.yes24.com/goods/89553062/800x0";
			image = Image.getInstance(url);
			doc.add(image);
			
			System.out.println("���� �Ϸ�");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			doc.close();
		}
	}
}
