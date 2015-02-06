package easy_200_floodfill_NOT_WORKING;

public class Main {
	public static void main(String[] args) {
//		Picture picture = new Picture(30, 20);
		Picture picture = new Picture("test1.txt");
		picture.printPicture();
		picture.bucketFill(8, 12, '@');
	}
}