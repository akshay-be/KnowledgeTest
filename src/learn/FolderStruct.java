package learn;
import java.io.File;

public class FolderStruct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String filterdFileName = "I:\\";
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <=9; j++) {
				for (int k = 0; k < 9; k++) {
					for (int l = 0; l < 9; l++) {
						for (int m = 0; m < 9; m++) {
							for (int n = 0; n < 9; n++) {
								for (int o = 0; o < 9; o++) {
									for (int p = 0; p < 9; p++) {
										for (int q = 0; q < 9; q++) {
											for (int r = 0; r < 9; r++) {
												for (int s = 0; s < 9; s++) {
													File file = new File(filterdFileName + "" + i + "\\" + j+ "\\" + k+ "\\" + l+ "\\" 
															 + m+ "\\" + n+ "\\" + o+ "\\" + p+ "\\" + q+ "\\" + r+ "\\" + s);
													if (!file.exists()) {
														System.out.println(file.mkdirs());
														System.out.println("Created : "
																+ file.getAbsolutePath()+" Status : "+file.exists());
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

}
